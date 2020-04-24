package scf.session9;

public class Point {

    double xCoordinate;

    double yCoordinate;

    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * @return the xCoordinate
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * @param xCoordinate the xCoordinate to set
     */
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * @return the yCoordinate
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * @param yCoordinate the yCoordinate to set
     */
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    
}
