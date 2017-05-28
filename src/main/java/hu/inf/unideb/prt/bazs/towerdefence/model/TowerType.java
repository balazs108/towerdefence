package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Created by Balazs on 2017-05-20.
 */
public enum TowerType {
    Normal(96,10,10,25),
    Fast(64,2,1,30),
    Chaos(128,20,20,30);
    private int range;
    private int damage;
    private int reloadTime;
    private int cost;

    TowerType(int range, int damage, int reloadTime, int cost) {
        this.range = range;
        this.damage = damage;
        this.reloadTime = reloadTime;
        this.cost =cost;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public int getCost() {
        return cost;
    }
}
