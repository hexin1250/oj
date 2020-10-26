package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1243 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				sc.nextLine();
				char[] type = sc.nextLine().toCharArray();
				Map<Character, Integer> map = new HashMap<>();
				for (int i = 0; i < n; i++) {
					map.put(type[i], sc.nextInt());
				}
				sc.nextLine();
				char[] terrorist = sc.nextLine().toCharArray();
				char[] bully = sc.nextLine().toCharArray();
				int[][] dp = new int[terrorist.length + 1][bully.length + 1];
				for (int i = 1; i <= terrorist.length; i++) {
					for (int j = 1; j <= bully.length; j++) {
						if(terrorist[i - 1] == bully[j - 1]) {
							int weight = map.get(terrorist[i - 1]);
							dp[i][j] = dp[i - 1][j - 1] + weight;
						} else {
							dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
						}
					}
				}
				int max = Arrays.stream(dp).mapToInt(arr -> Arrays.stream(arr).max().getAsInt()).max().getAsInt();
				System.out.println(max);
			}
		}
	}

}
