package org.academiadecodigo.invictus.flappybird.game;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {

    private Game game;
    private Mouse mouse;
    private boolean clicked;

    public MyMouse(Game game){
        this.game = game;
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if((mouseEvent.getX() > 222 && mouseEvent.getX() < 234 && mouseEvent.getY() > 325 && mouseEvent.getY() < 360) ||
                (mouseEvent.getX() > 280 && mouseEvent.getX() < 297 && mouseEvent.getY() > 330 && mouseEvent.getY() < 365)){
            if(!clicked) {
                clicked = true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        game.getBackgroundMusic().open();
                        game.init();

                    }
                }).start();
            }
        }

    }
}
