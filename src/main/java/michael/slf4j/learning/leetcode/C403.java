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
	
	private Set<Point> memory = new HashSet<>();

	public boolean canCross(int[] stones) {
		if(stones[1] != 1) {
			return false;
		}
		for (int i = 2; i >= 0; i--) {
			boolean ret = dfs(stones, 1, i);
			if(ret) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dfs(int[] stones, int index, int k) {
		if(index == stones.length - 1) {
			return true;
		}
		Point p = new Point(index, k);
		if(memory.contains(p)) {
			return false;
		}
		boolean ret = false;
		for (int i = index + 1; i < stones.length; i++) {
			int num = stones[i];
			if(num > stones[index] + k) {
				break;
			}
			if(num == stones[index] + k) {
				int nextK = num - stones[index];
				ret = dfs(stones, i, nextK + 1);
				if(ret) {
					return true;
				}
				ret = dfs(stones, i, nextK);
				if(ret) {
					return true;
				}
				ret = dfs(stones, i, nextK - 1);
				if(ret) {
					return true;
				}
			}
		}
		memory.add(p);
		return ret;
	}

}
