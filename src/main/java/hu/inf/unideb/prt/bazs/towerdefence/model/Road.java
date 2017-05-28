package hu.inf.unideb.prt.bazs.towerdefence.model;

import hu.inf.unideb.prt.bazs.towerdefence.model.Coord;

import java.util.LinkedList;

/**
 * A Road class which contains a linked list of nodes.
 */
public class Road {
    /**
     * The outline of the road.
     */
    private LinkedList<Coord> roadNodes;

    /**
     * Constructor method for the road.
     */
    public Road() {
        this.roadNodes= new LinkedList<Coord>();
    }

    /**
     * This method adds a node to the linked list.
     * @param x the x coordinate of the node.
     * @param y the y coordinate of the node.
     */
    public void addNode(int x, int y) {
        this.roadNodes.addLast(new Coord(x,y));
    }

    /**
     * Getter method for the linked list.
     * @return the last node on the linked list.
     */
    public Coord getLast() {
       return this.roadNodes.getLast();
    }

    /**
     * Getter method for the linked list.
     * @return the linked list.
     */
    public LinkedList<Coord> getRoadNodes() {
        return roadNodes;
    }



}
