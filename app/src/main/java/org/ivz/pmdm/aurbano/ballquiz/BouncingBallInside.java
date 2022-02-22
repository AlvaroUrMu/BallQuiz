package org.ivz.pmdm.aurbano.ballquiz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BouncingBallInside extends View {

    Context context;
    private Ball[] balls;
    private int[] colorEasy = new int[]{Color.RED, Color.YELLOW, Color.BLUE};
    private int[] colorMedium = new int[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.CYAN};
    private int[] colorHard = new int[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.BLACK};
    public static int nBalls;

    public BouncingBallInside(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BouncingBallInside(Context context) {
        super(context);
        init();
    }

    private void init() {

        switch(MainActivity.mode) {
            case 1:
                nBalls = randomNumber(1);
                balls = new Ball[nBalls];

                for (int i = 0; i < nBalls; i++) {
                    for (int j = 0; j < colorEasy.length; j++)
                    balls[i] = (new Ball(randomMove()*50,randomMove()*50,100,20, colorEasy[randomColorEasy()]));
                }
                break;

            case 2:
                nBalls = randomNumber(2);
                balls = new Ball[nBalls];
                for (int i = 0; i < nBalls; i++) {
                    balls[i] = (new Ball(randomMove()*50,randomMove()*50,100,30, colorMedium[randomColorMedium()]));
                }
                break;

            case 3:
                nBalls = randomNumber(3);
                balls = new Ball[nBalls];
                for (int i = 0; i < nBalls; i++) {
                    balls[i] = (new Ball(randomMove()*50,randomMove()*50,100,40, colorHard[randomColorHard()]));
                }
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < nBalls; i++) {
            balls[i].move(canvas);
            canvas.drawOval(balls[i].oval, balls[i].paint);
        }
        invalidate();
    }

    public int randomNumber(int level) {
        int num = 0;
        Random rn = new Random();
        int lowEasy = 5, highEasy = 10;
        int lowMedium = 10, highMedium = 15;
        int lowHard = 15, highHard = 20;

        if(level == 1) {
            num = rn.nextInt(highEasy - lowEasy) + lowEasy;
        } else if(level == 2) {
            num = rn.nextInt(highMedium - lowMedium) + lowMedium;
        } else if(level == 3) {
            num = rn.nextInt(highHard - lowHard) + lowHard;
        }
        return num;
    }

    public int randomMove() {
        int num = 0;
        Random rn = new Random();
        num = rn.nextInt(20) + 1;
        return num;
    }

    public int randomColorEasy() {
        int num = 0;
        Random rn = new Random();
        num = rn.nextInt(3);
        return num;
    }

    public int randomColorMedium() {
        int num = 0;
        Random rn = new Random();
        num = rn.nextInt(5);
        return num;
    }

    public int randomColorHard() {
        int num = 0;
        Random rn = new Random();
        num = rn.nextInt(7);
        return num;
    }
}
