package com.svecw.dept.manager.subject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private String id;
    private String code;
    private String name;
    private String description;
    private int totalHours;
    private int credits;
    private List<String> prerequisites;
    private List<Topic> topics;

}
