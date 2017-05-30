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
