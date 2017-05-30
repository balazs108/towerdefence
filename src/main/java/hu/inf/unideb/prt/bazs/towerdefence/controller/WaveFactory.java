package hu.inf.unideb.prt.bazs.towerdefence.controller;

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

import hu.inf.unideb.prt.bazs.towerdefence.model.MobType;
import hu.inf.unideb.prt.bazs.towerdefence.model.Wave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *This class creates a list of waves for the game.
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
