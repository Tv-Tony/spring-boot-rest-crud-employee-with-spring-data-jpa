package com.tvtoner.cruddemo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="payroll")
public class Payroll {

    //Define attributes for database tables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="PayrollId")
    private int payrollId;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee;

    @Column(name ="Salary")
    private BigDecimal salary;

    @Column(name ="PaymentDate")
    private Date paymentDate;

    //Constructors

    public Payroll(){

    }

    public Payroll(int payrollId, Employee employee, BigDecimal salary, Date paymentDate) {
        this.payrollId = payrollId;
        this.employee = employee;
        this.salary = salary;
        this.paymentDate = paymentDate;
    }


    //Setters and getters

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }


    //toString method

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollId=" + payrollId +
                ", employee=" + employee +
                ", salary=" + salary +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
