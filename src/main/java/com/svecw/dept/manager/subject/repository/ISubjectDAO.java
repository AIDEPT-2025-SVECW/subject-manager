package com.svecw.dept.manager.subject.repository;

import java.util.List;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.model.Topic;

/**
 * DAO Interface for Subject and Topic operations.
 * Method names follow Spring Data JPA repository naming conventions.
 */
public interface ISubjectDAO {

    /**
     * Find all subjects.
     */
    List<Subject> findAll();

    /**
     * Find a subject by its id.
     */
    Subject findById(String id);

    /**
     * Find subjects whose id starts with the given prefix.
     * Case-sensitive version.
     */
    default List<Subject> findByIdStartingWith(String prefix) {
        return null;
    }

    /**
     * Find subjects whose id starts with the given prefix.
     * Case-insensitive version (useful for RequestParam searches).
     */
    default List<Subject> findByIdStartingWithIgnoreCase(String prefix) {
        return null;
    }

    /**
     * Find topics belonging to a subject by subject id.
     */
    default List<Topic> findTopicsBySubjectId(String subjectId) {
        return null;
    }

    /**
     * Find a topic by subject id and topic id.
     */
    default Topic findTopicBySubjectIdAndId(String subjectId, String topicId) {
        return null;
    }

    /**
     * Save a new topic under a subject.
     * Returns number of rows inserted (1 if success).
     */
    default int saveTopic(String subjectId, Topic topic) {
        return 0;
    }

    /**
     * Delete a topic by subject id and topic id.
     * Returns number of rows deleted (1 if success).
     */
    default int deleteTopicBySubjectIdAndId(String subjectId, String topicId) {
        return 0;
    }
}
