import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

public class BlockPiece implements Shape{
    private double x;
    private double y;
    private CanvasWindow canvas;
    public BlockPiece(double x, double y, CanvasWindow canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        Block block = new Block (x, y);
        Block block1 = new Block (x + Block.SIZE, y);
        Block block2 = new Block (x + Block.SIZE, y + Block.SIZE);
        Block block3 = new Block (x,  y + Block.SIZE);

        block.setFillColor(Color.RED);
        block1.setFillColor(Color.RED);
        block2.setFillColor(Color.RED);
        block3.setFillColor(Color.RED);

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'automaticMove'");
    }
}
