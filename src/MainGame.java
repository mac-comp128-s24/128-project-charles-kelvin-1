import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.KeyboardEvent;

public class MainGame {
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    public MainGame(){
        canvas = new CanvasWindow("Tetris", WIDTH, HEIGHT);
        matrixManager = new MatrixManager(canvas);
    }

    public void run(){
            
    }

    public void keyCheck(){
        canvas.onKeyDown(e -> handleKey(e));
    }

    public void handleKey(KeyboardEvent e){
        if(e.getKey().toString().equalsIgnoreCase("A")){
            
        } else if(e.getKey().toString().equalsIgnoreCase("D")){
        
        }else if(e.getKey().toString().equalsIgnoreCase("S")){
        
        }else if(e.getKey().toString().equalsIgnoreCase("W")){
        
        }
    }

    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
    }
}
