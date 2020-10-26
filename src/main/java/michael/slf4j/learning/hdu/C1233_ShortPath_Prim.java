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
public class C1233_ShortPath_Prim {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				Map<Integer, List<Edge>> map = new HashMap<>();
				for (int i = 0; i < (n * (n - 1) / 2); i++) {
					int source = sc.nextInt() - 1;
					int target = sc.nextInt() - 1;
					int road = sc.nextInt();
					List<Edge> sourceList = map.get(source);
					if(sourceList == null) {
						sourceList = new ArrayList<>();
					}
					sourceList.add(new Edge(source, target, road));
					map.put(source, sourceList);
					
					List<Edge> targetList = map.get(target);
					if(targetList == null) {
						targetList = new ArrayList<>();
					}
					targetList.add(new Edge(target, source, road));
					map.put(target, targetList);
				}
				Set<Integer> vSet = new HashSet<>();
				vSet.add(0);
				int total = 0;
				while(vSet.size() < n) {
					int min = Integer.MAX_VALUE;
					int e = -1;
					for (Integer preV : vSet) {
						List<Edge> vList = map.get(preV);
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
		private int pre;
		private int v;
		private int e;
		public Edge(int pre, int e, int v) {
			this.pre = pre;
			this.e = e;
			this.v = v;
		}
		public int getPre() {
			return pre;
		}
		public int getV() {
			return v;
		}
		public int getE() {
			return e;
		}
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.getV() < o2.getV() ? -1 : 1;
		}
	}

}
