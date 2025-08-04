package michael.slf4j.learning.leetcode;

public class C122 {

	public static void main(String[] args) {
		C122 c = new C122();
		int[] prices = new int[] {6,1,3,2,4,7};
		System.out.println(c.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		int min = prices[0];
		int max = 0;
		int ret = 0;
		for (int i = 1; i < len; i++) {
			if(prices[i] <= prices[i - 1]) {
				ret += max;
				min = prices[i];
				max = 0;
			} else {
				int value = prices[i] - min;
				if(max < value) {
					max = value;
				}
			}
		}
		if(max != 0) {
			ret += max;
		}
		return Math.max(max, ret);
	}

}
