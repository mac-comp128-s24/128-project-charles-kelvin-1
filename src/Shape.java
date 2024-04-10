import java.util.Queue;

import edu.macalester.graphics.CanvasWindow;

public class Shape {
    private double x;
    private double y;
    private int[][] coordinates;
    private int[][] first;
    private int[][] second;
    private int[][] third;
    private int[][] fourth;
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    private String name;
    private Queue<int[][]> rotations;

    public Shape(double x, double y, MatrixManager matrixManager, CanvasWindow canvas, String name){
        this.x = x;
        this.y = y;
        this.matrixManager = matrixManager;
        this.canvas = canvas;
        this.name = name;
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
        rotations.add(first);
        rotations.add(second);
        rotations.add(third);
        rotations.add(fourth);
    }

    private void IsOBlock(){
        first[0][0] = 1;
        first[1][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;


    }

    private void IsZBlock(){
        first[0][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;
        first[1][2] = 1;
    }

    private void IsSBlock(){
        first[1][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;
        first[0][2] = 1;
    }

    private void IsIBlock(){
        first[0][0] = 1;
        first[0][1] = 1;
        first[0][2] = 1;
        first[0][3] = 1;
    }

    private void IsLBlock(){
        first[1][0] = 1;
        first[1][1] = 1;
        first[1][2] = 1;
        first[0][2] = 1;
    }

    private void IsJBlock(){
        first[0][0] = 1;
        first[1][0] = 1;
        first[1][1] = 1;
        first[1][2] = 1;
    }

    private void IsTBlock(){
        first[1][0] = 1;
        first[0][1] = 1;
        first[1][1] = 1;
        first[1][2] = 1;
    }



    
}
