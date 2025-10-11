package com.svecw.dept.manager.subject.model;

import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue
    private String topicId;
    private String name;
    private String description;
    private int theoryHours;
    private String subjectId;
    // @ManyToOne
    // @JoinColumn(name = "subject_id")
    // @Lazy
    // private Subject subject;
    // private List<String> referenceMaterials;

}
