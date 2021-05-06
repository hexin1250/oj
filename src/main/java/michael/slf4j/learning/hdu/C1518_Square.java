package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1518_Square {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				int sum = Arrays.stream(arr).sum();
				if(sum % 4 != 0) {
					System.out.println("no");
					continue;
				}
				int target = sum / 4;
				int[] mem = new int[n];
				Arrays.sort(arr);
				boolean ret = dfs(target, arr, mem, 0, 0, 0);
				System.out.println((ret ? "yes" : "no"));
			}
		}
	}

	private static boolean dfs(int target, int[] arr, int[] mem, int index, int current, int level) {
		if(level == 4) {
			for (int i = 0; i < mem.length; i++) {
				if(mem[i] == 0) {
					return false;
				}
			}
			return true;
		}
		for (int i = index; i < arr.length; i++) {
			if(mem[i] != 0) {
				continue;
			}
			int nextValue = current + arr[i];
			if(nextValue > target) {
				continue;
			}
			mem[i] = 1;
			boolean ret = false;
			if(nextValue == target) {
				ret = dfs(target, arr, mem, 0, 0, level + 1);
			} else {
				ret = dfs(target, arr, mem, i + 1, nextValue, level);
			}
			if(ret) {
				return true;
			}
			mem[i] = 0;
		}
		return false;
	}

}
