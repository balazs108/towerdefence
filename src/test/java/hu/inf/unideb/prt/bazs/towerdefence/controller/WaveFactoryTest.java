package hu.inf.unideb.prt.bazs.towerdefence.controller;

import hu.inf.unideb.prt.bazs.towerdefence.model.MobType;
import hu.inf.unideb.prt.bazs.towerdefence.model.Wave;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Balazs on 2017-05-26.
 */
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
