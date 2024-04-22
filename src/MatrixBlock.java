import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class MatrixBlock extends Rectangle {
    public final static double SIZE = 20;

    public MatrixBlock(double x, double y){
        super(x, y, SIZE, SIZE);
        this.setFillColor(Color.GRAY);
    }

    public boolean isDefaultColor(){
        if(this.getFillColor().equals(Color.GRAY))  
            return true;
        return false;
    }

    public void setDefaultColor(){
        this.setFillColor(Color.GRAY);
    }

    
}
