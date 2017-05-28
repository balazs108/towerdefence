package hu.inf.unideb.prt.bazs.towerdefence.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Balazs on 2017-05-25.
 */
public class EntityManagerProvider {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("aethernal_td_db");
        entityManager=entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
    public static void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
