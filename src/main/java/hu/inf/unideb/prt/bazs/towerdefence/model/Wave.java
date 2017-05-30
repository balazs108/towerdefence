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

import hu.inf.unideb.prt.bazs.towerdefence.model.MobType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A wave class, used to store the {@link Mob}s used in the {@link hu.inf.unideb.prt.bazs.towerdefence.controller.Game}.
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
     * Getter method for the mobtype list.
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
