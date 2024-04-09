import edu.macalester.graphics.CanvasWindow;

public class MainGame {
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    public MainGame(){
        canvas = new CanvasWindow("Tetris", WIDTH, HEIGHT);
        matrixManager = new MatrixManager(canvas);
    }
    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
    }
}
