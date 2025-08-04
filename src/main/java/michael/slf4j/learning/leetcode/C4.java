package michael.slf4j.learning.leetcode;

public class C4 {

	public static void main(String[] args) {
		C4 c = new C4();
		int[] nums1 = new int[] {1,3};
		int[] nums2 = new int[] {2};
//		int[] nums1 = new int[] {2,2,4,4};
//		int[] nums2 = new int[] {2,2,4,4};
		System.out.println(c.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(nums2.length == 0) {
			return getSingle(nums1, nums2);
		} else if(nums1.length == 0) {
			return getSingle(nums2, nums1);
		} else if(nums1[len1 - 1] <= nums2[0]) {
			return getSingle(nums1, nums2);
		} else if(nums1[0] >= nums2[len2 - 1]) {
			return getSingle(nums2, nums1);
		}
		return findMid(nums1, nums2);
	}

	private double findMid(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int target = (len1 + len2) / 2;
		if((len1 + len2) % 2 == 1) {
			target++;
		}
		int currentResult = getResult(nums1, 1, len1, nums2, target);
		if(currentResult == Integer.MAX_VALUE) {
			currentResult = getResult(nums2, 1, len2, nums1, target);
		}
		if((len1 + len2) % 2 == 0) {
			int currentResult2 = getResult(nums1, 1, len1, nums2, target + 1);
			if(currentResult2 == Integer.MAX_VALUE) {
				currentResult2 = getResult(nums2, 1, len2, nums1, target + 1);
			}
			return ((double)currentResult + (double)currentResult2) / 2D;
		}
		return currentResult;
	}
	
	/**
	 * 
	 * @param baselineNums
	 * @param currentIndex
	 * @param searchNums
	 * @return int[], 包含两个元素: index 0代表最小的下标, index 1代表最大的下标
	 */
	private int getResult(int[] baselineNums, int left, int right, int[] searchNums, int targetIndex) {
		int currentIndex = (left + right) / 2;
		int num = baselineNums[currentIndex - 1];
		int[] ret = getIndex(num, searchNums, 1, searchNums.length);
		/**
		 * 说明有相等数字的情况
		 */
		int rightMinIndex = ret[0];
		int rightMaxIndex = ret[1];
		if((rightMinIndex != 0 && rightMinIndex == rightMaxIndex && num != searchNums[rightMinIndex - 1]) || rightMinIndex == 0) {
			if(targetIndex == rightMinIndex + currentIndex) {
				return num;
			}
		} else if(targetIndex >= rightMinIndex + currentIndex - 1 && targetIndex <= rightMaxIndex + currentIndex) {
			return num;
		}
		if(left == right) {
			/**
			 * 说明没有找到
			 */
			return Integer.MAX_VALUE;
		}
		/**
		 * 这种情况说明，当前值num=baselineNums[currentIndex - 1]，比searchNums[max]还要大，说明结果一定在baselineNums中
		 */
		if(rightMinIndex == 0 && targetIndex < rightMinIndex + currentIndex) {
			return baselineNums[targetIndex - 1];
		} else if(rightMaxIndex == searchNums.length && targetIndex > rightMaxIndex + currentIndex) {
			return baselineNums[targetIndex - searchNums.length - 1];
		}
		int mid = (left + right) / 2;
		if(targetIndex < rightMinIndex + currentIndex) {
			return getResult(baselineNums, left, mid, searchNums, targetIndex);
		}
		return getResult(baselineNums, mid + 1, right, searchNums, targetIndex);
	}
	
	private int[] getIndex(int num, int[] nums, int left, int right) {
		if(num < nums[left - 1]) {
			return new int[] {left - 1, left - 1};
		} else if(num > nums[right - 1]) {
			return new int[] {right, right};
		}
		if(num == nums[left - 1]) {
			int realLeft = findFirst(num, nums, 1, left);
			int realRight = findLast(num, nums, left, right);
			return new int[] {realLeft, realRight};
		} else if(num == nums[right - 1]) {
			int realLeft = findFirst(num, nums, left, right);
			int realRight = findLast(num, nums, left, right);
			return new int[] {realLeft, realRight};
		}
		int mid = (left + right) / 2;
		if(num < nums[mid - 1]) {
			return getIndex(num, nums, left, mid - 1);
		} else if(num > nums[mid - 1]) {
			return getIndex(num, nums, mid + 1, right);
		}
		return getIndex(num, nums, left, mid);
	}
	
	private int findFirst(int num, int[] nums, int realLeft, int left) {
		if(left == 1) {
			return 1;
		}
		if(realLeft == left) {
			return left;
		}
		int mid = (realLeft + left) / 2;
		if(num > nums[mid - 1]) {
			return findFirst(num, nums, mid + 1, left);
		}
		return findFirst(num, nums, realLeft, mid);
	}

	private int findLast(double num, int[] nums, int right, int realRight) {
		if(nums[right - 1] > num) {
			return right - 1;
		}
		if(right == nums.length) {
			return right;
		}
		if(right == realRight) {
			return right;
		}
		int mid = (right + realRight) / 2;
		if(num < nums[mid - 1]) {
			return findLast(num, nums, right, mid);
		}
		return findLast(num, nums, mid + 1, realRight);
	}

	private double getSingle(int[] leftNums, int[] rightNums) {
		int len1 = leftNums.length, len2 = rightNums.length;
		int mid = (len1 + len2) / 2;
		double ret = getMid(leftNums, rightNums, len1, mid);
		if((len1 + len2) % 2 == 0) {
			ret += getMid(leftNums, rightNums, len1, mid - 1);
			ret = ret / 2;
		}
		return ret;
	}

	private double getMid(int[] leftNums, int[] rightNums, int len1, int mid) {
		double single = 0D;
		if(len1 <= mid) {
			single = rightNums[mid - len1];
		} else {
			single = leftNums[mid];
		}
		return single;
	}

}
