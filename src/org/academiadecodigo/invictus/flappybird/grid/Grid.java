package org.academiadecodigo.invictus.flappybird.grid;

import org.academiadecodigo.invictus.flappybird.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 10;
    private int cellSize = 10;
    private int cols;
    private int rows;
    private Picture field;

    public Grid() {
        field = new Picture(PADDING,PADDING, "/background2-35.gif");
        field.draw();
        this.cols = field.getWidth()/cellSize;
        this.rows = field.getHeight()/cellSize;

    }

    /*
    public void init() {

    }
    */

    public int getCols(){
        return cols;
    }

    public int getRows(){
        return rows;
    }

    public static int getPADDING() {
        return PADDING;
    }

    public int getCellSize() {
        return cellSize;
    }


    /**
     * Create a random grid position
     *
     * @return the new grid position
     */
    public GridPosition makeGridPosition(int col, int row){
        return new GridPosition(col, row, this);
    }


    /**
     * Creates a a grid position in a specific column and row
     *
     * @param col the position column
     * @param row the position row
     * @return the new grid position
     */
     //public GridPosition makeGridPosition(int col, int row);

}
