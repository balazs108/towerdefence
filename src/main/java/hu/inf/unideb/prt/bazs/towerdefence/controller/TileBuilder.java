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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is similar to the {@link RoadBuilder} class, it initializes a 10X10 grid that covers the field.
 * This grid shows which tiles are available for the towers, the builder class is needed so the path of the
 * road can be followed easily thus making it off limits for the towers its easy.
 */
public class TileBuilder {
    /**
     * A matrix made out of booleans that shows which tiles are available for the towers.
     */
    private boolean[][] tiles;
    /**
     * The current x coordinate of the builder.
     */
    private int x;
    /**
     * The current y coordinate of the builder.
     */
    private int y;

    /**
     * The constructor that begins teh initialization process.
     * @param startX the x coordinate of the first tile
     * @param startY the y coordinate of the first tile
     * It sets the current value of the matrix to true which means the tile is not available for towers
     */
    public TileBuilder(int startX, int startY) {
        this.tiles = new boolean[10][10];
        this.x=startX;
        this.y=startY;
        tiles[y][x]= true;
    }

    /**
     * This method changes the values of tiles that are "higher" the current one.
     * @param unit the number of tiles that will be changed. (32x32 pixels is a tile)
     * @return returns a tilebuilder so the methods can be linked up, making the initializing process easy and simple.
     */
    public TileBuilder up(int unit) {
        for(int i=0;i<unit;i++) {
            this.y--;
            this.tiles[y][x]=true;
        }
        return this;
    }

    /**
     * This method changes the values of tiles that are "lower" the current one.
     * @param unit the number of tiles that will be changed. (32x32 pixels is a tile)
     * @return returns a tilebuilder so the methods can be linked up, making the initializing process easy and simple.
     */
    public TileBuilder down(int unit) {
        for(int i=0;i<unit;i++) {
            this.y++;
            this.tiles[y][x]=true;
        }
        return this;
    }
    /**
     * This method changes the values of tiles that are "to the left" the current one.
     * @param unit the number of tiles that will be changed. (32x32 pixels is a tile)
     * @return returns a tilebuilder so the methods can be linked up, making the initializing process easy and simple.
     */
    public TileBuilder left(int unit) {
        for(int i=0;i<unit;i++) {
            this.x--;
            this.tiles[y][x]=true;
        }
        return this;
    }
    /**
     * This method changes the values of tiles that are "to the right" the current one.
     * @param unit the number of tiles that will be changed. (32x32 pixels is a tile)
     * @return returns a tilebuilder so the methods can be linked up, making the initializing process easy and simple.
     */
    public TileBuilder right(int unit) {
        for(int i=0;i<unit;i++) {
            this.x++;
            this.tiles[y][x]=true;
        }
        return this;
    }

    /**
     * Builder method that converts the tilebuilder into a tile.
     * @return the tile.
     */
    public boolean[][] build() {
        Logger logger = LoggerFactory.getLogger(TileBuilder.class);
        logger.info("The tile matrix is built.");
        return this.tiles;
    }

}
