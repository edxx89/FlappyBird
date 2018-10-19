package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.obstacles.Obstacle;
import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background;
    private KeyboardListener key;
    private Obstacle obstacle;


    public void init() {
        background = new Picture(0, 0, "background.gif");
        background.draw();
        player = new Player();
        key = new KeyboardListener(player);
        obstacle = new Obstacle();
    }


    public void start() {

        while (!player.isDead()) {
            try {
                Thread.sleep(20);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();

            }
            player.move();
            obstacle.move(-2);
            checkCollision();
        }
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

}
