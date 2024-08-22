package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_WIDTH;

public class Map {
    int x, y; // координаты постановки карты на устройстве (ЛЕВЫЙ НИЖНИЙ УГОЛ)
    int width, height;
    int srcX, srcY; // координаты в источнике (изображение)
    int sizeStep; // размер шага
    int countStep; // количество шагов по экрану
    final static int MAX_COUNT_STEP = 4;

    public Map(int x, int y, int srcWidth, int srcHeight) {
        this.x = x;
        this.y = y;
        srcX = x;
        srcY = y;
        width = srcWidth;
        height = srcHeight;
        sizeStep = SCR_HEIGHT/MAX_COUNT_STEP;
        countStep = 0;
    }

    boolean isHit(float tx, float ty){
        return tx>x && tx<x+SCR_WIDTH/8f && ty>y && ty<y+SCR_WIDTH/8f;
    }

    void moveUP(){
        countStep -= 1;
        srcY -= height/(2*MAX_COUNT_STEP);
    }

    void moveDOWN(){
        countStep += 1;
        srcY += height/(2*MAX_COUNT_STEP);
    }
}
