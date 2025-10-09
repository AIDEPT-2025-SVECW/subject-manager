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

    // Not a good approach as I am using prefix as parth variable which
    // is not a good practice as path variable should be used to identify a resource
    // uniquely
    // hence using request param approach is recommended
    @Deprecated
    @GetMapping("/search1/{prefix}")
    public List<Subject> getSubjectStartingWith_1(@PathVariable("prefix") String prefix) {
        System.out.println(prefix);
        return SubjectDataProvider.getData().values().stream()
                .filter(subject -> subject.getSubjectId().startsWith(prefix))
                .toList();
    }

    @GetMapping("/search")
    public List<Subject> getSubjectStartingWith(@RequestParam("prefix") String prefix) {
        return subjectService.getSubjectStartingWith(prefix);
    }

    @GetMapping("/{id}/topics")
    public List<Topic> getSubjectTopics(@PathVariable("id") String id) {
        System.out.println(id);
        return subjectService.getSubjectTopics(id);
    }

    @RequestMapping("/{id}/topics/{topicId}")
    public Topic getSubjectTopic(@PathVariable("id") String id, @PathVariable("topicId") String topicId) {
        System.out.println(id + " " + topicId);
        return subjectService.getSubjectTopic(id, topicId);
    }

    @PostMapping("/{id}/topics")
    public Topic addTopicToSubject(@PathVariable("id") String id, @RequestBody Topic topic2Add) {
        return subjectService.addTopicToSubject(id, topic2Add);
    }

    @DeleteMapping("/{id}/topics/{topicId}")
    public String deleteTopicFromSubject(@PathVariable("id") String id, @PathVariable("topicId") String topicId) {
        return subjectService.deleteTopicFromSubject(id, topicId);
    }

}
