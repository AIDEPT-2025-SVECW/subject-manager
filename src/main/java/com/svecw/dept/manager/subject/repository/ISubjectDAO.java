package com.svecw.dept.manager.subject.repository;

import java.util.List;

import com.svecw.dept.manager.subject.model.Subject;

public interface ISubjectDAO {

    public List<Subject> findAll();

    public Subject findById(String id);

}
