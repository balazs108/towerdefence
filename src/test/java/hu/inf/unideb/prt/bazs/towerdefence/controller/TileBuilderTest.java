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

import hu.inf.unideb.prt.bazs.towerdefence.model.Field;
import org.junit.Assert;
import org.junit.Test;

public class TileBuilderTest {

    @Test
    public void tileBuilderTest() {
        Field field = new Field();
        Boolean[][] testMatrix = new Boolean[10][10];
        for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                testMatrix[i][j]=false;
            }
        }
        testMatrix[1][1]=true;
        testMatrix[2][1]=true;
        field.setTiles(new TileBuilder(1,1).down(1).build());
        Assert.assertArrayEquals(testMatrix,field.getTiles());
        field.setTiles(new TileBuilder(1,1).down(2).right(3).up(1).left(2).build());
        testMatrix[3][1]=true;
        testMatrix[3][2]=true;
        testMatrix[3][3]=true;
        testMatrix[3][4]=true;
        testMatrix[2][4]=true;
        testMatrix[2][3]=true;
        testMatrix[2][2]=true;
        Assert.assertArrayEquals(testMatrix,field.getTiles());

    }

}
