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
    private Queue<int[][]> rotations;

    public Shape(int x, int y, MatrixManager matrixManager, CanvasWindow canvas, String name){
        this.x = x;
        this.y = y;
        this.matrixManager = matrixManager;
        this.canvas = canvas;
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
        if(x >= 0 || x < 10 || y < matrixManager.getMatrix().length || !(matrixManager.getMatrix()[x][y] == 1 && coordinates[x][y] != 1)){
            int[][] matrix = matrixManager.getMatrix();
            for(int i = 0; i < coordinates.length; i++){
                for(int j = 0; j < coordinates[i].length; j++){
                    if(i + y > -1 && i + y < 20 && j + x <10 && j + x > -1 && matrix[i + y][j + x] == 1 && coordinates[i][j] == 1){
                        matrix[i + y][j + x] = 0;
                    }
                }
            }
            checkRotate();
            int[][] removed = rotations.remove();
            coordinates = removed;
            rotations.add(removed);
        }
        
    }

    public void checkRotate(){
        int[][] next = rotations.peek();
        int[][] matrix = matrixManager.getMatrix();
        for(int i = 0; i < next.length; i++){
            for(int j = 0; j < next[i].length; j++){
                    if(i + y > 19)
                        y-= (i + y - 19);
                    if(j + x > 9)
                        x-= (j + x - 9);
                    else if(j + x == -1)
                        x++;
            }
        }
    }

    public void gravity(){
        if(canMove(0, 1)){
            int[][] matrix = matrixManager.getMatrix();
            for(int i = coordinates.length - 1; i >= 0; i--){
                for(int j = 0; j < coordinates[i].length; j++){
                    if(coordinates[i][j] == 1){
                        if(i + y > -1)
                            matrix[i + y][j + x] = 0;
                        matrix[i + y + 1][j + x] = 1;
                    }
                }
            }
            y++;
            matrixManager.colorBlockMatrix();
        }
    }

    public boolean canMove(int dx, int dy) {
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

    public void moveRight(){
        if(canMove(1, 0)){
            int[][] matrix = matrixManager.getMatrix();
                for(int i = 0; i < coordinates.length; i++){
                    for(int j = coordinates[i].length-1; j >= 0;j--){
                        if(coordinates[i][j] == 1){
                            if(j + x > -1 && j + x < 20)
                                matrix[i + y][j + x] = 0;
                            matrix[i + y][j + x + 1] = 1;
                        }
                    }
                }
            x++;
            matrixManager.colorBlockMatrix();
        }
    }

    public void moveLeft(){
        if(x - 1 > -1 && canMove(-1, 0)){
            int[][] matrix = matrixManager.getMatrix();
                for(int i = 0; i < coordinates.length; i++){
                    for(int j = 0; j < coordinates[i].length; j++){
                        if(coordinates[i][j] == 1){
                            if(i + y > -1)
                                matrix[i + y][j + x] = 0;
                            matrix[i + y][j + x - 1] = 1;
                        }
                    }
                }
            x--;
            matrixManager.colorBlockMatrix();
        }
    }

    // public void moveVertical(int dy){
    //     if(canMove(0, dy)){
    //         int[][] matrix = matrixManager.getMatrix();
    //         for(int i = coordinates.length - 1; i >= 0; i--){
    //             for(int j = 0; j < coordinates[i].length; j++){
    //                 if(coordinates[i][j] == 1){
    //                     if(i + y > -1)
    //                         matrix[i + y][j + x] = 0;
    //                     matrix[i + y + 1][j + x] = 1;
    //                 }
    //             }
    //         }
    //         y++;
    //         matrixManager.colorBlockMatrix();
    //     }
        
    // }

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
