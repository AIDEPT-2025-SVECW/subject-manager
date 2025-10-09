package com.svecw.dept.manager.subject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.model.Topic;
import com.svecw.dept.manager.subject.repository.ISubjectDAO;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    ISubjectDAO subjectDAO;

    public List<Subject> getAllSubjects() {
        return subjectDAO.findAll();
    }

    public Subject getSubjectById(String id) {
        return subjectDAO.findById(id);
    }

    public List<Subject> getSubjectStartingWith(String prefix) {
        return subjectDAO.findByIdStartingWithIgnoreCase(prefix);
    }

    public List<Topic> getSubjectTopics(String subjectId) {
        return subjectDAO.findTopicsBySubjectId(subjectId);
    }

    public Topic getSubjectTopic(String subjectId, String topicId) {
        return subjectDAO.findTopicBySubjectIdAndId(subjectId, topicId);

    }

    public Topic addTopicToSubject(String subjectId, Topic topic2Add) {
        return subjectDAO.saveTopic(subjectId, topic2Add) == 1 ? topic2Add : null;
    }

    public String deleteTopicFromSubject(String subjectId, String topicId) {
        String message = "";
        if (subjectDAO.findTopicBySubjectIdAndId(subjectId, topicId) != null) {
            System.out.println("Topic exists");
            subjectDAO.deleteTopicBySubjectIdAndId(subjectId, topicId);
            message = "Topic with id " + topicId + " deleted successfully from subject " + subjectId;
        } else {
            System.out.println("Topic does not exist");
            message = "Topic with id " + topicId + " not found in subject " + subjectId;
        }
        return message;
    }
}
