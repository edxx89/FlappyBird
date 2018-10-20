package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.obstacles.Obstacle;
import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background;
    private KeyboardListener key;
    private Obstacle obstacle;
    private int counter;
    private int speed = -2;
    private Picture gameOver;


    public void init() {
        background = new Picture(0, 0, "background.gif");
        background.draw();
        gameOver = new Picture(0,0,"gameover.jpg");
        player = new Player();
        key = new KeyboardListener(player);
        obstacle = new Obstacle();
    }


    public void start() {

        obstacle.setObstacles();

        while (!player.isDead()) {
            try {
                Thread.sleep(20);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();

            }

            obstacle.move(speed);
            player.move();
            checkCollision();
            counter++;

            if (counter > 200) {
                improveSpeed();
                counter = 0;
            }
        }
    }

    public void gameOver() {
         gameOver.draw();
    }

    public void checkCollision(){
        if (player.getImage().getX() < obstacle.getBottomPic().getX() + obstacle.getBottomPic().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacle.getBottomPic().getX() &&
                player.getImage().getY() < obstacle.getBottomPic().getY() + obstacle.getBottomPic().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacle.getBottomPic().getY()){

            player.die();
        }

        if (player.getImage().getX() < obstacle.getTopPic().getX() + obstacle.getTopPic().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacle.getTopPic().getX() &&
                player.getImage().getY() < obstacle.getTopPic().getY() + obstacle.getTopPic().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacle.getTopPic().getY()) {

            player.die();
        }
    }

    public void improveSpeed() {
        this.speed = --speed;
    }
    
}
