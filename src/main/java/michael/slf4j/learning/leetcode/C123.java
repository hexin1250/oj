package michael.slf4j.learning.leetcode;

public class C123 {

	public static void main(String[] args) {
		C123 c = new C123();
		int[] prices = new int[] {1,2,4,2,5,7,2,4,9,0};
		System.out.println(c.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		int len = prices.length;
		int min = prices[0];
		int max = 0;
		int top1 = 0;
		int top2 = 0;
		for (int i = 1; i < len; i++) {
			if(prices[i] <= prices[i - 1]) {
				if(max > top1) {
					top2 = top1;
					top1 = max;
				} else if(max > top2) {
					top2 = max;
				}
				min = prices[i];
				max = 0;
			} else {
				int value = prices[i] - min;
				if(max < value) {
					max = value;
				}
			}
		}
		if(max > top1) {
			top2 = top1;
			top1 = max;
		} else if(max > top2) {
			top2 = max;
		}
		return top1 + top2;
	}

}
