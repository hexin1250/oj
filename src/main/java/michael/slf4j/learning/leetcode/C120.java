package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C120 {

	public static void main(String[] args) {
		C120 c = new C120();
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(List.of(-1));
		triangle.add(List.of(-2,-3));
		System.out.println(c.minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int depth = triangle.size();
		int ret = triangle.get(0).get(0);
		int[][] dp = new int[depth][];
        dp[0] = new int[1];
        dp[0][0] = ret;
		for (int i = 1; i < depth; i++) {
			int[] row = new int[i + 1];
			dp[i] = row;
			List<Integer> rowList = triangle.get(i);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j <= i; j++) {
				int currentNum = rowList.get(j);
				if(j == 0) {
					dp[i][j] = dp[i - 1][j] + currentNum;
				} else if(j == i) {
					dp[i][j] = dp[i - 1][j - 1] + currentNum;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + currentNum;
				}
				if(dp[i][j] < min) {
					min = dp[i][j];
				}
			}
			ret = min;
		}
		return ret;
	}

}
