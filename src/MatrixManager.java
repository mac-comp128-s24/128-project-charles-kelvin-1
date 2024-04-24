import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import edu.macalester.graphics.CanvasWindow;

public class MatrixManager {
    private int[][] matrix;
    private MatrixBlock[][] blocks;
    private CanvasWindow canvas;
    private final double LEFT_MOST_BLOCK = 100;
    private final double TOP_MOST_BlOCK = 100;

    

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

    public void clearMatrix(Shape shape){
        int[][] coordinates = shape.getCoordinates();
        int x = shape.getX();
        int y = shape.getY();
        for(int i = 0; i < coordinates.length; i++){
            for(int j = 0; j < coordinates[i].length; j++){
                if(i + y > -1 && i + y < 20)
                    matrix[i + y][j + x] = 0;
            }
        }
    }

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

    public boolean rowIsComplete(int i){
        for(int j = 0; j < matrix[i].length; j++){
            if(matrix[i][j] == 0){
                return false;
            }
        }
        return true;
    }

    public void resetRow(int i){
        for(int j = 0; j < blocks[i].length; j++){
            blocks[i][j].setFillColor(Color.GRAY);
            matrix[i][j] = 0;
        }
    }

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

    public MatrixBlock[][] getBlocks() {
        return blocks;
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public void setMatrix(int[][] m){
        matrix = m;
    }

}
