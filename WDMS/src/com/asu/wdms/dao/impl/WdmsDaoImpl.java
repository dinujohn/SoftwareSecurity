package com.asu.wdms.dao.impl;
import org.springframework.jdbc.core.JdbcTemplate;


public class WdmsDaoImpl{
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

}
