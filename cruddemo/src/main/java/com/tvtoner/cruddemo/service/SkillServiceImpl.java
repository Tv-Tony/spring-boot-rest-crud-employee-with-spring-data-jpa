package com.tvtoner.cruddemo.service;

import com.tvtoner.cruddemo.dao.SkillRepository;
import com.tvtoner.cruddemo.entity.Skill;
import com.tvtoner.cruddemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(int theId) {
        Optional<Skill> result = skillRepository.findById(theId);
        Skill skill = null;
        if (result.isPresent()) {
            skill = result.get();
        } else {
            throw new RuntimeException("Did not find skill id - " + theId);
        }
        return skill;
    }

    @Override
    public Skill save(Skill theSkill) {
        return skillRepository.save(theSkill);
    }

    @Override
    public void deleteById(int theId) {
        skillRepository.deleteById(theId);
    }
}