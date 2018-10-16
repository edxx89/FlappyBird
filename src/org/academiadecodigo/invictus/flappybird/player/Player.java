package org.academiadecodigo.invictus.flappybird.player;


import org.academiadecodigo.invictus.flappybird.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.sql.SQLOutput;

public class Player {

    private Picture image;
    private boolean dead;
    private Direction direction;


    public Player(){
        image = new Picture(10, 150 , "character2.png");

        //image.translate( image.getX() + 20, 0);

        image.draw();
        direction = Direction.NULL;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }


    public void move(){

       switch (direction) {

           case UP:
               image.translate(0,-10);
               break;

           case DOWN:
               image.translate(0,10);
               break;

           case NULL:
               image.translate(0,0);
               break;
       }

    }

    public boolean isDead() {
        return dead;
    }
}
