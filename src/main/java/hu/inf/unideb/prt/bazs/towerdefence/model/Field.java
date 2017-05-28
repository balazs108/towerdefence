package hu.inf.unideb.prt.bazs.towerdefence.model;

import hu.inf.unideb.prt.bazs.towerdefence.controller.RoadBuilder;
import hu.inf.unideb.prt.bazs.towerdefence.controller.TileBuilder;

/**
 * Created by Balazs on 2017-04-30.
 */
public class Field {
    private Road road;
    private boolean[][] tiles;

    public Field() {
        road=new RoadBuilder((4*32)-16,-16)
                .down(1)
                .left(3)
                .down(4)
                .right(3)
                .up(2)
                .right(3)
                .down(4)
                .left(6)
                .down(3)
                .right(9)
                .up(9)
                .left(4)
                .up(1)
                .build();
        tiles = new TileBuilder(3,0)
                .left(3)
                .down(4)
                .right(3)
                .up(2)
                .right(3)
                .down(4)
                .left(6)
                .down(3)
                .right(9)
                .up(9)
                .left(4)
                .build();
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public boolean getTile(int x, int y) {
        return tiles[y][x];
    }

    public void setTile(int x, int y, boolean b) {
        this.tiles[y][x] = b;
    }

    public void setTiles(boolean[][] tiles) {
        this.tiles = tiles;
    }

    public boolean[][] getTiles() {
        return tiles;
    }
}
