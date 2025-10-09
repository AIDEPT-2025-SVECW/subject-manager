package com.svecw.dept.manager.subject.service;

import java.util.List;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.model.Topic;

public interface ISubjectService {

    public List<Subject> getAllSubjects();

    public Subject getSubjectById(String id);

    public List<Subject> getSubjectStartingWith(String prefix);

    public List<Topic> getSubjectTopics(String subjectId);

    public Topic getSubjectTopic(String subjectId, String topicId);

    public Topic addTopicToSubject(String subjectId, Topic topic2Add);

    public String deleteTopicFromSubject(String subjectId, String topicId);

}
