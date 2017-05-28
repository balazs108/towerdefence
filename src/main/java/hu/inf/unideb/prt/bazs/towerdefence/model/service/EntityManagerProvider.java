package hu.inf.unideb.prt.bazs.towerdefence.model.service;

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
