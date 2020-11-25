package lehigh;

import processing.core.PApplet;

public class MovingBalls2 extends PApplet{


    public void settings(){
        size(400,400);
    }

    public void draw(){
        background(0);
        fill(255);
        ellipse(200,200,20,20);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls2"};
        MovingBalls2 movingBalls2 = new MovingBalls2();
        PApplet.runSketch(processingArgs, movingBalls2);
    }
}