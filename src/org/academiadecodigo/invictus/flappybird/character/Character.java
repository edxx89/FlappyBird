package org.academiadecodigo.invictus.flappybird.character;

import org.academiadecodigo.invictus.flappybird.grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Character {

    private Picture image;

    public Character(){
        image = new Picture(Grid.PADDING, Grid.PADDING, "/Users/codecadet/FlappyBird/resources/chico.png");
        image.grow(-50, -50);
        image.draw();
    }


    public void move(){

    }
}
