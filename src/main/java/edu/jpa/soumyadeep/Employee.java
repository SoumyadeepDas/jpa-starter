package edu.jpa.soumyadeep;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Employee class representing an entity with id and name.
 */
@Entity
@Table
public class Employee {
    @Id
    private int id;


    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "employee_name",length = 100)
    // This annotation specifies the column name in the database table.
    // If not specified, the default column name will be the same as the field name.
    private String name;

    @Column(name = "employee_ssn",unique = true,length = 20)
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
}
