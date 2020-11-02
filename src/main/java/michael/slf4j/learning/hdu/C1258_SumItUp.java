package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class C1258_SumItUp {
	private static Set<Integer> cache = new HashSet<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int target = sc.nextInt();
				int n = sc.nextInt();
				if(n == 0 && target == 0) {
					break;
				}
				int[] a = new int[n];
				int[] mem = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				Arrays.sort(a);
				List<List<Integer>> ret = dfs(a, mem, n, new ArrayList<>(), target);
				System.out.println("Sums of " + target + ":");
				if(ret.isEmpty()) {
					System.out.println("NONE");
				} else {
					ret.forEach(list -> {
						System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining("+")));
					});
				}
				cache.clear();
			}
		}
	}
	
	public static List<List<Integer>> dfs(int[] a, int[] mem, int step, List<Integer> stack, int last) {
		List<List<Integer>> ret = new ArrayList<>();
		int hash = Objects.hashCode(stack);
		if(cache.contains(hash)) {
			return ret;
		}
		if(last == 0) {
			ret.add(stack);
			cache.add(hash);
			return ret;
		}
		if(step == 0 || last < 0) {
			cache.add(hash);
			return ret;
		}
		for (int i = step - 1; i >= 0; i--) {
			if(mem[i] == 1) {
				continue;
			}
			List<Integer> currentStack = new ArrayList<>(stack);
			mem[i] = 1;
			currentStack.add(a[i]);
			List<List<Integer>> currentResult = dfs(a, mem, i, currentStack, last - a[i]);
			if(!currentResult.isEmpty()) {
				ret.addAll(currentResult);
			}
			mem[i] = 0;
		}
		cache.add(hash);
		return ret;
	}

}
