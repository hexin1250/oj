package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author ch
 * Timeout
 */
public class C1051_WoodenSticks {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				Stick[] arr = new Stick[n];
				for (int i = 0; i < n; i++) {
					arr[i] = new Stick(sc.nextInt(), sc.nextInt());
				}
				Arrays.sort(arr, new Comparator<Stick>() {
					@Override
					public int compare(Stick o1, Stick o2) {
						if(o1.w < o2.w) {
							return -1;
						} else if(o1.w > o2.w) {
							return 1;
						}
						if(o1.l < o2.l) {
							return -1;
						}
						return 1;
					}
				});
				int[] mem = new int[n];
				int minStep = minStep(arr, null, mem, 0, -1);
				System.out.println(minStep);
			}
		}
	}
	
	private static int minStep(Stick[] arr, Stick prev, int[] mem, int cost, int minCost) {
		if(minCost != -1 && cost >= minCost) {
			return -1;
		}
		int min = -1;
		int isEmpty = 0;
		for (int i = 0; i < arr.length; i++) {
			if(mem[i] == 1) {
				continue;
			}
			isEmpty++;
			mem[i] = 1;
			Stick c = arr[i];
			int extra = 0;
			if(prev == null || (c.l < prev.l || c.w < prev.w) ) {
				extra = 1;
			}
			int steps = minStep(arr, c, mem, cost + extra, min);
			if(steps == -1) {
				isEmpty--;
			} else if(min == -1 || steps < min) {
				min = steps;
			}
			mem[i] = 0;
		}
		if(isEmpty == 0) {
			return cost;
		}
		return min;
	}

	public static class Stick{
		public int w;
		public int l;
		public Stick(int w, int l) {
			this.w = w;
			this.l = l;
		}
		@Override
		public int hashCode() {
			return w * 31 + l;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Stick)) {
				return false;
			}
			Stick s = (Stick) obj;
			return this.w == s.w && this.l == s.l;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append('[').append(w).append(',').append(l).append(']');
			return sb.toString();
		}
	}

}
