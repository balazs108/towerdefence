package hu.inf.unideb.prt.bazs.towerdefence.model;

import hu.inf.unideb.prt.bazs.towerdefence.model.MobType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Balazs on 2017-05-20.
 */
public class Wave {
   private List<MobType> mobList;
   private int currentMob;

    public Wave( MobType... mobTypes) {
        this.mobList = new ArrayList<>();
        mobList.addAll(Arrays.asList(mobTypes));
        currentMob=0;
    }

    public List<MobType> getMobList() {
        return mobList;
    }

    public void setMobList(List<MobType> mobList) {
        this.mobList = mobList;
    }

    public int getCurrentMob() {
        return currentMob;
    }

    public void incCurrentMob() {
        this.currentMob++;
    }
}
