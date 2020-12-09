package lehigh;

import processing.core.PApplet;

import java.util.ArrayList;
import  java.util.Random;

public class MovingBalls2 extends PApplet{
    class Ball{
        int x, y, radius;
        float speedx, speedy, directionx, directiony;
        int [] color;

        Ball(){
            radius = (int) random(5,20);
            x = (int) random(width - radius);
            y = (int) random(width - radius);
            speedx = random(0.8f,1.4f);
            speedy = random(0.8f,1.4f);
            color = new int[]{ (int) random(255), (int)random(255), (int)random(255)};

        }

        public void move(){
            fill(color[0], color[1], color[2]);
                    ellipse(x, y, radius, radius);
            if(x > (width -radius)|| x < (radius))
            speedx = - speedx;
            if(y > (height - radius)|| y < (radius))
            speedy = - speedy;
            x += speedx;
            y += speedy;
        }

    }

    ArrayList<Ball> balls;
    int numClick = 0;



    public void settings(){
        size(400,400);
        balls = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            balls.add(new Ball());
        }
    }

    public void draw() {
        background(0);
        fill(255);
        for (Ball ball : balls) {
           ball.move();
        }
        textSize(32);
        fill(255, 255, 255, 100);
        text("score: " + Integer.toString(numClick), 10, 90);
    }

    @Override
    public void mouseClicked(){
            for(Ball b: balls)
            if(Math.abs(mouseX - b.x) <= b.radius && Math.abs(mouseY - b.y) <= b.radius)
            {
                numClick += 1;
//              b.radius = 0;
              b.speedx *=1.5;
              b.speedy *=1.5;




            }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls2"};
        MovingBalls2 movingBalls2 = new MovingBalls2();
        PApplet.runSketch(processingArgs, movingBalls2);
    }
}
