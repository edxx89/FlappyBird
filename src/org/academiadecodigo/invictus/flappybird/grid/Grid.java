package org.academiadecodigo.invictus.flappybird.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 10;
    private int cellSize = 10;
    private int cols;
    private int rows;
    private Picture field;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * Initializes the grid
     */
    public void init() {
        field = new Picture(PADDING,PADDING,"/Users/codecadet/Project/FlappyBird/resources/background2-35.gif");
        field.draw();
    }

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

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */
    //public GridPosition makeGridPosition();

    /**
     * Creates a a grid position in a specific column and row
     *
     * @param col the position column
     * @param row the position row
     * @return the new grid position
     */
    //public GridPosition makeGridPosition(int col, int row);

}
