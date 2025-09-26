package com.svecw.dept.manager.subject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.svecw.dept.manager.subject.model.Subject;

import jakarta.annotation.PostConstruct;

@Repository
public class SubjectDAOImpl implements ISubjectDAO {

    private Connection connection;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @PostConstruct
    private void init() {
        try {
            // Step 1: Load and register the JDBC driver
            // This step is handled by Class.forName("com.mysql.cj.jdbc.Driver") in older
            // versions,
            // but in modern JDBC, this step is optional if you use a JDBC 4.0+ compliant
            // driver.
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Establish the connection
            // Using DriverManager to connect to the database by providing URL, username,
            // and password.
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("Unable to establish connection, please check connectin properties");
            e.printStackTrace();
        }
    }

    public List<Subject> findAll() {
        List<Subject> subjects = new ArrayList<>();
        String query = "select * from subject.subjects";
        Statement st = null;
        ResultSet rs = null;
        try {
            // Step 3: Create the statement
            // Creating a PreparedStatement to perform parameterized SQL operations (safe
            // from SQL injection).
            st = connection.createStatement();
            // Step 4: Set parameters and execute the query
            // Setting values into the placeholders and executing the SQL statement.
            rs = st.executeQuery(query);
            // Step 5: (Optional in INSERT) Process the result
            // For INSERT/UPDATE/DELETE, we usually check the affected rows.
            // For SELECT, we would use ResultSet and iterate over it.
            while (rs.next()) {
                String subject_id = rs.getString("subject_id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int totalHours = rs.getInt("total_hours");
                int credits = rs.getInt("credits");
                Subject currSubject = new Subject();
                currSubject.setId(subject_id);
                currSubject.setCode(code);
                currSubject.setName(name);
                currSubject.setDescription(description);
                currSubject.setTotalHours(totalHours);
                currSubject.setCredits(credits);
                subjects.add(currSubject);
            }
        } catch (SQLException ex) {
            System.out.println("Unable to execute query");
            ex.printStackTrace();
        } finally {

            try {
                // Step 6: Close the resources
                // It's important to release database resources to avoid memory leaks.
                rs.close();
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return subjects;
    }

    public Subject findById(String id) {
        List<Subject> subjects = new ArrayList<>();
        String query = "select * from subject.subjects where subject_id='" + id + "'";
        System.out.println(query);
        Statement st = null;
        ResultSet rs = null;
        try {
            // Step 3: Create the statement
            // Creating a PreparedStatement to perform parameterized SQL operations (safe
            // from SQL injection).
            st = connection.createStatement();
            // Step 4: Set parameters and execute the query
            // Setting values into the placeholders and executing the SQL statement.
            rs = st.executeQuery(query);
            // Step 5: (Optional in INSERT) Process the result
            // For INSERT/UPDATE/DELETE, we usually check the affected rows.
            // For SELECT, we would use ResultSet and iterate over it.
            while (rs.next()) {
                String subject_id = rs.getString("subject_id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int totalHours = rs.getInt("total_hours");
                int credits = rs.getInt("credits");
                Subject currSubject = new Subject();
                currSubject.setId(subject_id);
                currSubject.setCode(code);
                currSubject.setName(name);
                currSubject.setDescription(description);
                currSubject.setTotalHours(totalHours);
                currSubject.setCredits(credits);
                subjects.add(currSubject);
            }
        } catch (SQLException ex) {
            System.out.println("Unable to execute query");
            ex.printStackTrace();
        } finally {

            try {
                // Step 6: Close the resources
                // It's important to release database resources to avoid memory leaks.
                rs.close();
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return subjects.get(0);

    }

}
