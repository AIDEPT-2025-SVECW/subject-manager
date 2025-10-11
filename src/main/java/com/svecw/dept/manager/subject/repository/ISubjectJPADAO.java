package com.svecw.dept.manager.subject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svecw.dept.manager.subject.model.Subject;

@Repository
public interface ISubjectJPADAO extends JpaRepository<Subject, String> {

    /**
     * Find all subjects.
     */
    // select & from subject
    List<Subject> findAll();

    /**
     * Find a subject by its id.
     */
    // select * from subject where subjectId=?
    Optional<Subject> findById(String id);

    // select * from Subject where lower(subjectId) like lower(? || '%')
    List<Subject> findBySubjectIdStartingWithIgnoreCase(String prefix);

}
