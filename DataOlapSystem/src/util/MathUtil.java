package util;

import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.inference.TestUtils;

public class MathUtil {

	public static double getTTestValue(List<Map<String, Object>> sample1, List<Map<String, Object>> sample2){
		double[] s1 = convertToArray(sample1);
		double[] s2 = convertToArray(sample1);
		return TestUtils.t(s1, s2);
	}
	
	private static double[] convertToArray(List<Map<String, Object>> sample){
		double[] s = new double[sample.size()];
		int i=0;
		for(Map<String, Object> map:sample){
			s[i] = (double)map.get("NUM");
		}
		return s;
	}
}
