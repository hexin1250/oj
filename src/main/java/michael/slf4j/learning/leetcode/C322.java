package michael.slf4j.learning.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C322 {

	public static void main(String[] args) {
		int[] nums = new int[] {186,419,83,408};
		int amount = 6249;
		C322 c = new C322();
		System.out.println(c.coinChange(nums, amount));
	}
	
	private Map<Integer, Integer> dp = new HashMap<>();

	public int coinChange(int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		Arrays.sort(coins);
		int count = traversal(coins, amount, 0);
		return count;
	}

	private int traversal(int[] coins, int amount, int level) {
		if(amount == 0) {
			return 0;
		}
		if(amount < 0) {
			return -1;
		}
		if(dp.containsKey(amount)) {
			return dp.get(amount);
		}
		int count = -1;
		for (int i = coins.length - 1; i >= 0; i--) {
			int current = traversal(coins, amount - coins[i], level + 1);
			if(current == -1) {
				continue;
			}
			if(current < count || count == -1) {
				count = current;
			}
		}
		if(count != -1) {
			count = count + 1;
		}
		dp.put(amount, count);
		return count;
	}

}
