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
        if (player.getImage().getX() < obstacle.getBottomChosen().getX() + obstacle.getBottomChosen().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacle.getBottomChosen().getX() &&
                player.getImage().getY() < obstacle.getBottomChosen().getY() + obstacle.getBottomChosen().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacle.getBottomChosen().getY()){

            player.die();
        }

        if (player.getImage().getX() < obstacle.getTopChosen().getX() + obstacle.getTopChosen().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacle.getTopChosen().getX() &&
                player.getImage().getY() < obstacle.getTopChosen().getY() + obstacle.getTopChosen().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacle.getTopChosen().getY()) {

            player.die();
        }
    }



}
