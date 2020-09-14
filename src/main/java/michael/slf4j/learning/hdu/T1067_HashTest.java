package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T1067_HashTest {
	static Set<Long> set = new HashSet<>();
	static Map<Long, Long> map = new HashMap<>();
	
	public static void main(String[] args) {
		long[] a = new long[] {1,2,3,4,5,6,7,8};
		int[] mem = new int[a.length];
		long aMin = bfsMin(a, mem, 0L, 0);
		long aMax = bfsMax(a, mem, 0L, 0);
		System.out.println(aMin + ":" + aMax + ":" + bfs(a, mem, 0L, 0));
		long[] b = new long[] {25,26,27,28,29,29,29,29};
		long bMin = bfsMin(b, mem, 0L, 0);
		long bMax = bfsMax(b, mem, 0L, 0);
		System.out.println(bMin + ":" + bMax + ":" + bfs(b, mem, 0L, 0));
		System.out.println(map.size());
		
		long sum = 69504937L;
		for (long i = 1; i <= 3; i++) {
			sum *= 30L;
		}
		System.out.println(sum);
	}
	
	private static long bfs(long[] a, int[] mem, long hash, int step) {
		if(step == a.length) {
//			if(set.contains(hash)) {
//				System.out.println("Not Enough");
//			} else {
//				set.add(hash);
//			}
			map.put(hash, 1L);
			return 1;
		}
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			if(mem[i] == 1) {
				continue;
			}
			mem[i] = 1;
			long n = a[i];
			sum += bfs(a, mem, hash + n * ((long)Math.pow(a.length, step)), step + 1);
			mem[i] = 0;
		}
		return sum;
	}

	private static long bfsMax(long[] a, int[] mem, long hash, int step) {
		if(step == a.length) {
			return hash;
		}
		long max = Long.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(mem[i] == 1) {
				continue;
			}
			mem[i] = 1;
			long n = a[i];
			long v = bfsMax(a, mem, hash + n * ((long)Math.pow(a.length, step)), step + 1);
			if(v > max) {
				max = v;
			}
			mem[i] = 0;
		}
		return max;
	}
	
	private static long bfsMin(long[] a, int[] mem, long hash, int step) {
		if(step == a.length) {
			return hash;
		}
		long min = Long.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(mem[i] == 1) {
				continue;
			}
			mem[i] = 1;
			long n = a[i];
			long v = bfsMin(a, mem, hash + n * ((long)Math.pow(a.length, step)), step + 1);
			if(v < min) {
				min = v;
			}
			mem[i] = 0;
		}
		return min;
	}

}
