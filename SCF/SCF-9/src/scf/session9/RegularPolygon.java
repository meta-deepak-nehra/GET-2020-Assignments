package scf.session9;

import java.util.List;

class RegularPolygon extends Shape {

    private int totalSides;

    private int sideLength;

    private Point[] points;

    private Point center;

    private double apothem;

    private double radius;

    RegularPolygon(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        if (parameters.size() < 2) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.totalSides = parameters.get(0);
        this.sideLength = parameters.get(1);

        if (totalSides < 0 || sideLength < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        if (points == null) {
            setApothemRadiusCenterAndPoint();
        }

        return totalSides * (0.5 * sideLength * apothem);
    }

    @Override
    public double getPerimeter() {
        return totalSides * sideLength;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        double area = 0;
        double verySmallDifference = 0.1;

        if (points == null) {
            setApothemRadiusCenterAndPoint();
        }

        for (int i = 0; i < points.length - 1; i++) {
            area += calculateAreaOfTriangle(point, points[i], points[i + 1]);
        }

        area += calculateAreaOfTriangle(point, points[points.length - 1], points[0]);

        if (Math.abs(area - this.getArea()) < verySmallDifference) {
            return true;
        } else {
            return false;
        }
    }

    private void setApothemRadiusCenterAndPoint() {
        double internalAngle = (2 * Math.PI) / totalSides;
        apothem = ((double) sideLength) / (2 * Math.tan(internalAngle / 2));
        radius = ((double) sideLength) / (2 * Math.sin(internalAngle / 2));
        center = new Point(origin.xCoordinate + sideLength / 2.0, origin.yCoordinate + apothem);
        points = new Point[totalSides];
        double angle = Math.PI + internalAngle / 2.0;
        for (int i = 0; i < points.length; i++) {
            points[i] =
                    new Point(center.xCoordinate + radius * Math.sin(angle), center.yCoordinate
                            + radius * Math.cos(angle));
            angle += internalAngle;
        }
    }

    private double calculateAreaOfTriangle(Point A, Point B, Point C) {
        double AB = calculateDistance(A, B);
        double BC = calculateDistance(B, C);
        double AC = calculateDistance(A, C);
        return calculateAreaOfTriangle(AB, BC, AC);
    }

    private double calculateDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.xCoordinate - B.xCoordinate, 2)
                + Math.pow(A.yCoordinate - B.yCoordinate, 2));
    }

    private double calculateAreaOfTriangle(double side1, double side2, double side3) {
        double semiperimeter = (side1 + side2 + side3) / 2;
        double area =
                Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2)
                        * (semiperimeter - side3));
        return area;
    }

}
