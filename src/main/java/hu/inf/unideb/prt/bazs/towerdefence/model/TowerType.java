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
