package lehigh;

import processing.core.PApplet;

public class BubbleSortTextProcessing extends PApplet {
    int[] arr = {99, 33, 15, 38, 26, 11, 19};
    float[] x = {20, 70, 120, 170, 220, 270, 320};
    float y = 130;

    int i = 0;
    int max = arr.length - 1;

    boolean inSwap = false;

    public void settings() {
        size(400, 230);
    }

    public void drawText(boolean fillPurple){
        for(int k = 0; k < arr.length; k ++) {
            fill(196); // Grey
            textSize(16);
            if (k == i  || k == i + 1) {
                if(fillPurple)
                    fill(255, 0, 255); // Purple
                else
                    fill(0, 0, 255); // Blue
            }
            if (k > max) {
                fill(0, 255, 0); // Green
            }
            text(Integer.toString(arr[k]), x[k], y);
        }
    }




    public void swap ( int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }


        public void draw () {
            delay(800);
            background(0);

            if (i >= max) {
                i = 0;
                max--;
            }
            if (arr[i] > arr[i + 1]) {
                if (!inSwap) {
                    drawText(false);
                    inSwap = true;

                }


                else {
                    swap(i, i + 1);
                    drawText(true);
                    inSwap = false;
                }
            }
            else drawText(false);
            if(!inSwap)
                i ++;
        }


    public static void main (String[]args){
            String[] processingArgs = {"BubbleSortTextProcessing"};
            BubbleSortTextProcessing bubbleSortTextProcessing = new BubbleSortTextProcessing();
            PApplet.runSketch(processingArgs, bubbleSortTextProcessing);
        }
    }

