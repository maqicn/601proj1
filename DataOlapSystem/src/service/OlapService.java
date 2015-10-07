package service;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * Template 1, INITIALIZE OPTIONS
	 */
	public List<Map<String, Object>> getAllDiseaseType(){
		return this.jdbcTemplate.queryForList(SQL.SQL_ALL_DIS_TYPE);
	}
	public List<Map<String, Object>> getAllDiseaseDesc(){
		return this.jdbcTemplate.queryForList(SQL.SQL_ALL_DIS_DESC);
	}
	public List<Map<String, Object>> getAllDiseaseName(){
		return this.jdbcTemplate.queryForList(SQL.SQL_ALL_DIS_NAME);
	}

	/**
	 * TEMPLATE 1
	 * @param desp:disease.description
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int getCntByDiseaseDesp(String desp){
		return this.jdbcTemplate.queryForInt(SQL.SQL_DISEASE_DESP, new Object[]{desp});
	}
	
	/**
	 * TEMPLATE 1
	 * @param type:disease.type
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int getCntByDiseaseType(String type){
		return this.jdbcTemplate.queryForInt(SQL.SQL_DISEASE_TYPE, new Object[]{type});
	}
	
	/**
	 * TEMPLATE 1
	 * @param name:disease.name
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int getCntByDiseaseName(String name){
		return this.jdbcTemplate.queryForInt(SQL.SQL_DISEASE_NAME, new Object[]{name});
	}
	
	/**
	 * TEMPLATE 2
	 * @param desp:disease.description
	 * @return
	 */
	public List<Map<String, Object>> getDrugTypeByDisDesp(String desp){
		return this.jdbcTemplate.queryForList(SQL.SQL_DURG_TYPE, new Object[]{desp});
	}
	
	/**
	 * TEMPLATE 3
	 * @param disName
	 * @param clusterId
	 * @param meaUnitId
	 * @return
	 */
	public List<Map<String, Object>> getRnaExpByCluster(String disName, String clusterId, String meaUnitId){
		return this.jdbcTemplate.queryForList(SQL.SQL_RNA_EXPRESSION, new Object[]{disName, clusterId, meaUnitId});
	}
	
	/**
	 * TEMPLATE 4,5,6
	 * @param disName
	 * @param goId
	 * @return
	 */
	public List<Map<String, Object>> getRnaExpByGo(String disName, String goId){
		return this.jdbcTemplate.queryForList(SQL.SQL_RNA_EXPRESSION, new Object[]{disName, goId});
	}
}
