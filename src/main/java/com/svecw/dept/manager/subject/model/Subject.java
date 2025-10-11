package com.svecw.dept.manager.subject.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue
    private String subjectId;
    private String code;
    private String name;
    private String description;
    private int totalHours;
    private int credits;
    // private List<String> prerequisites;
    @OneToMany(mappedBy = "subjectId")
    private List<Topic> topics;

}
