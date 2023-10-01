package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Coordinate;

import java.util.ArrayList;
import java.util.List;

class Board {

    private Color[][] colors;
    private Player player;
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
        for (int i = 0; i < 6; i++) {
            if (this.colors[i][col].isNull()) {
                this.colors[i][col] = color;
                break;
            }
        }
    }


    Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    boolean isBoardFull(Coordinate coordinate) {
        for(int i = 0; i < Coordinate.ROW; i++ ) {
            for(int j = 0; j < Coordinate.COL; j++) {
                if(this.isEmpty(coordinate)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isConnectFour(Color color) {
        assert !color.isNull();

        List<Direction> directions = this.getDirections(color);
        if (directions.size() < Coordinate.DIMENSION - 1) {
            return false;
        }
        for (int i = 0; i < directions.size() - 1; i++) {
            if (directions.get(i) != directions.get(i + 1)) {
                return false;
            }
        }
        return !directions.get(0).isNull();
    }

    private List<Direction> getDirections(Color color) {
        assert !color.isNull();

        List<Direction> directions = new ArrayList<>();
        List<Coordinate> coordinates = this.getCoordinates(color);
        if (!coordinates.isEmpty()) {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
            }
        }
        return directions;
    }

    List<Coordinate> getCoordinates(Color color) {
        assert !color.isNull();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < Coordinate.ROW; i++) {
            for (int j = 0; j < Coordinate.COL; j++) {
                if (this.getColor(new Coordinate(i, j)) == color) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }

}