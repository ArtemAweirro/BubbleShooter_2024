package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;

public class ScreenSettings implements Screen {

    final BubbleShooter bub;

    BitmapFont font;
    Texture imgSoundOn, imgSoundOff;
    Texture imgPointUP, imgPointDOWN;

    Button btnSound, btnUp, btnDown;
    BuButton btnReturn;

    boolean isStart = true;

    public ScreenSettings(BubbleShooter bub) {
        this.bub = bub;
        bub.batch = new SpriteBatch();
        bub.camera = new OrthographicCamera();
        bub.camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        bub.touch = new Vector3();

        imgSoundOn = new Texture("imgSoundOn.png");
        imgSoundOff = new Texture("imgSoundOff.png");
        imgPointUP = new Texture("imgUp.png");
        imgPointDOWN = new Texture("imgDown.png");

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("appetite.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = SCR_WIDTH/10;
        parameter.color = Color.valueOf("#5C349A");
        font = generator.generateFont(parameter);

        btnSound = new Button(SCR_WIDTH*5/8f, SCR_HEIGHT*21/30f, ScreenGame.SCR_WIDTH/7.5f, ScreenGame.SCR_WIDTH/7.5f);
        btnUp = new Button(SCR_WIDTH*6/8f, SCR_HEIGHT*16/30f, ScreenGame.SCR_WIDTH/7.5f, ScreenGame.SCR_WIDTH/7.5f);
        btnDown = new Button(SCR_WIDTH*6/8f, SCR_HEIGHT*45/100f, ScreenGame.SCR_WIDTH/7.5f, ScreenGame.SCR_WIDTH/7.5f);
        btnReturn = new BuButton(SCR_WIDTH*2/8, SCR_HEIGHT/8, font, "НАЗАД");
    }

    @Override
    public void show() {
    }

    void saveSettings(){
        Preferences prefs = Gdx.app.getPreferences("preferences");
        prefs.putInteger("row", bub.screenGame.countRows);
        prefs.putBoolean("sound", bub.screenGame.isSound);
        prefs.flush();
    }

    void loadSettings(){
        Preferences pref = Gdx.app.getPreferences("preferences");
        if (pref.contains("row")) bub.screenGame.countRows = pref.getInteger("row", 3);
        if (pref.contains("sound")) bub.screenGame.isSound = pref.getBoolean("sound", true);
        if (bub.screenGame.countRows == 0) bub.screenGame.countRows = 3;
    }

    @Override
    public void render(float delta) {
        if (isStart){
            isStart = false;
            loadSettings();
        }
        if (Gdx.input.justTouched()){
            bub.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            bub.camera.unproject(bub.touch);
            if (btnSound.isHit(bub.touch.x, bub.touch.y)){
                bub.screenGame.isSound = !bub.screenGame.isSound;
                if (bub.screenGame.isSound) bub.screenGame.sndBulk.play();
            }
            if (btnUp.isHit(bub.touch.x, bub.touch.y) && bub.screenGame.countRows < 20) {
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                bub.screenGame.countRows++;
            }
            if (btnDown.isHit(bub.touch.x, bub.touch.y) && bub.screenGame.countRows > 1){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                bub.screenGame.countRows--;
            }
            if (btnReturn.isHit(bub.touch.x, bub.touch.y)){
                if (bub.screenGame.isSound) bub.screenMenu.sndClick.play();
                bub.setScreen(bub.screenMenu);
            }
            saveSettings();
        }

        bub.camera.update();
        bub.batch.setProjectionMatrix(bub.camera.combined);
        bub.batch.begin();
        bub.batch.draw(bub.screenMenu.imgBackground, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        font.draw(bub.batch, "ЗВУК ", SCR_WIDTH/4f, SCR_HEIGHT*3/4f);
        font.draw(bub.batch, "СТРОЧЕК \n 6 уровня    " + bub.screenGame.countRows, SCR_WIDTH/15f, SCR_HEIGHT*59/100f);
        bub.batch.draw(imgPointUP, btnUp.x, btnUp.y, btnUp.width, btnUp.height);
        bub.batch.draw(imgPointDOWN, btnDown.x, btnDown.y, btnDown.width, btnDown.height);
        font.draw(bub.batch, btnReturn.text, btnReturn.x, btnReturn.y);
        if (bub.screenGame.isSound) bub.batch.draw(imgSoundOn, btnSound.x, btnSound.y, btnSound.width, btnSound.height);
        if (!bub.screenGame.isSound) bub.batch.draw(imgSoundOff, btnSound.x, btnSound.y, btnSound.width, btnSound.height);
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
        imgSoundOn.dispose();
        imgSoundOff.dispose();
        imgPointUP.dispose();
        imgPointDOWN.dispose();
        font.dispose();
    }
}
