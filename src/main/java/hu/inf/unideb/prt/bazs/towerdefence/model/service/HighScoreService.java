package hu.inf.unideb.prt.bazs.towerdefence.model.service;

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
