package hu.inf.unideb.prt.bazs.towerdefence.controller;

import hu.inf.unideb.prt.bazs.towerdefence.model.MobType;
import hu.inf.unideb.prt.bazs.towerdefence.model.Wave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Balazs on 2017-05-20.
 *This class creates a list of waves for the game
 */
public class WaveFactory {
    /**
     * This method creates a wave, with the defined number of mobs.
     * @param boss defines how many boss type mobs will be in the wave
     * @param heavy defines how many heavy type mobs will be in the wave
     * @param medium defines how many medium type mobs will be in the wave
     * @param light defines how many light type mobs will be in the wave
     * @return a wave that has been created with the mobarray
     */
    public static Wave createWave(int boss, int heavy, int medium, int light) {

        Logger logger = LoggerFactory.getLogger(WaveFactory.class);

        MobType[] mobArray=new MobType[boss+heavy+medium+light];

        for (int i=0;i<boss;i++)
            mobArray[i] = MobType.BOSS;

        for (int i=boss; i<boss + heavy; i++)
            mobArray[i] = MobType.HEAVY;

        for (int i=boss + heavy; i<boss + heavy + medium; i++)
            mobArray[i] = MobType.MEDIUM;

        for (int i=boss + heavy + medium; i<boss + heavy + medium + light; i++)
            mobArray[i] = MobType.LIGHT;

        logger.info("A wave has been constructed.");
        return new Wave(mobArray);
    }


}
