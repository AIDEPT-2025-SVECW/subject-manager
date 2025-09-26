package com.svecw.dept.manager.subject;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);
	}

	// @Bean
	// public DataSource getSubjectDataSource() {
	// DataSource ds = new DriverManagerDataSource(url, userName, password);
	// return ds;
	// }

	// @Bean
	// public JdbcTemplate getJdbcTemplate() {
	// JdbcTemplate template = new JdbcTemplate(getSubjectDataSource());
	// return template;
	// }

}
