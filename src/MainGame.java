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

    /**
     * This constructor simply initializes all the instance variables and adds two shape objects to the shapeQueue
     */
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

    /**
     * This method handles the animation of the game using an animate loop. In this loop, gravity, rotations, game condition, score and level labels are all handled.
     */
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

    /**
     * Uses an onKeyDown event handler to enable keyboard inputs/keyboard movements
     */
    public void keyCheck(){
        canvas.onKeyDown(e -> handleKey(e));
    }

    public void handleKey(KeyboardEvent e){
        String key = e.getKey().toString();
        if(key.equalsIgnoreCase("A") || key.equalsIgnoreCase("J")){
            currentShape.moveLeft();
        } else if(key.equalsIgnoreCase("D") || key.equalsIgnoreCase("L")){
            currentShape.moveRight();
        }else if(key.equalsIgnoreCase("S") || key.equalsIgnoreCase("K")){
            currentShape.gravity();
        }else if(key.equalsIgnoreCase("W") || key.equalsIgnoreCase("SPACE") || key.equalsIgnoreCase("I")){
            rotate = true;
        }
    }

    /**i
     * This method randomly creates one the seven available blocks and adds it to the shapeQueue.
     */
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

    /**
     * checks whether the current shape can move and if the y position of the shape is less than 0 meaning that it is not on the board yet. If it can't move and its not on the board the method returns true. Otherwise it returns false.
     * @return whether the game is over or not.
     */
    public boolean isGameOver(){
        if (!currentShape.canMove(0,1) && currentShape.getY() < 0)
            return true;
        return false;
    }

    /**
     * sets the score based on the number of complete rows cleared.
     * @param num the number of removed rows/ complete rows when the shape cant move anymore.
     */
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

    /**
     * sets the level and pause length or the overall delay between the shape moving down based on the current score
     */
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

    /**
     * This is the main method that allows the game to actually run
     * @param args
     */
    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
        mainGame.run();
    }
}
