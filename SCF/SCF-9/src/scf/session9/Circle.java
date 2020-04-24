package scf.session9;

import java.util.List;

class Circle extends Shape {

    private int radius;

    private Point centerPoint;

    Circle(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        this.origin = origin;
        this.radius = parameters.get(0);
        this.centerPoint = null;

        if (radius < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {

        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {

        return 2 * Math.PI * radius;
    }

    @Override
    public Point getOrigin() {

        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {

        if (centerPoint == null) {
            setCenterPoint();
        }

        double distanceOfPointFromCenter =
                Math.sqrt(Math.pow(centerPoint.xCoordinate - point.xCoordinate, 2)
                        + Math.pow(centerPoint.yCoordinate - point.yCoordinate, 2));

        if (distanceOfPointFromCenter < radius) {
            return true;
        } else {
            return false;
        }
    }

    private void setCenterPoint() {
        double x1 = origin.xCoordinate;
        double y1 = origin.yCoordinate;
        double r = this.radius;
        double x1Squared = Math.pow(x1, 2);
        double y1Squared = Math.pow(y1, 2);
        double a = x1Squared + y1Squared;
        double b = -1 * ((2 * x1 * y1Squared) + (2 * Math.pow(x1, 3)));
        double c = (x1Squared * y1Squared) + Math.pow(x1, 4) - (Math.pow(r, 2) * x1Squared);
        double D = Math.pow(b, 2) - 4 * a * c;
        double x = (-1 * b + Math.pow(D, 0.5)) / (2 * a);
        double y = (y1 / x1) * x;
        centerPoint = new Point(x, y);
    }
}
