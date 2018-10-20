package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.obstacles.Obstacles;
import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background;
    private KeyboardListener key;
    private Obstacles obstacles;
    private int counter;
    private int speed = -2;
    private Picture gameOver;


    public void init() {
        background = new Picture(0, 0, "background.gif");
        background.draw();
        gameOver = new Picture(0,0,"gameover.jpg");
        player = new Player();
        key = new KeyboardListener(player);
        obstacles = new Obstacles();
    }


    public void start() {
        obstacles.setObstacles();

        while (!player.isDead()) {
            try {
                Thread.sleep(20);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            obstacles.move(speed);
            player.move();
            checkCollision();
            counter++;

            if (counter > 100) {
                improvedSpeed();
                counter = 0;
            }
        }
    }

    public void gameOver() {
         gameOver.draw();
    }

    public void checkCollision(){
        if (player.getImage().getX() < obstacles.getBottomPic().getX() + obstacles.getBottomPic().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacles.getBottomPic().getX() &&
                player.getImage().getY() < obstacles.getBottomPic().getY() + obstacles.getBottomPic().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacles.getBottomPic().getY()){

            player.die();
        }

        if (player.getImage().getX() < obstacles.getTopPic().getX() + obstacles.getTopPic().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacles.getTopPic().getX() &&
                player.getImage().getY() < obstacles.getTopPic().getY() + obstacles.getTopPic().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacles.getTopPic().getY()) {

            player.die();
        }
    }

    public void improvedSpeed () {
        speed = --speed;
    }
}
