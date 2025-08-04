package michael.slf4j.learning.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class C239 {

	public static void main(String[] args) {
		C239 c = new C239();
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int[] ret = c.maxSlidingWindow(nums, 3);
		System.out.println(Arrays.stream(ret).mapToObj(i -> i + "").collect(Collectors.joining(" ")));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		TreeMap<Integer, List<Integer>> numMap = new TreeMap<>();
		
		int[] ret = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			int num = nums[i];
			List<Integer> addList = numMap.get(num);
			if(addList == null) {
				addList = new LinkedList<>();
				numMap.put(num, addList);
			}
			addList.add(i);
		}
		ret[0] = numMap.lastKey();
		for (int i = k; i < nums.length; i++) {
			int removeNum = nums[i - k];
			List<Integer> removeList = numMap.get(removeNum);
			removeList.remove(0);
			if(removeList.isEmpty()) {
				numMap.remove(removeNum);
			}
			
			int num = nums[i];
			List<Integer> addList = numMap.get(num);
			if(addList == null) {
				addList = new LinkedList<>();
				numMap.put(num, addList);
			}
			addList.add(i);
			ret[i - k + 1] = numMap.lastKey();
		}
		return ret;
	}

}
