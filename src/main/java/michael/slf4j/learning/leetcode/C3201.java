package michael.slf4j.learning.leetcode;

public class C3201 {

	public static void main(String[] args) {
		C3201 c = new C3201();
		int[] nums = new int[] {3,1,6,2,2};
		System.out.println(c.maximumLength(nums));
	}

	public int maximumLength(int[] nums) {
		int len = nums.length;
		int[] status = new int[3];
		status[2] = 1;
		int dir = 0;
		for (int i = 0; i < len; i++) {
			int currentDir = 0;
			if(nums[i] % 2 == 0) {
				status[0]++;
				currentDir = 1;
			} else {
				status[1]++;
				currentDir = -1;
			}
			if(dir != 0) {
				if(dir != currentDir) {
					status[2]++;
				}
			}
			dir = currentDir;
		}
		return Math.max(Math.max(status[0], status[1]), status[2]);
	}

}
