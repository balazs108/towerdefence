package hu.inf.unideb.prt.bazs.towerdefence.controller;

import hu.inf.unideb.prt.bazs.towerdefence.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Balazs on 2017-04-30.
 */
public class Game {
    /**
     *The class that defines the path for the mobs and the area which can be used by towers.
     */
    private Field field;
    /**
     * List of mobs that are currently on the filed.
     */
    private List<Mob> mobs;
    /**
     * A list for waves, which are mob lists, of the mobs that are used during the game.
     */
    private List<Wave> waves;
    /**
     * A singe wave object for the current wave.
     */
    private Wave wave;
    /**
     * List of towers that are on the field;
     */
    private List<Tower> towers;
    /**
     * A resource that is required for tower placement.
     */
    private int gold;
    /**
     * The number of mobs that are allowed to reach their destination before the game is over.
     */
    private int life;
    /**
     * The score of the player.
     */
    private int score;
    /**
     * The number of the wave that is used currently.
     */
    private int currentWave;
    /**
     * A delay that defines how fast are the mobs sent into the field.
     */
    private int mobDelay;
    /**
     * A logger object, that helps keeping track of important moments.
     */
    private Logger logger = LoggerFactory.getLogger(Game.class);
    /**
     * Constructor to initialize a game.
     */
    public Game() {
        this.field = new Field();
        this.mobs = new ArrayList<>();
        this.waves = Arrays.asList(
                WaveFactory.createWave(0,0,5,0),
                WaveFactory.createWave(0,0,5,5),
                WaveFactory.createWave(0,0,15,5),
                WaveFactory.createWave(0,10,0,5),
                WaveFactory.createWave(1,5,5,5),

                WaveFactory.createWave(0,10,5,5),
                WaveFactory.createWave(0,5,20,5),
                WaveFactory.createWave(0,0,0,40),
                WaveFactory.createWave(0,3,20,20),
                WaveFactory.createWave(2,10,20,0),

                WaveFactory.createWave(0,10,20,20),
                WaveFactory.createWave(0,0,0,60),
                WaveFactory.createWave(0,10,40,0),
                WaveFactory.createWave(0,15,25,0),
                WaveFactory.createWave(3,10,20,20)

                );
        this.currentWave = -1;
        this.gold = 75;
        this.life = 5;
        this.score = 0;
        this.mobDelay = 0;
        this.towers = new ArrayList<>();
    }

    /**
     * This method sets the targets for the towers based on the mobs distance from the tower, the first mob from the mobslist that is in
     * the towers range, and calls the towers shoot method that decreases the mobs health by the towers damage value.
     */
    public void towerShoot() {
        towers.forEach(t-> {
            t.setTarget(mobs.stream()
                    .filter(m -> Math.sqrt(Math.pow(m.getX()-t.getX(),2)+Math.pow(m.getY()-t.getY(),2)) < t.getTowerType().getRange())
                    .findFirst().orElse(null)
            );
            t.shoot();
        });
    }

    /**
     * This method loads in the current wave in the games wave variable (which is a list of mobs).
     */
    public void loadWave() {
        if (mobs.isEmpty()) {
            currentWave++;
            if(currentWave<15) {
                wave = waves.get(currentWave);
                mobDelay = 0;
                logger.info("A new wave has been loaded in.");
            }
        }
    }

    /**
     * The method summons each mob from the moblist with a delay so they don't get stacked together.
     */
    public void summonMob() {
        if (mobDelay % 2 == 0 && wave.getMobList().size() > wave.getCurrentMob()) {
            mobs.add(new Mob(wave.getMobList().get(wave.getCurrentMob()), field.getRoad()));
            wave.incCurrentMob();
            logger.info("A mob was summoned.");
        }
        mobDelay++;
    }

    /**
     * This method looks for "dead" mobs in the wave moblist, and if it finds one with 0 or less health than removes it
     * from the moblist, and increases the games gold and score variable with the mobs loot value.
     */
    public void mobDies() {
        mobs.forEach(m -> {
            if (m.getHealth() <= 0) {
                this.gold += m.getMobType().getLoot();
                this.score += m.getMobType().getLoot();
                logger.info("A mob died.");
            }
        });
        mobs = mobs.stream().filter(m -> m.getHealth() > 0).collect(Collectors.toList());
    }

    /**
     * This method calls the mobs move method for each mob on the field, if a mob reaches the end of the road it is removed
     * from the moblist and decreases the games life variables value by one.
     */
    public void mobMoves() {
        mobs.forEach(m -> {
            m.move();
            if (m.isReachGoal()) {
                this.life--;
                logger.info("A mob has reached the end of the road.");
            }
        });
        mobs = mobs.stream().filter(m -> !m.isReachGoal()).collect(Collectors.toList());
    }

    /**
     * Acts like a 'listener' or 'handler' to small time intervals. It 'ticks'
     * every 50 milliseconds by default (depending on the view). This method is
     * calls the methods listed above.
     */
    public void tick() {
        towerShoot();
        loadWave();
        summonMob();
        mobDies();
        mobMoves();
    }

    /**
     * This method places a tower on the field if a few conditions are met.
     * @param type is the type of the tower
     * @param x this is the x coordinate of the towers center
     * @param y this is the y coordinate of the towers center
     * First checks if there is enough gold to "buy" the tower and if the selected tile is open for building, if so
     * the required amount of gold is removed, a new tower object is added to the Towers list, and closes the tile so
     * no other towers can be built on the same area.
     */
    public void putTower(TowerType type, int x, int y) {
        if (this.getGold() -type.getCost() >= 0 && !this.field.getTile(x/32,y/32)) {
            this.getTowers().add(new Tower(type, x/32*32+16, y/32*32+16 ));
            this.updateGold(-type.getCost());
            this.field.setTile(x/32,y/32,true);
        }
    }


    /**
     * Getter method for the field.
     * @return the field.
     */
    public Field getField() {
        return field;
    }

    /**
     * Getter method for the mobList.
     * @return the mobList.
     */
    public List<Mob> getMobs() {
        return mobs;
    }

    /**
     * Setter method for the mobList.
     * @param mobs mobList.
     */
    public void setMobs(List<Mob> mobs) {
        this.mobs = mobs;
    }

    /**
     * Getter method for the gold.
     * @return the gold.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Update method for the gold.
     * @param gold the value which the gold will be increased.
     */
    public void updateGold(int gold) {
        this.gold += gold;
    }

    /**
     * Getter method for the life.
     * @return the life.
     */
    public int getLife() {
        return life;
    }

    /**
     * Setter method for the life.
     * @param life the new life.
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Getter method for the score.
     * @return the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter method for the score.
     * @param score the new score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter method for the currentWave.
     * @return the currentWave.
     */
    public int getCurrentWave() {
        return currentWave;
    }

    /**
     * Getter method for the towerList.
     * @return the towerList.
     */
    public List<Tower> getTowers() {
        return towers;
    }

    /**
     * Setter method for the gold.
     * @param gold the new gold.
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Getter method for the wave.
     * @return the wave.
     */
    public Wave getWave() {
        return wave;
    }
}
