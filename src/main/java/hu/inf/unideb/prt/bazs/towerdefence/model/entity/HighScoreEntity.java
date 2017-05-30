package hu.inf.unideb.prt.bazs.towerdefence.model.entity;

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

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 *  The entity object for the records in the highscore table.
 */
@Entity
public class HighScoreEntity {
    /**
     * The ID of the Highscore.
     */
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "IdGenerator", sequenceName = "hssequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
    private long id;
    /**
     * The name of the player.
     */
    @Column(name = "Player")
    private String player;
    /**
     * The score the player.
     */
    @Column(name = "Score")
    private int score;
    /**
     * The moment when the score was registered.
     */
    @Column(name = "Date")
    private LocalDateTime date;

    /**
     * Empty constructor.
     */
    public HighScoreEntity() {
        super();
    }

    /**
     *Constructor for the entity.
     * @param player the name that will be set.
     * @param score the score that will be set.
     * @param date the date that will be set.
     */
    public HighScoreEntity(String player, int score , LocalDateTime date) {
        super();
        this.player = player;
        this.score = score;
        this.date = date;
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
     * Getter method for the player.
     * @return the player.
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Setter method for the player.
     * @param player the new player.
     */
    public void setPlayer(String player) {
        this.player = player;
    }
    /**
     * Getter method for the date.
     * @return the date.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter method for the date.
     * @param date the new date.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
