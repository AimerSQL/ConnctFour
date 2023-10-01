package conecta4.views;

import conecta4.types.Coordinate;
import conecta4.types.Error;
import utils.models.ConcreteCoordinate;
import utils.views.SquareBoundedCoordinateView;

class CoordinateView extends SquareBoundedCoordinateView {

    @Override
    public SquareBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
        return new Coordinate(concreteCoordinate);
    }

    @Override
    public String getErrorMessage() {
        return ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()];
    }

}