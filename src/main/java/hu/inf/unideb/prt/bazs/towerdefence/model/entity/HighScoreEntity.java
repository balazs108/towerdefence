package hu.inf.unideb.prt.bazs.towerdefence.model.entity;

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

}
