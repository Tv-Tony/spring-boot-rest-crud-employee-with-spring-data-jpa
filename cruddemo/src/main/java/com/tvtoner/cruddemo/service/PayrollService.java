package com.tvtoner.cruddemo.service;

import com.tvtoner.cruddemo.entity.EmployeeSkills;
import com.tvtoner.cruddemo.entity.Payroll;
import com.tvtoner.cruddemo.entity.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayrollService {

    List<Payroll> findAll();

    Payroll findById(int theId);

    Payroll save(Payroll thePayroll);

    void deleteById(int theId);


}
