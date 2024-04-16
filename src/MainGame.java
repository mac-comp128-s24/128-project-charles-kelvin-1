import java.util.Queue;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.KeyboardEvent;

public class MainGame {
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    private Shape shape;
    public Queue<int[][]> piecesQueue;
    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    public MainGame(){
        canvas = new CanvasWindow("Tetris", WIDTH, HEIGHT);
        matrixManager = new MatrixManager(canvas);
        shape = new Shape(5, -1, matrixManager, canvas, "O-Block");
    }

    public void run(){
            canvas.animate(() -> {
                shape.gravity();
                canvas.pause(1000);});
    }

    public void keyCheck(){
        canvas.onKeyDown(e -> handleKey(e));
    }

    public void handleKey(KeyboardEvent e){
        if(e.getKey().toString().equalsIgnoreCase("A")){
            shape.moveHorizontal(-1);
        } else if(e.getKey().toString().equalsIgnoreCase("D")){
            shape.moveHorizontal(1);
        }else if(e.getKey().toString().equalsIgnoreCase("S")){
            shape.moveVertical(1);
        }else if(e.getKey().toString().equalsIgnoreCase("W")){
            shape.rotate();
        }
    }

    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
        mainGame.run();
    }
}
