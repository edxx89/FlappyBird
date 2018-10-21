package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.obstacles.Obstacles;
import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background, secondBackground, thirdBackground;
    private KeyboardListener key;
    private Obstacles obstacles;
    private int counter;
    private int speed = -4;
    private Picture gameOver;
    private Sound sound;

    Text text = new Text(420, 20, "SCORE: ");


    public void init() {
        background = new Picture(0, 0, "background.jpg");
        secondBackground = new Picture(background.getWidth(),0, "background.jpg");
        thirdBackground = new Picture(background.getWidth() * 2, 0, "background.jpg");
        background.draw();
        secondBackground.draw();
        player = new Player();
        key = new KeyboardListener(player);
        obstacles = new Obstacles();
        gameOver = new Picture(0, 0, "gameover.jpg");
        sound = new Sound("/Users/codecadet/Project/FlappyBird/resources/background.wav");
    }

    public void start() {
        int score = 0;
        int iCounter = 0;
        obstacles.setObstacles();
        text.grow(20, 10);
        text.setColor(Color.ORANGE);
        text.draw();
        sound.open();

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
            moveBackground();
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
        gameOver();
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

    public void moveBackground () {
        background.translate(speed,0);
        secondBackground.translate(speed,0);

        if (background.getX() < -background.getWidth() && background.getX() > -background.getWidth() - 20) {
            background.translate(background.getWidth() * 2,0);
        }

        if (secondBackground.getX() < -background.getWidth() && secondBackground.getX() > -background.getWidth() - 20) {
            secondBackground.translate(background.getWidth() * 2, 0);
        }

        if (thirdBackground.getX() < -background.getWidth() && thirdBackground.getX() > -background.getWidth() - 20) {
            thirdBackground.translate(background.getWidth() * 2, 0);
        }
    }

    public void improvedSpeed() {
        if (speed > -10) {
            speed = --speed;
            System.out.println(speed);
        }
    }


    public void gameOver() {
        gameOver.draw();
    }
}
