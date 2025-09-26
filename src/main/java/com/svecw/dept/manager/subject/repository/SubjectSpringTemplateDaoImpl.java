package com.svecw.dept.manager.subject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.model.Topic;

/**
 * DAO Implementation for Subject and Topic operations using JdbcTemplate.
 * Method names follow JPA Repository style naming convention.
 */
@Repository
@Primary
public class SubjectSpringTemplateDaoImpl implements ISubjectDAO {

    @Autowired(required = false)
    private JdbcTemplate template;

    /**
     * Equivalent to JPA: findAll()
     * Get all subjects.
     */
    @Override
    public List<Subject> findAll() {
        String sql = "SELECT * FROM subject.subjects";
        return template.query(sql, new BeanPropertyRowMapper<>(Subject.class));
    }

    /**
     * Equivalent to JPA: findById(String id)
     * Get subject by ID.
     */
    @Override
    public Subject findById(String id) {
        String sql = "SELECT * FROM subject.subjects WHERE id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Subject.class), id);
    }

    /**
     * Equivalent to JPA: findByIdStartingWith(String prefix)
     * Get subjects whose id starts with given prefix (PathVariable version).
     */
    @Override
    public List<Subject> findByIdStartingWith(String prefix) {
        String sql = "SELECT * FROM subject.subjects WHERE id LIKE ?";
        return template.query(sql, new BeanPropertyRowMapper<>(Subject.class), prefix + "%");
    }

    /**
     * Equivalent to JPA: findByIdStartingWithIgnoreCase(String prefix)
     * Another version for RequestParam style search (case-insensitive).
     */
    @Override
    public List<Subject> findByIdStartingWithIgnoreCase(String prefix) {
        String sql = "SELECT * FROM subject.subjects WHERE LOWER(id) LIKE LOWER(?)";
        return template.query(sql, new BeanPropertyRowMapper<>(Subject.class), prefix + "%");
    }

    /**
     * Equivalent to JPA: findTopicsBySubjectId(String subjectId)
     * Get topics for a given subject.
     */
    @Override
    public List<Topic> findTopicsBySubjectId(String subjectId) {
        String sql = "SELECT * FROM subject.topics WHERE subject_id = ?";
        return template.query(sql, new BeanPropertyRowMapper<>(Topic.class), subjectId);
    }

    /**
     * Equivalent to JPA: findTopicBySubjectIdAndId(String subjectId, String
     * topicId)
     * Get a specific topic inside a subject.
     */
    @Override
    public Topic findTopicBySubjectIdAndId(String subjectId, String topicId) {
        String sql = "SELECT * FROM subject.topics WHERE subject_id = ? AND id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Topic.class), subjectId, topicId);
    }

    /**
     * Equivalent to JPA: saveTopic(Topic topic)
     * Add a new topic to a subject.
     */
    @Override
    public int saveTopic(String subjectId, Topic topic) {
        String sql = "INSERT INTO subject.topics (id, description, subject_id) VALUES (?, ?, ?)";
        return template.update(sql, topic.getId(), topic.getDescription(), subjectId);
    }

    /**
     * Equivalent to JPA: deleteTopicBySubjectIdAndId(String subjectId, String
     * topicId)
     * Delete a topic from a subject.
     */
    @Override
    public int deleteTopicBySubjectIdAndId(String subjectId, String topicId) {
        String sql = "DELETE FROM subject.topics WHERE subject_id = ? AND id = ?";
        return template.update(sql, subjectId, topicId);
    }
}
