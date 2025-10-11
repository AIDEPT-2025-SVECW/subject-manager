package com.svecw.dept.manager.subject.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import com.svecw.dept.manager.subject.model.StudentInterviews;

@RepositoryRestResource(path = "interviews")
public interface IStudentInterviewJPARepo extends MongoRepository<StudentInterviews, String> {

        public List<StudentInterviews> findAll();

        public List<StudentInterviews> findByFinalResultIsNull();

        public List<StudentInterviews> findByTypeOfInterview(@Param("typeOfInterview") String typeOfInterview);

        public List<StudentInterviews> findByRegId(@Param("regId") String regId);

        public List<StudentInterviews> findByTypeOfInterviewAndFinalResult(
                        @Param("typeOfInterview") String typeOfInterview, @Param("finalResult") String finalResult);

        public List<StudentInterviews> findByDateOfInterviewAfterAndFinalResultIsNull(
                        @Param("dateOfInterview") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date interviewDate);

}
