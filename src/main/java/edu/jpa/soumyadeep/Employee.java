package edu.jpa.soumyadeep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Employee class representing an entity with id and name.
 */
@Entity
@Table
public class Employee {
    @Id
    private int id;

    @Column(name = "employee_name")
    // This annotation specifies the column name in the database table.
    // If not specified, the default column name will be the same as the field name.
    private String name;

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
