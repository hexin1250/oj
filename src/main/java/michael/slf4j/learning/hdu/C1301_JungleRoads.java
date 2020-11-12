package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Prim
 */
public class C1301_JungleRoads {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				sc.nextLine();
				Map<String, List<Edge>> map = new HashMap<>();
				String start = null;
				for (int i = 1; i <= n - 1; i++) {
					String line = sc.nextLine();
					String[] parts = line.split("[\\s]+");
					String currentStart = null;
					for (int j = 0; j < parts.length / 2; j++) {
						String s = parts[2 * j];
						if(start == null) {
							start = s;
						}
						String e = null;
						if(j == 0) {
							currentStart = s;
							continue;
						} else {
							e = s;
						}
						int v = Integer.valueOf(parts[2 * j + 1]);
						
						List<Edge> sourceList = map.get(currentStart);
						if(sourceList == null) {
							sourceList = new ArrayList<>();
						}
						sourceList.add(new Edge(currentStart, e, v));
						map.put(currentStart, sourceList);
						
						List<Edge> targetList = map.get(e);
						if(targetList == null) {
							targetList = new ArrayList<>();
						}
						targetList.add(new Edge(e, currentStart, v));
						map.put(e, targetList);
					}
				}
				Set<String> vSet = new HashSet<>();
				vSet.add(start);
				int total = 0;
				while(vSet.size() < n) {
					int min = Integer.MAX_VALUE;
					String e = null;
					for (String s : vSet) {
						List<Edge> vList = map.get(s);
						Iterator<Edge> it = vList.iterator();
						while(it.hasNext()) {
							Edge edge = it.next();
							if(vSet.contains(edge.getE())){
								it.remove();
								continue;
							}
							if(edge.getV() < min) {
								e = edge.getE();
								min = edge.getV();
							}
						}
					}
					vSet.add(e);
					total += min;
				}
				System.out.println(total);
			}
		}
	}
	
	public static class Edge implements Comparator<Edge> {
		private String s;
		private String e;
		private int v;
		public Edge(String s, String e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		public String getS() {
			return s;
		}
		public int getV() {
			return v;
		}
		public String getE() {
			return e;
		}
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.getV() < o2.getV() ? -1 : 1;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(s).append("->").append(e).append(":").append(v);
			return sb.toString();
		}
	}

}
