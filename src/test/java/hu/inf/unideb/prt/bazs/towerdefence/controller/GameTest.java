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

import hu.inf.unideb.prt.bazs.towerdefence.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Balazs on 2017-05-27.
 */
public class GameTest {
    Game test = new Game();
    @Test
    public void gamePutTowerTest(){
        test.setGold(25);
        test.putTower(TowerType.Chaos,35,35);
        Assert.assertEquals(25,test.getGold());
        Assert.assertEquals(false,test.getField().getTile(1,1));
        Assert.assertEquals(0,test.getTowers().size());
        test.putTower(TowerType.Normal,35,35);
        Assert.assertEquals(0,test.getGold());
        Assert.assertEquals(true,test.getField().getTile(1,1));
        Assert.assertEquals(1,test.getTowers().size());
        Assert.assertEquals(TowerType.Normal,test.getTowers().get(0).getTowerType());
    }
    @Test
    public void towerShootAndMobDiesTest() {
        Game test = new Game();
        List<Mob> testMobList = new ArrayList<>();
        testMobList.add(new Mob(MobType.BOSS,  (new RoadBuilder(32,32).down(1).build())));
        test.setMobs(testMobList);
        test.mobMoves();
        test.setGold(25);
        test.setScore(0);
        test.putTower(TowerType.Normal,34,34);
        test.getMobs().get(0).setHealth(10);
        test.towerShoot();
        Assert.assertEquals(0,test.getMobs().get(0).getHealth());
        Assert.assertEquals(test.getMobs().get(0),test.getTowers().get(0).getTarget());
        test.mobDies();
        Assert.assertEquals(0,test.getMobs().size());
        Assert.assertEquals(50,test.getGold());
        Assert.assertEquals(50,test.getScore());
    }

    @Test
    public void mobMovesTest() {
        Game test = new Game();
        List<Mob> testMobList = new ArrayList<>();
        testMobList.add(new Mob(MobType.BOSS,  (new RoadBuilder(32,32).down(1).build())));
        test.setMobs(testMobList);
        test.setLife(5);
        Assert.assertEquals(1,test.getMobs().size());
        for(int i=0;i<=40;i++)
            test.mobMoves();
        Assert.assertEquals(0,test.getMobs().size());
        Assert.assertEquals(4,test.getLife());
    }

    @Test
    public void loadWaveTest() {
        Game test = new Game();
        test.loadWave();
        Assert.assertEquals(0,test.getCurrentWave());
        Assert.assertEquals(5,test.getWave().getMobList().size());
        Assert.assertEquals(MobType.MEDIUM,test.getWave().getMobList().get(0));
    }

    @Test
    public void summonMobTest() {
        Game test = new Game();
        test.loadWave();
        Assert.assertEquals(0,test.getMobs().size());
        test.summonMob();
        Assert.assertEquals(1,test.getMobs().size());
    }
    @Test
    public void tickTest() {
        Game test = new Game();
        Wave testWave = new Wave();
        test.getField().setRoad(new RoadBuilder(0,0).down(1).right(1).up(1).left(1).build());
        testWave = (WaveFactory.createWave(0,0,5,0));
        test.tick();
        Assert.assertEquals(1,test.getMobs().size());
        Assert.assertEquals(0,test.getCurrentWave());
        Assert.assertEquals(0,test.getTowers().size());
        Assert.assertEquals(true, testWave.getMobList().equals(test.getWave().getMobList()));
        test.putTower(TowerType.Normal,64,64);
        while (test.getMobs().size()>0) {
            test.tick();
        }
        Assert.assertEquals(test.getLife(),0);
        Assert.assertEquals(false,test.getTowers().get(0).isShooting());

    }

}
