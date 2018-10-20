package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Player player;

    public KeyboardListener(Player player){
        this.player = player;

        Keyboard key = new Keyboard(this);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(down);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(up);

        KeyboardEvent standUp = new KeyboardEvent();
        standUp.setKey(KeyboardEvent.KEY_UP);
        standUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        key.addEventListener(standUp);

        KeyboardEvent standDown = new KeyboardEvent();
        standDown.setKey(KeyboardEvent.KEY_DOWN);
        standDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        key.addEventListener(standDown);
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            player.setDirection(Direction.DOWN);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            player.setDirection(Direction.UP);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            player.setDirection(Direction.NULL);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            player.setDirection(Direction.NULL);
        }
    }
}
