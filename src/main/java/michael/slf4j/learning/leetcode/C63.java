package michael.slf4j.learning.leetcode;

public class C63 {

	public static void main(String[] args) {
		C63 c = new C63();
		int[][] board = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(c.uniquePathsWithObstacles(board));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;
		if(obstacleGrid[rows - 1][cols - 1] == 1 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		int[][] dp = new int[rows + 1][cols + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if(i == 1 && j == 1) {
					dp[1][1] = 1;
					continue;
				}
				if(obstacleGrid[i - 1][j - 1] == 1) {
					dp[i][j] = 0;
					continue;
				}
				int above = i > 1 ? dp[i - 1][j] : 0;
				int left = j > 1 ? dp[i][j - 1] : 0;
				dp[i][j] = above + left;
			}
		}
		return dp[rows][cols];
	}

}
