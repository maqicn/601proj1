package constant;

public class SQL {

	public static final String SCHEMA = new String("qwang39.");
	public static final String SQL_DISEASE_DESP = new String("select count(1) from "+SCHEMA+"patient p, disease d, clinical_fact c " +
			"where p.p_id = c.p_id and d.ds_id=c.ds_id and d.description = ?");
}
