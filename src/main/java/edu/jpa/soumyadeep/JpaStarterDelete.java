package edu.jpa.soumyadeep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterDelete {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();



        Employee employee = entityManager.find(Employee.class, 1);
        if (employee.getAccessCard() != null) {
            employee.getAccessCard().setOwner(null);
            employee.setAccessCard(null);
        }


        entityManager.remove(employee);


        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
