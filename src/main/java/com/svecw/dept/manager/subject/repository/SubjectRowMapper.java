package com.svecw.dept.manager.subject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.svecw.dept.manager.subject.model.Subject;

public class SubjectRowMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject currSubj = new Subject();
        String subject_id = rs.getString("subject_id");
        String code = rs.getString("code");
        String name = rs.getString("name");
        String description = rs.getString("description");
        int totalHours = rs.getInt("total_hours");
        int credits = rs.getInt("credits");
        currSubj.setSubjectId(subject_id);
        currSubj.setCode(code);
        currSubj.setName(name);
        currSubj.setDescription(description);
        currSubj.setTotalHours(totalHours);
        currSubj.setCredits(credits);
        return currSubj;
    }

}
