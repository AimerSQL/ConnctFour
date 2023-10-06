package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Coordinate;
import conecta4.types.Direction;

class Board {

    private final Color[][] colors;
    private Coordinate position;

    public String test10;
    Board() {
        this.colors = new Color[Coordinate.ROW][Coordinate.COL];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.ROW; i++) {
            for (int j = 0; j < Coordinate.COL; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(int col, Color color) {
        boolean put = false;
        int i = 0;
        do {
            if (this.colors[i][col].isNull()) {
                this.colors[i][col] = color;
                position = new Coordinate(i, col);
                put = true;
            }
            i++;
        } while (!put && i < 6);
    }



    Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate) {
        return this.getColor(coordinate) == Color.NULL;
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate);
    }

    boolean isBoardFull() {
        for(int i = 0; i < Coordinate.ROW; i++ ) {
            for(int j = 0; j < Coordinate.COL; j++) {
                if(this.isEmpty(new Coordinate(i,j))) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isConnectFour(Color color) {
        for (Direction direction : Direction.values()) {
            boolean isConnected = checkDirection(color, position, direction);
            if (isConnected) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDirection(Color color, Coordinate coordinate, Direction direction) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int newX = coordinate.getRow() + i * direction.getDx();
            int newY = coordinate.getColumn() + i * direction.getDy();

            if (isValidCoordinate(newX, newY) && colors[newX][newY] == color) {
                count++;
            } else {
                break;
            }
        }
        return count == 4;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < Coordinate.ROW && y >= 0 && y < Coordinate.COL;
    }

}
