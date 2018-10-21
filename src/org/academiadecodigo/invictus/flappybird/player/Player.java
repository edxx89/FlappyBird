package org.academiadecodigo.invictus.flappybird.player;


import org.academiadecodigo.invictus.flappybird.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private Picture image;
    private boolean dead;
    private Direction direction;
    private int i = 0;


    public Player() {
        image = new Picture(10, 150, "playerCharacter.png");
        image.draw();
        direction = Direction.NULL;

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public void move() {

        switch (direction) {

            /*case UP:
                if (image.getY() > 0) {
                    image.translate(0, -10);
                }
                break;

            case DOWN:
                if (image.getY() < 450) {
                    image.translate(0, 10);
                }
                break;*/
            case JUMP:
                for (int i = 0; i < 6; i++) {
                    image.translate(0, -i);
                }
                break;

            case NULL:
                for (i = 0; i < 5; i++) {
                    image.translate(0, i);
                    System.out.println(i);
                }
                break;

        }

    }

    public Picture getImage() {
        return image;
    }

    public boolean isDead() {
        return dead;
    }

    public void die() {
        dead = true;
    }
}
