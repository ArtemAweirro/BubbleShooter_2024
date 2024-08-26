package ru.itschool.bubbleshooter;

import static ru.itschool.bubbleshooter.ScreenGame.INTERVAL;
import static ru.itschool.bubbleshooter.ScreenGame.MAX_COUNT_IN_ROW;
import static ru.itschool.bubbleshooter.ScreenGame.MAX_COUNT_ROW;
import static ru.itschool.bubbleshooter.ScreenGame.SCR_HEIGHT;
import static ru.itschool.bubbleshooter.ScreenGame.shiftBallPlaceY;

import com.badlogic.gdx.math.MathUtils;

public class Levels {
    static void makingFirstLevel(Ball[][] marking) {
        marking[0][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 3, 2, 1);
        marking[0][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 3, 3, 1);
        marking[0][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 3, 4, 1);
        marking[0][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 5, 1);
        marking[0][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 6, 1);
        marking[0][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 7, 1);
        marking[0][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 8, 1);
        marking[0][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 9, 1);
        marking[0][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 10, 1);

        marking[1][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 3, 2, 2);
        marking[1][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 3, 3, 2);
        marking[1][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 4, 2);
        marking[1][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 5, 2);
        marking[1][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 6, 2);
        marking[1][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 3, 7, 2);
        marking[1][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 8, 2);
        marking[1][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 9, 2);

        marking[2][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 3, 3);
        marking[2][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 4, 3);
        marking[2][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 5, 3);
        marking[2][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 6, 3);
        marking[2][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 7, 3);
        marking[2][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 8, 3);
        marking[2][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 9, 3);

        marking[3][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 3, 4);
        marking[3][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 4, 4);
        marking[3][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 5, 4);
        marking[3][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 6, 4);
        marking[3][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 7, 4);
        marking[3][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 8, 4);

        marking[4][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 4, 5);
        marking[4][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 5, 5);
        marking[4][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 6, 5);
        marking[4][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 7, 5);
        marking[4][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 8, 5);

        marking[5][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 4, 6);
        marking[5][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 5, 6);
        marking[5][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 6, 6);
        marking[5][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 7, 6);

        marking[6][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 5, 7);
        marking[6][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 6, 7);
        marking[6][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 7, 7);

        marking[7][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 5, 8);
        marking[7][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 6, 8);

        marking[8][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 2, 6, 9);
    }

    static void makingSecondLevel(Ball[][] marking){
        marking[0][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 1, 1);
        marking[0][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 2, 1);
        marking[0][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 3, 3, 1);
        marking[0][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 3, 5, 1);
        marking[0][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 6, 1);
        marking[0][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 7, 1);
        marking[0][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 9, 1);
        marking[0][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 11, 1);

        marking[1][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 1, 2);
        marking[1][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 2, 2);
        marking[1][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 3, 2);
        marking[1][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 4, 2);
        marking[1][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 5, 2);
        marking[1][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 6, 2);
        marking[1][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 7, 2);
        marking[1][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 8, 2);
        marking[1][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 9, 2);
        marking[1][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 10, 2);

        marking[2][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 3, 3);
        marking[2][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 4, 3);
        marking[2][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 5, 3);
        marking[2][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 6, 3);
        marking[2][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 7, 3);
        marking[2][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 8, 3);
        marking[2][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 9, 3);
        marking[2][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 10, 3);


        marking[3][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 2, 4);
        marking[3][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 3, 4);
        marking[3][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 2, 5, 4);
        marking[3][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 6, 4);
        marking[3][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 9, 4);
        marking[3][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 10, 4);

        marking[4][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 6, 5);

        marking[5][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 1, 6);
        marking[5][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 2, 6);
        marking[5][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 3, 6);
        marking[5][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 4, 6);
        marking[5][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 5, 6);
        marking[5][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 6, 6);
        marking[5][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 7, 6);
        marking[5][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 8, 6);
        marking[5][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 9, 6);
        marking[5][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 10, 6);

        marking[6][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 2, 7);
        marking[6][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 3, 7);
        marking[6][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 4, 7);
        marking[6][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 6, 7);
        marking[6][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 7, 7);
        marking[6][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 8, 7);
        marking[6][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 9, 7);
        marking[6][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 10, 7);

        marking[7][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 1, 8);
        marking[7][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 2, 8);
        marking[7][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 3, 8);
        marking[7][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 4, 8);
        marking[7][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 7, 8);
        marking[7][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 8, 8);
        marking[7][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 9, 8);
        marking[7][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 10, 8);

        marking[8][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 2, 9);
        marking[8][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 3, 9);
        marking[8][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 4, 9);
        marking[8][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 2, 8, 9);
        marking[8][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 9, 9);
        marking[8][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 10, 9);
    }

    static void makingThirdLevel(Ball[][] marking){
        marking[0][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 1, 1);
        marking[0][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 2, 1);
        marking[0][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 3, 1);
        marking[0][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 8, 1);
        marking[0][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 9, 1);
        marking[0][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 10, 1);

        marking[1][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 1, 2);
        marking[1][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 2, 2);
        marking[1][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 3, 2);
        marking[1][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 9, 2);
        marking[1][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 10, 2);
        marking[1][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 11, 2);

        marking[2][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 1, 3);
        marking[2][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 2, 3);
        marking[2][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 3, 3);
        marking[2][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 4, 3);
        marking[2][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 1, 5, 3);
        marking[2][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 6, 3);
        marking[2][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 7, 3);
        marking[2][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 8, 3);
        marking[2][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 9, 3);
        marking[2][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 10, 3);

        marking[3][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 1, 4);
        marking[3][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 2, 2, 4);
        marking[3][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 3, 4);
        marking[3][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 4, 4);
        marking[3][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 2, 5, 4);
        marking[3][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 1, 6, 4);
        marking[3][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 1, 7, 4);
        marking[3][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 1, 8, 4);
        marking[3][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 1, 9, 4);
        marking[3][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 1, 10, 4);
        marking[3][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 2, 11, 4);

        marking[4][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 1, 5);
        marking[4][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 2, 5);
        marking[4][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 0, 3, 5);
        marking[4][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 4, 5);
        marking[4][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 5, 5);
        marking[4][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 6, 5);
        marking[4][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 7, 5);
        marking[4][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 0, 8, 5);
        marking[4][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 9, 5);
        marking[4][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 1, 10, 5);

        marking[5][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 1, 6);
        marking[5][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 2, 6);
        marking[5][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 3, 6);
        marking[5][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 4, 6);
        marking[5][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 5, 6);
        marking[5][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 6, 6);
        marking[5][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 7, 6);
        marking[5][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 8, 6);
        marking[5][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 9, 6);
        marking[5][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 1, 10, 6);
        marking[5][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 11, 6);

        marking[6][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 1, 1, 7);
        marking[6][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 2, 7);
        marking[6][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 3, 7);
        marking[6][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 4, 7);
        marking[6][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 5, 7);
        marking[6][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 6, 7);
        marking[6][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 7, 7);
        marking[6][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 8, 7);
        marking[6][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 9, 7);
        marking[6][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 10, 7);

        marking[7][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 1, 8);
        marking[7][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 2, 8);
        marking[7][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 3, 8);
        marking[7][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 4, 8);
        marking[7][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 5, 8);
        marking[7][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 6, 8);
        marking[7][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 7, 8);
        marking[7][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 8, 8);
        marking[7][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 9, 8);
        marking[7][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 10, 8);
        marking[7][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 11, 8);

        marking[8][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 1, 9);
        marking[8][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 2, 9);
        marking[8][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 3, 9);
        marking[8][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 4, 9);
        marking[8][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 5, 9);
        marking[8][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 1, 6, 9);
        marking[8][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 7, 9);
        marking[8][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 8, 9);
        marking[8][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 9, 9);
        marking[8][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 10, 9);

        marking[9][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 3, 2, 10);
        marking[9][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 3, 3, 10);
        marking[9][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 3, 4, 10);
        marking[9][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 5, 10);
        marking[9][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 6, 10);
        marking[9][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 7, 10);
        marking[9][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 8, 10);
        marking[9][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 9, 10);
        marking[9][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 10, 10);
    }

    static void makingFourthLevel(Ball[][] marking){
        marking[0][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 1, 1);
        marking[0][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 2, 1);
        marking[0][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 3, 1);
        marking[0][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 4, 1);
        marking[0][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 5, 1);
        marking[0][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 6, 1);
        marking[0][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 7, 1);
        marking[0][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 8, 1);
        marking[0][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 9, 1);
        marking[0][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 10, 1);
        marking[0][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 1, 11, 1);

        marking[1][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 1, 1, 2);
        marking[1][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 1, 2, 2);
        marking[1][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 1, 3, 2);
        marking[1][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 4, 2);
        marking[1][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 5, 2);
        marking[1][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 6, 2);
        marking[1][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 7, 2);
        marking[1][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 1, 8, 2);
        marking[1][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 1, 9, 2);
        marking[1][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 1, 10, 2);

        marking[2][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 1, 3);
        marking[2][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 2, 3);
        marking[2][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 3, 3);
        marking[2][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 4, 3);
        marking[2][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 5, 3);
        marking[2][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 6, 3);
        marking[2][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 7, 3);
        marking[2][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 8, 3);
        marking[2][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 9, 3);
        marking[2][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 10, 3);
        marking[2][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 2, 11, 3);

        marking[3][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 1, 4);
        marking[3][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 2, 4);
        marking[3][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 3, 4);
        marking[3][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 4, 4);
        marking[3][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 5, 4);
        marking[3][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 6, 4);
        marking[3][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 7, 4);
        marking[3][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 8, 4);
        marking[3][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 9, 4);
        marking[3][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 10, 4);

        marking[4][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 1, 5);
        marking[4][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 0, 2, 5);
        marking[4][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 3, 5);
        marking[4][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 4, 5);
        marking[4][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 5, 5);
        marking[4][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 6, 5);
        marking[4][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 7, 5);
        marking[4][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 8, 5);
        marking[4][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 9, 5);
        marking[4][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 0, 10, 5);
        marking[4][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 11, 5);

        marking[5][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 1, 6);
        marking[5][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 2, 6);
        marking[5][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 3, 6);
        marking[5][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 4, 6);
        marking[5][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 5, 6);
        marking[5][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 6, 6);
        marking[5][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 7, 6);
        marking[5][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 8, 6);
        marking[5][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 9, 6);
        marking[5][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 10, 6);

        marking[6][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 1,  7);
        marking[6][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 2, 7);
        marking[6][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 3, 7);
        marking[6][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 4, 7);
        marking[6][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 5, 7);
        marking[6][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 6, 7);
        marking[6][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 7, 7);
        marking[6][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 8, 7);
        marking[6][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 9, 7);
        marking[6][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 10, 7);
        marking[6][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 11, 7);

        marking[7][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 1, 8);
        marking[7][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 2, 8);
        marking[7][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 3, 8);
        marking[7][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 4, 8);
        marking[7][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 5, 8);
        marking[7][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 6, 8);
        marking[7][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 7, 8);
        marking[7][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 8, 8);
        marking[7][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 9, 8);
        marking[7][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 10, 8);

        marking[8][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 2, 1,  9);
        marking[8][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 2, 9);
        marking[8][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 3, 9);
        marking[8][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 4, 9);
        marking[8][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 5, 9);
        marking[8][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 6, 9);
        marking[8][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 7, 9);
        marking[8][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 8, 9);
        marking[8][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 9, 9);
        marking[8][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 10, 9);
        marking[8][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 2, 11, 9);

        marking[9][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 1, 10);
        marking[9][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 2, 10);
        marking[9][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 3,  10);
        marking[9][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 4, 10);
        marking[9][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 3, 5, 10);
        marking[9][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 3, 6, 10);
        marking[9][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 7, 10);
        marking[9][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 8, 10);
        marking[9][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 9, 10);
        marking[9][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 10, 10);

        marking[10][0] = new Ball(2*INTERVAL + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 1,  11);
        marking[10][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 2, 11);
        marking[10][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 3, 11);
        marking[10][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 4, 11);
        marking[10][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 0, 5, 11);
        marking[10][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 3, 6,  11);
        marking[10][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 0, 7, 11);
        marking[10][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 8, 11);
        marking[10][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 9, 11);
        marking[10][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 10, 11);
        marking[10][10] = new Ball(2*INTERVAL + 10*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 11, 11);

        marking[11][0] = new Ball(2*INTERVAL + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 1, 12);
        marking[11][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 2, 12);
        marking[11][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 3,  12);
        marking[11][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 2, 4, 12);
        marking[11][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 5, 12);
        marking[11][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 6, 12);
        marking[11][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 2, 7, 12);
        marking[11][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 8, 12);
        marking[11][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 9, 12);
        marking[11][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 0, 10, 12);

        marking[12][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 2, 13);
        marking[12][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 3, 13);
        marking[12][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 4, 13);
        marking[12][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 5, 13);
        marking[12][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 6, 13);
        marking[12][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 7, 13);
        marking[12][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 8, 13);
        marking[12][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 9, 13);
        marking[12][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 10,13);

        marking[13][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 29*Ball.height/2 + 14*INTERVAL, 2, 5, 14);
        marking[13][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 29*Ball.height/2 + 14*INTERVAL, 2, 6, 14);

        marking[14][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 31*Ball.height/2 + 15*INTERVAL, 2, 6, 15);
    }

    static void makingFifthLevel(Ball[][] marking) {
        marking[0][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 2, 1);
        marking[0][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 3, 1);
        marking[0][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 4, 1);
        marking[0][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 5, 1);
        marking[0][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 6, 1);
        marking[0][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 7, 1);
        marking[0][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 8, 1);
        marking[0][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 2, 9, 1);
        marking[0][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 3*Ball.height/2 + INTERVAL, 0, 10, 1);

        marking[1][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 2, 2);
        marking[1][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 3, 2);
        marking[1][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 3, 4, 2);
        marking[1][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 5, 2);
        marking[1][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 6, 2);
        marking[1][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 3, 7, 2);
        marking[1][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 2, 8, 2);
        marking[1][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 5*Ball.height/2 + 2*INTERVAL, 0, 9, 2);

        marking[2][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 2, 3);
        marking[2][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 3, 3);
        marking[2][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 4, 3);
        marking[2][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 5, 3);
        marking[2][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 6, 3);
        marking[2][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 7, 3);
        marking[2][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 3, 8, 3);
        marking[2][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 9, 3);
        marking[2][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 7*Ball.height/2 + 3*INTERVAL, 0, 10, 3);

        marking[3][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 2, 4);
        marking[3][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 3, 4);
        marking[3][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 4, 4);
        marking[3][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 5, 4);
        marking[3][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 6, 4);
        marking[3][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 7, 4);
        marking[3][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 3, 8, 4);
        marking[3][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 9*Ball.height/2 + 4*INTERVAL, 0, 9, 4);

        marking[4][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 2, 5);
        marking[4][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 0, 3, 5);
        marking[4][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 4, 5);
        marking[4][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 5, 5);
        marking[4][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 6, 5);
        marking[4][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 7, 5);
        marking[4][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 3, 8, 5);
        marking[4][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 0, 9, 5);
        marking[4][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 11*Ball.height/2 + 5*INTERVAL, 2, 10, 5);

        marking[5][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 2, 6);
        marking[5][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 3, 6);
        marking[5][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 4, 6);
        marking[5][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 5, 6);
        marking[5][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 6, 6);
        marking[5][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 3, 7, 6);
        marking[5][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 0, 8, 6);
        marking[5][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 13*Ball.height/2 + 6*INTERVAL, 2, 9, 6);

        marking[6][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 1, 2, 7);
        marking[6][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 3, 7);
        marking[6][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 4, 7);
        marking[6][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 5, 7);
        marking[6][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 6, 7);
        marking[6][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 3, 7, 7);
        marking[6][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 0, 8, 7);
        marking[6][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 2, 9, 7);
        marking[6][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 15*Ball.height/2 + 7*INTERVAL, 1, 10, 7);

        marking[7][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 2, 8);
        marking[7][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 3, 8);
        marking[7][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 4, 8);
        marking[7][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 5, 8);
        marking[7][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 3, 6, 8);
        marking[7][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 0, 7, 8);
        marking[7][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 2, 8, 8);
        marking[7][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 17*Ball.height/2 + 8*INTERVAL, 1, 9, 8);

        marking[8][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 1, 2, 9);
        marking[8][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 1, 3, 9);
        marking[8][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 2, 4, 9);
        marking[8][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 5, 9);
        marking[8][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 3, 6, 9);
        marking[8][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 0, 7, 9);
        marking[8][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 2, 8, 9);
        marking[8][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 1, 9, 9);
        marking[8][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 19*Ball.height/2 + 9*INTERVAL, 1, 10, 9);

        marking[9][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 2, 10);
        marking[9][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 3,  10);
        marking[9][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 2, 4, 10);
        marking[9][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 5, 10);
        marking[9][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 0, 6, 10);
        marking[9][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 2, 7, 10);
        marking[9][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 8, 10);
        marking[9][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 21*Ball.height/2 + 10*INTERVAL, 1, 9, 10);

        marking[10][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 1, 2, 11);
        marking[10][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 1, 3, 11);
        marking[10][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 1, 4, 11);
        marking[10][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 5, 11);
        marking[10][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 0, 6,  11);
        marking[10][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 2, 7, 11);
        marking[10][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 1, 8, 11);
        marking[10][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 1, 9, 11);
        marking[10][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 23*Ball.height/2 + 11*INTERVAL, 1, 10, 11);

        marking[11][1] = new Ball(2*INTERVAL + Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 1, 2, 12);
        marking[11][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 1, 3,  12);
        marking[11][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 1, 4, 12);
        marking[11][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 2, 5, 12);
        marking[11][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 2, 6, 12);
        marking[11][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 1, 7, 12);
        marking[11][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 1, 8, 12);
        marking[11][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width, SCR_HEIGHT - 25*Ball.height/2 + 12*INTERVAL, 1, 9, 12);

        marking[12][1] = new Ball(2*INTERVAL + Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 2, 13);
        marking[12][2] = new Ball(2*INTERVAL + 2*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 3, 13);
        marking[12][3] = new Ball(2*INTERVAL + 3*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 4, 13);
        marking[12][4] = new Ball(2*INTERVAL + 4*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 5, 13);
        marking[12][5] = new Ball(2*INTERVAL + 5*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 6, 13);
        marking[12][6] = new Ball(2*INTERVAL + 6*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 0, 7, 13);
        marking[12][7] = new Ball(2*INTERVAL + 7*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 8, 13);
        marking[12][8] = new Ball(2*INTERVAL + 8*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 9, 13);
        marking[12][9] = new Ball(2*INTERVAL + 9*Ball.width + Ball.width/2, SCR_HEIGHT - 27*Ball.height/2 + 13*INTERVAL, 2, 10,13);
    }

    static void makingSixthLevel(Ball[][] marking, int countRows){
        int k = 1;
        for (int j = 0; j < countRows; j++){
            k += 2;
            for (int i = 0; i <= Ball.size; i++) {
                if ((j + 1) % 2 == 0) {
                    // Чётный ряд
                    if (i != Ball.size)
                        //11-го места нет в нём
                        marking[j][i] = new Ball(2*INTERVAL + i * Ball.width + Ball.width,
                            SCR_HEIGHT - k*Ball.height/2 + (j + 1)*INTERVAL,
                            MathUtils.random(3), i + 1, j + 1);
                }
                else
                    // Нечётный ряд
                    marking[j][i] = new Ball(2 * INTERVAL + i * Ball.width + Ball.width/2,
                        SCR_HEIGHT - k * Ball.height / 2 + (j + 1) * INTERVAL,
                        MathUtils.random(3), i + 1, j + 1);
            }
        }
    }

    static void moveLevelSix(Ball[][] marking) {
        // Множитель смещения, нужен для правильной обработки в дальнейшем
        if (shiftBallPlaceY == 1)
            shiftBallPlaceY = 0;
        else
            shiftBallPlaceY = 1;

        // Смещение существующих шаров
        for (int i = MAX_COUNT_ROW - 1; i >= 0; i--) {
            for (int j = MAX_COUNT_IN_ROW - 1; j >= 0; j--) {
                if (marking[i][j] != null) { // Шар существует
                    // Cмещение шара вниз на 1 ряд
                    marking[i + 1][j] = marking[i][j];
                    marking[i + 1][j].y += -Ball.height + INTERVAL;
                    marking[i + 1][j].placeY += 1;
                    // Очистка прошлого места от объекта
                    marking[i][j] = null; // *------------------------------------------------------Можно оптимизировать: лишнее переназначение памяти!
                }
            }
        }

        // Cоздание новых шаров в первом ряду
        for (int j = 0; j < MAX_COUNT_IN_ROW; j++) {
            if (shiftBallPlaceY == 0) {
                // Шары были в чётном ряду, значит новый ряд будет нечётным
                marking[0][j] = new Ball(2 * INTERVAL + j * Ball.width + Ball.width / 2,
                    SCR_HEIGHT - 3 * Ball.height / 2 + INTERVAL,
                    MathUtils.random(3), j + 1, 1);
            } else {
                // Шары были в нечётном ряду, значит новый ряд будет чётным
                if (j != MAX_COUNT_IN_ROW - 1)
                    // 11-го шара в чётном ряду нет!
                    marking[0][j] = new Ball(2 * INTERVAL + j * Ball.width + Ball.width,
                        SCR_HEIGHT - 3 * Ball.height / 2 + INTERVAL,
                        MathUtils.random(3), j + 1, 1);
                else
                    marking[0][j] = null;
            }
        }
    }
}
