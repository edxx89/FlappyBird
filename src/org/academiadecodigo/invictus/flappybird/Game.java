package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.obstacles.Obstacles;
import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background;
    private KeyboardListener key;
    private Obstacles obstacles;
    private int counter;
    private int speed = -2;
    private Picture gameOver;
    Text text = new Text(420, 20, "SCORE: ");


    public void init() {
        background = new Picture(0, 0, "background.gif");
        background.draw();
        gameOver = new Picture(0, 0, "gameover.jpg");
        player = new Player();
        key = new KeyboardListener(player);
        obstacles = new Obstacles();
    }

    public void start() {
        int score = 0;
        int iCounter = 0;

        obstacles.setFirstObstacles();
        text.grow(20, 10);
        text.setColor(Color.ORANGE);
        text.draw();

        while (!player.isDead()) {
            try {
                Thread.sleep(20);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            for (int i = 0; i < obstacles.getSwapTopPictures().size(); i++) {
                if (player.getImage().getY() > 470 ||
                        (player.getImage().getY() < 30 && player.getImage().getX() == obstacles.getSwapTopPictures().get(i).getX())) {
                    player.die();
                }
            }

            obstacles.move(speed);
            player.move();
            //moveBackground();
            checkCollision();
            counter++;
            iCounter++;


            if (counter > 250) {
                improvedSpeed();
                counter = 0;
            }

            if (iCounter == 100) {
                score += 5;
                text.setText("SCORE: " + score);
                iCounter = 0;
            }
        }

    }


    public void checkCollision() {
        for (int i = 0; i < obstacles.getSwapTopPictures().size(); i++) {

            if (player.getImage().getX() < obstacles.getSwapBottomPictures().get(i).getX() + obstacles.getSwapBottomPictures().get(i).getWidth() &&
                    player.getImage().getX() + player.getImage().getWidth() > obstacles.getSwapBottomPictures().get(i).getX() &&
                    player.getImage().getY() < obstacles.getSwapBottomPictures().get(i).getY() + obstacles.getSwapBottomPictures().get(i).getHeight() &&
                    player.getImage().getY() + player.getImage().getHeight() > obstacles.getSwapBottomPictures().get(i).getY()) {

                player.die();
            }

            if (player.getImage().getX() < obstacles.getSwapTopPictures().get(i).getX() + obstacles.getSwapTopPictures().get(i).getWidth() &&
                    player.getImage().getX() + player.getImage().getWidth() > obstacles.getSwapTopPictures().get(i).getX() &&
                    player.getImage().getY() < obstacles.getSwapTopPictures().get(i).getY() + obstacles.getSwapTopPictures().get(i).getHeight() &&
                    player.getImage().getY() + player.getImage().getHeight() > obstacles.getSwapTopPictures().get(i).getY()) {

                player.die();
            }
        }
    }

    /*public void moveBackground () {
        background.translate(speed,0);
    }*/

    public void improvedSpeed() {
        if (speed > -11) {
            speed = --speed;
        }
    }


    public void gameOver() {
        gameOver.draw();
    }
}
