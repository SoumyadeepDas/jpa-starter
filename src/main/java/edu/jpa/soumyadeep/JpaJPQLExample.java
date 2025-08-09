package edu.jpa.soumyadeep;

import jakarta.persistence.*;

import java.util.List;

public class JpaJPQLExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Query selectEFromEmployeeE = entityManager.createQuery("select e from Employee e");
        // This JPQL query selects all Employee entities from the database.
        // The "e" is an alias for the Employee entity, and it allows us to
        // refer to the Employee entity in the query.

        //TypedQuery<Employee> selectEFromEmployeeE = entityManager.createQuery("select e from Employee e", Employee.class);
        // The TypedQuery is a type-safe query that returns a list of Employee entities.

        //TypedQuery<Employee> selectEFromEmployeeE = entityManager.createQuery("select e from Employee e where e.type = 'FULL_TIME' ", Employee.class);

        // This JPQL query selects all Employee entities from the database where the type is 'FULL_TIME'.

        //TypedQuery<Employee> selectEFromEmployeeE = entityManager.createQuery("select e from Employee e where e.name like 'John%' ", Employee.class);
        // This JPQL query selects all Employee entities from the database where the name starts with 'John'. The % signifies a wildcard match in JPQL, similar to SQL.
        // Note: In JPQL, you cannot use the '%' wildcard directly in the query string like in SQL.
        // Instead, you would typically use the LIKE operator in a WHERE clause to achieve this,

        //TypedQuery<Employee> selectEFromEmployeeE = entityManager.createQuery("select e from Employee e where e.accessCard.isActive = true  ", Employee.class);
        // This JPQL query selects all Employee entities from the database where the associated AccessCard is active (isActive = true).
        //This demonstrates the join operation of SQL where the Employee entity is joined with the AccessCard entity based on the relationship defined in the entity classes.
        //In JPQL, it's much more refined and easier to read compared to raw SQL queries as Java already knows the relationships between entities.

        //TypedQuery<String> selectEFromEmployeeE = entityManager.createQuery("select e.name from Employee e", String.class);
        //This JPQL query selects the names of all Employee entities from the database. Since the return type is String, we specify String.class as the second argument to createQuery.
        //The List type will also change to List<String> when we execute this query.

        //TypedQuery<Integer> selectEFromEmployeeE = entityManager.createQuery("select e.id from Employee e", Integer.class);

        //TypedQuery<Object[]> selectEFromEmployeeE = entityManager.createQuery("select e.id, e.name from Employee e", Object[].class);


        //Avoiding SQL Injection
//        String minID = "1";
//        TypedQuery<Employee> selectEFromEmployeeE = entityManager.createQuery("select e from Employee e where e.id> :minID", Employee.class);
//        selectEFromEmployeeE.setParameter("minID", minID);
       // List<Object[]> resultList = selectEFromEmployeeE.getResultList();


        // This will print the list of all Employee entities fetched from the database.
       // resultList.forEach(System.out::println);

//        resultList.forEach(row -> {
//            // Each row is an Object array containing the id and name of the employee.
//            System.out.println("ID: " + row[0] + ", Name: " + row[1]);
//        });

        //Demonstrating NamedQuery
        TypedQuery<Employee> selectEFromEmployeeE = entityManager.createNamedQuery("Employee.findAllInAsc", Employee.class);

        List<Employee> resultList = selectEFromEmployeeE.getResultList();
        System.out.println("Printing employees in ascending order:");
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }
}
