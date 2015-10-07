package constant;

public class SQL {

	public static final String SCHEMA = new String("qwang39.");
	
	public static final String SQL_DISEASE_DESP = new String("select count(1) from patient p, disease d, clinical_fact c " +
			"where p.p_id = c.p_id and d.ds_id=c.ds_id and d.description = ?");
	
	public static final String SQL_DISEASE_TYPE = new String("select count(1) from patient p, disease d, clinical_fact c " +
			"where p.p_id = c.p_id and d.ds_id=c.ds_id and d.type = ?");
	
	public static final String SQL_DISEASE_NAME = new String("select count(1) from patient p, disease d, clinical_fact c " +
			"where p.p_id = c.p_id and d.ds_id=c.ds_id and d.name = ?");
	
	public static final String SQL_DURG_TYPE = new String("select distinct dr.type from patient p, disease d, clinical_fact c, drug dr " +
			"where p.p_id = c.p_id and d.ds_id=c.ds_id and dr.dr_id = c.dr_id and d.description = ?");
	
	public static final String SQL_RNA_EXPRESSION = new String("");
	
	public static final String SQL_DISEASE_EXPRESSION = new String("");
	
	public static final String SQL_ALL_DIS_TYPE = new String("select distinct type from disease");
	
	public static final String SQL_ALL_DIS_DESC = new String("select distinct description from disease");
	
	public static final String SQL_ALL_DIS_NAME = new String("select distinct name from disease");
}
