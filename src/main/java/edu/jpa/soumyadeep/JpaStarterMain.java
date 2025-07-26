package edu.jpa.soumyadeep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class JpaStarterMain {
    public static void main( String[] args ) {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Soumyadeep");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Moumita");

        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setName("Subhojit");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        transaction.commit();

    }
}
