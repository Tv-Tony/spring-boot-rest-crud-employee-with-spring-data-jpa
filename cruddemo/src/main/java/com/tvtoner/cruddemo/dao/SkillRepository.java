package com.tvtoner.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tvtoner.cruddemo.entity.Skill;
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
