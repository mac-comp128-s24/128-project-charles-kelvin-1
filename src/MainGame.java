import java.util.ArrayDeque;
import java.util.Queue;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.KeyboardEvent;

public class MainGame {
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    private Shape currentShape;
    public Queue<Shape> shapeQueue;
    public final int WIDTH = 400;
    public final int HEIGHT = 600;
    public int score;

    public MainGame(){
        canvas = new CanvasWindow("Tetris", WIDTH, HEIGHT);
        matrixManager = new MatrixManager(canvas);
        shapeQueue = new ArrayDeque<Shape>(2);
        generateBlock();
        generateBlock();
        currentShape = shapeQueue.poll();
        generateBlock();
        keyCheck();
        score = 0;
    }

    public void run(){
            canvas.animate(() -> {
                if(currentShape.canMove(0, 1)){
                    currentShape.gravity();
                    canvas.pause(300);
                } else{
                    matrixManager.rowsAreComplete(currentShape);
                    currentShape = shapeQueue.poll();
                    generateBlock();
                }
            
            });
    }

    public void keyCheck(){
        canvas.onKeyDown(e -> handleKey(e));
    }

    public void handleKey(KeyboardEvent e){
        if(e.getKey().toString().equalsIgnoreCase("A")){
            currentShape.moveLeft();
        } else if(e.getKey().toString().equalsIgnoreCase("D")){
            currentShape.moveRight();
        }else if(e.getKey().toString().equalsIgnoreCase("S")){
            currentShape.gravity();
        }else if(e.getKey().toString().equalsIgnoreCase("W")){
            currentShape.rotate();
        }
    }

    private void generateBlock(){
        int shapeNum = (int) (Math.random()*7);
        String shapeName;
        if(shapeNum == 0)
            shapeName = "O-Block";
        else if (shapeNum ==1)
            shapeName = "Z-Block";
        else if (shapeNum == 2)
            shapeName = "S-Block";
        else if (shapeNum == 3)
            shapeName = "I-Block";
        else if (shapeNum == 4)
            shapeName = "L-Block";
        else if (shapeNum == 5)
            shapeName = "J-Block";
        else
            shapeName = "T-Block";
        shapeQueue.add(new Shape(5, -1, matrixManager, canvas, shapeName));
    }



    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
        mainGame.run();
    }
}
