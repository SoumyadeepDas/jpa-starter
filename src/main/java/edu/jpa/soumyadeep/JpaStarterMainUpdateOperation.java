//package edu.jpa.soumyadeep;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class JpaStarterMainUpdateOperation {
//    public static void main(String[] args) {
//        // Simulating the update operation of the Employee entity in the database.
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Employee employee1 = entityManager.find(Employee.class, 1);
//        //before updating the employee entity.
//       // System.out.println(employee1); // This will print the employee instance with primary key value 1.
//        employee1.setType(EmployeeType.CONTRACTOR); // updated from FULL_TIME to CONTRACTOR but we haven't saved it to
//        //the database yet.
//
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(employee1);
//        // persist() is used to save the entity to the database. If the entity already exists in the database, it will
//        // update the entity. If not, it will create a new entity in the database.
//        // In this case, we are updating the employee entity with primary key value 1.
//        // If we don't call persist(), the changes will not be saved to the database.
//        transaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();
//
//        System.out.println(employee1); // This will print the employee instance with primary key value 1 after updating it.
//    }
//}
