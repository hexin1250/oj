package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C442 {

	public static void main(String[] args) {
//		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		int[] nums = new int[] {1,1,2};
		C442 c = new C442();
		System.out.println(c.findDuplicates(nums));
	}
	
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if(Math.abs(num) == i + 1) {
				continue;
			}
			int index = num - 1;
			if(nums[index] < 0 || nums[index] == num) {
				ret.add(num);
			} else {
				nums[index] = Math.abs(nums[index]) * -1;
			}
		}
		return ret;
	}

	public List<Integer> findDuplicates1(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if(num == i + 1) {
				continue;
			}
			if(num == nums[num - 1]) {
				ret.add(num);
				nums[i] = -1;
			} else {
				int index = i;
				int nextIndex = num - 1;
				while(true) {
					int tmp = nums[index];
					nums[index] = nums[nextIndex];
					nums[nextIndex] = tmp;
					
					index = i;
					nextIndex = nums[i] - 1;
					if(nextIndex < 0) {
						break;
					}
					if(nums[index] == index + 1) {
						break;
					} else {
						if(nums[index] == nums[nextIndex]) {
							ret.add(nums[i]);
							nums[index] = -1;
							break;
						}
					}
				}
			}
		}
		return ret;
	}

}
