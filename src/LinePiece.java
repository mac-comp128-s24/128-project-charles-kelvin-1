public class LinePiece implements Shape{
    private int[][] coordinates;
    private double x;
    private double y;

    public LinePiece(){
        coordinates = new int[4][4];
        coordinates[0][0] = 1;
        coordinates[1][0] = 1;
        coordinates[2][0] = 1;
        coordinates[3][0] = 1;
    }

    @Override
    public void rotate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }

    @Override
    public int[][] coordinates() {
        return coordinates;
    }

    @Override
    public void automaticMove() {
        for(int i = 0; i < coordinates.length; i++){
            for(int j = 0; j < coordinates[i].length; j++){
                
            }
        }
    }

    
    
}
