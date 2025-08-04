package michael.slf4j.learning.leetcode;

public class C174 {

	public static void main(String[] args) {
		C174 c = new C174();
//		int[][] dungeon = new int[][] {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
//		int[][] dungeon = new int[][] {{0,0}};
//		int[][] dungeon = new int[][] {{-3}, {-7}};
		int[][] dungeon = new int[][] {{1,-3,3}, {0,-2,0}, {-3,-3,-3}};
		System.out.println(c.calculateMinimumHP(dungeon));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] status = new int[m][n];
		int[][] health = new int[m][n];
		status[0][0] = dungeon[0][0];
		health[0][0] = dungeon[0][0];
		for (int i = 1; i < n; i++) {
			int currentHealth = dungeon[0][i];
			health[0][i] = health[0][i - 1] + currentHealth;
			status[0][i] = Math.min(health[0][i], status[0][i - 1]);
		}
		for (int i = 1; i < m; i++) {
			int currentHealth = dungeon[i][0];
			health[i][0] = health[i - 1][0] + currentHealth;
			status[i][0] = Math.min(health[i][0], status[i - 1][0]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int currentHealth = dungeon[i][j];
				int leftHealth = health[i][j - 1] + currentHealth;
				int leftStatus = Math.min(leftHealth, status[i][j - 1]);
				int upHealth = health[i - 1][j] + currentHealth;
				int upStatus = Math.min(upHealth, status[i - 1][j]);
				if(upHealth > leftHealth) {
					status[i][j] = upStatus;
					health[i][j] = upHealth;
				} else if(upHealth < leftHealth) {
					status[i][j] = leftStatus;
					health[i][j] = leftHealth;
				} else {
					status[i][j] = Math.max(leftStatus, upStatus);
					health[i][j] = leftHealth;
				}
			}
		}
		int ret = status[m - 1][n - 1];
		if(ret >= 0) {
			return 1;
		}
		return Math.abs(ret) + 1;
	}

}
