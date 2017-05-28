package hu.inf.unideb.prt.bazs.towerdefence.model;

import java.util.ListIterator;

/**
 * Created by Balazs on 2017-05-01.
 */
public class Mob {
    private int health;
    private int x,y;
    private MobType mobType;
    private ListIterator<Coord> roadIterator;
    private Coord currentNode;
    private boolean reachGoal;


    public Mob(MobType mobType, Road road) {
        this.mobType = mobType;
        this.health = this.mobType.getHealth();
        this.roadIterator = road.getRoadNodes().listIterator();
        this.currentNode=this.roadIterator.next();
        this.x = currentNode.getX();
        this.y = currentNode.getY();
        this.reachGoal=false;
    }

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

    public int getHealth() {
        return health;
    }

    public void damageHealth(int damage) {
        this.health-=damage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MobType getMobType() {
        return mobType;
    }

    public void setMobType(MobType mobType) {
        this.mobType = mobType;
    }


    public boolean isReachGoal() {
        return reachGoal;
    }

    public void setReachGoal(boolean reachGoal) {
        this.reachGoal = reachGoal;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
