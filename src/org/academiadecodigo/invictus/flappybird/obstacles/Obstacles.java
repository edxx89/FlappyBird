package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacles {

    private Picture[]  topPicArray;
    private Picture[] bottomPicArray;
    private Picture bottomPic;
    private Picture topPic;

    public Obstacles(){

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
        topPic = topPicArray[random];
        topPic.draw();

        bottomPic = bottomPicArray[random];
        bottomPic.draw();

    }

    public Picture getBottomPic(){
        return bottomPic;
    }

    public Picture getTopPic() {
        return topPic;
    }

    public void move(int speed) {

        if(bottomPic.getX() < - 100) {
            bottomPic.translate(700,0);
            topPic.translate(700,0);
            setObstacles();
        }

        bottomPic.translate(speed,0);
        topPic.translate(speed,0);


    }

}

