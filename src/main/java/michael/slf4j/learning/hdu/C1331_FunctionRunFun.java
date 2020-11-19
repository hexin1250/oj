package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1331_FunctionRunFun {
	private static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				if(a == -1 && b == -1 && c == -1) {
					break;
				}
				int ret = w(a, b, c);
				System.out.println(String.format("w(%s, %s, %s) = %s", a, b, c, ret));
			}
		}
	}

	private static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if(a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		int hash = hash(a, b, c);
		Integer ret = map.get(hash);
		if(ret != null) {
			return ret;
		}
		if(a < b && b < c) {
			ret = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		} else {
			ret = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}
		map.put(hash, ret);
		return ret;
	}
	
	private static int hash(int a, int b, int c) {
		int hash = a;
		hash = hash * 21 + b;
		hash = hash * 21 + c;
		return hash;
	}

}
