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

    public MainGame(){
        canvas = new CanvasWindow("Tetris", WIDTH, HEIGHT);
        matrixManager = new MatrixManager(canvas);
        shapeQueue = new ArrayDeque<Shape>(2);
        generateBlock();
        generateBlock();
        currentShape = shapeQueue.poll();
        generateBlock();
        keyCheck();
    }

    public void run(){
            canvas.animate(() -> {
                if(currentShape.gravity()){
                currentShape.gravity();
                } else{
                    currentShape = shapeQueue.poll();
                    generateBlock();
                }
            
            });
    }

    public void keyCheck(){
        System.out.println("keyCheck is called");
        canvas.onKeyDown(e -> handleKey(e));
    }

    public void handleKey(KeyboardEvent e){
        System.out.println("Key pressed: " + e.getKey().toString()); // Add this line to check if handleKey() is being called
        if(e.getKey().toString().equalsIgnoreCase("A")){
            currentShape.moveHorizontal(-1);
        } else if(e.getKey().toString().equalsIgnoreCase("D")){
            currentShape.moveHorizontal(1);
        }else if(e.getKey().toString().equalsIgnoreCase("S")){
            currentShape.moveVertical(1);
        }else if(e.getKey().toString().equalsIgnoreCase("W")){
            currentShape.rotate();
        }
    }

    private void generateBlock(){
        int shapeNum = (int) (Math.random()*6);
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
