package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C399 {

	public static void main(String[] args) {
		C399 c = new C399();
		List<List<String>> equations = new ArrayList<>();
//		equations.add(List.of("a", "b"));
//		equations.add(List.of("c", "b"));
//		equations.add(List.of("d", "b"));
//		equations.add(List.of("ab", "bc"));
//		double[] values = new double[] {2,3,4,0.5};
		equations.add(List.of("a", "b"));
		equations.add(List.of("b", "c"));
		
		double[] values = new double[] {2,3};
		
		List<List<String>> queries = new ArrayList<>();
		queries.add(List.of("a", "c"));
		queries.add(List.of("b", "a"));
		queries.add(List.of("a", "e"));
		queries.add(List.of("a", "a"));
		queries.add(List.of("x", "x"));
		
		double[] ret = c.calcEquation(equations, values, queries);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < equations.size(); i++) {
			List<String> list = equations.get(i);
			String a = list.get(0);
			String b = list.get(1);
			double v = values[i];
			
			Map<String, Double> subMap1 = map.get(a);
			if(subMap1 == null) {
				subMap1 = new HashMap<>();
				map.put(a, subMap1);
			}
			subMap1.put(b, v);
			
			Map<String, Double> subMap2 = map.get(b);
			if(subMap2 == null) {
				subMap2 = new HashMap<>();
				map.put(b, subMap2);
			}
			subMap2.put(a, 1 / v);
			set.add(a);
			set.add(b);
		}
		Set<String> mem = new HashSet<>();
		Map<String, Map<String, Double>> valueMap = new HashMap<>();
		Map<String, String> subjectMap = new HashMap<>();
		for (String x : set) {
			if(mem.contains(x)) {
				continue;
			}
			Map<String, Double> subValueMap = new HashMap<>();
			subValueMap.put(x, 1D);
			valueMap.put(x, subValueMap);
			mem.add(x);
			subjectMap.put(x, x);
			addData(x, x, valueMap, map, mem, subjectMap);
		}
		int len = queries.size();
		double[] ret = new double[len];
		for (int i = 0; i < len; i++) {
			List<String> list = queries.get(i);
			String a = list.get(0);
			String b = list.get(1);
			String subjectA = subjectMap.get(a);
			String subjectB = subjectMap.get(b);
			if(subjectA == null || !subjectA.equals(subjectB)) {
				ret[i] = -1D;
			} else {
				Map<String, Double> subValueMap = valueMap.get(subjectA);
				double valueA = subValueMap.get(a);
				double valueB = subValueMap.get(b);
				ret[i] = valueA / valueB;
			}
		}
		return ret;
	}

	private void addData(String subject, String x, Map<String, Map<String, Double>> valueMap, Map<String, Map<String, Double>> map,
			Set<String> mem, Map<String, String> subjectMap) {
		Map<String, Double> subValueMap = valueMap.get(subject);
		double valueX = subValueMap.get(x);
		
		Map<String, Double> subMap = map.get(x);
		for (Entry<String, Double> entry : subMap.entrySet()) {
			String y = entry.getKey();
			if(mem.contains(y)) {
				continue;
			}
			double v = entry.getValue();
			double valueY = valueX / v;
			subValueMap.put(y, valueY);
			
			subjectMap.put(y, subject);
			mem.add(y);
			addData(subject, y, valueMap, map, mem, subjectMap);
		}
	}

}
