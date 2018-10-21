package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Player player;
    private Game game;

    public KeyboardListener(Player player, Game game){
        this.player = player;
        this.game = game;

        Keyboard key = new Keyboard(this);

        /*KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(down);

        KeyboardEvent standDown = new KeyboardEvent();
        standDown.setKey(KeyboardEvent.KEY_DOWN);
        standDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        key.addEventListener(standDown);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(up);

        KeyboardEvent standUp = new KeyboardEvent();
        standUp.setKey(KeyboardEvent.KEY_UP);
        standUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        key.addEventListener(standUp);*/



        KeyboardEvent jump = new KeyboardEvent();
        jump.setKey(KeyboardEvent.KEY_SPACE);
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(jump);

        KeyboardEvent fall = new KeyboardEvent();
        fall.setKey(KeyboardEvent.KEY_SPACE);
        fall.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        key.addEventListener(fall);


        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_S);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(start);
    }


    long previousTime;
    long currentTime;
    long difftime;


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        /*if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            player.setDirection(Direction.DOWN);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            player.setDirection(Direction.UP);
        }*/

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.setDirection(Direction.JUMP);
        }

        /*if(keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            try{
                Thread.sleep(1000);
                game.start();
            }catch (InterruptedException ex){

            }
        }*/


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        /*if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            player.setDirection(Direction.NULL);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            player.setDirection(Direction.NULL);
        }*/


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.setDirection(Direction.NULL);
        }
    }
}
