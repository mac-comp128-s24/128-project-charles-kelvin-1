import edu.macalester.graphics.CanvasWindow;
import java.awt.Color;

public class LinePiece implements Shape{
    private double x;
    private double y;
    private CanvasWindow canvas;

    public LinePiece(double x, double y, CanvasWindow canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        Block block = new Block (x, y);
        Block block1 = new Block (x, y + Block.SIZE);
        Block block2 = new Block (x, y + 2*Block.SIZE);
        Block block3 = new Block (x, y + 3*Block.SIZE);

        block.setFillColor(Color.BLUE);
        block1.setFillColor(Color.BLUE);
        block2.setFillColor(Color.BLUE);
        block3.setFillColor(Color.BLUE);

        canvas.add(block);
        canvas.add(block1);
        canvas.add(block2);
        canvas.add(block3);
    }

    @Override
    public void rotate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }

    @Override
    public void automaticMove() {
        // for(int i = 0; i < coordinates.length; i++){
        //     for(int j = 0; j < coordinates[i].length; j++){
                
        //     }
        // }
    }

    
    
}
