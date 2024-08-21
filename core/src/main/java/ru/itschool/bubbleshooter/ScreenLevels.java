package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenLevels implements Screen {

    final BubbleShooter bub;

    BitmapFont font;
    Texture imgAtlasMap;
    TextureRegion[] imgMap;
    Texture imgLevel;
    Texture imgPointUP, imgPointDOWN;

    BuButton[] buButtons = new BuButton[6];

    Button btnUp, btnDown;

    Map[] map = new Map[2];
    Map[] circle = new Map[6];

    Button btnBack;

    public ScreenLevels(BubbleShooter bub) {
        this.bub = bub;
        bub.batch = new SpriteBatch();
        bub.camera = new OrthographicCamera();
        bub.camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        bub.touch = new Vector3();

        imgAtlasMap = new Texture("imgMapLevel.jpg");
        imgMap = new TextureRegion[2];
        for (int i = imgMap.length - 1; i >= 0; i--)
            imgMap[i] = new TextureRegion(imgAtlasMap, 0, i*SCR_HEIGHT, SCR_WIDTH, SCR_HEIGHT);
        imgLevel = new Texture("imgLevel.png");
        imgPointUP = new Texture("imgUp.png");
        imgPointDOWN = new Texture("imgDown.png");

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("appetite.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = SCR_WIDTH/10;
        parameter.color = Color.valueOf("#755D9A");
        font = generator.generateFont(parameter);

        buButtons[0] = new BuButton(SCR_WIDTH*31/100, SCR_HEIGHT - SCR_HEIGHT*28/100, font, String.valueOf(1));
        circle[0] = new Map(SCR_WIDTH*2/8, SCR_HEIGHT - SCR_HEIGHT/3);
        buButtons[1] = new BuButton(SCR_WIDTH*61/102, SCR_HEIGHT - SCR_HEIGHT*68/110, font, String.valueOf(2));
        circle[1] = new Map(SCR_WIDTH*8/15, SCR_HEIGHT - SCR_HEIGHT*4/6);
        buButtons[2] = new BuButton(SCR_WIDTH*40/100, SCR_HEIGHT/12, font, String.valueOf(3));
        circle[2] = new Map(SCR_WIDTH*3/9, SCR_HEIGHT/31);
        buButtons[3] = new BuButton(SCR_WIDTH*78/100, -SCR_HEIGHT*22/90, font, String.valueOf(4));
        circle[3] = new Map(SCR_WIDTH*13/18, -SCR_HEIGHT*9/30);
        buButtons[4] = new BuButton(SCR_WIDTH*35/110, -SCR_HEIGHT*55/100, font, String.valueOf(5));
        circle[4] = new Map(SCR_WIDTH*2/8, -SCR_HEIGHT + SCR_HEIGHT*4/10);
        buButtons[5] = new BuButton(SCR_WIDTH*51/120, -SCR_HEIGHT + SCR_HEIGHT*24/122, font, String.valueOf(6));
        circle[5] = new Map(SCR_WIDTH*40/110, -SCR_HEIGHT + SCR_HEIGHT/7);

        map[0] = new Map(0, 0);
        map[1] = new Map(0, -SCR_HEIGHT);

        btnUp = new Button(SCR_WIDTH*26/30f, SCR_HEIGHT*16/30f, ScreenGame.SCR_WIDTH/7.5f, ScreenGame.SCR_WIDTH/7.5f);
        btnDown = new Button(SCR_WIDTH*26/30f, SCR_HEIGHT*46/100f, ScreenGame.SCR_WIDTH/7.5f, ScreenGame.SCR_WIDTH/7.5f);
        btnBack = new Button(0, SCR_HEIGHT - Ball.width, Ball.width, Ball.height);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()){
            bub.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            bub.camera.unproject(bub.touch);
            if (btnUp.isHit(bub.touch.x, bub.touch.y) && map[0].y > 0){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                for (int i = 0; i < circle.length; i++){
                    buButtons[i].moveDOWN();
                    circle[i].moveDOWN();
                }
                for (int i = 0; i < map.length; i++)
                    map[i].moveDOWN();
            }
            if (btnDown.isHit(bub.touch.x, bub.touch.y) && map[0].y < SCR_HEIGHT - SCR_WIDTH/4){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                for (int i = 0; i < circle.length; i++){
                    buButtons[i].moveUP();
                    circle[i].moveUP();
                }
                for (int i = 0; i < map.length; i++)
                    map[i].moveUP();
            }
            for (int i = 0; i < circle.length; i++){
                if (circle[i].isHit(bub.touch.x, bub.touch.y)){
                    if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                    bub.screenGame.LEVEL = i+1;
                    bub.screenGame.start();
                    bub.setScreen(bub.screenGame);
                    break;
                }
            }
            if (btnBack.isHit(bub.touch.x, bub.touch.y)){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                bub.setScreen(bub.screenMenu);
            }
        }

        bub.camera.update();
        bub.batch.setProjectionMatrix(bub.camera.combined);
        bub.batch.begin();
        ScreenUtils.clear(Color.valueOf("#FFBD88"));
        for (int i = 0; i < map.length; i++)
            bub.batch.draw(imgMap[i], map[i].x, map[i].y);
        for (int i = 0; i < circle.length; i++)
            bub.batch.draw(imgLevel, circle[i].x, circle[i].y, SCR_WIDTH/8f, SCR_WIDTH/8f);
        for (int i = 0; i < buButtons.length; i++)
            font.draw(bub.batch, buButtons[i].text, buButtons[i].x, buButtons[i].y);
        bub.batch.draw(bub.screenGame.imgBtnBack, btnBack.x, btnBack.y, btnBack.width, btnBack.height);
        bub.batch.draw(imgPointUP, btnUp.x, btnUp.y, btnUp.width, btnUp.height);
        bub.batch.draw(imgPointDOWN, btnDown.x, btnDown.y, btnDown.width, btnDown.height);
        bub.batch.end();
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
    public void dispose() {
        font.dispose();
        imgAtlasMap.dispose();
        imgLevel.dispose();
        imgPointDOWN.dispose();
        imgPointUP.dispose();
    }
}
