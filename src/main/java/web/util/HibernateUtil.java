package web.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        HibernateUtil.entityManagerFactory = entityManagerFactory;

    }
    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
