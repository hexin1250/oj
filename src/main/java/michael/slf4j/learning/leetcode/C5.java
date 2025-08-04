package michael.slf4j.learning.leetcode;

public class C5 {

	public static void main(String[] args) {
		C5 c = new C5();
//		String s = "iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz";
		String s = "gagilli";
		System.out.println(c.longestPalindrome(s));
	}
	
	public String longestPalindrome(String s) {
		int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] arr = s.toCharArray();
        for (int behind = 1; behind < len; behind++) {
			for (int left = 0; left < len; left++) {
				int right = left + behind;
				if(right >= len) {
					break;
				}
				if(arr[left] == arr[right]) {
					if(right - left < 3) {
						dp[left][right] = true;
					} else {
						dp[left][right] = dp[left + 1][right - 1];
					}
				} else {
					dp[left][right] = false;
				}
				if(dp[left][right] && right - left + 1 > maxLen) {
					maxLen = right - left + 1;
					begin = left;
				}
			}
		}
        return s.substring(begin, begin + maxLen);
	}
	
	public String longestPalindrome1(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		int mid = len / 2;
		int left = -1, right = -1;
		String maxStr = s.substring(0, 1);
		if(len % 2 == 1) {
			String currentStr = getOddCount(len, arr, mid, mid - 1, 0);
			maxStr = currentStr;
			
			currentStr = getEvenCount(len, arr, 2 * mid - 1, mid - 1, 0);
			if(currentStr.length() > maxStr.length()) {
				maxStr = currentStr;
			}
			currentStr = getEvenCount(len, arr, 2 * mid + 1, mid, 1);
			if(currentStr.length() > maxStr.length()) {
				maxStr = currentStr;
			}
			left = mid - 1;
			right = mid + 1;
		} else {
			String currentStr = getEvenCount(len, arr, mid * 2 - 1, mid - 1, 0);
			maxStr = currentStr;
			left = mid - 1;
			right = mid;
		}
		while(left >= 0 && right <= len - 1) {
			String currentStr = null;
			int currentOffset = left;
			if(maxStr.length() >= 2 * currentOffset + 1) {
				break;
			}
			currentStr = getOddCount(len, arr, left, left - 1, 0);
			if(currentStr.length() > maxStr.length()) {
				maxStr = currentStr;
			}
			
			if(maxStr.length() >= 2 * currentOffset + 1) {
				break;
			}
			currentStr = getOddCount(len, arr, right, right - 1, (right - (len - right - 1)));
			if(currentStr.length() > maxStr.length()) {
				maxStr = currentStr;
			}
			
			if(maxStr.length() >= 2 * currentOffset) {
				break;
			}
			currentStr = getEvenCount(len, arr, left * 2 - 1, left - 1, 0);
			if(currentStr.length() > maxStr.length()) {
				maxStr = currentStr;
			}
			
			if(maxStr.length() >= 2 * currentOffset) {
				break;
			}
			currentStr = getEvenCount(len, arr, right * 2 + 1, right, right - (len - right - 1 - 1));
			if(currentStr.length() > maxStr.length()) {
				maxStr = currentStr;
			}
			
			left--;
			right++;
		}
		return maxStr;
	}

	private String getOddCount(int len, char[] arr, int mid, int start, int end) {
		int count = 1;
		for (int i = start; i >= end; i--) {
			if(arr[i] == arr[2 * mid - i]) {
				count++;
			} else {
				break;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = mid - (count - 1); i <= mid + (count - 1); i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
	
	private String getEvenCount(int len, char[] arr, int all, int start, int end) {
		int count = 0;
		for (int i = start; i >= end; i--) {
			if(arr[i] == arr[all - i]) {
				count++;
			} else {
				break;
			}
		}
		StringBuffer sb = new StringBuffer();
		int startIndex = start - count + 1;
		for (int i = startIndex; i <= all - startIndex; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

}
