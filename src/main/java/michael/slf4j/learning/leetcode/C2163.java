package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class C2163 {

	public static void main(String[] args) {
//		[7,9,5,8,1,3]
//		[7,  5,8,  3]
//		[7,9,1,8,5,3]
//		[7,  1,8,5  ]
//		[7,9,8,1,5,3]
//		[7,   ,1,5,3]
//		[5,3,1,8,9,7]
//		[7,  1,8,5  ]
//		[5,9,8,1,7,3]
//		[5,   ,1,7,3]
//		[5,9,1,3,7,8]
//		[    1,3,7,8]
//		[5,9,1,7,3,8]
//		[5,  1,7  ,8]
//		[8,9,7,5,1,3]
//		[8,9,7,5,   ]
		C2163 c = new C2163();
		int[] nums = new int[] {3,1,2};
		System.out.println(c.minimumDifference(nums));
	}

	public long minimumDifference(int[] nums) {
		int len = nums.length;
		int n = len / 3;
		
		TreeMap<Integer, List<Integer>> firstMap = new TreeMap<>();
		long firstSum = 0;
		for (int i = 0; i < n - 1; i++) {
			addDataIntoMap(nums, i, firstMap);
			firstSum += nums[i];
		}
		long secondSum = 0;
		TreeMap<Integer, List<Integer>> secondMap = new TreeMap<>();
		for (int i = n - 1; i < 3 * n; i++) {
			addDataIntoMap(nums, i, secondMap);
			secondSum += nums[i];
		}
		long minOffset = Long.MAX_VALUE;
		for (int i = n - 1; i < 2 * n; i++) {
			addDataIntoMap(nums, i, firstMap);
			firstSum += nums[i];
			List<Integer> firstDeleteList = deleteMap(firstMap, i - n + 1, true);
			long firstPart = 0;
			for (int index : firstDeleteList) {
				firstPart += nums[index];
			}
			
			deleteDataMap(nums, i, secondMap);
			secondSum -= nums[i];
			List<Integer> secondDeleteList = deleteMap(secondMap, 2 * n - i - 1, false);
			long secondPart = 0;
			for (int index : secondDeleteList) {
				secondPart += nums[index];
			}
			
			minOffset = Math.min(minOffset, (firstSum - firstPart) - (secondSum - secondPart));
			
			/**
			 * revert
			 */
			for (int j = firstDeleteList.size() - 1; j >= 0; j--) {
				addDataIntoMap(nums, firstDeleteList.get(j), firstMap);
			}
			for (int j = secondDeleteList.size() - 1; j >= 0; j--) {
				addDataIntoMap(nums, secondDeleteList.get(j), secondMap);
			}
		}
		return minOffset;
	}
	
	private void addDataIntoMap(int[] nums, int index, TreeMap<Integer, List<Integer>> map) {
		List<Integer> countList = map.get(nums[index]);
		if(countList == null) {
			countList = new ArrayList<>();
			map.put(nums[index], countList);
		}
		countList.add(index);
	}
	
	private void deleteDataMap(int[] nums, int index, TreeMap<Integer, List<Integer>> map) {
		int num = nums[index];
		deleteDataMap(num, map);
	}
	
	private void deleteDataMap(int num, TreeMap<Integer, List<Integer>> map) {
		List<Integer> countList = map.get(num);
		countList.remove(countList.size() - 1);
		if(countList.isEmpty()) {
			map.remove(num);
		}
	}
	
	private List<Integer> deleteMap(TreeMap<Integer, List<Integer>> treeMap, int delCount, boolean isLargestNumber){
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < delCount; i++) {
			int num = -1;
			if(isLargestNumber) {
				num = treeMap.lastKey();
			} else {
				num = treeMap.firstKey();
			}
			List<Integer> countList = treeMap.get(num);
			int index = countList.remove(countList.size() - 1);
			if(countList.isEmpty()) {
				treeMap.remove(num);
			}
			ret.add(index);
		}
		return ret;
	}

}
