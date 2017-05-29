package hu.inf.unideb.prt.bazs.towerdefence.model;

import java.util.ListIterator;

/**
 * A class for the mob objects, they will move on a preset {@link Road} from the starting point to the finish point.
 */
public class Mob {
    /**
     * The health of a mob object, if it gets to or below zero the mob will "die" .
     */
    private int health;
    /**
     * The x coordinate of the mob object on the field.
     */
    private int x;
    /**
     * The y coordinate of the mob object on the field.
     */
    private int y;
    /**
     * The type of the mob object, this determines factors like its speed, health or loot value.
     */
    private MobType mobType;
    /**
     * An iterator that helps the mob object to orient itself on the road.
     */
    private ListIterator<Coord> roadIterator;
    /**
     * A node from the road, that is the mob objects current objective.
     */
    private Coord currentNode;
    /**
     * A boolean that is true if the mob object reached the last node in the road, false otherwise.
     */
    private boolean reachGoal;

    /**
     * Constructor method for the mob.
     * @param mobType the mobs type.
     * @param road the road of the mob.
     */
    public Mob(MobType mobType, Road road) {
        this.mobType = mobType;
        this.health = this.mobType.getHealth();
        this.roadIterator = road.getRoadNodes().listIterator();
        this.currentNode=this.roadIterator.next();
        this.x = currentNode.getX();
        this.y = currentNode.getY();
        this.reachGoal=false;
    }

    /**
     * This method moves all mob objects on the field, if they reach their current goal then their goal will be changed.
     * The next node. If that's not possible then they have reached their goal thus the reachGoal boolean will be changed
     * to true.
     */
    public void move() {
        if( Math.abs(currentNode.getX()-this.x) < this.mobType.getSpeed() && Math.abs(currentNode.getY()-this.y) < this.mobType.getSpeed()) {
            this.x=currentNode.getX();
            this.y=currentNode.getY();
            if(roadIterator.hasNext())
                this.currentNode = roadIterator.next();
            else
                this.reachGoal=true;
        }else {

            if (this.y - currentNode.getY() == 0 && this.x < currentNode.getX()) {
                this.x += this.mobType.getSpeed();
            }else
            if (this.y - currentNode.getY() == 0 && this.x > currentNode.getX()) {
                this.x -= this.mobType.getSpeed();
            }else
            if (this.x - currentNode.getX() == 0 && this.y < currentNode.getY()) {
                this.y += this.mobType.getSpeed();
            }else
            if (this.x - currentNode.getX() == 0 && this.y > currentNode.getY()) {
                this.y -= this.mobType.getSpeed();
            }
        }
    }

    /**
     * Getter method for the heath.
     * @return the health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * A method that decreases the mobs health by the given value.
     * @param damage the value that is subtracted from the health.
     */
    public void damageHealth(int damage) {
        this.health-=damage;
    }

    /**
     * Getter method for the x coordinate.
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }
    /**
     * Getter method for the Y coordinate.
     * @return the Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter method for the mobtype.
     * @return the mobtype.
     */
    public MobType getMobType() {
        return mobType;
    }

    /**
     * Getter method for the reachGoal.
     * @return the reachGoal.
     */
    public boolean isReachGoal() {
        return reachGoal;
    }

    /**
     * Setter method for the health.
     * @param health the new health.
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
