package conecta4.types;

import utils.models.ConcreteCoordinate;

public class Coordinate {

    public static final int ROW = 6;
    public static final int COL = 7;
    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        new Coordinate(row, column);
    }


    /*protected int getDimension() {
        return Coordinate.DIMENSION;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
            if (this.getColumn() != other.getColumn())
                return false;
        }
        return true;
    }*/

}