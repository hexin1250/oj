package michael.slf4j.learning.leetcode;

public class C321 {

	public static void main(String[] args) {
//		int[] nums1 = new int[] {3,4,6,5};
//		int[] nums2 = new int[] {9,1,2,5,8,3};
//		int k = 5;
//		int[] nums1 = new int[] {6,7};
//		int[] nums2 = new int[] {6,0,4};
//		int k = 5;
//		int[] nums1 = new int[] {3,9};
//		int[] nums2 = new int[] {8,9};
//		int k = 3;
		int[] nums1 = new int[] {8,9};
		int[] nums2 = new int[] {3,9};
		int k = 3;
		C321 c = new C321();
		int[] ret = c.maxNumber(nums1, nums2, k);
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i] + " ");
		}
		System.out.println();
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int index = 0;
		int start1 = 0;
		int start2 = 0;
		int[] counts = new int[k];
		while(index < k) {
			int max = -1;
			int pick1 = -1;
			int pick2 = -1;
			int index1 = start1;
			int index2 = start2;
			int end1 = len1 - k + index + 1;
			for (index1 = start1; index1 < end1; index1++) {
				if(max < nums1[index1]) {
					max = nums1[index1];
					pick1 = index1;
				}
			}
			int end2 = len2 - k + index + 1;
			for (index2 = start2; index2 < end2; index2++) {
				if(max < nums2[index2]) {
					max = nums2[index2];
					pick2 = index2;
					pick1 = -1;
				}
			}
			int maxGap1 = k - index - len2 + index2;
			for (int i = index1; i < len1 - maxGap1 + 1; i++) {
				if(max < nums1[i]) {
					max = nums1[i];
					pick1 = i;
					pick2 = -1;
				}
			}
			int maxGap2 = k - index - len1 + index1;
			for (int i = index2; i < len2 - maxGap2 + 1; i++) {
				if(max < nums2[i]) {
					max = nums2[i];
					pick2 = i;
					pick1 = -1;
				}
			}
			counts[index] = max;
			if(pick1 != -1) {
				start1 = pick1 + 1;
			}
			if(pick2 != -1) {
				start2 = pick2 + 1;
			}
			index++;
		}
		return counts;
	}

}
