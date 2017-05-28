package hu.inf.unideb.prt.bazs.towerdefence.model;

/**
 * Created by Balazs on 2017-05-20.
 */
public class Tower {
    private TowerType towerType;
    private int reloadState;
    private int x,y;
    private Mob target;
    private boolean shooting;

    public Tower(TowerType towerType, int x, int y) {
        this.towerType = towerType;
        this.x = x;
        this.y = y;
        reloadState=0;
        shooting = false;
    }

    public TowerType getTowerType() {
        return towerType;
    }

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

    public void setTowerType(TowerType towerType) {
        this.towerType = towerType;
    }

    public int getReloadState() {
        return reloadState;
    }

    public void setReloadState(int reloadState) {
        this.reloadState = reloadState;
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

    public Mob getTarget() {
        return target;
    }

    public void setTarget(Mob target) {
        this.target = target;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}
