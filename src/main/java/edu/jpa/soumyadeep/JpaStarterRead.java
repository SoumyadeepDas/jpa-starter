package edu.jpa.soumyadeep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee1 = entityManager.find(Employee.class, 1);
        Employee employee2 = entityManager.find(Employee.class, 2);

        System.out.println(employee1.getPayStubList());

        //One to one is eager by default.
        //One to many is lazy by default. JPA will not fetch the related entities from the many side until we access
        //them.

//        PayStub payStub1 = entityManager.find(PayStub.class, 1);
//        PayStub payStub2 = entityManager.find(PayStub.class, 2);
        //This is working because payStub is the relation owner and it has the foreign key column in the database.
        //So, when we call entityManager.find(PayStub.class, 1), JPA will fetch the PayStub entity with primary key
        // value 1
        // and also fetch the Employee entity associated with it using the foreign key employee_id.
        //This is because the PayStub entity has a Many-to-One relationship with the Employee entity,
        // and JPA will automatically join the PayStub and Employee tables based on the foreign key relationship.
//        System.out.println(payStub1.getEmployee());
//        System.out.println();
//        System.out.println(payStub2.getEmployee());
//        System.out.println("******************* Employee 1 ******************");
//        System.out.println(employee1.getName());
//        System.out.println("******************* Accessed Card ******************");
//        System.out.println(employee1.getAccessCard().getId());
//
//        System.out.println();
//        System.out.println(employee1);
//        entityManager.close();
//        entityManagerFactory.close();

//        AccessCard accessCard1 = entityManager.find(AccessCard.class, 1);
//        System.out.println(accessCard1.getOwner());


        //The problem with this code is AccessCard is mapped to Employee with a one-to-one relationship, and Employee
        // is mapped to AccessCard with a one-to-one relationship. Now, it's creating a cyclic dependency.
        //So JPA call join two times to fetch the data from the database.


    }
}
