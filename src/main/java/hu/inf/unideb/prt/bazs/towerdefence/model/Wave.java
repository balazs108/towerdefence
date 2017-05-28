package hu.inf.unideb.prt.bazs.towerdefence.model;

import hu.inf.unideb.prt.bazs.towerdefence.model.MobType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A wave class.
 */
public class Wave {
    /**
     * A list of mobtypes.
     */
    private List<MobType> mobList;
    /**
     * The index of the mob that is currently used.
     */
    private int currentMob;

    /**
     * Constructor of the wave.
     * @param mobTypes a list of mobtypes.
     */
    public Wave( MobType... mobTypes) {
        this.mobList = new ArrayList<>();
        mobList.addAll(Arrays.asList(mobTypes));
        currentMob=0;
    }

    /**
     * Getter method for the mobtype list
     * @return the mobtype list.
     */
    public List<MobType> getMobList() {
        return mobList;
    }

    /**
     * Getter method for the currentmob.
     * @return the currentmob.
     */
    public int getCurrentMob() {
        return currentMob;
    }

    /**
     * Increment method for the currentmob.
     */
    public void incCurrentMob() {
        this.currentMob++;
    }
}
