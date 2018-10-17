package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private Picture downRectangle;
    private Picture upRectangle;

    public Obstacle(){
        downRectangle = new Picture(450,300, "tinoDown.png");
        downRectangle.draw();
        upRectangle = new Picture(450,0,"carlaoUp.png");
        upRectangle.draw();

    }

    public void move(){
        downRectangle.translate(-2,0);
        upRectangle.translate(-2,0);
    }

    public Picture getDownRectangle(){
        return downRectangle;
    }

    public Picture getUpRectangle() {
        return upRectangle;
    }
}
