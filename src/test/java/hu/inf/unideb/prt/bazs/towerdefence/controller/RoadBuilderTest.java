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
