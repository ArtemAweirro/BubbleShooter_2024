package ru.itschool.bubbleshooter;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class MainBall extends Ball{
    float vx, vy; // проекции по осям
    boolean fly;

    MainBall(ArrayList<Integer> balls){
        super(ScreenGame.SCR_WIDTH/2,
                Ball.height/2,
                balls.get(MathUtils.random(0, balls.size()-1)),
                0,
                0);
        fly = false;
    }

    void move(){
        x += vx;
        y += vy;
        if (x > ScreenGame.SCR_WIDTH - Ball.width/2 || x < Ball.width/2) vx = -vx;
    }

    boolean overlap(Ball ball){
        int dist;
        dist = (int)Math.sqrt(Math.pow((x - ball.x),2) +
                Math.pow((y - ball.y), 2));
        return dist < Ball.width*7/8;
    }
}
