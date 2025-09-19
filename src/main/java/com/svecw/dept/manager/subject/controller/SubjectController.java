package com.svecw.dept.manager.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.svecw.dept.manager.subject.model.Subject;
import com.svecw.dept.manager.subject.model.SubjectDataProvider;
import com.svecw.dept.manager.subject.model.Topic;
import com.svecw.dept.manager.subject.service.ISubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    ISubjectService subjectService;

    @RequestMapping("/")
    public List<Subject> listSubjects() {
        System.out.println("Listing all subjects111111");
        return subjectService.getAllSubjects();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subject getSubject(@PathVariable("id") String id) {
        System.out.println(id);
        return subjectService.getSubjectById(id);
    }

    @GetMapping("/search/{prefix}")
    public List<Subject> getSubjectStartingWith(@PathVariable("prefix") String prefix) {
        System.out.println(prefix);
        return SubjectDataProvider.getData().values().stream()
                .filter(subject -> subject.getId().startsWith(prefix))
                .toList();
    }

    @GetMapping("/search1")
    public List<Subject> getSubjectStartingWith_1(@RequestParam("prefix") String prefix) {
        System.out.println(prefix);
        return SubjectDataProvider.getData().values().stream()
                .filter(subject -> subject.getId().startsWith(prefix))
                .toList();
    }

    @GetMapping("/{id}/topics")
    public List<Topic> getSubjectTopics(@PathVariable("id") String id) {
        System.out.println(id);
        return SubjectDataProvider.getData().get(id).getTopics();
    }

    @RequestMapping("/{id}/topics/{topicId}")
    public Topic getSubjectTopic(@PathVariable("id") String id, @PathVariable("topicId") String topicId) {
        System.out.println(id + " " + topicId);
        return SubjectDataProvider.getData().get(id).getTopics().stream()
                .filter(topic -> topic.getId().equals(topicId))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/{id}/topics")
    public Topic addTopicToSubject(@PathVariable("id") String id, @RequestBody Topic topic2Add) {
        Subject subject = SubjectDataProvider.getData().get(id);
        System.out.println("topic 2 add " + topic2Add.getDescription());
        if (subject == null) {
            throw new RuntimeException("Subject not found with id: " + id);
        }
        subject.getTopics().add(topic2Add);
        return topic2Add;
    }

    @DeleteMapping("/{id}/topics?name={prefix}")
    public String deleteTopicFromSubject(@PathVariable("id") String id, @PathVariable("topicId") String topicId) {
        Subject subject = SubjectDataProvider.getData().get(id);
        if (subject == null) {
            throw new RuntimeException("Subject not found with id: " + id);
        }
        boolean removed = subject.getTopics().removeIf(topic -> topic.getId().equals(topicId));
        if (!removed) {
            throw new RuntimeException("Topic not found with id: " + topicId + " in subject: " + id);
        }
        return "Topic with id: " + topicId + " removed from subject: " + id;
    }

}
