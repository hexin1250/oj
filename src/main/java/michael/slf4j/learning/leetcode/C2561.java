package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class C2561 {

	public static void main(String[] args) {
		int[] nums1 = new int[] {84,80,43,8,80,88,43,14,100,88};
		int[] nums2 = new int[] {32,32,42,68,68,100,42,84,14,8};
//		int[] nums1 = new int[] {4,4,4,4,3};
//		int[] nums2 = new int[] {5,5,5,5,3};
//		int[] nums1 = new int[] {1};
//		int[] nums2 = new int[] {1};
		C2561 c = new C2561();
		System.out.println(c.minCost(nums1, nums2));
	}

	public long minCost(int[] basket1, int[] basket2) {
		Arrays.sort(basket1);
		Arrays.sort(basket2);
		int len = basket1.length;
		int index1 = 0;
		int index2 = 0;
		Map<Integer, Integer> exclusionMap1 = new LinkedHashMap<>();
		Map<Integer, Integer> exclusionMap2 = new LinkedHashMap<>();
		long min = Math.min(basket1[0], basket2[0]);
		while(index1 < len || index2 < len) {
			int result = offset(basket1, basket2, index1, index2, len);
			if(result == 0) {
				index1++;
				index2++;
			} else if(result < 0) {
				int num = basket1[index1];
				Integer count = exclusionMap1.get(num);
				if(count == null) {
					count = 0;
				}
				count++;
				exclusionMap1.put(num, count);
				index1++;
			} else {
				int num = basket2[index2];
				Integer count = exclusionMap2.get(num);
				if(count == null) {
					count = 0;
				}
				count++;
				exclusionMap2.put(num, count);
				index2++;
			}
		}
		List<Integer> list1 = convert(exclusionMap1);
		List<Integer> list2 = convert(exclusionMap2);
		if(list1 == null || list2 == null || list1.size() != list2.size()) {
			return -1;
		}
		int size = list1.size();
		long ret = 0L;
		for (int i = 0; i < size; i++) {
			int currentMin = Math.min(list1.get(i), list2.get(size - i - 1));
			if(currentMin <= min * 2) {
				ret += currentMin;
			} else {
				ret += min * 2;
			}
		}
		return ret;
	}
	
	private List<Integer> convert(Map<Integer, Integer> map){
		List<Integer> ret = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int count = entry.getValue();
			if(count % 2 == 1) {
				return null;
			}
			int len = count / 2;
			for (int i = 0; i < len; i++) {
				ret.add(num);
			}
		}
		return ret;
	}
	
	private int offset(int[] basket1, int[] basket2, int index1, int index2, int len) {
		if(index1 == len) {
			return 1;
		}
		if(index2 == len) {
			return -1;
		}
		return basket1[index1] - basket2[index2];
	}

}
