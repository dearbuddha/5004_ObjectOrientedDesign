package ps8;

public class WayPoint {

    public WayPoint(double x, double y, int timestamp){
        this.setX(x);
        this.setY(y);
        this.setTimestamp(timestamp);
    }

    public WayPoint(){
        this.setX(0);
        this.setY(0);
        this.setTimestamp(0);
    }

    public WayPoint(WayPoint other){
        this(other.xCoordinates, other.yCoordinates, other.timestamp);
    }

    private double xCoordinates;
    private double yCoordinates;
    private int timestamp;

    public double getX() {
        return xCoordinates;
    }

    public void setX(double xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public double getY() {
        return yCoordinates;
    }

    public void setY(double yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public static double Distance(WayPoint wayPoint1, WayPoint wayPoint2){
        double xDistance = wayPoint1.getX() - wayPoint2.getX();
        double yDistance = wayPoint1.getY()  - wayPoint2.getY();
        double distance  = 0.1 * Math.sqrt(xDistance * xDistance + yDistance * yDistance);
//        System.out.printf( "Total distance travelled: %.2f", distance);
        return distance;
    }

    public String toString(){
        return "[x: " + this.getX() + ", y: " + this.getY() + ", timestamp: " + this.getTimestamp() + "]";
    }
}
