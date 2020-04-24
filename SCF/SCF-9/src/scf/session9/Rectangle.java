package scf.session9;

import java.util.List;

class Rectangle extends Shape {

    int width;

    int height;

    Rectangle(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        if (parameters.size() < 2) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.width = parameters.get(0);
        this.height = parameters.get(1);

        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {

        return width * height;
    }

    @Override
    public double getPerimeter() {

        return 2 * (width + height);
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
                && point.yCoordinate < origin.yCoordinate + height) {

            return true;
        }

        return false;
    }

}
