package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class C1572 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if (n == 0) {
					break;
				}
				int[][] city = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						city[i][j] = sc.nextInt();
					}
				}
				int k = sc.nextInt();
				Set<Integer> set = new TreeSet<>();
				for (int i = 0; i < k; i++) {
					set.add(sc.nextInt());
				}
				int[] arr = new int[set.size()];
				int index = 0;
				for (int v : set) {
					arr[index++] = v;
				}
				int[] mem = new int[arr.length];
				System.out.println(dfs(city, arr, mem, 0, 0, Integer.MAX_VALUE));
			}
		}
	}
	
	public static int dfs(int[][] city, int[] arr, int[] mem, int position, int current, int currentMin) {
		boolean complete = true;
		for (int i : mem) {
			if(i == 0) {
				complete = false;
				break;
			}
		}
		if(complete) {
			return current;
		}
		int min = currentMin;
		for (int i = 0; i < arr.length; i++) {
			if(mem[i] == 1) {
				continue;
			}
			int newPosition = arr[i];
			int now = current + city[position][newPosition];
			if(now >= min) {
				continue;
			}
			mem[i] = 1;
			int result = dfs(city, arr, mem, newPosition, now, min);
			if(result < min) {
				min = result;
			}
			mem[i] = 0;
		}
		return min;
	}

}
