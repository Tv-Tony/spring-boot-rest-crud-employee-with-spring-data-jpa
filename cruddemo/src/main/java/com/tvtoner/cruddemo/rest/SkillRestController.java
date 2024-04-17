package com.tvtoner.cruddemo.rest;

import com.tvtoner.cruddemo.entity.Employee;
import com.tvtoner.cruddemo.entity.Skill;
import com.tvtoner.cruddemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillRestController {

    private SkillService skillService;

    @Autowired
    public SkillRestController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public List<Skill> getAllSkills(){
        return skillService.findAll();
    }

    @GetMapping("/skills/{skillId}")
    public Skill getAllSkills(@PathVariable int skillId){
        return skillService.findById(skillId);
    }

    @PostMapping("/skills")
    public Skill addNewSkill(@RequestBody Skill theSkill){
        theSkill.setId(0);

        Skill dbSkill = skillService.save(theSkill);

        return dbSkill;
    }

    @PutMapping("/skills")
    public Skill updateSkill(@RequestBody Skill theSkill){

        Skill dbSkill = skillService.save(theSkill);

        return  dbSkill;
    }

    @DeleteMapping
    public String deleteSkill(int skillId){
        Skill tempSkill = skillService.findById(skillId);

        if (tempSkill == null){
            throw new RuntimeException(("Skill Id not found - " +skillId));
        }
        else {
            skillService.deleteById(skillId);
        }
        return "Deleted employee id - " +skillId;
    }

}
