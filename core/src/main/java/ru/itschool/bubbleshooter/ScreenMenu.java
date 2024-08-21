package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenMenu implements Screen {

    final BubbleShooter bub;

    Texture imgBackground;

    Sound sndClick;

    BitmapFont font, fontName;
    BuButton btnPlay, btnExit, btnSetting;

    public ScreenMenu(BubbleShooter bub) {
        this.bub = bub;
        bub.batch = new SpriteBatch();
        bub.camera = new OrthographicCamera();
        bub.camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        bub.touch = new Vector3();

        imgBackground = new Texture("imgMenu.jpg");

        sndClick = Gdx.audio.newSound(Gdx.files.internal("sndClick.mp3"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("appetite.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = SCR_WIDTH/9;
        parameter.color = Color.valueOf("#5C349A");
        font = generator.generateFont(parameter);

        parameter.size = SCR_WIDTH/6;
        fontName = generator.generateFont(parameter);

        btnPlay = new BuButton(SCR_WIDTH/2, SCR_HEIGHT*57/100, font, "ИГРАТЬ");
        btnSetting = new BuButton(SCR_WIDTH/2, SCR_HEIGHT*17/100, font, "НАСТРОЙКИ");
        btnExit = new BuButton(SCR_WIDTH/2, SCR_HEIGHT*9/100, font, "ВЫХОД");
        bub.screenSettings.loadSettings();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()){
            bub.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            bub.camera.unproject(bub.touch);
            if (btnPlay.isHit(bub.touch.x, bub.touch.y)){
                if (bub.screenGame.isSound) sndClick.play();
                bub.setScreen(bub.screenLevels);
            }
            if (btnSetting.isHit(bub.touch.x, bub.touch.y)){
                if (bub.screenGame.isSound) sndClick.play();
                bub.setScreen(bub.screenSettings);
            }
            if (btnExit.isHit(bub.touch.x, bub.touch.y))
                Gdx.app.exit();
        }

        bub.camera.update();
        bub.batch.setProjectionMatrix(bub.camera.combined);
        bub.batch.begin();
        bub.batch.draw(imgBackground, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        fontName.draw(bub.batch, "Bubble", SCR_WIDTH*8/100f, SCR_HEIGHT*92/100f);
        fontName.draw(bub.batch, "Shooter", SCR_WIDTH*32/100f, SCR_HEIGHT*80/100f);
        font.draw(bub.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        font.draw(bub.batch, btnSetting.text, btnSetting.x, btnSetting.y);
        font.draw(bub.batch, btnExit.text, btnExit.x, btnExit.y);
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
        imgBackground.dispose();
        sndClick.dispose();
        font.dispose();
        fontName.dispose();
    }
}
