package michael.slf4j.learning.leetcode;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class C403 {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,3,5,6,8,12,17};
		C403 c = new C403();
		System.out.println(c.canCross(nums));
	}
	
	private Set<Point> mem = new HashSet<>();

	public boolean canCross(int[] stones) {
		return traversal(stones, 0, 1);
	}
	
	public boolean traversal(int[] stones, int index, int step) {
		if(index == stones.length - 1) {
			return true;
		}
		Point p = new Point(index, step);
		if(mem.contains(p)) {
			return false;
		}
		boolean ret = false;
		for (int i = index + 1; i < stones.length; i++) {
			int num = stones[i];
			if(num > stones[index] + step) {
				break;
			}
			if(num == stones[index] + step) {
				int k = num - stones[index];
				ret = traversal(stones, i, k + 1);
				if(ret) {
					return true;
				}
				ret = traversal(stones, i, k);
				if(ret) {
					return true;
				}
				ret = traversal(stones, i, k - 1);
				if(ret) {
					return true;
				}
			}
		}
		mem.add(p);
		return ret;
	}

}
