package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1279 {
	private static Map<Integer, List<Integer>> cache = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				List<Integer> list = getArray(n);
				if(list.isEmpty()) {
					System.out.println("No number can be output !");
				} else {
					System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
				}
			}
		}
	}
	
	public static List<Integer> getArray(int n){
		if(n == 1) {
			return new ArrayList<>();
		}
		if(cache.containsKey(n)) {
			return cache.get(n);
		}
		List<Integer> ret = new ArrayList<>();
		int nextN;
		if(n % 2 == 1) {
			ret.add(n);
			nextN = 3 * n + 1;
		} else {
			nextN = n / 2;
		}
		ret.addAll(getArray(nextN));
		cache.put(n, ret);
		return ret;
	}

}
