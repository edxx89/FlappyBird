package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.player.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Player player;
    private Game game;


    public KeyboardListener(Player player, Game game) {
        this.player = player;
        this.game = game;

        Keyboard key = new Keyboard(this);

        KeyboardEvent jump = new KeyboardEvent();
        jump.setKey(KeyboardEvent.KEY_SPACE);
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(jump);

        KeyboardEvent fall = new KeyboardEvent();
        fall.setKey(KeyboardEvent.KEY_SPACE);
        fall.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        key.addEventListener(fall);

        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_R);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key.addEventListener(start);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.setDirection(Direction.JUMP);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            if (player.isDead()) {
                game.newGame();
                player.reviveChico();
                game.setSpeed();
                game.getDieAfterSound().close();
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.setDirection(Direction.NULL);
        }
    }
}
