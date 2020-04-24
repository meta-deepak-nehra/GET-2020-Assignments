package scf.session9;

import java.time.LocalTime;

public abstract class Shape {
    Point origin;

    LocalTime time;

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract Point getOrigin();

    public abstract boolean isPointEnclosed(Point point);
}
