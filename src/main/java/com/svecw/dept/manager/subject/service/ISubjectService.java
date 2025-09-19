package com.svecw.dept.manager.subject.service;

import java.util.List;

import com.svecw.dept.manager.subject.model.Subject;

public interface ISubjectService {

    public List<Subject> getAllSubjects();

    public Subject getSubjectById(String id);

}
