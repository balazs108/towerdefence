package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Class that is used in the road, it represents a coordinate.
 */
public class Coord {
    private int x;
    private int y;

    /**
     * Constructor for the coord.
     * @param x an int the x coordinate.
     * @param y an int the y coordinate.
     */
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for the y coordinate.
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter method for the x coordinate.
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }
}
