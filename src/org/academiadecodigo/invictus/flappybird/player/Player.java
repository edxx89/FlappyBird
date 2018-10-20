package org.academiadecodigo.invictus.flappybird.player;

import org.academiadecodigo.invictus.flappybird.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private Picture image;
    private boolean dead;
    private Direction direction;


    public Player(){
        image = new Picture(10, 150 , "bird copy.png");
        image.draw();
        direction = Direction.NULL;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }


    public void move(){

       switch (direction) {

           case UP:
               if(image.getY() > 7) {
                   image.translate(0, -10);
               }
               break;

           case DOWN:
               if(image.getY() < 445) {
                   image.translate(0, 10);
               }
               break;

           case NULL:
               image.translate(0,0);
               break;
       }

    }

    public Picture getImage(){
        return image;
    }

    public boolean isDead() {
        return dead;
    }

    public void die(){
        dead = true;
    }
}
