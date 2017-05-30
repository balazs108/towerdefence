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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity manager class.
 */
public class EntityManagerProvider {
    /**
     * Entity manager factory.
     */
    private static EntityManagerFactory entityManagerFactory;
    /**
     * Entity manager.
     */
    private static EntityManager entityManager;

    /**
     * Static method for initializing the entityManager.
     */
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("aethernal_td_db");
        entityManager=entityManagerFactory.createEntityManager();
    }

    /**
     * Getter method for the entityManager.
     * @return the entityManager.
     */
    public static EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Static method that closes the connection with the database.
     */
    public static void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
