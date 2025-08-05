package edu.jpa.soumyadeep;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EmailGroup {
    //An email group can contain many employees, and an employee can belong to many email groups.
    //This is a many-to-many relationship.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String groupName;

    //List of employees in this email group.
    //This is a many-to-many relationship, so we will use a List to store the
    //employees in this email group.
    @ManyToMany(mappedBy = "emailGroups")
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "EmailGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
