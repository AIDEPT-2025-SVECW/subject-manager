package com.svecw.dept.manager.subject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.repository.ISubjectDAO;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    ISubjectDAO subjectDAO;

    public List<Subject> getAllSubjects() {
        return subjectDAO.findAll();
    }

}
