package hu.inf.unideb.prt.bazs.towerdefence.model.service;

import hu.inf.unideb.prt.bazs.towerdefence.model.entity.HighScoreEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Balazs on 2017-05-21.
 */
public class HighScoreService {


    EntityManager entityManager;

    public HighScoreService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(HighScoreEntity highscore) {
        entityManager.persist(highscore);
    }


    public List<HighScoreEntity> getAll() {
        TypedQuery<HighScoreEntity> query = entityManager.createQuery("SELECT h FROM hu.inf.unideb.prt.bazs.towerdefence.model.entity.HighScoreEntity h order by  h.score desc", HighScoreEntity.class);
        return query.getResultList();
    }


}
