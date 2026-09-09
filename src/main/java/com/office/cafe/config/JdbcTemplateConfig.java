package com.office.cafe.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JdbcTemplateConfig {

	final private String CLASS_NAME = "[JdbcTemplateConfig] ";
	
	@Bean
	public BasicDataSource dataSource() {
		System.out.println(CLASS_NAME.concat("dataSource()"));
		
		BasicDataSource basicDataSource = 
				new BasicDataSource();
		
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/DB_MENU");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("1234");
		
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxTotal(10);
		basicDataSource.setMaxIdle(2);
		basicDataSource.setMinIdle(2);
		
		return basicDataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		System.out.println(CLASS_NAME.concat("jdbcTemplate()"));
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println(CLASS_NAME.concat("passwordEncoder()"));
		
		return new BCryptPasswordEncoder();
		
	}
	
}