package michael.slf4j.learning.leetcode;

public class C42 {

	public static void main(String[] args) {
	}

	public int trap1(int[] height) {
		int len = height.length;
		int[][] maxV = new int[len][2];
		for (int i = 1; i < len; i++) {
			int leftMax = Math.max(maxV[i - 1][0], height[i - 1]);
			if(height[i] < leftMax) {
				maxV[i][0] = leftMax;
			}
			int rightMax = Math.max(maxV[len - i][1], height[len - i]);
			if(height[len - i - 1] < rightMax) {
				maxV[len - i - 1][1] = rightMax;
			}
		}
		int ret = 0;
		for (int i = 0; i < len; i++) {
			int minHeight = Math.min(maxV[i][0], maxV[i][1]);
			if(height[i] < minHeight) {
				ret += minHeight - height[i];
			}
		}
		return ret;
	}
	
	public int trap(int[] height) {
		int len = height.length;
		int[][] maxV = new int[len][2];
		
		for (int i = 1; i < len; i++) {
			int rightMax = Math.max(maxV[len - i][1], height[len - i]);
			if(height[len - i - 1] < rightMax) {
				maxV[len - i - 1][1] = rightMax;
			}
		}
		
		int ret = 0;
		for (int i = 1; i < len; i++) {
			int leftMax = Math.max(maxV[i - 1][0], height[i - 1]);
			if(height[i] < leftMax) {
				maxV[i][0] = leftMax;
			}
			int minHeight = Math.min(maxV[i][0], maxV[i][1]);
			if(height[i] < minHeight) {
				ret += minHeight - height[i];
			}
		}
		return ret;
	}

}
