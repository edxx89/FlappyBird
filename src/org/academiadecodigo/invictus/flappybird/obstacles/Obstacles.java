package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Obstacles {

    private Picture[] topPicArray;
    private Picture[] bottomPicArray;
    private Picture bottomPic;
    private Picture topPic;
    private Picture secondBottomPic;
    private Picture secondTopPic;
    private Picture thirdBottomPic;
    private Picture thirdTopPic;
    private LinkedList<Picture> topPictures = new LinkedList<>();
    private LinkedList<Picture> bottomPictures = new LinkedList<>();
    private LinkedList<Picture> swapTopPictures = new LinkedList<>();


    public Obstacles() {

        topPicArray = new Picture[7];


        topPicArray[0] = new Picture(511, -1, "topTino.png");
        topPicArray[1] = new Picture(511, -84, "topChico.png");
        topPicArray[2] = new Picture(511, -116, "topIceCream.png");
        topPicArray[3] = new Picture(511, -113, "topTurtle.png");
        topPicArray[4] = new Picture(511, -29, "topMarcio.png");
        topPicArray[5] = new Picture(511, -9, "topEdgardo.png");
        topPicArray[6] = new Picture(511, 0, "topCarlao.png");

        for (int i = 0; i < topPicArray.length; i++) {
            topPictures.add(topPicArray[i]);
        }


        bottomPicArray = new Picture[7];

        bottomPicArray[0] = new Picture(511, 300, "bottomAudrey.png");
        bottomPicArray[1] = new Picture(511, 250, "bottomMariana.png");
        bottomPicArray[2] = new Picture(511, 200, "bottomEdgardo.png");
        bottomPicArray[3] = new Picture(511, 170, "bottomCarlao.png");
        bottomPicArray[4] = new Picture(511, 350, "bottomIceCream.png");
        bottomPicArray[5] = new Picture(511, 400, "bottomChico.png");
        bottomPicArray[6] = new Picture(511, 430, "bottomTurtle.png");

        for (int i = 0; i < bottomPicArray.length; i++) {
            bottomPictures.add(bottomPicArray[i]);
        }
    }

    public void setObstacles() {
        int random = (int) Math.floor(Math.random() * 7);

        topPic = topPictures.get(random);
        Picture topPicTemp = topPic;
        topPic.draw();
        topPictures.remove(random);
        swapTopPictures.add(topPicTemp);


        topPic = topPicArray[random];
        topPic.draw();

        bottomPic = bottomPicArray[random];
        bottomPic.draw();

        if (random < 6) {
            secondTopPic = topPicArray[random + 1];
            secondTopPic.translate(300, 0);
            secondTopPic.draw();

            secondBottomPic = bottomPicArray[random + 1];
            secondBottomPic.translate(300, 0);
            secondBottomPic.draw();

        } else if (random == 6) {
            secondTopPic = topPicArray[random - 1];
            secondTopPic.translate(300, 0);
            secondTopPic.draw();

            secondBottomPic = bottomPicArray[random - 1];
            secondBottomPic.translate(300, 0);
            secondBottomPic.draw();
        }

        if (random < 5) {
            thirdTopPic = topPicArray[random + 2];
            thirdTopPic.translate(600, 0);
            thirdTopPic.draw();

            thirdBottomPic = bottomPicArray[random + 2];
            thirdBottomPic.translate(600, 0);
            thirdBottomPic.draw();

        } else {
            thirdTopPic = topPicArray[random - 2];
            thirdTopPic.translate(600, 0);
            thirdTopPic.draw();

            thirdBottomPic = bottomPicArray[random - 2];
            thirdBottomPic.translate(600, 0);
            thirdBottomPic.draw();
        }

    }

    public Picture getBottomPic() {
        return bottomPic;
    }

    public Picture getTopPic() {
        return topPic;
    }

    public Picture getSecondBottomPic() {
        return secondBottomPic;
    }

    public Picture getSecondTopPic() {
        return secondTopPic;
    }

    public void move(int speed) {

        if (thirdBottomPic.getX() < - 88) {
            bottomPic.translate(1300, 0);
            topPic.translate(1300, 0);

            secondBottomPic.translate(1000, 0);
            secondTopPic.translate(1000, 0);

            thirdBottomPic.translate(700, 0);
            thirdTopPic.translate(700,0);
            setObstacles();
        }


        bottomPic.translate(speed, 0);
        topPic.translate(speed, 0);
        secondBottomPic.translate(speed, 0);
        secondTopPic.translate(speed, 0);
        thirdBottomPic.translate(speed,0);
        thirdTopPic.translate(speed,0);

    }

}

