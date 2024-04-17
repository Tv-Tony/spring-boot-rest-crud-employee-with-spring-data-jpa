package com.tvtoner.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="SkillId")
    private int id;

    @Column(name ="SkillName")
    private String skillName;

    //Constructor

    public Skill(){

    }

    public Skill(int id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    //Getter Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    // toString method

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
