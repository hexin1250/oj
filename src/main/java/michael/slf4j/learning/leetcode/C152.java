package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C152 {

	public static void main(String[] args) {
		C152 c = new C152();
		int[] nums = new int[] {-3,-1,-1};
//		int[] nums = new int[] {0};
		System.out.println(c.maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int len = nums.length;
		Stack<List<Integer>> listStack = new Stack<>();
		Stack<Integer> stack = new Stack<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			if(nums[i] == 0 || i == 0) {
				stack.push(0);
				listStack.push(new ArrayList<>());
				if(nums[i] == 0) {
					max = 0;
					continue;
				}
			}
			List<Integer> currentList = listStack.peek();
			currentList.add(nums[i]);
			int negativeCount = stack.pop();
			if(nums[i] < 0) {
				negativeCount++;
			}
			stack.push(negativeCount);
		}
		
		while(!stack.isEmpty()) {
			int negativeCount = stack.pop();
			List<Integer> currentList = listStack.pop();
			int sum = 1;
			if(currentList.isEmpty()) {
				sum = 0;
			} else if(currentList.size() == 1) {
				sum = currentList.get(0);
			} else {
				if(negativeCount % 2 == 0) {
					for (Integer num : currentList) {
						sum *= num;
					}
				} else {
					int currentNegativeIndex = 0;
					int headSum = 1;
					int tailSum = 1;
					for (Integer num : currentList) {
						if(currentNegativeIndex > 0) {
							tailSum *= num;
						}
						if(num < 0) {
							currentNegativeIndex++;
						}
						if(currentNegativeIndex < negativeCount) {
							headSum *= num;
						}
					}
					sum = Math.max(headSum, tailSum);
				}
			}
			if(sum > max) {
				max = sum;
			}
		}
		return max;
	}

}
