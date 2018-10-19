package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private Picture[] topPicArr;
    private Picture[] bottomPicArray;
    private Picture bottomChosen;
    private Picture topChosen;
    private int obstaclesSpeed;


    public Obstacle(){

        topPicArr = new Picture[10];

        topPicArr[0] = new Picture(600, 0, "MarianaUp.png");
        topPicArr[1] = new Picture(600, 0, "chicoUp.png");
        topPicArr[2] = new Picture(600, 0, "carlaoUp.png");
        topPicArr[3] = new Picture(600, 0, "turtleUp.png");
        topPicArr[4] = new Picture(600, -10, "pigup.png");
        topPicArr[5] = new Picture(600, 0, "EdgardoUp.png");
        topPicArr[6] = new Picture(600, 0, "audreyUp.png");
        topPicArr[7] = new Picture(600, 0, "marcioUp.png");
        topPicArr[8] = new Picture(600, 0, "icecreamUp.png");
        topPicArr[9] = new Picture(600, 0, "tinoUp.png");

        bottomPicArray = new Picture[10];

        bottomPicArray[0] = new Picture(600, 356,"icecreamDown.png");
        bottomPicArray[1] = new Picture(600, 300, "audreyDown.png");
        bottomPicArray[2] = new Picture(600, 450, "pig.png");
        bottomPicArray[3] = new Picture(600, 191, "EdgardoDown.png");
        bottomPicArray[4] = new Picture(600, 170, "carlaoDown.png");
        bottomPicArray[5] = new Picture(600, 409, "turtleDown.png");
        bottomPicArray[6] = new Picture(600, 300, "chicoDown.png");
        bottomPicArray[7] = new Picture(600, 379, "tinoDown.png");
        bottomPicArray[8] = new Picture(600, 245, "MarianaDown.png");
        bottomPicArray[9] = new Picture(600, 221, "marcioDown.png");

    }

    public void setObstacles() {
        int random = (int) Math.floor(Math.random() * 10);
        this.topChosen = topPicArr[random];
        topChosen.draw();
        this.bottomChosen = bottomPicArray[random];
        bottomChosen.draw();
    }

    public Picture getBottomChosen(){
        return bottomChosen;

    }

    public Picture getTopChosen() {
        return topChosen;
    }

    public void move(int speed) {
        int counter = 0;
        this.obstaclesSpeed = speed;
        setObstacles();
        while(getBottomChosen().getX() > -100) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            bottomChosen.translate(speed, 0);
            topChosen.translate(speed, 0);
            counter++;

            if(counter > 150){
                System.out.println(counter);
                counter = 0;
                speed--;
                System.out.println(speed);
            }
        }
        bottomChosen.translate(700,0);
        topChosen.translate(700,0);
        setObstacles();
        move(speed);
        }
        
}

