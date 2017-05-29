//CHECKSTYLE:OFF
package hu.inf.unideb.prt.bazs.towerdefence.controller;

import hu.inf.unideb.prt.bazs.towerdefence.model.Coord;
import hu.inf.unideb.prt.bazs.towerdefence.model.Field;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class RoadBuilderTest {

    @Test
    public void tileBuilderTest() {
        Field field = new Field();
        Coord test1 = new Coord(0,32);
        Coord test2 = new Coord(64,32);
        Coord test3 = new Coord(-96,0);
        Coord test4 = new Coord(0,-128);
        field.setRoad(new RoadBuilder(0,0).down(1).build());
        Assert.assertEquals(test1.getX(),field.getRoad().getLast().getX());
        Assert.assertEquals(test1.getY(),field.getRoad().getLast().getY());
        field.setRoad(new RoadBuilder(0,0).down(1).right(2).build());
        Assert.assertEquals(test2.getX(),field.getRoad().getLast().getX());
        Assert.assertEquals(test2.getY(),field.getRoad().getLast().getY());
        field.setRoad(new RoadBuilder(0,0).left(3).build());
        Assert.assertEquals(test3.getX(),field.getRoad().getLast().getX());
        Assert.assertEquals(test3.getY(),field.getRoad().getLast().getY());
        field.setRoad(new RoadBuilder(0,0).up(4).build());
        Assert.assertEquals(test4.getX(),field.getRoad().getLast().getX());
        Assert.assertEquals(test4.getY(),field.getRoad().getLast().getY());

    }
}
