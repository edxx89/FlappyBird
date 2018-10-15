package org.academiadecodigo.invictus.flappybird;

import org.academiadecodigo.invictus.flappybird.character.Character;
import org.academiadecodigo.invictus.flappybird.grid.Grid;

public class Game {

    private Grid grid;

    private Character character;

    private MyKeyboard k;

    private int delay;



    public void init(){
        Grid grid = new Grid();
        Character character = new Character();
    }
}
