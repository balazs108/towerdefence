package hu.inf.unideb.prt.bazs.towerdefence.model;

/*-
 * #%L
 * towerdefence
 * %%
 * Copyright (C) 2017 University of Debrecen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * #L%
 */

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
