package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1159_CommonSubsequence {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				if(parts.length == 1) {
					System.out.println(0);
					continue;
				} else {
					if(parts[0].trim().length() == 0) {
						System.out.println(0);
						continue;
					}
				}
				String s1 = parts[0];
				String s2 = parts[1];
				char[] ch1 = s1.toCharArray();
				char[] ch2 = s2.toCharArray();
				int[][] dp = new int[s1.length() + 1][s2.length() + 1];
				for (int i = 1; i < s1.length() + 1; i++) {
					for (int j = 1; j < s2.length() + 1; j++) {
						if(ch2[j - 1] == ch1[i - 1]) {
							dp[i][j] = dp[i - 1][j - 1] + 1;
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
