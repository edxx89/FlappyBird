package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.obstacles.Obstacle;
import org.academiadecodigo.invictus.flappybird.obstacles.ObstacleFactory;
import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background;
    private KeyboardListener key;
    private Obstacle obstacle;
    private ObstacleFactory factory;
    private Picture[] downObstacles;

    public void init() {
        background = new Picture(0, 0, "background.gif");
        background.draw();
        player = new Player();
        key = new KeyboardListener(player);
        obstacle = new Obstacle();

        while (!player.isDead()) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            player.move();
            obstacle.move();
            checkCollision();
        }
    }

    public void checkCollision() {
        if (player.getImage().getX() < obstacle.getDownRectangle().getX() + obstacle.getDownRectangle().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacle.getDownRectangle().getX() &&
                player.getImage().getY() < obstacle.getDownRectangle().getY() + obstacle.getDownRectangle().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacle.getDownRectangle().getY()) {

            player.die();
        }

        if (player.getImage().getX() < obstacle.getUpRectangle().getX() + obstacle.getUpRectangle().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacle.getUpRectangle().getX() &&
                player.getImage().getY() < obstacle.getUpRectangle().getY() + obstacle.getUpRectangle().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacle.getUpRectangle().getY()) {

            player.die();
        }
    }

    private void drawObstacles(){
        downObstacles = factory.createObstacles();

        for (int i = 0; i < downObstacles.length; i++) {
            downObstacles[i].draw();
            for (int j = 1; j < downObstacles.length; j++) {
                if (downObstacles[i].getX() == 450) {
                    downObstacles[j].draw();
                }
            }
        }
    }
}
