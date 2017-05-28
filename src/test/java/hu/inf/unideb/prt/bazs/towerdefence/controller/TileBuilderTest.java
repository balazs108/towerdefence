package hu.inf.unideb.prt.bazs.towerdefence.controller;

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
