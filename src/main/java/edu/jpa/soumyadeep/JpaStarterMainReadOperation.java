//package edu.jpa.soumyadeep;
//
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
////Reading with JPA from the database.
//public class JpaStarterMainReadOperation {
//    public static void main(String[] args) {
//        //Simulating the reading of the Employee entity from the database.
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Employee employee1 = entityManager.find(Employee.class, 1); //the first argument is the entity class,
//        // and the second argument is the primary key value of the entity to be read from the database. I wanna get an
//        //employee instance whose primary key value is 1.
//        System.out.println(employee1); //What do JPA do? JPA fetched the employee entity from the database with
//        // primary key value 1
//        // and returned the Employee instance with the same primary key value.
//        //we printed the employee instance to see the values of the fields. Note the toSTring() method in the
//        // Employee class
//        // is overridden to print the values of the fields in a readable format.
//
//        //When we were saving we had to do a transaction.begin() and transaction.commit() to save the entity.
//        //But when we are reading, we don't need to do that. Because reading is a read-only operation, while
//        // saving is a write operation which may create race conditions.
//
//        //Fetching the next employee entity with primary key value 2
//        Employee employee2 = entityManager.find(Employee.class, 2);
//        System.out.println(employee2);
//
//        //Fetching the next employee entity with primary key value 3
//        Employee employee3 = entityManager.find(Employee.class, 3);
//        System.out.println(employee3);
//
//        //suppose we want to fetch an employee entity with primary key value 4, which does not exist in the database.
//        Employee employee4 = entityManager.find(Employee.class, 4);
//        //This will return null, as there is no employee entity with primary key value 4
//        System.out.println(employee4); //This will print null, as there is no employee entity with primary key value 4.
//
//
//    }
//}
