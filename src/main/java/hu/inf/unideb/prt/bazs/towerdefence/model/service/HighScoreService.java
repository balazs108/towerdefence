package hu.inf.unideb.prt.bazs.towerdefence.model.service;

import hu.inf.unideb.prt.bazs.towerdefence.model.entity.HighScoreEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *   It contains basic methods for a standard database service.
 */
public class HighScoreService {

    /**
     * Entity manager for the entity.
     */
    EntityManager entityManager;

    /**
     * Constructor method.
     * @param entityManager the entitymanager that will be set.
     */
    public HighScoreService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Add method, that persists an entity.
     * @param highscore the entity that will be persisted.
     */
    public void add(HighScoreEntity highscore) {
        entityManager.persist(highscore);
    }

    /**
     * Returns every highscore entity in the database.
     * @return the list of entities in the database.
     */
    public List<HighScoreEntity> getAll() {
        TypedQuery<HighScoreEntity> query = entityManager.createQuery("SELECT h FROM hu.inf.unideb.prt.bazs.towerdefence.model.entity.HighScoreEntity h order by  h.score desc", HighScoreEntity.class);
        return query.getResultList();
    }


}
