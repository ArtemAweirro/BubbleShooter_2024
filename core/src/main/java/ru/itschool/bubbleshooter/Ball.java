package ru.itschool.bubbleshooter;

import com.badlogic.gdx.utils.TimeUtils;

public class Ball {
    static int size = 11;
    int x, y;

    static int width;
    static int height = width = (int) (ScreenGame.SCR_WIDTH/11.5f);
    int type;
    int placeX, placeY; // место в ряду
    boolean isExist;
    int faza;
    static int nFaz = 3;
    long timeFazaInterval = 100, timeLastFazaShow;

    public Ball(int x, int y, int type, int placeX, int placeY) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.placeX = placeX;
        this.placeY = placeY;
        isExist = true;
        faza = 0;
    }

    void animation(){
        if (TimeUtils.millis() - timeLastFazaShow >= timeFazaInterval){
            faza++;
            timeLastFazaShow = TimeUtils.millis();
        }
    }
}
