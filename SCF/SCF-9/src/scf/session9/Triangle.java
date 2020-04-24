package scf.session9;

import java.util.List;

class Triangle extends Shape {

    private int baseSide; // side AB

    private int sideOriginatingFromLeftOfBaseSide; // side AC

    private int sideOriginatingFromRightOfBaseSide; // side BC

    private double area;

    private Point A;

    private Point B;

    private Point C;

    Triangle(Point origin, List<Integer> parameters) {
        if (parameters.size() < 3) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.baseSide = parameters.get(0);
        this.sideOriginatingFromLeftOfBaseSide = parameters.get(1);
        this.sideOriginatingFromRightOfBaseSide = parameters.get(2);
        area = -1;

        if (!isValidTriangle(baseSide, sideOriginatingFromLeftOfBaseSide,
                sideOriginatingFromRightOfBaseSide)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {

        if (area == -1) {
            setArea();
        }
        return area;
    }

    private void setArea() {
        this.area =
                calculateArea(baseSide, sideOriginatingFromLeftOfBaseSide,
                        sideOriginatingFromRightOfBaseSide);
    }

    private double calculateArea(double side1, double side2, double side3) {
        double semiperimeter = (side1 + side2 + side3) / 2;
        // heron's formula
        // area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        double area =
                Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2)
                        * (semiperimeter - side3));
        return area;
    }

    @Override
    public double getPerimeter() {
        return baseSide + sideOriginatingFromLeftOfBaseSide + sideOriginatingFromRightOfBaseSide;
    }

    @Override
    public Point getOrigin() {

        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        if (A == null || B == null || C == null) {
            setCornerPoints();
        }

        double verySmallDifference = 0.1;
        // suppose triangle is ABC and point is P
        Point P = point;
        double AB = baseSide;
        double AC = sideOriginatingFromLeftOfBaseSide;
        double BC = sideOriginatingFromRightOfBaseSide;

        double PA = calculateDistance(P, A);
        double PB = calculateDistance(P, B);
        double PC = calculateDistance(P, C);

        double areaPAB = calculateArea(PA, PB, AB);
        double areaPBC = calculateArea(PB, PC, BC);
        double areaPAC = calculateArea(PA, PC, AC);
        double areaABC = getArea();

        if (Math.abs(areaPAB + areaPBC + areaPAC - areaABC) < verySmallDifference) {
            return true;
        } else {
            return false;
        }
    }

    private void setCornerPoints() {
        A = new Point(origin.xCoordinate, origin.yCoordinate);
        B = new Point(A.xCoordinate + baseSide, A.yCoordinate);
        double area = getArea();
        double height = (2 * area) / baseSide;
        double xOfBaseOfPerpendicularFromC =
                Math.sqrt(Math.pow(sideOriginatingFromLeftOfBaseSide, 2) - Math.pow(height, 2))
                        + A.xCoordinate;
        C = new Point(xOfBaseOfPerpendicularFromC, A.yCoordinate + height);
    }

    private double calculateDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.xCoordinate - B.xCoordinate, 2)
                + Math.pow(A.yCoordinate - B.yCoordinate, 2));
    }

    private boolean isValidTriangle(int side1, int side2, int side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return false;
        }
        if (side1 > side2 + side3 || side2 > side1 + side3 || side3 > side1 + side2) {
            return false;
        }

        return true;
    }
}
