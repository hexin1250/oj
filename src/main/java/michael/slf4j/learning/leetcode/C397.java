package michael.slf4j.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

public class C397 {

	public static void main(String[] args) {
		int n = 2147483647;
		C397 c = new C397();
		System.out.println(c.integerReplacement(n));
	}
	static Map<Long, Integer> mem = new HashMap<>();
	
	static {
		long num = 4L;
		for (int i = 3; i <= 32; i++) {
			num <<= 1;
			mem.put(num, i);
			mem.put(num - 1, i + 1);
			mem.put(num + 1, i + 1);
		}
	}
	
	public int integerReplacement(int n) {
		return integerReplacement(n, true);
	}

	public int integerReplacement(long n, boolean flag) {
		if(n == 1) {
			return 0;
		}
		if(mem.containsKey(n)) {
			return mem.get(n);
		}
		if(n % 2 == 0) {
			int v = integerReplacement(n / 2, flag) + 1;
			mem.put(n, v);
			return v;
		}
		int max = Integer.MAX_VALUE;
		int v1 = integerReplacement(n - 1, flag) + 1;
		if(v1 < max) {
			mem.put(n, v1);
			max = v1;
		}
		int v2 = integerReplacement(n + 1, flag) + 1;
		if(v2 < max) {
			mem.put(n, v2);
			max = v2;
		}
		return max;
	}

}
