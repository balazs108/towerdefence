package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Tower class, these are objects that can be placed on the {@link Field}, and will try to "kill" {@link Mob}s near them.
 */
public class Tower {
    /**
     * The type of the tower.
     */
    private TowerType towerType;
    /**
     * The state of reload. If it's below or on zero than the tower can fire.
     */
    private int reloadState;
    /**
     * The x coordinate of the tower.
     */
    private int x;
    /**
     * The y coordinate of the tower.
     */
    private int y;
    /**
     * A mob object that is the towers target.
     */
    private Mob target;
    /**
     * A bool value that determines if the tower is shooting at the moment or nor, this enables the drawing of the
     * towers projectile between him and its target.
     */
    private boolean shooting;

    /**
     * Constructor method, creates a tower.
     * @param towerType the new towers type.
     * @param x the x coordinate of the new tower.
     * @param y the y coodrinate of the new tower.
     */
    public Tower(TowerType towerType, int x, int y) {
        this.towerType = towerType;
        this.x = x;
        this.y = y;
        reloadState=0;
        shooting = false;
    }

    /**
     * This method is responsible for the tower shooting at its target.
     * If the towers reloadstate is below or on zero and it has a target, then it will shoot at it,
     * and as a result the mobs health will be decreased by the towers damage.
     */
    public void shoot() {
        if(reloadState <= 0 && target != null) {
            target.damageHealth(towerType.getDamage());
            reloadState = towerType.getReloadTime();
            shooting = true;
        }   else {
            shooting = false;
        }
            reloadState--;

    }

    /**
     * Getter method for the towertype.
     * @return the towertype.
     */
    public TowerType getTowerType() {
        return towerType;
    }

    /**
     * Getter method for the towers x coordinate.
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }
    /**
     * Getter method for the towers y coordinate.
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }
    /**
     * Getter method for the towers target.
     * @return the target.
     */
    public Mob getTarget() {
        return target;
    }

    /**
     * Setter method for the target.
     * @param target the new target.
     */
    public void setTarget(Mob target) {
        this.target = target;
    }

    /**
     * Getter method for the shooting.
     * @return the value of shooting.
     */
    public boolean isShooting() {
        return shooting;
    }


}
