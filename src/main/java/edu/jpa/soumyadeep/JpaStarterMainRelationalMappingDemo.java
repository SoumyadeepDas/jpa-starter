package edu.jpa.soumyadeep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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
        accessCard2.setOwner(employee2);
        accessCard1.setOwner(employee1);


        // Creating PayStub records and associating them with employee1.
        // Since this is a Many-to-One relationship, multiple PayStubs (payStub1, payStub2)
        // can be linked to the same Employee (employee1).
        // This will result in multiple rows in the pay_stub table with the same employee_id as a foreign key.
        //
        // Internally, when you call payStub1.setEmployee(employee1), Hibernate will populate
        // the employee_id column in the pay_stub table with employee1's primary key.
        // This establishes the link between PayStub and Employee in the database.
        // When persisted, Hibernate ensures referential integrity by inserting the appropriate foreign key.
        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(java.time.LocalDate.of(2021, 1, 1));
        payStub1.setPayPeriodEnd(java.time.LocalDate.of(2021, 2, 15));
        payStub1.setSalary(5000.00f);
        payStub1.setEmployee(employee1);
        employee1.addPayStub(payStub1); // This line ensures that the payStub1 is added to the employee1's
        // payStubList, thereby making the data consistent.

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(java.time.LocalDate.of(2022, 1, 3));
        payStub2.setPayPeriodEnd(java.time.LocalDate.of(2022, 2, 20));
        payStub2.setSalary(2000.00f);
        payStub2.setEmployee(employee1);
        employee1.addPayStub(payStub2);


        employee1.setPayStubList(List.of(payStub1, payStub2));
        // Why are we writing this line? Even if we don't write this line, JPA will still persist the PayStubs
        // because we have a reversed relationship
        // in the Employee class with the payStubs with @OneToMany annotation. So even if we don't set the
        // payStubList in the Employee class, JPA will still persist the PayStubs.
        //However, it is a good practice to set the relationship in both directions to maintain consistency and
        // clarity in your code.
        //This is because how JPA is designed. JPA doesn't always persist the object in the database immediately,
        // however it does guanarantee the updated data always. If we don't set the paystubList in the Employee
        // class, we might get up ending with null value in the payStubList field of the Employee class when we fetch
        // the Employee object from the database later on. So it's a good practice to set the payStubList in the
        // Employee class to avoid this issue.


        //Instead of doing this, we can do this in a better way by introducing some utility methods in the Employee
        // class for adding and removing PayStubs. This will help us to maintain the relationship in both directions.


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityManager.persist(accessCard1);
        entityManager.persist(accessCard2);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("Employees and Access Cards saved successfully!");

    }
}
