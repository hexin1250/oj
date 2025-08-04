package michael.slf4j.learning.leetcode;

public class C91 {

	public static void main(String[] args) {
		C91 c = new C91();
		String s = "301";
		System.out.println(c.numDecodings(s));
	}

	public int numDecodings(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		if(arr[0] == '0') {
			return 0;
		}
		int[] dp = new int[len];
		dp[0] = 1;
		if(len >= 2) {
			int sum = sum(arr, 0, 1);
			if(arr[1] == '0') {
				if(sum > 26) {
					return 0;
				} else {
					dp[1] = 1;
				}
			} else {
				if(sum <= 26) {
					dp[1] = 2;
				} else {
					dp[1] = 1;
				}
			}
		}
		for (int i = 2; i < dp.length; i++) {
			char c = arr[i];
			int sum = sum(arr, i - 1, i);
			if(c == '0') {
				if(arr[i - 1] == '0' || sum > 26) {
					return 0;
				}
				dp[i] = dp[i - 2];
				dp[i - 1] = dp[i - 2];
			} else if(sum > 26) {
				dp[i] = dp[i - 1];
			} else {
				if(arr[i - 1] == '0') {
					dp[i] = dp[i - 1];
				} else {
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}
		}
		return dp[len - 1];
	}
	
	private int sum(char[] arr, int index1, int index2) {
		return (arr[index1] - '0') * 10 + (arr[index2] - '0');
	}

}
