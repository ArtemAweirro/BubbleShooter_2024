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
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenLevels implements Screen {

    final BubbleShooter bub;

    BitmapFont font;
    Texture imgAtlasMap;
    Texture imgLevel;
    Texture imgPointUP, imgPointDOWN;

    Map map;

    Button btnUp, btnDown, btnBack;
    Button[] circleBtn = new Button[6];
    BuButton[] buBtnLevel = new BuButton[6];

    public ScreenLevels(BubbleShooter bub) {
        this.bub = bub;
        bub.batch = new SpriteBatch();
        bub.camera = new OrthographicCamera();
        bub.camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        bub.touch = new Vector3();

        imgAtlasMap = new Texture("imgMapLevel.jpg");
        imgLevel = new Texture("imgLevel.png");
        imgPointUP = new Texture("imgUp.png");
        imgPointDOWN = new Texture("imgDown.png");

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("appetite.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "0123456789";
        parameter.size = SCR_WIDTH/10;
        parameter.color = Color.valueOf("#755D9A");
        font = generator.generateFont(parameter);

        map = new Map(0, 0, imgAtlasMap.getWidth(), imgAtlasMap.getHeight());

        buBtnLevel[0] = new BuButton(SCR_WIDTH*31/100, SCR_HEIGHT - SCR_HEIGHT*28/100, font, String.valueOf(1));
        circleBtn[0] = new Button(SCR_WIDTH*2/8f, SCR_HEIGHT - SCR_HEIGHT/3f, SCR_WIDTH / 8f, SCR_WIDTH / 8f);
        buBtnLevel[1] = new BuButton(SCR_WIDTH*61/102, SCR_HEIGHT - SCR_HEIGHT*68/110, font, String.valueOf(2));
        circleBtn[1] = new Button(SCR_WIDTH*8/15f, SCR_HEIGHT - SCR_HEIGHT*4/6f, SCR_WIDTH / 8f, SCR_WIDTH / 8f);
        buBtnLevel[2] = new BuButton(SCR_WIDTH*40/100, SCR_HEIGHT/12, font, String.valueOf(3));
        circleBtn[2] = new Button(SCR_WIDTH*3/9f, SCR_HEIGHT/31f, SCR_WIDTH / 8f, SCR_WIDTH / 8f);
        buBtnLevel[3] = new BuButton(SCR_WIDTH*78/100, -SCR_HEIGHT*22/90, font, String.valueOf(4));
        circleBtn[3] = new Button(SCR_WIDTH*13/18f, -SCR_HEIGHT*9/30f, SCR_WIDTH / 8f, SCR_WIDTH / 8f);
        buBtnLevel[4] = new BuButton(SCR_WIDTH*35/110, -SCR_HEIGHT*55/100, font, String.valueOf(5));
        circleBtn[4] = new Button(SCR_WIDTH*2/8f, -SCR_HEIGHT + SCR_HEIGHT*4/10f, SCR_WIDTH / 8f, SCR_WIDTH / 8f);
        buBtnLevel[5] = new BuButton(SCR_WIDTH*51/120, -SCR_HEIGHT + SCR_HEIGHT*24/122, font, String.valueOf(6));
        circleBtn[5] = new Button(SCR_WIDTH*40/110f, -SCR_HEIGHT + SCR_HEIGHT/7f, SCR_WIDTH / 8f, SCR_WIDTH / 8f);

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
            if (btnUp.isHit(bub.touch.x, bub.touch.y) && map.countStep > 0){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                for (int i = 0; i < buBtnLevel.length; i++){
                    buBtnLevel[i].moveUP();
                    circleBtn[i].moveUP();
                }
                map.moveUP();
            }
            if (btnDown.isHit(bub.touch.x, bub.touch.y) && map.countStep < Map.MAX_COUNT_STEP){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                for (int i = 0; i < buBtnLevel.length; i++){
                    buBtnLevel[i].moveDOWN();
                    circleBtn[i].moveDOWN();
                }
                map.moveDOWN();
            }
            for (int i = 0; i < circleBtn.length; i++){
                if (circleBtn[i].isHit(bub.touch.x, bub.touch.y)){
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

        bub.batch.draw(imgAtlasMap, map.x, map.y, SCR_WIDTH, SCR_HEIGHT, map.srcX, map.srcY, imgAtlasMap.getWidth(), imgAtlasMap.getHeight()/2, false, false);

        for (Button value : circleBtn) // рисование кружочков уровней
            bub.batch.draw(imgLevel, value.x, value.y, value.width, value.height);

        for (BuButton buBtn : buBtnLevel) // рисование цифр уровней
            font.draw(bub.batch, buBtn.text, buBtn.x, buBtn.y);

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
