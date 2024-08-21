package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

public class Frame{
    float x, y;
    float width, height;

    public Frame() {
        this.x = SCR_WIDTH/22f;
        this.y = SCR_HEIGHT/3.2f;
        this.width = SCR_WIDTH*92/100f;
        this.height = SCR_HEIGHT*45/100f;
    }
}
