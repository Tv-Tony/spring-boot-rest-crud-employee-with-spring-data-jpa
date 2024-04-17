package com.tvtoner.cruddemo.service;

import com.tvtoner.cruddemo.entity.Employee;
import com.tvtoner.cruddemo.entity.EmployeeSkills;

import java.util.List;

public interface EmployeesSkillsService {
    List<EmployeeSkills> findAll();

    EmployeeSkills findById(int theId);

    EmployeeSkills save(EmployeeSkills theEmployeeSkills);

    void deleteById(int theId);

    List<EmployeeSkills> getEmployeeSkills(int employeeId);

//
//    void addSkillToEmployee(int employeeId, int skillId);
//
//    void updateEmployeeSkills(int employeeId, int skillId);
//
//    void removeSkillFromEmployee(int employeeId, int skillId);
}
