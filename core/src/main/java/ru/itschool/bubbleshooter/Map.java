package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

public class Map {
    int x, y;
    int width, height;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        width = SCR_WIDTH;
        height = SCR_HEIGHT;
    }

    boolean isHit(float tx, float ty){
        return tx>x && tx<x+SCR_WIDTH/8f && ty>y && ty<y+SCR_WIDTH/8f;
    }

    void moveUP(){
        y = y + SCR_WIDTH/4;
    }

    void moveDOWN(){
        y = y - SCR_WIDTH/4;
    }
}
