package scf.session9;

import java.util.List;

public class ShapeFactory {

    public static Shape createShape(ShapeType shapeType, Point origin,
            List<Integer> shapeParameters) throws IllegalArgumentException {
        
        Shape shape;
        
        switch (shapeType) {
        case SQUARE:
            shape = new Square(origin, shapeParameters);
            break;
        case RECTANGLE:
            shape = new Rectangle(origin, shapeParameters);
            break;
        case CIRCLE:
            shape = new Circle(origin, shapeParameters);
            break;
        case TRIANGLE:
            shape = new Triangle(origin, shapeParameters);
            break;
        case REGULAR_POLYGON:
            shape = new RegularPolygon(origin, shapeParameters);
            break;
        default:
            throw new IllegalArgumentException("Invalid Shape Type");
        }
        
        return shape;
    }
}
