package hu.inf.unideb.prt.bazs.towerdefence.controller;

import hu.inf.unideb.prt.bazs.towerdefence.model.Road;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Balazs on 2017-05-10.
 * This class is responsible for making a list of nodes which is the {@link Road} itself
 */
public class RoadBuilder {
    /**
     * A Road variable in which the road will be built up.
     */
    private Road road;

    /**
     * Starts the construction of the list by making the first link.
     * @param startX this is the starting x coordinate
     * @param startY this is the starting y coordinate
     */
    public RoadBuilder(int startX, int startY) {
        this.road = new Road();
        this.road.addNode(startX,startY);
    }

    /**
     * This method creates a new node "higher" then its parent.
     * @param unit the number of tiles between the previous node and the new one. (32x32 pixels is a tile)
     * @return returns a roadbuilder so the methods can be linked up, making the building process easy and comapct.
     */
    public RoadBuilder up(int unit) {
        this.road.addNode(
                this.road.getLast().getX(),
                this.road.getLast().getY()-(32*unit)
        );
        return this;
    }
    /**
     * This method creates a new node "lower" then its parent.
     * @param unit the number of tiles between the previous node and the new one. (32x32 pixels is a tile)
     * @return returns a roadbuilder so the methods can be linked up, making the building process easy and comapct.
     */
    public RoadBuilder down(int unit) {
        this.road.addNode(
                this.road.getLast().getX(),
                this.road.getLast().getY()+(32*unit)
        );
        return this;
    }
    /**
     * This method creates a new node to the "left" of its parent.
     * @param unit the number of tiles between the previous node and the new one. (32x32 pixels is a tile)
     * @return returns a roadbuilder so the methods can be linked up, making the building process easy and comapct.
     */
    public RoadBuilder left(int unit) {
        this.road.addNode(
                this.road.getLast().getX()-(32*unit),
                this.road.getLast().getY()
        );
        return this;
    }
    /**
     * This method creates a new node to the "right" of  its parent.
     * @param unit the number of tiles between the previous node and the new one. (32x32 pixels is a tile)
     * @return returns a roadbuilder so the methods can be linked up, making the building process easy and comapct.
     */
    public RoadBuilder right(int unit) {
        this.road.addNode(
                this.road.getLast().getX()+(32*unit),
                this.road.getLast().getY()
        );
        return this;
    }

    /**
     * Builder method that converts the RoadBuilder into a road.
     * @return the road.
     */
    public Road build() {
        Logger logger = LoggerFactory.getLogger(RoadBuilder.class);
        logger.info("The road is finished.");
        return road;
    }
}