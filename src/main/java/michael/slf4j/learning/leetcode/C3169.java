package michael.slf4j.learning.leetcode;

import java.util.Arrays;

public class C3169 {

	public static void main(String[] args) {
		int days = 10;
		int[][] meetings = new int[][] {{1,5}, {2,6},{8,9}};
		C3169 c = new C3169();
		System.out.println(c.countDays(days, meetings));
	}

	public int countDays(int days, int[][] meetings) {
		/**
		 * 0 = count
		 * 1 = start
		 * 2 = end
		 */
		Arrays.sort(meetings, (a, b) -> {
			if(a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		int count = days;
		int lastStart = meetings[0][0];
		int lastEnd = meetings[0][1];
		for (int i = 1; i < meetings.length; i++) {
			int[] meeting = meetings[i];
			int currentStart = meeting[0];
			int currentEnd = meeting[1];
			if(currentStart > lastEnd + 1) {
				count = count - (lastEnd - lastStart + 1);
				lastStart = currentStart;
				lastEnd = currentEnd;
			} else if(currentEnd > lastEnd) {
				lastEnd = currentEnd;
			}
		}
		return count - (lastEnd - lastStart + 1);
	}

}
