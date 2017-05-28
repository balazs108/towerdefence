package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Created by Balazs on 2017-05-01.
 */
public enum MobType {
    BOSS(400,2,50),
    HEAVY(100,3,10),
    MEDIUM(50,4,4),
    LIGHT(30,5,1);
    private int health;
    private int speed;
    private int loot;

    MobType(int health, int speed, int loot) {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLoot() {
        return loot;
    }
}
