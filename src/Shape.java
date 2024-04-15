import java.util.Queue;
import java.util.ArrayDeque;

import edu.macalester.graphics.CanvasWindow;

public class Shape {
    private int x;
    private int y;
    private int[][] coordinates;
    private int[][] first;
    private int[][] second;
    private int[][] third;
    private int[][] fourth;
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    private String name;
    private Queue<int[][]> rotations;

    public Shape(int x, int y, MatrixManager matrixManager, CanvasWindow canvas, String name){
        this.x = x;
        this.y = y;
        this.matrixManager = matrixManager;
        this.canvas = canvas;
        this.name = name;
        rotations = new ArrayDeque<>();
        coordinates = new int[4][4];
        first = new int[4][4];
        second = new int[4][4];
        third = new int[4][4];
        fourth = new int[4][4];
        for(int i = 0; i < coordinates.length; i++){
            for(int j = 0; j < coordinates[i].length; j++){
                coordinates[i][j] = 0;
                first[i][j] = 0;
                second[i][j] = 0;
                third[i][j] = 0;
                fourth[i][j] = 0;
            }
        }

        if(name.equalsIgnoreCase("O-Block")){
            IsOBlock();
        }else if(name.equalsIgnoreCase("Z-Block")){
            IsZBlock();
        }else if(name.equalsIgnoreCase("S-Block")){
            IsSBlock();
        }else if(name.equalsIgnoreCase("I-Block")){
            IsIBlock();
        }else if(name.equalsIgnoreCase("L-Block")){
            IsLBlock();
        }else if(name.equalsIgnoreCase("J-Block")){
            IsJBlock();
        }else{ //T-Block
            IsTBlock();
        }
        rotations.add(second);
        rotations.add(third);
        rotations.add(fourth);
        rotations.add(first);
        coordinates = first;
    }

    private void IsOBlock(){
        first[0][0] = 1;
        first[1][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;

        second[0][0] = 1;
        second[1][0] = 1;
        second[0][1] = 1;
        second[1][1] = 1;

        third[0][0] = 1;
        third[1][0] = 1;
        third[0][1] = 1;
        third[1][1] = 1;

        fourth[0][0] = 1;
        fourth[1][0] = 1;
        fourth[0][1] = 1;
        fourth[1][1] = 1;

    }

    private void IsZBlock(){
        first[0][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;
        first[1][2] = 1;

        second[0][1] = 1;
        second[1][0] = 1;
        second[1][1] = 1;
        second[2][0] = 1;

        third[0][0] = 1;
        third[0][1] = 1;
        third[1][1] = 1;
        third[1][2] = 1;

        fourth[0][1] = 1;
        fourth[1][0] = 1;
        fourth[1][1] = 1;
        fourth[2][0] = 1;
    }

    private void IsSBlock(){
        first[1][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;
        first[0][2] = 1;

        second[0][0] = 1;
        second[1][0] = 1;
        second[1][1] = 1;
        second[2][1] = 1;

        third[1][0] = 1;
        third[0][1] = 1;
        third[1][1] = 1;
        third[0][2] = 1;

        fourth[0][0] = 1;
        fourth[1][0] = 1;
        fourth[1][1] = 1;
        fourth[2][1] = 1;
    }

    private void IsIBlock(){
        first[0][0] = 1;
        first[0][1] = 1;
        first[0][2] = 1;
        first[0][3] = 1;

        second[0][0] = 1;
        second[1][0] = 1;
        second[2][0] = 1;
        second[3][0] = 1;

        third[0][0] = 1;
        third[0][1] = 1;
        third[0][2] = 1;
        third[0][3] = 1;

        fourth[0][0] = 1;
        fourth[1][0] = 1;
        fourth[2][0] = 1;
        fourth[3][0] = 1;
    }

    private void IsLBlock(){
        first[1][0] = 1;
        first[1][1] = 1;
        first[1][2] = 1;
        first[0][2] = 1;

        second[0][0] = 1;
        second[1][0] = 1;
        second[2][0] = 1;
        second[2][1] = 1;

        third[0][0] = 1;
        third[0][1] = 1;
        third[0][2] = 1;
        third[1][0] = 1;

        fourth[0][0] = 1;
        fourth[0][1] = 1;
        fourth[1][1] = 1;
        fourth[2][1] = 1;
    }

    private void IsJBlock(){
        first[0][0] = 1;
        first[1][0] = 1;
        first[1][1] = 1;
        first[1][2] = 1;

        second[0][1] = 1;
        second[1][1] = 1;
        second[2][1] = 1;
        second[2][0] = 1;

        third[0][0] = 1;
        third[1][0] = 1;
        third[1][1] = 1;
        third[1][2] = 1;

        fourth[0][0] = 1;
        fourth[1][0] = 1;
        fourth[0][1] = 1;
        fourth[2][0] = 1;
    }

    private void IsTBlock(){
        first[1][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;
        first[1][2] = 1;

        second[0][0] = 1;
        second[1][0] = 1;
        second[2][0] = 1;
        second[1][1] = 1;

        third[0][0] = 1;
        third[0][1] = 1;
        third[0][2] = 1;
        third[1][1] = 1;

        fourth[0][1] = 1;
        fourth[1][0] = 1;
        fourth[1][1] = 1;
        fourth[2][1] = 1;
    }

    public void rotate(){
        int[][] removed = rotations.remove();
        coordinates = removed;
        rotations.add(removed);
    }

    //public void gravity(MatrixManager m){
        // boolean canMove = true;
        //     for (int i = 0; i < coordinates.length; i++) {
        //         for (int j = 0; j < coordinates[i].length; j++) {
        //             if (coordinates[i][j] == 1) {
        //                 int newX = x + j;
        //                 int newY = y + i + 1;
        //                 if (newX < 0 || newX >= boardWidth || newY >= boardHeight || board[newY][newX] == 1) {
        //                     canMove = false;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        //}

    public void gravity(){
        if(canMove(0, 1)){
            int[][] matrix = matrixManager.getMatrix();
            for(int i = 0; i < coordinates.length; i++){
                for(int j = 0; j < coordinates[i].length; j++){
                    if(coordinates[i][j] == 1){
                        matrix[i + y + 1][j + x] = 1;
                        if(i + y -1 > -1)
                            matrix[i + y - 1][j + x] = 0;
                    }
                }
            }
            y++;
            matrixManager.colorBlockMatrix();
        }
    }

    private boolean canMove(int dx, int dy) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (coordinates[i][j] == 1) {
                    int newX = x + j + dx;
                    int newY = y + i + dy;
                    if (newX < 0 || newX >= matrixManager.getMatrix()[i].length || newY >= matrixManager.getMatrix().length || (matrixManager.getMatrix()[newY][newX] == 1 && coordinates[newY - y][newX - x] != 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void moveHorizontal(int dx){
        if(canMove(x, 0)){
            int[][] matrix = matrixManager.getMatrix();
                for(int i = 0; i < coordinates.length; i++){
                    for(int j = 0; j < coordinates[i].length; j++){
                        if(coordinates[i][j] == 1){
                            matrix[i + y][j + x + dx] = 1;
                            if(i + y -1 > -1)
                                matrix[i + y - 1][j + x] = 0;
                        }
                    }
                }
            x+=dx;
            matrixManager.colorBlockMatrix();
        }
    }

    public void moveVertical(int dy){
        if(canMove(0, dy)){
            int[][] matrix = matrixManager.getMatrix();
                for(int i = 0; i < coordinates.length; i++){
                    for(int j = 0; j < coordinates[i].length; j++){
                        if(coordinates[i][j] == 1){
                            matrix[i + y + dy][j + x] = 1;
                            if(i + y -1 > -1)
                                matrix[i + y - 1][j + x] = 0;
                        }
                    }
                }
            y++;
            matrixManager.colorBlockMatrix();
        }
        
    }

    public int[][] getCoordinates(){
        return coordinates;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    
}
