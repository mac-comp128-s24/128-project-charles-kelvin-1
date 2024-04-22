import java.util.Queue;
import java.util.ArrayDeque;
import java.awt.Color;

public class Shape {
    private int x;
    private int y;
    private int[][] coordinates;
    private int[][] first;
    private int[][] second;
    private int[][] third;
    private int[][] fourth;
    private MatrixManager matrixManager;
    private Queue<int[][]> rotations;
    private Color color;

    public Shape(MatrixManager matrixManager, String name){
        this.matrixManager = matrixManager;
        rotations = new ArrayDeque<>();
        coordinates = new int[5][5];
        first = new int[5][5];
        second = new int[5][5];
        third = new int[5][5];
        fourth = new int[5][5];
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
        x = 4;
        y = -1;
        color = Color.YELLOW;
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
        x = 4;
        y = -1;
        color = Color.GREEN;
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
        x = 4;
        y = -1;
        color = Color.RED;
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
        x = 3;
        y = -1;
        color = Color.CYAN;
        first[0][0] = 1;
        first[0][1] = 1;
        first[0][2] = 1;
        first[0][3] = 1;

        second[0][3] = 1;
        second[1][3] = 1;
        second[2][3] = 1;
        second[3][3] = 1;

        third[0][0] = 1;
        third[0][1] = 1;
        third[0][2] = 1;
        third[0][3] = 1;

        fourth[0][3] = 1;
        fourth[1][3] = 1;
        fourth[2][3] = 1;
        fourth[3][3] = 1;
    }

    private void IsLBlock(){
        x = 3;
        y = -1;
        color = Color.ORANGE;
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
        x = 3;
        y = -1;
        color = Color.BLUE;
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
        x = 4;
        y = -1;
        color = Color.PINK;
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
            matrixManager.colorBlockMatrix(this);
        }
    }

    public boolean canMove(int dx, int dy) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (coordinates[i][j] == 1) {
                    int newX = x + j + dx;
                    int newY = y + i + dy;
                    if (newX < 0 || newX >= matrixManager.getMatrix()[0].length || newY >= matrixManager.getMatrix().length || newY < 0|| (matrixManager.getMatrix()[newY][newX] == 1 && coordinates[newY - y][newX - x] != 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void moveRight(){
        if(y > -1 && canMove(1, 0)){
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
            matrixManager.colorBlockMatrix(this);
        }
    }

    public void moveLeft(){
        if(x - 1 > -1 && y > -1 && canMove(-1, 0)){
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
            matrixManager.colorBlockMatrix(this);
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

    public Color getColor() {
        return color;
    }



    
}
