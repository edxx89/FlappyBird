package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Obstacles {

    private Picture[] topPicArray;
    private Picture[] bottomPicArray;

    private LinkedList<Picture> topPictures = new LinkedList<>();
    private LinkedList<Picture> bottomPictures = new LinkedList<>();

    private LinkedList<Picture> swapTopPictures = new LinkedList<>();
    private LinkedList<Picture> swapBottomPictures = new LinkedList<>();




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
        int random = (int) (Math.random() * topPictures.size());

        swapTopPictures.add(topPictures.get(random));
        swapBottomPictures.add(bottomPictures.get(random));

        swapTopPictures.get(swapTopPictures.size()-1).draw();
        swapBottomPictures.get(swapBottomPictures.size()-1).draw();

        topPictures.remove(random);
        bottomPictures.remove(random);

    }

    public LinkedList<Picture> getSwapTopPictures() {
        return swapTopPictures;
    }

    public LinkedList<Picture> getSwapBottomPictures() {
        return swapBottomPictures;
    }

    public void move(int speed) {

        if (swapTopPictures.get(0).getX() < - 88) {

            swapTopPictures.get(0).translate(700,0);
            swapBottomPictures.get(0).translate(700, 0);
            topPictures.add(swapTopPictures.get(0));
            bottomPictures.add(swapBottomPictures.get(0));
            swapTopPictures.remove(0);
            swapBottomPictures.remove(0);
        }

        if (swapTopPictures.get(swapTopPictures.size()-1).getX() <= 220 && (swapTopPictures.get(swapTopPictures.size()-1).getX() >= 200)) {
            setObstacles();

        }

        for (int i = 0; i < swapTopPictures.size(); i++) {
            swapBottomPictures.get(i).translate(speed, 0);
            swapTopPictures.get(i).translate(speed, 0);
        }
    }

}

