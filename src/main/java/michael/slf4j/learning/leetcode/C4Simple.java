package michael.slf4j.learning.leetcode;

public class C4Simple {

	public static void main(String[] args) {
		C4Simple c = new C4Simple();
//		int[] nums1 = new int[] {1,3};
//		int[] nums2 = new int[] {2};
		int[] nums1 = new int[] {2,2,4,4};
		int[] nums2 = new int[] {2,2,4,4};
		System.out.println(c.findMedianSortedArrays(nums1, nums2));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] arr = generate(nums1, nums2);
		int len = arr.length;
		int target = len / 2;
		double ret = 0D;
		ret += arr[target];
		if(len % 2 == 0) {
			ret += arr[target - 1];
			ret /= 2;
		}
		return ret;
	}

	private int[] generate(int[] nums1, int[] nums2) {
		int[] ret = new int[nums1.length + nums2.length];
		int l1 = 0, l2 = 0;
		int index = 0;
		while(l1 < nums1.length || l2 < nums2.length) {
			int num1 = Integer.MAX_VALUE;
			if(l1 < nums1.length) {
				num1 = nums1[l1];
			} else {
				ret[index++] = nums2[l2++];
				continue;
			}
			int num2 = Integer.MAX_VALUE;
			if(l2 < nums2.length) {
				num2 = nums2[l2];
			} else {
				ret[index++] = nums1[l1++];
				continue;
			}
			if(num1 <= num2) {
				ret[index++] = num1;
				l1++;
			} else {
				ret[index++] = num2;
				l2++;
			}
		}
		return ret;
	}

}
