package michael.slf4j.learning.leetcode;

public class C97 {

	public static void main(String[] args) {
		C97 c = new C97();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(c.isInterleave(s1, s2, s3));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if(len1 + len2 != len3) {
			return false;
		}
		if(len3 == 0) {
			return true;
		}
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		boolean ret = false;
		for (int k = 1; k <= len3; k++) {
			int iStart = 0;
			int jStart = k - iStart;
			if(jStart >= len2) {
				jStart = len2;
				iStart = k - jStart;
			}
			for (int i = iStart; i <= len1 && i <= k; i++) {
				int j = k - i;
				if(j > len2 || j < 0) {
					continue;
				}
				char ck = s3.charAt(k - 1);
				if(i > 0 && ck == s1.charAt(i - 1) && dp[i - 1][j]) {
					dp[i][j] = true;
				}
				if(j > 0 && ck == s2.charAt(j - 1) && dp[i][j - 1]) {
					dp[i][j] = true;
				}
				if(k == len3 && dp[i][j]) {
					ret = true;
					break;
				}
			}
		}
		return ret;
	}

}
