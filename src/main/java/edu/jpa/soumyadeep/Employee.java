package edu.jpa.soumyadeep;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.Fetch;

import java.time.LocalDate;
import java.util.List;

/**
 * Employee class representing an entity with id and name.
 */
@Entity
@Table
public class Employee {
    @Id   //Instead of @ID, to set the primary key of the entity by ourself, we can use @GeneratedValue annotation.
    @GeneratedValue
    //This will generate the primary key value automatically as an auto-incremented value in the database.
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    //FetchType.LAZY means that the access card will not be loaded from the database until it is accessed. It will
    // only be loaded when we call the getAccessCard() method.
    private AccessCard accessCard;


//    @OneToOne(fetch = FetchType.EAGER)
//    //FetchType.EAGER means that the access card will be loaded from the database when the employee is loaded. We
//    // don't need to call the getAccessCard() method to load the access card from the database.
//    private AccessCard accessCard;


    //the PayStub is the relation owner, so it has the foreign key column in the database.
    //So, we can fetch the Employee entity from the PayStub entity using the foreign key
    //column employee_id in the PayStub table.
    @OneToMany(mappedBy = "employee")
    private List<PayStub> payStubList;

    public List<PayStub> getPayStubList() {
        return payStubList;
    }

    public void setPayStubList(List<PayStub> payStubList) {
        this.payStubList = payStubList;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }


    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }

    //by default, JPA will save this. So mark it as transient if you don't want to save it in the database.
    @Transient
    private String debugInfo; //just for debugging purposes, not persisted in the database.

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "employee_name", length = 100)
    // This annotation specifies the column name in the database table.
    // If not specified, the default column name will be the same as the field name.
    private String name;

    @Column(name = "employee_ssn", unique = true, length = 20)
    private String ssn;

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private LocalDate dateOfBirth;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", accessCard=" + accessCard +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
