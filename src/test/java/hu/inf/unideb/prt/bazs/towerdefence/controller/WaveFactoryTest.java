//CHECKSTYLE:OFF
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
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaveFactoryTest {
    @Test
    public void WaveFactoryTest(){
        List<MobType> test1 = new ArrayList<>();
        List<MobType> test2 = new ArrayList<>();
        List<Wave> waves;
        waves = Arrays.asList(
                WaveFactory.createWave(5,5,5,5),
                WaveFactory.createWave(1,1,1,1)
                ) ;
        test1.add(MobType.BOSS);
        test1.add(MobType.BOSS);
        test1.add(MobType.BOSS);
        test1.add(MobType.BOSS);
        test1.add(MobType.BOSS);

        test1.add(MobType.HEAVY);
        test1.add(MobType.HEAVY);
        test1.add(MobType.HEAVY);
        test1.add(MobType.HEAVY);
        test1.add(MobType.HEAVY);

        test1.add(MobType.MEDIUM);
        test1.add(MobType.MEDIUM);
        test1.add(MobType.MEDIUM);
        test1.add(MobType.MEDIUM);
        test1.add(MobType.MEDIUM);

        test1.add(MobType.LIGHT);
        test1.add(MobType.LIGHT);
        test1.add(MobType.LIGHT);
        test1.add(MobType.LIGHT);
        test1.add(MobType.LIGHT);

        test2.add(MobType.BOSS);
        test2.add(MobType.HEAVY);
        test2.add(MobType.MEDIUM);
        test2.add(MobType.LIGHT);

        Assert.assertEquals(test1.get(1),waves.get(0).getMobList().get(1));
        Assert.assertEquals(test1.get(2),waves.get(0).getMobList().get(2));
        Assert.assertEquals(test1.get(5),waves.get(0).getMobList().get(5));
        Assert.assertEquals(test1.get(8),waves.get(0).getMobList().get(8));
        Assert.assertEquals(test1.get(10),waves.get(0).getMobList().get(10));
        Assert.assertEquals(test1.get(15),waves.get(0).getMobList().get(15));
        Assert.assertEquals(test1.get(17),waves.get(0).getMobList().get(17));
        Assert.assertEquals(test1.get(19),waves.get(0).getMobList().get(19));

        Assert.assertEquals(test2.get(0),waves.get(1).getMobList().get(0));
        Assert.assertEquals(test2.get(1),waves.get(1).getMobList().get(1));
        Assert.assertEquals(test2.get(2),waves.get(1).getMobList().get(2));
        Assert.assertEquals(test2.get(3),waves.get(1).getMobList().get(3));
    }
}
