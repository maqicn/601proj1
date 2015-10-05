package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import constant.SQL;

public class OlapService {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	public int getCntByDiseaseDesp(String desp){
		return this.jdbcTemplate.queryForInt(SQL.SQL_DISEASE_DESP, new Object[]{desp});
	}
}
