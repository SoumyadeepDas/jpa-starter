package edu.jpa.soumyadeep;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PayStub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate payPeriodStart;
    private LocalDate payPeriodEnd;
    private float salary;

    // Many-to-One mapping: Many PayStubs can be linked to one Employee.
    // This means multiple pay stub records can belong to the same employee in the database.
    // The foreign key column (employee_id) will be created in the PayStub table.
    @ManyToOne
    @JoinColumn(name = "paystub_employeeId")
    // This annotation specifies the foreign key column in the PayStub table that references the Employee table.
    // The name attribute specifies the name of the foreign key column in the PayStub table. @JoinColumn is used to
    // define the foreign key column in the PayStub table that references the primary key of the
    // Employee table. This establishes the relationship between the PayStub and Employee entities.
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPayPeriodStart() {
        return payPeriodStart;
    }

    public void setPayPeriodStart(LocalDate payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public LocalDate getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public void setPayPeriodEnd(LocalDate payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PayStub{" +
                "id=" + id +
                ", payPeriodStart=" + payPeriodStart +
                ", payPeriodEnd=" + payPeriodEnd +
                ", salary=" + salary +
                ", employee=" + employee +
                '}';
    }
}
