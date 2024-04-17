package com.tvtoner.cruddemo.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name ="employeeskills")
public class EmployeeSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private int id;

    //JoinColumn specifies the foreign key and references the key to the Employees table
    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name ="SkillId")
    private Skill skillId;

    public EmployeeSkills(){

    }

    public EmployeeSkills(int id, Employee employee, Skill skillId) {
        this.id = id;
        this.employee = employee;
        this.skillId = skillId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
    }

    @Override
    public String toString() {
        return "EmployeeSkills{" +
                "id=" + id +
                ", employee=" + employee +
                ", skillId=" + skillId +
                '}';
    }
}
