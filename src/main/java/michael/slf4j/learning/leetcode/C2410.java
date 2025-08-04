package michael.slf4j.learning.leetcode;

import java.util.Arrays;

public class C2410 {

	public static void main(String[] args) {
		C2410 c = new C2410();
		int[] players = new int[] {4,7,9};
		int[] trainers = new int[] {8,2,5,8};
		System.out.println(c.matchPlayersAndTrainers(players, trainers));
	}

	public int matchPlayersAndTrainers(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		int playerLen = players.length, trainerLen = trainers.length;
		int index1 = 0, index2 = 0, count = 0;
		while(index1 < playerLen && index2 < trainerLen) {
			if(players[index1] <= trainers[index2]) {
				count++;
				index1++;
				index2++;
			} else {
				index2++;
			}
		}
		return count;
	}
	
	public int matchPlayersAndTrainers1(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		int playerLen = players.length, trainerLen = trainers.length;
		int[][] dp = new int[playerLen + 1][trainerLen + 1];
		for (int i = 1; i <= playerLen; i++) {
			for (int j = 1; j <= trainerLen; j++) {
				if(players[i - 1] <= trainers[j - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[playerLen][trainerLen];
	}

}
