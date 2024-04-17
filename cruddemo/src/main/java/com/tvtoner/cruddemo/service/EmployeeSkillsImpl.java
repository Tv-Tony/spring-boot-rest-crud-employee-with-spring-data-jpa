package com.tvtoner.cruddemo.service;


import com.tvtoner.cruddemo.dao.EmployeeSkillsRepository;
import com.tvtoner.cruddemo.entity.EmployeeSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeSkillsImpl implements EmployeesSkillsService {

    private final EmployeeSkillsRepository employeeSkillsRepository;

    @Autowired
    public EmployeeSkillsImpl(EmployeeSkillsRepository employeeSkillsRepository) {
        this.employeeSkillsRepository = employeeSkillsRepository;
    }

    @Override
    public List<EmployeeSkills> findAll() {
        return employeeSkillsRepository.findAll();
    }

    @Override
    public EmployeeSkills findById(int theId) {
        Optional<EmployeeSkills> result = employeeSkillsRepository.findById(theId);
        EmployeeSkills employeeSkills = null;
        if (result.isPresent()) {
            employeeSkills = result.get();
        } else {
            throw new RuntimeException("Did not find employee skill id - " + theId);
        }
        return employeeSkills;
    }

    @Override
    public EmployeeSkills save(EmployeeSkills theEmployeeSkills) {
        return employeeSkillsRepository.save(theEmployeeSkills);
    }

    @Override
    public void deleteById(int theId) {
        employeeSkillsRepository.deleteById(theId);
    }

    @Override
    public List<EmployeeSkills> getEmployeeSkills(int employeeId) {
        // Retrieve all employee skills from the repository
        List<EmployeeSkills> allEmployeeSkills = employeeSkillsRepository.findAll();

        // Filter the list to find employee skills with the matching employeeId
        List<EmployeeSkills> matchingSkills = allEmployeeSkills.stream()
                .filter(employeeSkills -> employeeSkills.getEmployee().getiD() == employeeId)
                .collect(Collectors.toList());

        return matchingSkills;
    }
//
//    @Override
//    public void addSkillToEmployee(int employeeId, int skillId) {
//
//    }
//
//    @Override
//    public void updateEmployeeSkills(int employeeId, int skillId) {
//
//    }
//
//    @Override
//    public void removeSkillFromEmployee(int employeeId, int skillId) {
//
//    }
}
