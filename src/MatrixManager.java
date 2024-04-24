import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import edu.macalester.graphics.CanvasWindow;

/**
 * Creates a 2D array representing the board for the game. Manages opertaion on the board.
 */
public class MatrixManager {
    private int[][] matrix;
    private MatrixBlock[][] blocks;
    private CanvasWindow canvas;
    private final double LEFT_MOST_BLOCK = 100;
    private final double TOP_MOST_BlOCK = 100;

/**
 * Creates a 20 by 10 array for the board in a canvas window, 
 * initializes indicies as blank matirix blocks to be displayed.
 * @param canvas, the window to display the board
 */
    public MatrixManager(CanvasWindow canvas){
        this.canvas = canvas;
        matrix = new int[20][10];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = 0;
            }
        }

        blocks = new MatrixBlock[20][10];
        double y = TOP_MOST_BlOCK;
        for(int i = 0; i < blocks.length; i++){
            double x = LEFT_MOST_BLOCK;
            for(int j = 0; j < blocks[i].length; j++){
                MatrixBlock block = new MatrixBlock(x, y);
                canvas.add(block);
                blocks[i][j] = block;
                x = x + MatrixBlock.SIZE;
            }
            y = y + 20;
        }
    }

    /**
     * Iterates through the coordiantes for given shape, sets blocks to the correct color or
     * makes them default color if empty.
     * @param shape, shape to be colored in.
     */
    public void colorBlockMatrix(Shape shape){
        int[][] coordinates = shape.getCoordinates();
        int x = shape.getX();
        int y = shape.getY();
        Color color = shape.getColor();
        for(int i = 0; i < coordinates.length; i++){
            for(int j = 0; j < coordinates[i].length; j++){
                if(i + y > -1 && i + y < 20 && j + x < 10 && j + x > -1){
                    if((matrix[i + y][j + x] == 1 && coordinates[i][j] == 1)){
                        blocks[i + y][j + x].setFillColor(color);
                    } else if(matrix[i + y][j + x] == 0){
                        blocks[i + y][j + x].setDefaultColor();
                    }
                }
            }
        }
    }

    /**
     * Iterates through shape grid and sets blocks to be emtpy.
     * @param shape, shape to be cleared.
     */
    public void clearBlocks(Shape shape){
        int[][] coordinates = shape.getCoordinates();
        int x = shape.getX();
        int y = shape.getY();
        for(int i = 0; i < coordinates.length; i++){
            for(int j = 0; j < coordinates[i].length; j++){
                if(i + y > -1 && i + y < 20 && x + j < 10 && matrix[i + y][j + x] == 0 && coordinates[i][j] == 1){
                    blocks[i + y][j + x].setDefaultColor();
                }
            }
        }
    }

    /**
     * Checks if row in matix is complete
     * @param i, row to be checked
     * @return, true if full ot false
     */
    public boolean rowIsComplete(int i){
        for(int j = 0; j < matrix[i].length; j++){
            if(matrix[i][j] == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Iterates throug row and sets each block to be empty
     * @param i, row to be reset
     */
    public void resetRow(int i){
        for(int j = 0; j < blocks[i].length; j++){
            blocks[i][j].setFillColor(Color.GRAY);
            matrix[i][j] = 0;
        }
    }

    /**
     * Checks if multiple rows are complete in the game and adjusts score
     * @param shape, current shape to check if it has completed a row
     * @param m, main game to set the score in
     */
    public void rowsAreComplete(Shape shape, MainGame m){
        int y = shape.getY();
        int numOfRemovedRows = 0;
        for(int i = y + 4; i >= y; i--){
            if(i < 20){
                if(rowIsComplete(i)){
                    numOfRemovedRows++;
                    resetRow(i);
                    if(i == y)
                        moveRowDown(i - 1, numOfRemovedRows);
                } else
                    moveRowDown(i, numOfRemovedRows);
            } 
        }
        m.setScore(numOfRemovedRows);
    }

    /**
     * Moves above blocks down a row after completion
     * @param index, row to begin moving down
     * @param numOfRows, number of blocks to move down at once.
     */
    private void moveRowDown(int index, int numOfRows){
        if(numOfRows > 0){
            for(int i = index; i >= 0; i--){
                for(int j = 0; j < 10; j++){
                    matrix[i + numOfRows][j] = matrix[i][j];
                    blocks[i + numOfRows][j].setFillColor(blocks[i][j].getFillColor());
                    matrix[i][j] = 0;
                    blocks[i][j].setDefaultColor();
                }
            }
        }
    }

    /**
     * returns the matrix blocks in from the game board.
     */
    public MatrixBlock[][] getBlocks() {
        return blocks;
    }

    /**
     * returns the matrix
     */
    public int[][] getMatrix(){
        return matrix;
    }

}
