package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class C1455 {
	private static List<String> excludeList = new ArrayList<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if (n == 0) {
					break;
				}
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				Arrays.sort(arr);
				int max = Arrays.stream(arr).max().getAsInt();
				int sum = Arrays.stream(arr).sum();
				List<Integer> list = new ArrayList<>();
				for (int i = max; i <= sum / 2; i++) {
					if (sum % i == 0) {
						list.add(i);
					}
				}
				int[] distinct = Arrays.stream(arr).distinct().toArray();
				Arrays.sort(distinct);
				int[] times = new int[distinct.length];
				int index = 0;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == distinct[index]) {
						times[index]++;
					} else {
						index++;
						times[index]++;
					}
				}
				int length = distinct.length;
				int find = -1;
				for (int target : list) {
					int position = length - 1;
					Stack<Integer> cache = new Stack<>();
					boolean ret = dps(distinct, times, position, 0, target, cache, true);
					excludeList.clear();
					if (ret) {
						find = target;
						break;
					}
				}
				System.out.println(find);
			}
		}
	}

	private static boolean dps(int[] distinct, int[] times, int position, int current, int target, Stack<Integer> cache, boolean writeCache) {
		int index = position;
		while (index >= 0) {
			if (times[index] == 0) {
				index--;
				continue;
			}
			int next = current + distinct[index];
			times[index]--;
			cache.push(distinct[index]);
			String keys = cache.stream().map(i -> i.toString()).collect(Collectors.joining("/"));
			boolean ret = false;
			if (next > target || excludeList.contains(keys)) {
				times[index]++;
				index--;
				cache.pop();
				continue;
			} else if (next == target) {
				boolean all = true;
				for (int m : times) {
					if (m > 0) {
						all = false;
						break;
					}
				}
				if (all) {
					return true;
				}
				Stack<Integer> newcache = new Stack<>();
				ret = dps(distinct, times, distinct.length - 1, 0, target, newcache, false);
			} else {
				ret = dps(distinct, times, index, next, target, cache, writeCache);
			}
			if (!ret) {
				if(writeCache) {
					excludeList.add(keys);
				}
				times[index]++;
				index--;
				cache.pop();
				if(cache.size() == 0) {
					return false;
				}
			} else {
				return true;
			}
		}
		return false;
	}

}
