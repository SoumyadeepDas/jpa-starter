package edu.jpa.soumyadeep;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class JpaStarterMainDeleteOperation {
//    public static void main(String[] args) {
//        //Simulating the delete operation of the Employee entity in the database.
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Employee employee1 = entityManager.find(Employee.class, 1);
//
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        //We have to begin a transaction before deleting the entity from the database.
//        entityManager.remove(employee1);  //Deleting the employee entity with primary key value 1 from the database.
//        transaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();
//
//
//    }
//}
