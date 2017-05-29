package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Enum of the {@link Tower} types.
 */
public enum TowerType {
    /**
     * Normal tower type, average stats.
     */
    Normal(96,10,10,25),
	/**
	* Fast tower type, low damage but it has an extreemly high fire rate.
	*/
    Fast(64,2,1,30),
	/**
	* Chaos tower type, high damage, long range but low fire rate.
	*/
    Chaos(128,20,20,30);
    /**
     * The range of the tower type.
     */
    private int range;
    /**
     * The damage of the tower type.
     */
    private int damage;
    /**
     * The reload time of the tower.
     */
    private int reloadTime;
    /**
     * The cost of the tower type.
     */
    private int cost;

    /**
     * Constructor method that creates a tower type.
     * @param range The range of the tower type.
     * @param damage The damage of the tower type.
     * @param reloadTime The reload time of the tower.
     * @param cost The cost of the tower type.
     */
    TowerType(int range, int damage, int reloadTime, int cost) {
        this.range = range;
        this.damage = damage;
        this.reloadTime = reloadTime;
        this.cost =cost;
    }

    /**
     * Getter method for the range.
     * @return the range.
     */
    public int getRange() {
        return range;
    }
    /**
     * Getter method for the damage.
     * @return the damage.
     */
    public int getDamage() {
        return damage;
    }
    /**
     * Getter method for the reloadTime.
     * @return the reloadTime.
     */
    public int getReloadTime() {
        return reloadTime;
    }
    /**
     * Getter method for the cost.
     * @return the cost.
     */
    public int getCost() {
        return cost;
    }
}
