package scf.session9;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Screen {

    double xMax;

    double yMax;

    List<Shape> shapes;

    public Screen(double xMax, double yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        shapes = new ArrayList<Shape>();
    }

    public boolean addShape(Shape shape) {
        if (!shapes.contains(shape)) {
            shape.time = LocalTime.now();
            shapes.add(shape);
            return true;
        }

        return false;
    }

    public boolean deleteShape(Shape shape) {
        if (shapes.contains(shape)) {
            shape.time = null;
            shapes.remove(shape);
            return true;
        }

        return false;
    }

    public void deleteShape(ShapeType shapeType) {
        Iterator<Shape> iterator = shapes.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (shape.getClass().getSimpleName().equals(shapeType.name())) {
                shape.time = null;
                iterator.remove();
            }
        }
    }

    public List<Shape> getShapesSortedByArea() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByArea());
        return list;
    }

    public List<Shape> getShapesSortedByPerimeter() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByPerimeter());
        return list;
    }

    public List<Shape> getShapesSortedByLocalTime() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByLocalTime());
        return list;
    }

    public List<Shape> getShapesSortedByOriginDistance() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByOriginDistance());
        return list;
    }

    public List<Shape> getEnclosingShapes(Point point) {
        List<Shape> enclosingShapes = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            if (shape.isPointEnclosed(point)) {
                enclosingShapes.add(shape);
            }
        }
        return enclosingShapes;
    }

    private class CompareShapesByArea implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getArea(), shape2.getArea());
        }
    }

    private class CompareShapesByPerimeter implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
        }
    }

    private class CompareShapesByLocalTime implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return shape1.time.compareTo(shape2.time);
        }
    }

    private class CompareShapesByOriginDistance implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            double distance1Squared =
                    Math.pow(shape1.origin.xCoordinate, 2) + Math.pow(shape1.origin.yCoordinate, 2);
            double distance1 = Math.sqrt(distance1Squared);
            double distance2Squared =
                    Math.pow(shape2.origin.xCoordinate, 2) + Math.pow(shape2.origin.yCoordinate, 2);
            double distance2 = Math.sqrt(distance2Squared);

            return Double.compare(distance1, distance2);
        }
    }
}
