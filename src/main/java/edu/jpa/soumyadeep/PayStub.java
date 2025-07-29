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
