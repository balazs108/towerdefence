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

import hu.inf.unideb.prt.bazs.towerdefence.controller.RoadBuilder;
import hu.inf.unideb.prt.bazs.towerdefence.controller.TileBuilder;

/**
 *A class used in the {@link hu.inf.unideb.prt.bazs.towerdefence.controller.Game}, it contains a {@link Road} and a tile matrix.
 */
public class Field {
    /**
     * A Road variable in which the RoadBuilders product will be stored.
     */
    private Road road;
    /**
     * A tile matrix in which the TileBuilders product will be soterd.
     */
    private boolean[][] tiles;

    /**
     * Constructor method that gives preset values to the road and the tile matrix.
     */
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

    /**
     * Getter method for the road.
     * @return the road.
     */
    public Road getRoad() {
        return road;
    }

    /**
     * Setter method for the road.
     * @param road the new road.
     */
    public void setRoad(Road road) {
        this.road = road;
    }

    /**
     * Getter method for a value in the tile matrix.
     * @param x the second index of the matrix.
     * @param y the first index of the matrix.
     * @return the value with the indexes listed above.
     */
    public boolean getTile(int x, int y) {
        return tiles[y][x];
    }

    /**
     * Setter method for a value in the tile matrix.
     * @param x the second index of the matrix.
     * @param y the first index of the matrix.
     * @param b the new value.
     */
    public void setTile(int x, int y, boolean b) {
        this.tiles[y][x] = b;
    }

    /**
     * Setter method for the tile matrix.
     * @param tiles the new tile matrix.
     */
    public void setTiles(boolean[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Getter method for the tile matrix.
     * @return the tile matrix.
     */
    public boolean[][] getTiles() {
        return tiles;
    }
}
