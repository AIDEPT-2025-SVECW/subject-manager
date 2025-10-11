package com.svecw.dept.manager.subject.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "student_interviews")
public class StudentInterviews {
    @Id
    private String id;
    @NonNull
    private String regId;
    @NonNull
    private String typeOfInterview;
    @NonNull
    private String[] jdSkills;
    @NonNull
    private String[] studentSkills;
    private String finalResult;
    private String studentAcademicGrade;
    private Date dateOfInterview;
    private Date dateOfResult;

}
