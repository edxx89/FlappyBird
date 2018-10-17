package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Obstacle {

    private Rectangle downRectangle;
    private Rectangle upRectangle;

    public Obstacle(){
        downRectangle = new Rectangle(450,250,50,250);
        downRectangle.setColor(Color.GREEN);
        downRectangle.fill();
        upRectangle = new Rectangle(450,0,50,200);
        upRectangle.setColor(Color.GREEN);
        upRectangle.fill();


    }

    public void move(){
        downRectangle.translate(-1,0);
        upRectangle.translate(-1,0);
    }

    public Rectangle getDownRectangle(){
        return downRectangle;
    }

    public Rectangle getUpRectangle() {
        return upRectangle;
    }
}
