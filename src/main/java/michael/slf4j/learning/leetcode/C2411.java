package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C2411 {
	public static void main(String[] args) {
		C2411 c = new C2411();
//		int[] nums = new int[] {1,0,2,1,3};
//		int[] nums = new int[] {1,2};
		int[] nums = new int[] {1,0};
		int[] ret = c.smallestSubarrays(nums);
		System.out.println(Arrays.stream(ret).mapToObj(i -> i + "").collect(Collectors.joining(",")));
	}
	
	private final int maxLen = 30;
	
	public int[] smallestSubarrays(int[] nums) {
		int max = 0;
		int len = nums.length;
		int[][] bits = new int[len][maxLen];
		int[] maxNum = new int[len];
		int end = len;
		boolean zeroEnd = true;
		for (int i = len - 1; i >= 0; i--) {
			if(nums[i] == 0 && zeroEnd) {
				end--;
			} else {
				zeroEnd = false;
			}
			bits[i] = getBitArr(nums[i]);
			max = max | nums[i];
			maxNum[i] = max;
		}
		int[] count = new int[maxLen];
		int[] ret = new int[len];
		int currentIndex = 0;
		for (int i = 0; i < end; i++) {
			int[] targetBit = getBitArr(maxNum[i]);
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < maxLen; j++) {
				if(targetBit[j] == 1) {
					list.add(j);
				}
			}
			
			boolean full = true;
			if(i != 0) {
				int[] bit = bits[i - 1];
				for (int j = 0; j < maxLen; j++) {
					count[j] -= bit[j];
					if(list.contains(j) && count[j] == 0) {
						full = false;
					}
				}
			} else {
				int[] bit = bits[i];
				for (int j = 0; j < maxLen; j++) {
					count[j] += bit[j];
					if(list.contains(j) && count[j] == 0) {
						full = false;
					}
				}
			}
			if(full) {
				ret[i] = currentIndex - i + 1;
			} else {
				while(currentIndex + 1 < len && !full) {
					full = true;
					currentIndex += 1;
					int[] nextBit = bits[currentIndex];
					for (int j = 0; j < maxLen; j++) {
						count[j] += nextBit[j];
						if(list.contains(j) && count[j] == 0) {
							full = false;
						}
					}
				}
				if(!full) {
					break;
				}
				ret[i] = currentIndex - i + 1;
			}
		}
		for (int i = end; i < len; i++) {
			ret[i] = 1;
		}
		return ret;
	}
	
	private int[] getBitArr(int num) {
		int[] ret = new int[maxLen];
		String bitStr = Integer.toBinaryString(num);
		int bitLen = bitStr.length();
		for (int j = maxLen - 1; j >= 0 && maxLen - j - 1 <= bitLen - 1; j--) {
			int tmp = maxLen - j - 1;
			int index = bitLen - 1 - tmp;
			ret[j] = bitStr.charAt(index) - '0';
		}
		return ret;
	}
}
