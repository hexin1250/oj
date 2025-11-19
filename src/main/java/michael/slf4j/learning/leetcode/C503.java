package michael.slf4j.learning.leetcode;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class C503 {

	public static void main(String[] args) {
		C503 c = new C503();
		int[] nums = new int[] {1,1,1};
		int[] ret = c.nextGreaterElements(nums);
		System.out.println(Arrays.stream(ret).mapToObj(i -> i + "").collect(Collectors.joining(",")));
	}

	public int[] nextGreaterElements(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return new int[] {-1};
		}
		int[] ret = new int[len];
		for (int i = 0; i < len; i++) {
			ret[i] = Integer.MIN_VALUE;
		}
		Stack<Integer> indexStack = new Stack<>();
		int index = 1;
		indexStack.push(0);
		while(!indexStack.isEmpty()) {
			if(index == indexStack.peek()) {
				ret[index] = -1;
				indexStack.pop();
				index++;
				if(index == len) {
					index = 0;
				}
				continue;
			}
			int num = nums[index];
			while(!indexStack.isEmpty()) {
				int lastIndex = indexStack.peek();
				if(nums[lastIndex] < num) {
					ret[lastIndex] = num;
					indexStack.pop();
				} else {
					break;
				}
			}
			if(ret[index] == Integer.MIN_VALUE && !indexStack.contains(index)) {
				indexStack.push(index);
			}
			index++;
			if(index == len) {
				index = 0;
			}
		}
		return ret;
	}

}
