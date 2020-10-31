package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1250_HatFibonacci {
	public static Map<Integer, String> map = new HashMap<>();
	
	static {
		map.put(1, "1");
		map.put(2, "1");
		map.put(3, "1");
		map.put(4, "1");
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				System.out.println(getResult(sc.nextInt()));
			}
		}
	}
	
	public static String getResult(int n) {
		String ret = map.get(n);
		if(ret != null) {
			return ret;
		}
		String part1 = plus(getResult(n - 1), getResult(n - 2));
		String part2 = plus(getResult(n - 3), getResult(n - 4));
		ret = plus(part1, part2);
		map.put(n, ret);
		return ret;
	}
	
	private static String plus(String s1, String s2) {
		return plus(getArray(s1), getArray(s2));
	}
	
	private static String plus(int[] a, int[] b) {
		int[] ret = plusArray(a, b);
		int length = a.length > b.length ? a.length + 1 : b.length + 1;
		StringBuffer sb = new StringBuffer();
		boolean start = false;
		for (int i = length - 1; i >= 0; i--) {
			if(!start && ret[i] == 0) {
				continue;
			} else {
				start = true;
			}
			sb.append(ret[i]);
		}
		return sb.toString();
	}
	
	private static int[] plusArray(int[] a, int[] b) {
		int length = a.length > b.length ? a.length + 1 : b.length + 1;
		int[] ret = new int[length];
		for (int i = 0; i < length; i++) {
			if(i < a.length) {
				ret[i] += a[i];
			}
			if(i < b.length) {
				ret[i] += b[i];
			}
			if(ret[i] >= 10) {
				ret[i + 1] = ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		return ret;
	}

	private static int[] getArray(String s) {
		char[] ch = s.toCharArray();
		int length = ch.length;
		int[] ret = new int[length];
		char init = '1';
		for (int i = 0; i < length; i++) {
			char c = ch[length - i - 1];
			if(c == '0') {
				ret[i] = 0;
			} else {
				ret[i] = c - init + 1;
			}
		}
		return ret;
	}

}
