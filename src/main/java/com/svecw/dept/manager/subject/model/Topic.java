package com.svecw.dept.manager.subject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private String id;
    private String name;
    private String description;
    private int theoryHours;
    private List<String> referenceMaterials;

}
