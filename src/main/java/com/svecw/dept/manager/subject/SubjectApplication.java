package com.svecw.dept.manager.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder()
				.username("hema")
				.password("hema123")
				.roles("USER")
				.build();

		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin123")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, admin);
	}

}
