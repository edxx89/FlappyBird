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
    Text text = new Text(420,20,"SCORE: ");


    public void init() {
        background = new Picture(0, 0, "background.gif");
        background.draw();
        gameOver = new Picture(0,0,"gameover.jpg");
        player = new Player();
        key = new KeyboardListener(player);
        obstacles = new Obstacles();
    }




    public void start() {
        int score = 0;
        int iCounter = 0;

        obstacles.setObstacles();
        text.grow(20,10);
        text.setColor(Color.ORANGE);
        text.draw();

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
            iCounter++;


            if (counter > 200) {
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

        if (player.getImage().getX() < obstacles.getSecondBottomPic().getX() + obstacles.getSecondBottomPic().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacles.getSecondBottomPic().getX() &&
                player.getImage().getY() < obstacles.getSecondBottomPic().getY() + obstacles.getSecondBottomPic().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacles.getSecondBottomPic().getY()){

            player.die();
        }

        if (player.getImage().getX() < obstacles.getSecondTopPic().getX() + obstacles.getSecondTopPic().getWidth() &&
                player.getImage().getX() + player.getImage().getWidth() > obstacles.getSecondTopPic().getX() &&
                player.getImage().getY() < obstacles.getSecondTopPic().getY() + obstacles.getSecondTopPic().getHeight() &&
                player.getImage().getY() + player.getImage().getHeight() > obstacles.getSecondTopPic().getY()) {

            player.die();
        }
    }

    public void improvedSpeed () {
        speed = --speed;
    }


    public void gameOver() {
        gameOver.draw();
    }
}
