package edu.jpa.soumyadeep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee1 = entityManager.find(Employee.class, 1);
        System.out.println("******************* Employee 1 ******************");
        System.out.println(employee1.getName());
        System.out.println("******************* Accessed Card ******************");
        System.out.println(employee1.getAccessCard().getId());

        System.out.println();
        System.out.println(employee1);
        entityManager.close();
        entityManagerFactory.close();
    }
}
