public interface Shape {
    public void rotate();
    public void automaticMove();

    public MatrixBlock getBlockAt(double x, double y);

    public void moveShapeX(double x);

    public void moveShapeY(double y);
}
