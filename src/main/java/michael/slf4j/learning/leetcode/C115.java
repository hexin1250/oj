package michael.slf4j.learning.leetcode;

public class C115 {

	public static void main(String[] args) {
		C115 c = new C115();
		long t1 = System.currentTimeMillis();
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", t = "bcddceeeebecbc";
		System.out.println(c.numDistinct(s, t));
		long t2 = System.currentTimeMillis();
		System.out.println("time:" + (t2 - t1));
	}

	public int numDistinct(String s, String t) {
		String pureS = s;
		for (int i = 0; i < t.length(); i++) {
			String unusedT = t.charAt(i) + "";
			if(!s.contains(unusedT)) {
				pureS = pureS.replaceAll(unusedT, "");
			}
		}
		
		int m = pureS.length();
        int n = t.length();
        // 创建动态规划数组，大小为 (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // 初始化：当 t 为空字符串时，s 的任何前缀都有 1 个匹配（空子序列）
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // 动态规划填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果 s 的第 i 个字符等于 t 的第 j 个字符
                if (pureS.charAt(i - 1) == t.charAt(j - 1)) {
                    // 可以选择匹配当前字符，也可以选择不匹配
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 字符不匹配时，只能跳过 s 的当前字符
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // 返回 s 的前 m 个字符中匹配 t 的前 n 个字符的子序列个数
        return dp[m][n];
		
	}

}
