package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Enum of {@link Mob} types.
 */
public enum MobType {
    /**
     * Boss type, strongest but also the slowest type.
     */
    BOSS(400,2,50),
    /**
     * Heavy type, weaker then a boss type, but in great number a fore to recon with.
     */
    HEAVY(100,3,10),
    /**
     * Medium type, the most common mobtype.
     */
    MEDIUM(50,4,4),
    /**
     * Light type, they are exceptionally weak but very fest.
     */
    LIGHT(30,5,1);
    /**
     * The health of a mobtype.
     */
    private int health;
    /**
     * The speed of a mobtype.
     */
    private int speed;
    /**
     * The loot value of a mobtype.
     */
    private int loot;

    /**
     * Constructor method that creates a mobtype.
     * @param health the health of the mobtype.
     * @param speed the speed of the mobtype
     * @param loot  the loot value of the mobype.
     */
    MobType(int health, int speed, int loot) {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
    }

    /**
     * Getter method for the health.
     * @return the health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter for the speed.
     * @return the speed.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Getter for the loot value.
     * @return the loot value.
     */
    public int getLoot() {
        return loot;
    }
}
