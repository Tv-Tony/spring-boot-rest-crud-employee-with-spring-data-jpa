package com.tvtoner.cruddemo.service;

import com.tvtoner.cruddemo.entity.Payroll;
import com.tvtoner.cruddemo.entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> findAll();

    Skill findById(int theId);

    Skill save(Skill theSkill);

    void deleteById(int theId);
}
