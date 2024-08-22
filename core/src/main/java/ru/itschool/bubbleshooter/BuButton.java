package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class BuButton {
    int x, y;
    float width, height;
    BitmapFont font;
    String text;

    public BuButton(int x, int y, BitmapFont font, String text) {
        this.x = x;
        this.y = y;
        this.font = font;
        this.text = text;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
        this.x -= (int) (width/2);
    }
    boolean isHit(float tx, float ty){
        return tx>x && tx<x+width && ty<y && ty>y-height;
    }

    void moveUP(){
        y = y - SCR_HEIGHT/Map.MAX_COUNT_STEP;
    }
    void moveDOWN(){
        y = y + SCR_HEIGHT/Map.MAX_COUNT_STEP;
    }
}
