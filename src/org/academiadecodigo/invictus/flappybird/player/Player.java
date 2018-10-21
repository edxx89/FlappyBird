package org.academiadecodigo.invictus.flappybird.player;


import org.academiadecodigo.invictus.flappybird.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private Picture image;
    private boolean dead;
    private Direction direction;
    private float gravity = 0.3f, gravityPlayer = 3f;
    private float velY = 0, velYplayer = 0;
    private final float maxSpeed = 15, maxSpeedPlayer = 13 ;

    public void gravityPlayer () {
        velYplayer += gravityPlayer;

        if (velYplayer > maxSpeedPlayer) {
            velYplayer = maxSpeedPlayer;
        }
    }

    public void gravity() {


        velY += gravity*2;

        if (velY > maxSpeed) {
            velY = maxSpeed;
        }
    }


    public Player() {
        image = new Picture(35, 150, "playerCharacter.png");
        image.draw();
        System.out.println("Draw player");
        direction = Direction.NULL;

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    long previousTime;
    long currentTime;
    long diffTime;

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
                previousTime = System.currentTimeMillis();
                gravityPlayer();
                velY = gravity;
                if (image.getY() > 0) {
                    image.translate(0, -velYplayer);
                }
                break;

            case NULL:
                currentTime = System.currentTimeMillis();

                diffTime = currentTime - previousTime;

                if(diffTime > 30) {
                    gravity();
                    image.translate(0, velY);
                    previousTime = 0;
                    currentTime = 0;
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
