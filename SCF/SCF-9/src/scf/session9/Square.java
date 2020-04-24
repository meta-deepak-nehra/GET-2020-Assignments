package scf.session9;

import java.util.List;

class Square extends Shape {

    int width;

    Square(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        if (parameters.size() < 0) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.width = parameters.get(0);

        if (width < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {

        return width * width;
    }

    @Override
    public double getPerimeter() {

        int numberOfSides = 4;
        return width * numberOfSides;
    }

    @Override
    public Point getOrigin() {

        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {

        if (point.xCoordinate > origin.xCoordinate
                && point.xCoordinate < origin.xCoordinate + width
                && point.yCoordinate > origin.yCoordinate
                && point.yCoordinate < origin.yCoordinate + width) {

            return true;
        } else {
            return false;
        }
    }
   
}
