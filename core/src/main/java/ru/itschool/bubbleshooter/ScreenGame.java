package ru.itschool.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class ScreenGame implements Screen {
    public static final int SCR_WIDTH = Gdx.graphics.getWidth(); // 468
	public static final int SCR_HEIGHT = Gdx.graphics.getHeight(); // 962
	public static final int INTERVAL = Ball.height/10; // интервал спавна между шариками
    public static final int MAX_COUNT_IN_ROW = 11; // максимальное количество шариков в строке
    public static final int MAX_COUNT_ROW = 23; // максимально количество строк

	final BubbleShooter bub;

	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;

	Texture imgAtlasBall; // 4 разноцветных шарика
	TextureRegion[] imgBall;
	Texture imgAtlBallBlue, imgAtlBallGreen, imgAtlBallOrange, imgAtlBallRed;
	TextureRegion[] imgBallBlue, imgBallGreen, imgBallOrange, imgBallRed;
	Texture imgBackgroundLevelFirst, imgBackgroundLevelSecond;
	Texture imgBtnBack, imgFrame;

	Sound sndBulk, sndWin, sndLose;
	Music musBackground;

	BitmapFont font, fontWin;

    Ball[][] markingField;

	ArrayList<Ball> balls;
	ArrayList<Ball> ballsAnimate;
	ArrayList<Integer> ballsIndexDelete;
	ArrayList<Ball> ballsDelete;
	ArrayList<Ball> oldMainBalls; // список заспавненных прошлых главных шаров

	MainBall mainBall;

	Frame frame;

	BuButton btnRetry, btnContinue, btnReturn;
	Button btnBack;

	int LEVEL;
	int countRows;
	boolean isWin = false;
	boolean isLose = false;
	boolean isSound = true; // статус звукового сопровождения
    boolean isFindOverlap = false;
    boolean isPressedBack = false;
    boolean isGameFieldEmpty = false;
    static int shiftBallPlaceY = 0; // множитель 0/1, т.к. в 6 уровне четность рядов меняется при смещении

	int moves; // кол-во ходов в игре
	int score = 0;
	int record;

	@SuppressWarnings("SuspiciousIndentation")
    public ScreenGame(BubbleShooter bub) {
		this.bub = bub;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();

		imgBall = new TextureRegion[4];
		imgAtlasBall = new Texture("atlasBall.png");
		imgBackgroundLevelFirst = new Texture("imgBackgroundLevelFirst.png");
		imgBackgroundLevelSecond = new Texture("imgBackgroundLevelSecond.jpg");
		imgBtnBack = new Texture("imgBack.png");
		imgFrame = new Texture("frame.jpg");
		for (int i = 0; i < imgBall.length; i++)
			imgBall[i] = new TextureRegion(imgAtlasBall, i*300, 0, 300, 300);

		imgAtlBallBlue = new Texture("atlasBallBlue.png");
		imgAtlBallGreen = new Texture("atlasBallGreen.png");
		imgAtlBallOrange = new Texture("atlasBallOrange.png");
		imgAtlBallRed = new Texture("atlasBallRed.png");

        imgBallBlue = new TextureRegion[3];
        createImgBallRegions(imgAtlBallBlue, imgBallBlue);
        imgBallGreen = new TextureRegion[3];
        createImgBallRegions(imgAtlBallGreen, imgBallGreen);
        imgBallOrange = new TextureRegion[3];
        createImgBallRegions(imgAtlBallOrange, imgBallOrange);
        imgBallRed = new TextureRegion[3];
        createImgBallRegions(imgAtlBallRed, imgBallRed);

		sndBulk = Gdx.audio.newSound(Gdx.files.internal("sndBulk.mp3"));
		sndWin = Gdx.audio.newSound(Gdx.files.internal("sndWin.mp3"));
		sndLose = Gdx.audio.newSound(Gdx.files.internal("sndLose.mp3"));
		musBackground = Gdx.audio.newMusic(Gdx.files.internal("musBackground.mp3"));

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("appetite.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyz" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|" +
            "\\/?-+=()*&.;:,{}\"´`'<>";
		parameter.size = SCR_WIDTH/15;
		parameter.color = Color.valueOf("#FFBD88");
		font = generator.generateFont(parameter);

		parameter.size = SCR_WIDTH/10;
		parameter.color = Color.valueOf("#8B0000"); //#960018 был
		fontWin = generator.generateFont(parameter);

        markingField = new Ball[MAX_COUNT_ROW][MAX_COUNT_IN_ROW]; // Разметка поля

		balls = new ArrayList<>(); // шарики на поле игры
		ballsAnimate = new ArrayList<>();
		ballsIndexDelete = new ArrayList<>();
		ballsDelete = new ArrayList<>();
		oldMainBalls = new ArrayList<>();

		frame = new Frame();

		btnRetry = new BuButton(SCR_WIDTH*18/50, SCR_HEIGHT*47/100, fontWin, "повторить");
		btnContinue = new BuButton(SCR_WIDTH*61/100, SCR_HEIGHT*4/10, fontWin, "продолжить");
		btnReturn = new BuButton(SCR_WIDTH*2/3, SCR_HEIGHT*4/10, fontWin, "вернуться");
		btnBack = new Button(SCR_WIDTH/2f - Ball.width/4f,SCR_HEIGHT - Ball.width*8/10f, ScreenGame.SCR_WIDTH/15f, ScreenGame.SCR_WIDTH/15f);
	}

    void createImgBallRegions(Texture imgAtlasBall, TextureRegion[] imgRegion) {
        for (int i = 0; i < imgRegion.length; i++)
            imgRegion[i] = new TextureRegion(imgAtlasBall, i*300, 0, 300, 300);
    }

	void spawnBalls(){
		switch (LEVEL){
			case 1:
                Levels.makingFirstLevel(markingField);
				moves = 15;
				break;
			case 2:
                Levels.makingSecondLevel(markingField);
				moves = 30;
				break;
			case 3:
                //Levels.makingThirdLevel(markingField);
				moves = 25;
				break;
			case 4:
                Levels.makingFourthLevel(markingField);
				moves = 33;
				break;
			case 5:
                Levels.makingFifthLevel(markingField);
				moves = 25;
				break;
			case 6:
				bub.screenSettings.loadSettings();
				Levels.makingSixthLevel(markingField, countRows);
				moves = 0;
				break;
		}
	}

	void setupDeletion(Ball selectBall){
        selectBall.isExist = false;
        if (selectBall.placeX != 1 && markingField[selectBall.placeY - 1][selectBall.placeX - 2] != null &&
            markingField[selectBall.placeY - 1][selectBall.placeX - 2].isExist &&
            selectBall.type == markingField[selectBall.placeY - 1][selectBall.placeX - 2].type) {
            // Проверка крайнего левого шара от selectBall
            setupDeletion(markingField[selectBall.placeY - 1][selectBall.placeX - 2]);
        }
        if (((selectBall.placeX != 10 && (selectBall.placeY + shiftBallPlaceY) % 2 == 0) || // selectBall в чётном ряду не крайний правый
            (selectBall.placeX != 11 && (selectBall.placeY + shiftBallPlaceY) % 2 != 0)) && // selectBall в нечётном ряду не крайний правый
            markingField[selectBall.placeY - 1][selectBall.placeX] != null &&
            markingField[selectBall.placeY - 1][selectBall.placeX].isExist &&
            selectBall.type == markingField[selectBall.placeY - 1][selectBall.placeX].type) {
            // Проверка крайнего правого шара от selectBall
            setupDeletion(markingField[selectBall.placeY - 1][selectBall.placeX]);
        }

        // Проверка диагонально нижних шаров
        if (selectBall.placeY != 23) {
            if ((selectBall.placeY + shiftBallPlaceY) % 2 == 0) { // selectBall в чётном ряду
                if (markingField[selectBall.placeY][selectBall.placeX - 1] != null &&
                    markingField[selectBall.placeY][selectBall.placeX - 1].isExist &&
                    selectBall.type == markingField[selectBall.placeY][selectBall.placeX - 1].type) {
                    // Проверка диагонально нижнего левого шара от выбранного, который в чётном ряду
                    setupDeletion(markingField[selectBall.placeY][selectBall.placeX - 1]);
                }
                if (markingField[selectBall.placeY][selectBall.placeX] != null &&
                    markingField[selectBall.placeY][selectBall.placeX].isExist &&
                    selectBall.type == markingField[selectBall.placeY][selectBall.placeX].type) {
                    // Проверка диагонально нижнего правого шара от выбранного, который в чётном ряду
                    setupDeletion(markingField[selectBall.placeY][selectBall.placeX]);
                }
            } else { // selectBall в нечётном ряду
                if (selectBall.placeX != 1 && // selectBall не крайний левый
                    markingField[selectBall.placeY][selectBall.placeX - 2] != null &&
                    markingField[selectBall.placeY][selectBall.placeX - 2].isExist &&
                    selectBall.type == markingField[selectBall.placeY][selectBall.placeX - 2].type) {
                    // Проверка диагонально нижнего левого шара от выбранного, который в нечётном ряду
                    setupDeletion(markingField[selectBall.placeY][selectBall.placeX - 2]);
                }
                if (selectBall.placeX != 11 && // selectBall не крайний правый
                    markingField[selectBall.placeY][selectBall.placeX - 1] != null &&
                    markingField[selectBall.placeY][selectBall.placeX - 1].isExist &&
                    selectBall.type == markingField[selectBall.placeY][selectBall.placeX - 1].type) {
                    // Проверка диагонально нижнего правого шара от выбранного, который в нечётном ряду
                    setupDeletion(markingField[selectBall.placeY][selectBall.placeX - 1]);
                }
            }
        }

        // Проверка диагонально верхних шаров
        if (selectBall.placeY != 1) {
            // Проверка на недостижение верха
            if ((selectBall.placeY + shiftBallPlaceY) % 2 == 0) { // selectBall в чётном ряду
                if (markingField[selectBall.placeY - 2][selectBall.placeX - 1] != null &&
                    markingField[selectBall.placeY - 2][selectBall.placeX - 1].isExist &&
                    selectBall.type == markingField[selectBall.placeY - 2][selectBall.placeX - 1].type) {
                    // Проверка диагонально верхнего левого шара от выбранного, который в чётном ряду
                    setupDeletion(markingField[selectBall.placeY - 2][selectBall.placeX - 1]);
                }
                if (markingField[selectBall.placeY - 2][selectBall.placeX ] != null &&
                    markingField[selectBall.placeY - 2][selectBall.placeX].isExist &&
                    selectBall.type == markingField[selectBall.placeY - 2][selectBall.placeX].type) {
                    // Проверка диагонально верхнего правого шара от выбранного, который в чётном ряду
                    setupDeletion(markingField[selectBall.placeY - 2][selectBall.placeX]);
                }
            }
            else { // selectBall в нечётном ряду
                if (selectBall.placeX != 1 && // selectBall не крайний левый
                    markingField[selectBall.placeY - 2][selectBall.placeX - 2] != null &&
                    markingField[selectBall.placeY - 2][selectBall.placeX - 2].isExist &&
                    selectBall.type == markingField[selectBall.placeY - 2][selectBall.placeX - 2].type) {
                    // Проверка диагонально верхнего левого шара от выбранного, который в нечётном ряду
                    setupDeletion(markingField[selectBall.placeY - 2][selectBall.placeX - 2]);
                }
                if (selectBall.placeX != 11 && // selectBall не крайний правый
                    markingField[selectBall.placeY - 2][selectBall.placeX - 1] != null &&
                    markingField[selectBall.placeY - 2][selectBall.placeX - 1].isExist &&
                    selectBall.type == markingField[selectBall.placeY - 2][selectBall.placeX - 1].type) {
                    // Проверка диагонально верхнего правого шара от выбранного, который в нечётном ряду
                    setupDeletion(markingField[selectBall.placeY - 2][selectBall.placeX - 1]);
                }
            }
        }
        ballsDelete.add(selectBall);
	}

	@SuppressWarnings("SuspiciousIndentation")
    void spawnNewMainBall(){
        // Появление нового главного шарика
		ArrayList<Integer> colorMainBalls = new ArrayList<>();
        for (int i = 0; i < MAX_COUNT_ROW; i++) {
            for (int j = 0; j < MAX_COUNT_IN_ROW; j++) {
                if (markingField[i][j] != null)
                    if (!colorMainBalls.contains(markingField[i][j].type))
                        colorMainBalls.add(markingField[i][j].type);
            }
        }
		mainBall = new MainBall(colorMainBalls);
		oldMainBalls.add(mainBall);
		if (oldMainBalls.size() > 3)
        // это наверное проверка на тройное совпадение цвета, хз
			while (oldMainBalls.get(0) == mainBall &&
				oldMainBalls.get(1) == mainBall &&
				oldMainBalls.get(2) == mainBall){
				mainBall = new MainBall(colorMainBalls);
				oldMainBalls.remove(0);
			}
		colorMainBalls.clear();
	}

	void start() {
        // Функция запуска уровня с нуля
        score = 0;
        isLose = false;
        isWin = false;
        isGameFieldEmpty = false;
        shiftBallPlaceY = 0;
        spawnBalls();
        spawnNewMainBall();
        if (isSound) {
            musBackground.setVolume(0.15f);
            musBackground.play();
        }
	}

	void drawPhases(Ball ball){ // рисование разрушения шариков
		switch (ball.type){
			case 0: batch.draw(imgBallBlue[ball.phase], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
				break;
			case 1: batch.draw(imgBallGreen[ball.phase], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
				break;
			case 2: batch.draw(imgBallOrange[ball.phase], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
				break;
			case 3: batch.draw(imgBallRed[ball.phase], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
		}

	}

	void loadRecords(){
		Preferences prefs = Gdx.app.getPreferences("preferences");
		if (prefs.contains("maxScore"))
			record = prefs.getInteger("maxScore", 0);
	}

	void saveRecords(int score){
		Preferences prefs = Gdx.app.getPreferences("preferences");
		if (!prefs.contains("maxScore")) prefs.putInteger("maxScore", 0);
		if (prefs.getInteger("maxScore") < score)
			prefs.putInteger("maxScore", score);
		prefs.flush();
	}

    void actionsAfterLosing() {
        musBackground.stop();
        sndLose.play();
        saveRecords(score);
        loadRecords();
    }

    void clearGameField() {
        // Очистка игрового поля от шариков
        for (int i = 0; i < MAX_COUNT_ROW; i++) {
            for (int j = 0; j < MAX_COUNT_IN_ROW; j++) {
                if (markingField[i][j] != null)
                    markingField[i][j] = null;
            }
        }
    }

    boolean gameFieldIsEmpty() {
        // Проверка на пустоту в первой строке разметки = определение конец или продолжение игры
        for (int i = 0; i < MAX_COUNT_IN_ROW; i++) {
            if (markingField[0][i] != null) {
                return false;
            }
        }
        return true;
    }

	@Override
	public void show() {
	}

	@SuppressWarnings("SuspiciousIndentation")
    @Override
	public void render(float delta) {
		// игровые события
		if (isSound && !musBackground.isPlaying() && !isWin && !isLose) {
            // если фоновая музыка закончилась, запускает заново
            musBackground.play();
        }

        if (isPressedBack)
            isPressedBack = false;

        if (isFindOverlap) {
            isFindOverlap = false;
            setupDeletion(mainBall);
            if (ballsDelete.size() >= 3) {
                sndBulk.play();
                // Набирается группа из >= 3 шариков, удаляем их
                for (Ball ball : ballsDelete) {
                    ballsAnimate.add(ball);
                    markingField[ball.placeY - 1][ball.placeX - 1] = null;
                }
            }
            else {
                // Шарики воскресают! (они умерли в deletion())
                for (Ball ball : ballsDelete) {
                    ball.isExist = true;
                }
                if (ballsDelete.get(ballsDelete.size() - 1).placeY == 23) {
                    // Главный шарик остановился прямо перед стоп-линией
                    isLose = true;
                    actionsAfterLosing();
                }
            }
            ballsDelete.clear();
            if (!(isGameFieldEmpty = gameFieldIsEmpty()) && !isLose)
                spawnNewMainBall();
        }

		if (Gdx.input.justTouched()) {
            // Произведено нажатие
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch); // масштабирование всех координат
			if (!isLose && !isGameFieldEmpty && !mainBall.fly) {
                // главный шарик не был в полёте
				moves -= 1;
				mainBall.fly = true;
                // далее задаётся скорость и направление главному шарику
				mainBall.vx = (touch.x - mainBall.x) / 70;
				if (mainBall.vx == 0)
					mainBall.vy = SCR_HEIGHT / 45f;
				else {
					mainBall.vy = (touch.y - mainBall.y + Ball.height / 2f) / 70;
					float a = (float) Math.atan(mainBall.vy / mainBall.vx); // угол вылета шара
					float v = SCR_HEIGHT / 45f;
					if (mainBall.vx > 0) {
						mainBall.vx = (float) Math.cos(a) * v;
						mainBall.vy = (float) Math.sin(a) * v;
					}
					else {
						mainBall.vx = -(float) Math.cos(a) * v;
						mainBall.vy = -(float) Math.sin(a) * v;
					}
				}
			}

			if (LEVEL == 6 && moves != 0 && moves%5 == 0) {
                // Добавляем новый ряд в 6 уровне
                Levels.moveLevelSix(markingField);
            }

			if (btnBack.isHit(touch.x, touch.y)){
                // Произведено нажатие на маленькую кнопку "назад"
                musBackground.stop();
                clearGameField();
                isPressedBack = true;
				bub.setScreen(bub.screenLevels);
			}

			if ((isWin || isLose) && btnRetry.isHit(touch.x, touch.y)) {
				// При победе/поражении нажата кнопка "повторить"
                if (isLose)
                    clearGameField();
                start();
            }

			if (isWin) {
                // При победе нажата кнопка "продолжить"
                // Переход на следующий уровень
                if (LEVEL != 6 && btnContinue.isHit(touch.x, touch.y)) {
                    LEVEL += 1;
                    start();
                }
                else if (btnReturn.isHit(touch.x, touch.y)) {
                    clearGameField();
                    bub.setScreen(bub.screenLevels);
                }
            }

            if (isLose && btnReturn.isHit(touch.x, touch.y)){
                // При проигрыше нажата кнопка "вернуться"
                clearGameField();
				bub.setScreen(bub.screenLevels);
			}
		}

		if (!isGameFieldEmpty && !isLose) {
            // Определяет двигаться главному шарику дальше или нет
            mainBall.move();
        }

		if (!isLose && !isGameFieldEmpty && mainBall.y >= SCR_HEIGHT - Ball.height/2) {
            // Шарик вылетает за пределы верхнего поля
			score -= 5;
			spawnNewMainBall();
		}

        if (!isLose && !isWin) {
            // Проверка наложения главного шарика на какой-либо
            int i = MAX_COUNT_ROW - 2;
            while (i >= 0 && !isFindOverlap) {
                for (int j = 0; j < MAX_COUNT_IN_ROW; j++) {
                    if (markingField[i][j] != null) {
                        if (mainBall.overlap(markingField[i][j])) {
                            // Произошло наложение главного шарика на текущий шарик
                            isFindOverlap = true;
                            mainBall.fly = false; // главный шарик остановился
                            mainBall.vx = 0; // скоростьX = 0
                            mainBall.vy = 0; // скоростьY = 0
                            if (mainBall.y >= markingField[i][j].y) {
                                // Главный шарик наложился выше или на уровне горизонта текущего шарика
                                mainBall.y = markingField[i][j].y;
                                mainBall.placeY = markingField[i][j].placeY;
                                if (mainBall.x < markingField[i][j].x) {
                                    // Главный шарик наложился СТРОГО левее вертикали текущего шарика
                                    if (markingField[i][j].placeX != 1) { // -- ПО-ХОРОШЕМУ ОН ЧИСТО ФИЗИЧЕСКИ НЕ СМОЖЕТ ОКАЗАТЬСЯ ЛЕВЕЕ КРАЙНЕГО СЛЕВА
                                        // Текущий шарик не является крайним слева
                                        mainBall.x = markingField[i][j].x - Ball.width;
                                        mainBall.placeX = markingField[i][j].placeX - 1;
                                    }
                                } else {
                                    // Главный шарик наложился НЕСТРОГО правее вертикали текущего шарика
                                    if ((markingField[i][j].placeX != 11 && (markingField[i][j].placeY + shiftBallPlaceY) % 2 != 0) || // -- ПО-ХОРОШЕМУ ОН ЧИСТО ФИЗИЧЕСКИ НЕ СМОЖЕТ ОКАЗАТЬСЯ ПРАВЕЕ КРАЙНЕГО СПРАВА
                                        (markingField[i][j].placeX != 10 && (markingField[i][j].placeY + shiftBallPlaceY) % 2 == 0)) {
                                        // Текущий шарик НЕ является крайним справа
                                        mainBall.x = markingField[i][j].x + Ball.width;
                                        mainBall.placeX = markingField[i][j].placeX + 1;
                                    }
                                }
                            } else {
                                // Главный шарик наложился ниже горизонта текущего шарика
                                mainBall.y = markingField[i][j].y - Ball.height + INTERVAL;
                                mainBall.placeY = markingField[i][j].placeY + 1;
                                if (mainBall.x < markingField[i][j].x) {
                                    // Главный шарик наложился СТРОГО левее вертикали текущего шарика
                                    if ((markingField[i][j].placeY + shiftBallPlaceY) % 2  == 0) {
                                        // Текущий шарик находится в ЧЁТНОМ ряду
                                        mainBall.x = markingField[i][j].x - Ball.width / 2;
                                        mainBall.placeX = markingField[i][j].placeX; // СЛЕВА место в нечётном = место в чётном
                                    } else {
                                        // Текущий шарик находится в НЕЧЁТНОМ ряду
                                        if (markingField[i][j].placeX != 1) {
                                            // Текущий шарик НЕ является крайним слева
                                            mainBall.x = markingField[i][j].x - Ball.width / 2;
                                            mainBall.placeX = markingField[i][j].placeX - 1;
                                        } else {
                                            // Текущий шарик является крайним слева
                                            mainBall.x = markingField[i][j].x + Ball.width / 2;
                                            mainBall.placeX = markingField[i][j].placeX; // СПРАВА место в чётном = место в нечётном
                                        }
                                    }
                                } else {
                                    // Главный шарик наложился НЕСТРОГО правее вертикали текущего шарика
                                    if ((markingField[i][j].placeY + shiftBallPlaceY) % 2 == 0) {
                                        // Текущий шарик находится в ЧЁТНОМ ряду
                                        mainBall.x = markingField[i][j].x + Ball.width / 2;
                                        mainBall.placeX = markingField[i][j].placeX + 1;
                                    } else {
                                        // Текущий шарик находится в НЕЧЁТНОМ ряду
                                        if (markingField[i][j].placeX != 11) {
                                            // Текущий шарик НЕ является крайним справа
                                            mainBall.x = markingField[i][j].x + Ball.width / 2;
                                            mainBall.placeX = markingField[i][j].placeX; // СПРАВА место в чётном = место в нечётном
                                        } else {
                                            // Текущий шарик является крайним справа
                                            mainBall.x = markingField[i][j].x - Ball.width / 2;
                                            mainBall.placeX = markingField[i][j].placeX - 1;
                                        }
                                    }
                                }
                            }
                            markingField[mainBall.placeY - 1][mainBall.placeX - 1] = mainBall; // садим шарик на поле
                            break;
                        }
                    }
                }
                i -= 1;
            }
        }

        // Логика анимации
		for (int i = ballsAnimate.size() - 1; i >= 0; i--) {
			ballsAnimate.get(i).animation();
			if (ballsAnimate.get(i).phase == Ball.nFaz){
                score += 5 ;
				ballsAnimate.remove(i);
			}
		}

        if (LEVEL != 6 && moves == 0 && !isGameFieldEmpty && !mainBall.fly) {
            // Игра проиграна
            if (!isLose) {
                isLose = true;
                actionsAfterLosing();
            }
        }

        if (isGameFieldEmpty && !isLose){
            // Игра выиграна
            if (!isWin && !isPressedBack){
                isWin = true;
                if (isSound) {
                    musBackground.stop();
                    sndWin.play();
                }
                saveRecords(score);
                loadRecords();
            }
        }


		// рисовка
		ScreenUtils.clear(0, 0, 0.2f, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined); // масштабирование всех координат
		batch.begin();
        // Рисование заднего фона
		if (LEVEL <= 3)
			batch.draw(imgBackgroundLevelFirst, 0, 0, SCR_WIDTH, SCR_HEIGHT);
		else
			batch.draw(imgBackgroundLevelSecond, 0, 0, SCR_WIDTH, SCR_HEIGHT);

		if (!isLose && LEVEL != 6) {
            // рисование количества оставшихся ходов (6 уровень - бесконечный, поэтому исключение)
            font.draw(batch, Integer.toString(moves), SCR_WIDTH * 55 / 100f, SCR_HEIGHT / 20f);
        }

		font.draw(batch, "СЧЁТ: " + score, 0, SCR_HEIGHT - Ball.width/6f);
		font.draw(batch, "УРОВЕНЬ: " + LEVEL, SCR_WIDTH*62/100f, SCR_HEIGHT - Ball.width/6f);

		for (int i = 0; i < ballsAnimate.size(); i++)
            // Рисование поэтапного разрушения шарика
			drawPhases(ballsAnimate.get(i));

        for (int i = 0; i < MAX_COUNT_ROW; i++) {
            // Рисование всех шариков на поле
            for (int j = 0; j < MAX_COUNT_IN_ROW; j++) {
                if (markingField[i][j] != null)
                    batch.draw(imgBall[markingField[i][j].type],markingField[i][j].x - Ball.width/2f, markingField[i][j].y - Ball.height/2f, Ball.width, Ball.height);
            }
        }

		if (!isLose && !isWin)
            // Рисование главного шарика
			batch.draw(imgBall[mainBall.type], mainBall.x - Ball.width/2f, mainBall.y - Ball.height/2f, Ball.width, Ball.height);

		if (isLose){
			batch.draw(imgFrame, frame.x, frame.y, frame.width, frame.height);
			fontWin.draw(batch, "Вы проиграли :(", SCR_WIDTH/7f, SCR_HEIGHT/1.4f);
			fontWin.draw(batch, "Рекорд: " + record, SCR_WIDTH/7f, SCR_HEIGHT/1.6f);
			fontWin.draw(batch, "Ваш счёт: " + score, SCR_WIDTH/7f, SCR_HEIGHT/1.78f);
			fontWin.draw(batch, btnRetry.text, btnRetry.x, btnRetry.y);
			fontWin.draw(batch, btnReturn.text, btnReturn.x, btnReturn.y);
		}
		if (isWin){
			batch.draw(imgFrame, frame.x, frame.y, frame.width, frame.height);
			fontWin.draw(batch, "Вы выиграли :)", SCR_WIDTH/6f, SCR_HEIGHT/1.4f);
			fontWin.draw(batch, "Рекорд: " + record, SCR_WIDTH/7f, SCR_HEIGHT/1.58f);
			fontWin.draw(batch, "Ваш счёт: " + score, SCR_WIDTH/7f, SCR_HEIGHT/1.75f);
			fontWin.draw(batch, btnRetry.text, btnRetry.x, btnRetry.y);
            if (LEVEL != 6)
    			fontWin.draw(batch, btnContinue.text, btnContinue.x, btnContinue.y);
            else
                fontWin.draw(batch, btnReturn.text, btnReturn.x, btnReturn.y);
		}
		batch.draw(imgBtnBack, btnBack.x, btnBack.y, btnBack.width, btnBack.height);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		System.gc();
		batch.dispose();
		imgAtlasBall.dispose();
		imgAtlBallBlue.dispose();
		imgAtlBallGreen.dispose();
		imgAtlBallOrange.dispose();
		imgAtlBallRed.dispose();
		imgBackgroundLevelFirst.dispose();
		imgBackgroundLevelSecond.dispose();
		imgBtnBack.dispose();
		imgFrame.dispose();
		font.dispose();
		fontWin.dispose();
		sndWin.dispose();
		sndLose.dispose();
		sndBulk.dispose();
		musBackground.dispose();
	}
}
