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
        employee1.setSsn("123-45-6789");
        employee1.setDateOfBirth(java.time.LocalDate.of(1990, 1, 1));
        employee1.setType(EmployeeType.FULL_TIME);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Moumita");
        //employee2.setSsn("123-45-6789"); // This will cause a unique constraint violation if the same SSN is used.
        // This is intentional to demonstrate the unique constraint feature of JPA (SQL). It's not JAVA complaining
        employee2.setSsn("123-45-9876");
        employee2.setDateOfBirth(java.time.LocalDate.of(2000, 10, 1));
        employee2.setType(EmployeeType.CONTRACTOR);


        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setName("Subhojit");
        employee3.setSsn("111-22-3333");
        employee3.setDateOfBirth(java.time.LocalDate.of(2003, 1, 15));
        employee3.setType(EmployeeType.FULL_TIME);

        //JPA will complain for Enumerator because it saves an enum type as INTEGER referring to the ordinals of the
        //enum.

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
