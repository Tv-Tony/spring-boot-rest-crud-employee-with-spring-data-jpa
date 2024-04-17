package com.tvtoner.cruddemo.rest;

import com.tvtoner.cruddemo.entity.Employee;
import com.tvtoner.cruddemo.entity.EmployeeSkills;
import com.tvtoner.cruddemo.service.EmployeeService;
import com.tvtoner.cruddemo.service.EmployeesSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeSkillsRestController {

    private EmployeesSkillsService employeesSkillsService;

    @Autowired
    public EmployeeSkillsRestController(EmployeesSkillsService employeesSkillsService) {
        this.employeesSkillsService = employeesSkillsService;
    }

    @GetMapping("/employeeskills")
    public List<EmployeeSkills> listAll() {
        return employeesSkillsService.findAll();
    }

    @GetMapping("/employeeskills/{employeeId}")
    public List<EmployeeSkills> listById(@PathVariable int employeeId) {
        return employeesSkillsService.getEmployeeSkills(employeeId);
    }

    @PostMapping("/employeesskills")
    public EmployeeSkills newEmployee(@RequestBody EmployeeSkills theEmployeeSkills) {
        theEmployeeSkills.setId(0);

        EmployeeSkills dbEmployeeSkills = employeesSkillsService.save(theEmployeeSkills);

        return dbEmployeeSkills;

    }

    @PutMapping("/employeeskills")
    public EmployeeSkills updateEmployeeSkills(@RequestBody EmployeeSkills theEmployeeSkills) {

        EmployeeSkills dbEmployeeSkills = employeesSkillsService.save(theEmployeeSkills);

        return dbEmployeeSkills;

    }

    @DeleteMapping("employeeskills/{employeeSkillsId}")
    public String deleteEmployeeSkillsById(@PathVariable int employeeSkillsId) {

        EmployeeSkills tempEmployeeSkills = employeesSkillsService.findById(employeeSkillsId);

        if (tempEmployeeSkills == null) {
            throw new RuntimeException("Employee skills Id not found - " + employeeSkillsId);
        }

        employeesSkillsService.deleteById(employeeSkillsId);

        return "Deleted employee id - " + employeeSkillsId;
    }
}

