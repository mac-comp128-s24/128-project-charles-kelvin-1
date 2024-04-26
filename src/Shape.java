import java.util.Queue;
import java.util.ArrayDeque;
import java.awt.Color;

/**
 * Creates a shape object that has a 2d array allowing it to move on the board when put in collaboration with the MatrixManager class
 */
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

    /**
     * This is the constructor that initailizes all the necessary instance variables
     * @param matrixManager is the board that the shape is placed on
     * @param name corresponds to the type of shape that this shape will be. Ex: O-Block
     */
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

    /**
     * Initializes the x, y, color variables for the O-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
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

    /**
     * Initializes the x, y, color variables for the Z-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
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

    /**
     * Initializes the x, y, color variables for the S-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
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

    /**
     * Initializes the x, y, color variables for the I-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
    private void IsIBlock(){
        x = 3;
        y = -1;
        color = Color.CYAN;
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

    /**
     * Initializes the x, y, color variables for the L-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
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

    /**
     * Initializes the x, y, color variables for the J-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
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

    /**
     * Initializes the x, y, color variables for the T-Block. Additionally, this method creates the 2d arrays that corresponds to the different rotations
     */
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


    /**
     * This method rotates the current block on the screen by moving to the next set of coordinates in the rotation queue. This rotation queue essentially acts as a circlular array. Additionally this method calls check rotate to make sure the block can rotate without hitting other blocks.
     */
    public void rotate(){
        if(x >= 0 || x < 10 && y < matrixManager.getMatrix().length && matrixManager.getMatrix()[y][x] != 1){
            int[][] matrix = matrixManager.getMatrix();
            MatrixBlock[][] blocks = matrixManager.getBlocks();
            for(int i = 0; i < coordinates.length; i++){
                for(int j = 0; j < coordinates[i].length; j++){
                    if(i + y > -1 && i + y < 20 && j + x <10 && j + x > -1 && matrix[i + y][j + x] == 1 && coordinates[i][j] == 1){
                        matrix[i + y][j + x] = 0;
                        blocks[i + y][j + x].setDefaultColor();
                    }
                }
            }
            checkRotate();
            int[][] removed = rotations.remove();
            coordinates = removed;
            matrixManager.colorBlockMatrix(this);
            rotations.add(removed);
        }
        
    }

    /**
     * This is a helper method within the rotate method. This method simply gets the coordinates of the next rotation and traverses through each index in the 2d array checking whether it is a one or not. If it is a one then it checks if the one is out of bounds of the Matrix board and repositions effectively.
     */
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

    /**
     * This method simply checks whether an object can move in a direction indicated by the dx and dy values.
     * @param dx this represents the change in x that we want our shape to undergo.
     * @param dy this represents the change in y that we want our shape to undergo.
     * @return returns whether the shape can move based on the changes to x and y by dx and dy
     */
    public boolean canMove(int dx, int dy) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (coordinates[i][j] == 1) {
                    int newX = x + j + dx;
                    int newY = y + i + dy;
                    if (newX < 0 || newX >= matrixManager.getMatrix()[0].length || newY >= matrixManager.getMatrix().length || (matrixManager.getMatrix()[newY][newX] == 1 && coordinates[newY - y][newX - x] != 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

 /**
 * This method returns the maximum number of positions the shape can move left without causing an obstruction.
 * @return the maximum number of positions the shape can move left
 */
public int canMoveLeft() {
    int maxLeft = Integer.MAX_VALUE;
    for (int i = 0; i < coordinates.length; i++) {
        for (int j = 0; j < coordinates[i].length; j++) {
            if (coordinates[i][j] == 1) {
                int newX = x + j - 1;
                int newY = y + i;
                if (newX < 0) {
                    maxLeft = Math.min(maxLeft, Math.abs(newX)); // Adjust maxLeft to prevent out-of-bounds
                } else if (newY >= 0 && matrixManager.getMatrix()[newY][newX] == 1) {
                    maxLeft = Math.min(maxLeft, j); // Adjust maxLeft to prevent overlapping other blocks
                }
            }
        }
    }
    return Math.min(maxLeft, x); // Adjust maxLeft to prevent going beyond the left boundary
}

    /**
     * This method calls canMove with a dy of 1 to check if the shape can move down one block. If it can, then each coordinate in the coordinates 2d array is shifted down 1 on the matrix board. The y value is then correctly incremented.
     */
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
            matrixManager.clearBlocks(this);
            y++;
            matrixManager.colorBlockMatrix(this);
        }
    }

    /**
     * This method calls canMove with a dx of 1 to check if the shape can move one block to the right. If it can, then each coordinate in the coordinates 2d array is shifted right 1 on the matrix board. The x value is then correctly incremented.
     */
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
            matrixManager.clearBlocks(this);
            x++;
            matrixManager.colorBlockMatrix(this);
        }
    }

    /**
     * This method calls canMove with a dx of -1 to check if the shape can move one block to the left. 
     * If it can, then each coordinate in the coordinates 2d array is shifted left 1 on the matrix board. The x value is then correctly decremented.
     */
    public void moveLeft() {
        if (y > -1) {
            int maxLeft = canMoveLeft();
            if (maxLeft > 0) {
                int[][] matrix = matrixManager.getMatrix();
                for (int i = 0; i < coordinates.length; i++) {
                    for (int j = 0; j < coordinates[i].length; j++) {
                        if (coordinates[i][j] == 1) {
                            matrix[y + i][x + j - maxLeft] = 1;
                            matrix[y + i][x + j] = 0;
                        }
                    }
                }
                x -= maxLeft;
                matrixManager.clearBlocks(this);
                matrixManager.colorBlockMatrix(this);
            }
        }
    }

    /**
     * This method simply returns the current coordinates of the shape
     * @return the coordinates
     */
    public int[][] getCoordinates(){
        return coordinates;
    }

    /**
     * This method simply returns the current x position that corresponds to the matrix board
     * @return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * This method simply returns the current y position that corresponds to the matrix board
     * @return the y value
     */
    public int getY() {
        return y;
    }

    /**
     * This method simply returns the current color of the shape so that the board can correctly color the shape.
     * @return the color of the shape
     */
    public Color getColor() {
        return color;
    }



    
}
