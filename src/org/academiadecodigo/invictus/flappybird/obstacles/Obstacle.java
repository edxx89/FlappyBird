package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private Picture[] topPicArray;
    private Picture[] bottomPicArray;
    private Picture bottomPic;
    private Picture topPic;
    private int obstaclesSpeed;


    public Obstacle(){

        topPicArray = new Picture[7];

        topPicArray[0] = new Picture(600, -1, "topTino.png");
        topPicArray[1] = new Picture(600, -84, "topChico.png");
        topPicArray[2] = new Picture(600, -116, "topIceCream.png");
        topPicArray[3] = new Picture(600, -113, "topTurtle.png");
        topPicArray[4] = new Picture(600, -29, "topMarcio.png");
        topPicArray[5] = new Picture(600, -9, "topEdgardo.png");
        topPicArray[6] = new Picture(600, 0, "topCarlao.png");


        bottomPicArray = new Picture[7];

        bottomPicArray[0] = new Picture(600, 300,"bottomAudrey.png");
        bottomPicArray[1] = new Picture(600, 250, "bottomMariana.png");
        bottomPicArray[2] = new Picture(600, 200, "bottomEdgardo.png");
        bottomPicArray[3] = new Picture(600, 170, "bottomCarlao.png");
        bottomPicArray[4] = new Picture(600, 350, "bottomIceCream.png");
        bottomPicArray[5] = new Picture(600, 400, "bottomChico.png");
        bottomPicArray[6] = new Picture(600, 430, "bottomTurtle.png");

    }

    public void setObstacles() {
        int random = (int) Math.floor(Math.random() * 7);
        this.topPic = topPicArray[random];
        topPic.draw();
        this.bottomPic = bottomPicArray[random];
        bottomPic.draw();
    }

    public Picture getBottomPic(){
        return bottomPic;

    }

    public Picture getTopPic() {
        return topPic;
    }

    public void move(int speed) {
        int counter = 0;
        this.obstaclesSpeed = speed;
        setObstacles();
        while(getBottomPic().getX() > -100) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            bottomPic.translate(speed, 0);
            topPic.translate(speed, 0);
            counter++;

            if(counter > 150){
                System.out.println(counter);
                counter = 0;
                speed = speed - 2;
                System.out.println(speed);
            }
        }
        bottomPic.translate(700,0);
        topPic.translate(700,0);
        setObstacles();
        move(speed);
        }
        
}

