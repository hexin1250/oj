package michael.slf4j.learning.leetcode;

public class C121 {

	public static void main(String[] args) {
	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < len; i++) {
			if(prices[i] <= min) {
				min = prices[i];
			} else {
				if(prices[i] - min > max) {
					max = prices[i] - min;
				}
			}
		}
		return max;
	}

}
