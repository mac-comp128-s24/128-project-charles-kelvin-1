import edu.macalester.graphics.CanvasWindow;

public class MainGame {
    private MatrixManager matrixManager;
    private CanvasWindow canvas;

    public MainGame(){
        canvas = new CanvasWindow("Tetris", 400, 600);
        matrixManager = new MatrixManager(canvas);
    }
    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
    }
}
