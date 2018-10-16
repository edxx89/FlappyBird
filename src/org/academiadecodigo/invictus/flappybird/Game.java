package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Picture background;
    private KeyboardListener key;


    public void init(){
        background = new Picture(0, 0, "background.gif");
        background.draw();
        player = new Player();
        key = new KeyboardListener(player);
        while (true) {
            try {
                Thread.sleep(20);
            }catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            player.move();

        }


    }
}
