package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class BubbleShooter extends Game {
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    ScreenMenu screenMenu;
    ScreenGame screenGame;
    ScreenSettings screenSettings;
    ScreenLevels screenLevels;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();
        screenGame = new ScreenGame(this);
        screenSettings = new ScreenSettings(this);
        screenMenu = new ScreenMenu(this);
        screenLevels = new ScreenLevels(this);
        setScreen(screenMenu);
    }
    @Override
    public void dispose() {
        batch.dispose();
        screenGame.dispose();
        screenMenu.dispose();
        screenSettings.dispose();
        screenLevels.dispose();
        super.dispose();
    }
}
