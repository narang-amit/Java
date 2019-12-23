//SOrry

public class Location implements Comparable<Location> {

    private int x,y,done;
    private Location prev;
    private double distance;

    public Location(int xvar, int yvar, Location previous) {
    	x = xvar;
    	y = yvar;
    	prev = previous;
    }
    public Location(int xvar, int yvar, Location previous, double distanceToStart) {
    	this(xvar,yvar,previous);
    	distance = distanceToStart;
    }
    public Location(int xvar, int yvar, Location previous, double distanceToStart, int doneSoFar) {
        this(xvar,yvar,previous,distanceToStart);
        done = doneSoFar;
    }
    public int getX() {
	   return x;
    }
    public int getY() {
	   return y;
    }
    public Location getPrev() {
	   return prev;
    }
    public double getDist() {
	   return distance;
    }
    public int getDone() {
        return done;
    }
    public void setDist(double dist) {
        distance = dist;
    }
    public boolean equals(Location temp) {
        return x == temp.getX() && y == temp.getY();
    }

    @Override
    public int compareTo(Location other) {
        /*
        if (MazeSolver.aStarStatus()) {
            Double x = (Double) this.distance + (Double) (1.0 * this.done);
            Double y = (Double) other.distance + (Double) (1.0 * other.done);
            return Double.compare(x,y);
        }
        */
        return Double.compare((Double) this.distance, (Double) other.getDist());
    }
}