package hu.inf.unideb.prt.bazs.towerdefence.model;

import hu.inf.unideb.prt.bazs.towerdefence.model.Coord;

import java.util.LinkedList;

/**
 * Created by Balazs on 2017-05-10.
 */
public class Road {
    private LinkedList<Coord> roadNodes;

    public Road() {
        this.roadNodes= new LinkedList<Coord>();
    }

    public void addNode(int x, int y) {
        this.roadNodes.addLast(new Coord(x,y));
    }
    public Coord getLast() {
       return this.roadNodes.getLast();
    }

    public LinkedList<Coord> getRoadNodes() {
        return roadNodes;
    }

    public void setRoadNodes(LinkedList<Coord> roadNodes) {
        this.roadNodes = roadNodes;
    }


}
