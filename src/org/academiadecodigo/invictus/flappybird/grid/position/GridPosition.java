package org.academiadecodigo.invictus.flappybird.grid.position;

import org.academiadecodigo.invictus.flappybird.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {

    private Rectangle rectangle;

    private Grid grid;

    public GridPosition(int col, int row, Grid grid){
        this.grid = grid;
        rectangle = new Rectangle(col, row, grid.getCellSize(), grid.getCellSize());
    }


}
