package hu.inf.unideb.prt.bazs.towerdefence.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Balazs on 2017-05-21.
 * This class is similar to the RoadBuilder class, it initializes a 10X10 grid that covers the field.
 * This grid shows which tiles are available for the towers, the builder class is needed so the path of the
 * road can be followed easily thus making it off limits for the towers its easy
 */
public class TileBuilder {
    private Logger logger = LoggerFactory.getLogger(TileBuilder.class);
    /**
     * A matrix made out of booleans that shows which tiles are available for the towers
     */
    private boolean[][] tiles;
    /**
     * The current x coordinate of the builder
     */
    private int x;
    /**
     * The current y coordinate of the builder
     */
    private int y;

    /**
     * The constructor that begins teh initialization process
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

    public boolean[][] build() {
        logger.info("The tile matrix is built.");
        return this.tiles;
    }

}
