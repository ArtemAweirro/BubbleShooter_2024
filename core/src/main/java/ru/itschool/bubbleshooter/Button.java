package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;

public class Button {
    float x, y;
    float width, height;

    public Button(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    boolean isHit(float tx, float ty){
        return tx>x && tx<x+width && ty>y && ty<y+height;
    }

    void moveUP(){
        y = y - (float) SCR_HEIGHT /Map.MAX_COUNT_STEP;
    }
    void moveDOWN(){
        y = y + (float) SCR_HEIGHT /Map.MAX_COUNT_STEP;
    }
}


