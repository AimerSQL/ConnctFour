package conecta4.types;

public class Coordinate {

    public static final int ROW = 6;
    public static final int COL = 7;
    private int row;
    private int column;


    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


}