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
import java.util.Collections;

public class ScreenGame implements Screen {
	public static final int SCR_WIDTH = 468;
	public static final int SCR_HEIGHT = 962;
	public static final int INTERVAL = Ball.height/10; // интервал спавна между шариками

	final BubbleShooter bub;

	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;

	Texture imgAtlasBall;
	TextureRegion[] imgBall;
	Texture imgAtlBallBlue, imgAtlBallOrange, imgAtlBallGreen, imgAtlBallRed;
	TextureRegion[] imgBallBlue, imgBallOrange, imgBallGreen, imgBallRed;
	Texture imgBackground1, imgBackground2;
	Texture imgBtnBack, imgFrame;

	Sound sndBulk, sndWin, sndLose;
	Music musBackground;

	BitmapFont font, fontWin;

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
	boolean isStart = true;
	boolean isEnd = false;
	boolean isWin = false;
	boolean isLose = false;
	boolean isSound = true;
	boolean isTouchBack = false;

	int moves; // кол-во ходов в игре
	int score = 0;
	int record;

	public ScreenGame(BubbleShooter bub) {
		this.bub = bub;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();

		imgBall = new TextureRegion[4];
		imgAtlasBall = new Texture("atlasBall.png");
		imgBackground1 = new Texture("imgBackground1.png");
		imgBackground2 = new Texture("imgBackground2.jpg");
		imgBtnBack = new Texture("imgBack.png");
		imgFrame = new Texture("frame.jpg");
		for (int i = 0; i < imgBall.length; i++)
			imgBall[i] = new TextureRegion(imgAtlasBall, i*300, 0, 300, 300);

		imgAtlBallBlue = new Texture("atlasBallBlue.png");
		imgAtlBallGreen = new Texture("atlasBallGreen.png");
		imgAtlBallOrange = new Texture("atlasBallOrange.png");
		imgAtlBallRed = new Texture("atlasBallRed.png");
		imgBallBlue = new TextureRegion[3];
		for (int i = 0; i < imgBallBlue.length; i++)
			imgBallBlue[i] = new TextureRegion(imgAtlBallBlue, i*300, 0, 300, 300);
		imgBallGreen = new TextureRegion[3];
		for (int i = 0; i < imgBallGreen.length; i++)
			imgBallGreen[i] = new TextureRegion(imgAtlBallGreen, i*300, 0, 300, 300);
		imgBallOrange = new TextureRegion[3];
		for (int i = 0; i < imgBallOrange.length; i++)
			imgBallOrange[i] = new TextureRegion(imgAtlBallOrange, i*300, 0, 300, 300);
		imgBallRed = new TextureRegion[3];
		for (int i = 0; i < imgBallRed.length; i++)
			imgBallRed[i] = new TextureRegion(imgAtlBallRed, i*300, 0, 300, 300);

		sndBulk = Gdx.audio.newSound(Gdx.files.internal("sndBulk.mp3"));
		sndWin = Gdx.audio.newSound(Gdx.files.internal("sndWin.mp3"));
		sndLose = Gdx.audio.newSound(Gdx.files.internal("sndLose.mp3"));
		musBackground = Gdx.audio.newMusic(Gdx.files.internal("musBackground.mp3"));

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("appetite.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
		parameter.size = SCR_WIDTH/15;
		parameter.color = Color.valueOf("#FFBD88");
		font = generator.generateFont(parameter);

		parameter.size = SCR_WIDTH/10;
		parameter.color = Color.valueOf("#8B0000"); //#960018 был
		fontWin = generator.generateFont(parameter);

		balls = new ArrayList<>();
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

	void spawnBalls(){
		switch (LEVEL){
			case 1: Levels.spawnLevelOne(balls);
				moves = 15;
				break;
			case 2: Levels.spawnLevelTwo(balls);
				moves = 30;
				break;
			case 3: Levels.spawnLevelThree(balls);
				moves = 25;
				break;
			case 4: Levels.spawnLevelFour(balls);
				moves = 33;
				break;
			case 5: Levels.spawnLevelFive(balls);
				moves = 25;
				break;
			case 6:
				bub.screenSettings.loadSettings();
				Levels.spawnLevelSix(balls, countRows);
				moves = 0;
				break;
		}
	}


	int placeYInRow(Ball ball){ // определение места шарика по вертикали
		int k = 1;
		for (int i = 1; i <= 24; i++){
			k += 2;
			if (SCR_HEIGHT - k*Ball.height/2 + i*INTERVAL == ball.y)
				return i;
		}
		return 0;
	}

	int placeXInRow(Ball ball){ // определение места шарика по горизонтали
		for (int i = 1; i <= Ball.size; i++)
			if ((ball.x == (i-1)*Ball.width + Ball.width/2) ||
					(ball.x == (i-1)*Ball.width + Ball.width))
				return i;
		return 0;
	}

	void deletion(){
		for (int i = 0; i < balls.size()-1; i++) {
			if (balls.get(i).x + Ball.width == balls.get(balls.size() - 1).x && balls.get(i).y == balls.get(balls.size()-1).y &&
					balls.get(i).type == balls.get(balls.size() - 1).type){
				ballsIndexDelete.add(i); // крайний левый
				ballsDelete.add(balls.get(i));
			}
			if (balls.get(i).x - Ball.width == balls.get(balls.size() - 1).x && balls.get(i).y == balls.get(balls.size()-1).y &&
					balls.get(i).type == balls.get(balls.size() - 1).type){
				ballsIndexDelete.add(i); // крайний правый
				ballsDelete.add(balls.get(i));
			}
			if (balls.get(i).x + Ball.width / 2 == balls.get(balls.size() - 1).x &&
					balls.get(i).y - Ball.height + INTERVAL == balls.get(balls.size() - 1).y &&
					balls.get(i).type == balls.get(balls.size() - 1).type){
				ballsIndexDelete.add(i); // левый сверху
				ballsDelete.add(balls.get(i));
			}
			if (balls.get(i).x - Ball.width / 2 == balls.get(balls.size() - 1).x &&
					balls.get(i).y - Ball.height + INTERVAL == balls.get(balls.size() - 1).y &&
					balls.get(i).type == balls.get(balls.size() - 1).type){
				ballsIndexDelete.add(i); // правый сверху
				ballsDelete.add(balls.get(i));
			}
			if (balls.get(i).x + Ball.width / 2 == balls.get(balls.size() - 1).x &&
					balls.get(i).y + Ball.height - INTERVAL == balls.get(balls.size() - 1).y &&
					balls.get(i).type == balls.get(balls.size() - 1).type){
				ballsIndexDelete.add(i); // левый снизу
				ballsDelete.add(balls.get(i));
			}
			if (balls.get(i).x - Ball.width / 2 == balls.get(balls.size() - 1).x &&
					balls.get(i).y + Ball.height - INTERVAL == balls.get(balls.size() - 1).y &&
					balls.get(i).type == balls.get(balls.size() - 1).type){
				ballsIndexDelete.add(i); // правый снизу
				ballsDelete.add(balls.get(i));
			}
		}

		while (!ballsDelete.isEmpty()){
			boolean check;
			for (int j = 0; j < ballsDelete.size(); j++){
				for (int i = 0; i < balls.size()-1; i++) {
					check = true;
					for (int k = 0; k < ballsIndexDelete.size(); k++)
						if (i == ballsIndexDelete.get(k)) {  // если шарик уже в списке удаленных, то проверки его не будет
							check = false;
							break;
						}
					if (check){
						if (balls.get(i).x + Ball.width == ballsDelete.get(j).x && balls.get(i).y == ballsDelete.get(j).y && balls.get(i).type == ballsDelete.get(j).type){
							ballsIndexDelete.add(i); // крайний левый
							ballsDelete.add(balls.get(i));
						}
						if (balls.get(i).x - Ball.width == ballsDelete.get(j).x && balls.get(i).y == ballsDelete.get(j).y && balls.get(i).type == ballsDelete.get(j).type){
							ballsIndexDelete.add(i); // крайний правый
							ballsDelete.add(balls.get(i));
						}
						if (balls.get(i).x + Ball.width / 2 == ballsDelete.get(j).x && balls.get(i).y - Ball.height + INTERVAL == ballsDelete.get(j).y && balls.get(i).type == ballsDelete.get(j).type){
							ballsIndexDelete.add(i); // левый сверху
							ballsDelete.add(balls.get(i));
						}
						if (balls.get(i).x - Ball.width / 2 == ballsDelete.get(j).x && balls.get(i).y - Ball.height + INTERVAL == ballsDelete.get(j).y && balls.get(i).type == ballsDelete.get(j).type){
							ballsIndexDelete.add(i); // правый сверху
							ballsDelete.add(balls.get(i));
						}
						if (balls.get(i).x + Ball.width / 2 == ballsDelete.get(j).x && balls.get(i).y + Ball.height - INTERVAL == ballsDelete.get(j).y && balls.get(i).type == ballsDelete.get(j).type){
							ballsIndexDelete.add(i); // левый снизу
							ballsDelete.add(balls.get(i));
						}
						if (balls.get(i).x - Ball.width / 2 == ballsDelete.get(j).x && balls.get(i).y + Ball.height - INTERVAL == ballsDelete.get(j).y && balls.get(i).type == ballsDelete.get(j).type){
							ballsIndexDelete.add(i); // правый снизу
							ballsDelete.add(balls.get(i));
						}
					}
				}
			}
			ballsDelete.clear();
		}
		if (ballsIndexDelete.size() > 1) {
			if(isSound) sndBulk.play();
			ballsIndexDelete.add(balls.size()-1);
			Collections.sort(ballsIndexDelete); // чтобы правильно удалялись шары
			for (int i = ballsIndexDelete.size(); i > 0; i--){
				score += 10;
				ballsAnimate.add(balls.get(ballsIndexDelete.get(i-1)));
				balls.remove((int)ballsIndexDelete.get(i-1));
			}
		}
		ballsIndexDelete.clear();
	}

	void spawnNewMainBall(){
		ArrayList<Integer> colorMainBalls = new ArrayList<>();
		for (int i = 0; i < balls.size(); i++) {
			if (!colorMainBalls.contains(balls.get(i).type))
				colorMainBalls.add(balls.get(i).type);
		}
		mainBall = new MainBall(colorMainBalls);
		oldMainBalls.add(mainBall);
		if (oldMainBalls.size() > 3)
			while (oldMainBalls.get(0) == mainBall &&
				oldMainBalls.get(1) == mainBall &&
				oldMainBalls.get(2) == mainBall){
				mainBall = new MainBall(colorMainBalls);
				oldMainBalls.remove(0);
			}
		colorMainBalls.clear();
	}

	void start(){
		score = 0;
		balls.clear();
		isLose = false;
		isEnd = false;
		isWin = false;
		spawnBalls();
		spawnNewMainBall();
		if (isSound) musBackground.play();
	}

	void drawFazes(Ball ball){
		switch (ball.type){
			case 0: batch.draw(imgBallBlue[ball.faza], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
				break;
			case 1: batch.draw(imgBallGreen[ball.faza], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
				break;
			case 2: batch.draw(imgBallOrange[ball.faza], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
				break;
			case 3: batch.draw(imgBallRed[ball.faza], ball.x - Ball.width/2f, ball.y - Ball.height/2f, Ball.width, Ball.height);
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

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		// игровые события
		if (isStart){
			isStart = false;
			if (isSound) {
				musBackground.setVolume(0.15f);
				musBackground.play();
			}
		}
		if (isSound && !musBackground.isPlaying() && !isWin && !isLose)
			musBackground.play();
		if (Gdx.input.justTouched()) {
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch); // масштабирование всех координат
			if (!balls.isEmpty() && !mainBall.fly) {
				moves -= 1;
				mainBall.fly = true;
				mainBall.vx = (touch.x - mainBall.x + Ball.width / 2f) / 70;
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

			if (LEVEL == 6 && moves%5 == 0 && moves != 0) Levels.moveLevelSix(balls);
			if (btnBack.isHit(touch.x, touch.y)){
				isTouchBack = true;
				balls.clear();
				bub.setScreen(bub.screenLevels);
			}
			if (btnRetry.isHit(touch.x, touch.y) && (isWin || isLose))
				start();
			if (balls.isEmpty() && btnContinue.isHit(touch.x, touch.y))
				bub.setScreen(bub.screenLevels);
			if (isLose && btnReturn.isHit(touch.x, touch.y)){
				balls.clear();
				bub.setScreen(bub.screenLevels);
			}
		}

		if (moves == 0 && !mainBall.fly && LEVEL != 6)
			isLose = true;

		if (!balls.isEmpty() && !isLose) mainBall.move();
		if (!balls.isEmpty() && mainBall.y >= SCR_HEIGHT - Ball.height/2 && !isLose) {
			score -= 5;
			spawnNewMainBall();
		}
		for (int i = 0; i < balls.size(); i++){
			if (balls.get(i).placeY == 23)
				isLose = true;
			if (mainBall.overlap(balls.get(i))) {
				if (mainBall.y > balls.get(i).y) {
					mainBall.y = balls.get(i).y;
					if (mainBall.x <= balls.get(i).x && balls.get(i).x != Ball.width/2){
						mainBall.x = balls.get(i).x - Ball.width;
					}
					else if (mainBall.x >= balls.get(i).x && balls.get(i).x != 440) {
						mainBall.x = balls.get(i).x + Ball.width;
					}
				}
				else {
					mainBall.y = balls.get(i).y - Ball.height + INTERVAL;
					if ((balls.get(i).x != Ball.width/2) && (balls.get(i).x != 440)){
						if (mainBall.x <= balls.get(i).x) mainBall.x = balls.get(i).x - Ball.width/2;
						else if (mainBall.x >= balls.get(i).x) mainBall.x = balls.get(i).x + Ball.width/2;
					}
					else {
						if (balls.get(i).x == Ball.width/2) mainBall.x = balls.get(i).x + Ball.width/2;
						if (balls.get(i).x == 440) mainBall.x = balls.get(i).x - Ball.width/2;
					}
				}
				mainBall.vx = 0;
				mainBall.vy = 0;
				balls.add(mainBall);
				balls.get(balls.size()-1).placeX = placeXInRow(balls.get(balls.size()-1));
				balls.get(balls.size()-1).placeY = placeYInRow(balls.get(balls.size()-1));
				if (balls.get(balls.size()-1).placeY == 23)
					isLose = true;
				if (!isLose){
					deletion();
					if (!balls.isEmpty())
						spawnNewMainBall();
				}
				break;
			}
		}

		for (int i = 0; i < ballsAnimate.size(); i++){
			ballsAnimate.get(i).animation();
			if (ballsAnimate.get(i).faza == Ball.nFaz){
				ballsAnimate.remove(i);
			}
		}

		if (balls.isEmpty() && !isLose && !isTouchBack){
			if (!isWin && isSound){
				isWin = true;
				musBackground.stop();
				sndWin.play();
				saveRecords(score);
				loadRecords();
			}
		}
		if (isSound && isLose){
			if (!isEnd){
				isEnd = true;
				mainBall.y = -Ball.height;
				musBackground.stop();
				sndLose.play();
				saveRecords(score);
				loadRecords();
			}
		}

		if (isTouchBack){
			isTouchBack = false;
			musBackground.stop();
		}

		// рисовка
		ScreenUtils.clear(0, 0, 0.2f, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined); // масштабирование всех координат
		batch.begin();
		if (LEVEL <= 3)
			batch.draw(imgBackground1, 0, 0, SCR_WIDTH, SCR_HEIGHT);
		else
			batch.draw(imgBackground2, 0, 0, SCR_WIDTH, SCR_HEIGHT);
		if (!isLose && LEVEL != 6) font.draw(batch, Integer.toString(moves), SCR_WIDTH*55/100f, SCR_HEIGHT/20f);
		font.draw(batch, "СЧЁТ: " + score, 0, SCR_HEIGHT - Ball.width/6f);
		font.draw(batch, "УРОВЕНЬ: " + LEVEL, SCR_WIDTH*62/100f, SCR_HEIGHT - Ball.width/6f);
		for (int i = 0; i < ballsAnimate.size(); i++)
			drawFazes(ballsAnimate.get(i));
		for (int i = 0; i < balls.size(); i++)
			batch.draw(imgBall[balls.get(i).type],balls.get(i).x - Ball.width/2f, balls.get(i).y - Ball.height/2f, Ball.width, Ball.height);
		if (!balls.isEmpty())
			batch.draw(imgBall[mainBall.type], mainBall.x - Ball.width/2f, mainBall.y - Ball.height/2f, Ball.width, Ball.height);
		if (isLose){
			batch.draw(imgFrame, frame.x, frame.y, frame.width, frame.height);
			fontWin.draw(batch, "Вы проиграли :(", SCR_WIDTH/7f, SCR_HEIGHT/1.4f);
			fontWin.draw(batch, "Рекорд: " + record, SCR_WIDTH/7f, SCR_HEIGHT/1.6f);
			fontWin.draw(batch, "Ваш счёт: " + score, SCR_WIDTH/7f, SCR_HEIGHT/1.78f);
			fontWin.draw(batch, btnRetry.text, btnRetry.x, btnRetry.y);
			fontWin.draw(batch, btnReturn.text, btnReturn.x, btnReturn.y);
		}
		if (balls.isEmpty()){
			batch.draw(imgFrame, frame.x, frame.y, frame.width, frame.height);
			fontWin.draw(batch, "Вы выиграли :)", SCR_WIDTH/6f, SCR_HEIGHT/1.4f);
			fontWin.draw(batch, "Рекорд: " + record, SCR_WIDTH/7f, SCR_HEIGHT/1.58f);
			fontWin.draw(batch, "Ваш счёт: " + score, SCR_WIDTH/7f, SCR_HEIGHT/1.75f);
			fontWin.draw(batch, btnRetry.text, btnRetry.x, btnRetry.y);
			fontWin.draw(batch, btnContinue.text, btnContinue.x, btnContinue.y);
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
		imgBackground1.dispose();
		imgBackground2.dispose();
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
