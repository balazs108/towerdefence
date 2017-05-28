package hu.inf.unideb.prt.bazs.towerdefence.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created by Balazs on 2017-05-21.
 */
@Entity
public class HighScoreEntity {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "IdGenerator", sequenceName = "hssequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
    private long id;
    @Column(name = "Player")
    private String player;
    @Column(name = "Score")
    private int score;
    @Column(name = "Date")
    private LocalDateTime date;

    /**
     *
     */
    public HighScoreEntity() {
        super();
    }

    /**
     *
     * @param player
     * @param score
     * @param date
     */
    public HighScoreEntity(String player, int score , LocalDateTime date) {
        super();
        this.player = player;
        this.score = score;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HighScoreEntity{" +
                "player='" + player + '\'' +
                ", score=" + score +
                ", date=" + date +
                '}';
    }
}
