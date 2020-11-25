package lehigh;

import processing.core.PApplet;


import java.util.Arrays;


public class MovingBalls extends PApplet {
    int howManyBalls = 8;
    float x[] = new float[howManyBalls];
    float y[] = new float[howManyBalls];
    float speedX[] = new float[howManyBalls];
    float speedY[] = new float[howManyBalls];
    float color[][] = new float[howManyBalls][3];
    int radius = 30;


    public void settings() {

        size(500, 500);
        Arrays.fill(speedX, 5);
        Arrays.fill(speedY, 5);
        for (int i = 0; i < howManyBalls; i++) {
            x[i] = random(radius, width - radius);
            y[i] = random(radius, height - radius);
            color[i] = new float[]{random(255), random(255), random(255)};
        }


    }

    public void draw() {
        background(0);
        fill(255, 50, 50);
        for (int i = 0; i < howManyBalls; i++) {
            fill(color[i][0], color[i][1], color[i][2]);
            ellipse(x[i], y[i], radius * 2, radius * 2);
            if ((x[i] - radius) <= 0 || (x[i] + radius) >= width) speedX[i] = -speedX[i];

            if ((y[i] - radius) <= 0 || (y[i] + radius) >= width) speedY[i] = -speedY[i];

            x[i] += speedX[i];
            y[i] += speedY[i];

            for (int j = 0; j < howManyBalls; j++) {
                float X = Math.abs(x[i] - x[j]);
                float Y = Math.abs(y[i] - y[j]);

                if ((X <= 60) && Y <= 60)
                    line(x[i], y[i], x[j], y[j]);
            }


        }
    }


        public static void main (String[]args){
            String[] processingArgs = {"MovingBalls"};
            MovingBalls movingBalls = new MovingBalls();
            PApplet.runSketch(processingArgs, movingBalls);
        }

}
