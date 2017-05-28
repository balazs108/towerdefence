package hu.inf.unideb.prt.bazs.towerdefence.controller;

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

}
