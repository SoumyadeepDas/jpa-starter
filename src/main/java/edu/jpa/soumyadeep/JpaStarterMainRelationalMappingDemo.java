package edu.jpa.soumyadeep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterMainRelationalMappingDemo {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setType(EmployeeType.FULL_TIME);
        employee1.setSsn("123-45-6789");
        employee1.setDateOfBirth(java.time.LocalDate.of(1990, 1, 1));

        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setType(EmployeeType.CONTRACTOR);
        employee2.setSsn("987-65-4321");
        employee2.setDateOfBirth(java.time.LocalDate.of(1995, 5, 15));

        AccessCard accessCard1 = new AccessCard();
        accessCard1.setIssuedDate(java.time.LocalDate.of(2002, 11, 10));
        accessCard1.setActive(true);
        accessCard1.setFirmwareVersion("1.0.0");

        AccessCard accessCard2 = new AccessCard();
        accessCard2.setIssuedDate(java.time.LocalDate.of(2003, 12, 20));
        accessCard2.setActive(false);
        accessCard2.setFirmwareVersion("1.2.0");

        employee1.setAccessCard(accessCard1);
        employee2.setAccessCard(accessCard2);



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(accessCard1);
        entityManager.persist(accessCard2);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("Employees and Access Cards saved successfully!");

    }
}
