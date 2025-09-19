package com.svecw.dept.manager.subject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.model.SubjectDataProvider;

@Repository
@Primary
public class SubjectDAOMockImpl implements ISubjectDAO {

    public List<Subject> findAll() {
        return new ArrayList<>(SubjectDataProvider.getData().values());
    }

}
