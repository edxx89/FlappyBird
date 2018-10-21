package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Obstacles {

    private LinkedList<Picture> topPictures = new LinkedList<>();
    private LinkedList<Picture> bottomPictures = new LinkedList<>();

    private LinkedList<Picture> swapTopPictures = new LinkedList<>();
    private LinkedList<Picture> swapBottomPictures = new LinkedList<>();


    public Obstacles() {

        topPictures.add(new Picture(511, -26, "topTino.png"));
        topPictures.add(new Picture(511, -109, "topChico.png"));
        topPictures.add(new Picture(511, -141, "topIceCream.png"));
        topPictures.add(new Picture(511, -138, "topTurtle.png"));
        topPictures.add(new Picture(511, -54, "topMarcio.png"));
        topPictures.add(new Picture(511, -34, "topEdgardo.png"));
        topPictures.add(new Picture(511, -25, "topCarlao.png"));


        bottomPictures.add(new Picture(511, 325, "bottomAudrey.png"));
        bottomPictures.add(new Picture(511, 275, "bottomMariana.png"));
        bottomPictures.add(new Picture(511, 225, "bottomEdgardo.png"));
        bottomPictures.add(new Picture(511, 195, "bottomCarlao.png"));
        bottomPictures.add(new Picture(511, 375, "bottomIceCream.png"));
        bottomPictures.add(new Picture(511, 425, "bottomChico.png"));
        bottomPictures.add(new Picture(511, 455, "bottomTurtle.png"));

    }

    public void setObstacles() {
        int random = (int) (Math.random() * topPictures.size());

        swapTopPictures.add(topPictures.get(random));
        swapBottomPictures.add(bottomPictures.get(random));

        swapTopPictures.get(swapTopPictures.size() - 1).draw();
        swapBottomPictures.get(swapBottomPictures.size() - 1).draw();

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

        if (swapTopPictures.get(0).getX() < -88) {

            swapTopPictures.get(0).translate(700, 0);
            swapBottomPictures.get(0).translate(700, 0);
            topPictures.add(swapTopPictures.get(0));
            bottomPictures.add(swapBottomPictures.get(0));
            swapTopPictures.remove(0);
            swapBottomPictures.remove(0);
        }

        if (swapTopPictures.get(swapTopPictures.size() - 1).getX() <= 220 && (swapTopPictures.get(swapTopPictures.size() - 1).getX() >= 200)) {
            setObstacles();

        }

        for (int i = 0; i < swapTopPictures.size(); i++) {
            swapBottomPictures.get(i).translate(speed, 0);
            swapTopPictures.get(i).translate(speed, 0);
        }
    }

}

