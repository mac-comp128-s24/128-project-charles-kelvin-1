import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class MatrixBlock extends Rectangle {
    public final static double SIZE = 20;

    /**
     * This method is the constructor that calls upon the parent classes constructor (rectangle) to create an object
     * @param x
     * @param y
     */
    public MatrixBlock(double x, double y){
        super(x, y, SIZE, SIZE);
        this.setFillColor(Color.GRAY);
    }

    /**
     * sets the color of the matrixblock to gray which is the default board color
     */
    public void setDefaultColor(){
        this.setFillColor(Color.GRAY);
    }

    
}
