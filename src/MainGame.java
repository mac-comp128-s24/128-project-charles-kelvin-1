import java.util.ArrayDeque;
import java.util.Queue;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.KeyboardEvent;

public class MainGame {
    private MatrixManager matrixManager;
    private CanvasWindow canvas;
    private Shape currentShape;
    public Queue<Shape> shapeQueue;
    public final int WIDTH = 400;
    public final int HEIGHT = 600;
    public int score;
    private GraphicsText scoreLabel;
    private GraphicsText levelLabel;
    private boolean rotate = false;
    private int pauseLength = 300;
    private int level = 1;

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
        scoreLabel = new GraphicsText("Score: " + score);
        scoreLabel.setFont(FontStyle.PLAIN, 24);
        canvas.add(scoreLabel, 20, 40);
        levelLabel = new GraphicsText("Level: " + level);
        levelLabel.setFont(FontStyle.PLAIN, 24);
        canvas.add(levelLabel, 150, 40);
    }

    public void run(){
            canvas.animate(() -> {
                if(currentShape.canMove(0, 1)){
                    if(rotate){
                        currentShape.rotate();
                        rotate = false;
                    }
                    levelSpeed();
                    levelLabel.setText("Level: " + level);
                    currentShape.gravity();
                    canvas.pause(pauseLength);
                } else{
                    if (isGameOver()){
                        canvas.closeWindow();
                        System.out.println("You're a loser");
                        System.out.println("Score: " + score);
                    }else{
                        matrixManager.rowsAreComplete(currentShape, this);
                        scoreLabel.setText("Score: " + score);
                        currentShape = shapeQueue.poll();
                        generateBlock();
                    }
                }
            
            });
    }

    public void keyCheck(){
        canvas.onKeyDown(e -> handleKey(e));
    }

    public void handleKey(KeyboardEvent e){
        String key = e.getKey().toString();
        if(key.equalsIgnoreCase("A")){
            currentShape.moveLeft();
        } else if(key.equalsIgnoreCase("D")){
            currentShape.moveRight();
        }else if(key.equalsIgnoreCase("S")){
            currentShape.gravity();
        }else if(key.equalsIgnoreCase("W") || key.equalsIgnoreCase("SPACE")){
            rotate = true;
            // currentShape.rotate();
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
        shapeQueue.add(new Shape(matrixManager, shapeName));
    }
    public boolean isGameOver(){
        if (!currentShape.canMove(0,1) && currentShape.getY() < 0){
            return true;
        }
        return false;
    }

    public void setScore(int num){
        if(num == 0)
            score+=10;
        else if(num == 1)
            score+=50;
        else if(num == 2)
            score+=125;
        else if(num == 3)
            score+=300;
        else
            score+=500;
    }

    private void levelSpeed(){
        if(score < 375){
            level = 1;
            pauseLength = 300;
        } else if(score >= 375 && score < 750){
            level = 2;
            pauseLength = 200;
        } else{
            level = 3;
            pauseLength = 100;
        }
    }


    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
        mainGame.run();
    }
}
