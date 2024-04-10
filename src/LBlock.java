import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class LBlock implements Shape{
    private double x;
    private double y;
    private CanvasWindow canvas;

    public LBlock(double x, double y, CanvasWindow canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        Block block = new Block (x, y);
        Block block1 = new Block (x, y - Block.SIZE);
        Block block2 = new Block (x+Block.SIZE, y - Block.SIZE);
        Block block3 = new Block (x+ 2*Block.SIZE, y - Block.SIZE);

        block.setFillColor(Color.YELLOW);
        block1.setFillColor(Color.YELLOW);
        block2.setFillColor(Color.YELLOW);
        block3.setFillColor(Color.YELLOW);

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

    @Override
    public MatrixBlock getBlockAt(double x, double y) {
        GraphicsObject g = canvas.getElementAt(x, y);
        if(g != null && g instanceof MatrixBlock && !((MatrixBlock) g).isDefaultColor()){
            return (MatrixBlock)g;
        }
        return null;
    }

    
    
}

