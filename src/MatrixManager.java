import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

public class MatrixManager {
    // private boolean[][] matrix;
    private MatrixBlock[][] blocks;
    private CanvasWindow canvas;

    public MatrixManager(CanvasWindow canvas){
        this.canvas = canvas;
        // matrix = new boolean[20][10];
        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[i].length; j++){
        //         matrix[i][j] = false;
        //     }
        // }

        blocks = new MatrixBlock[20][10];
        double y = 100;
        for(int i = 0; i < blocks.length; i++){
            double x = 100;
            for(int j = 0; j < blocks[i].length; j++){
                MatrixBlock block = new MatrixBlock(x, y);
                canvas.add(block);
                blocks[i][j] = block;
                x = x + MatrixBlock.SIZE;
            }
            y = y + 20;
        }
    }

    public boolean rowIsComplete(int i){
        for(int j = 0; j < blocks[i].length; j++){
            if(blocks[i][j].isDefaultColor()){
                return false;
            }
        }
        return true;
    }

    public void resetRow(int i){
        for(int j = 0; j < blocks[i].length; j++)
            blocks[i][j].setFillColor(Color.GRAY);
    }









}
