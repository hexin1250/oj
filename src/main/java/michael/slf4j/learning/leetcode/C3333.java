package michael.slf4j.learning.leetcode;

public class C3333 {

	public static void main(String[] args) {
		C3333 c = new C3333();
		String word = "aabbccdd";
		int k = 7;
		System.out.println(c.countStartingStrings(word, k));
	}
	
	private static final int MOD = 1000000007;

    public int countStartingStrings(String word, int k) {
        int n = word.length();
        if (n == 0){
            return 0;
        }

        int[] startOfRun = new int[n];
        int[] endOfRun = new int[n];
        startOfRun[0] = 0;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                startOfRun[i] = startOfRun[i - 1];
            } else {
                startOfRun[i] = i;
            }
        }
        endOfRun[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                endOfRun[i] = endOfRun[i + 1];
            } else {
                endOfRun[i] = i;
            }
        }

        long[] dp = new long[n];
        long[] prefixSum = new long[n + 1];
        int[] lastRunStart = new int[n];
        long[] runDpSum = new long[n];
        for (int i = 0; i < n; i++) {
            lastRunStart[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
                prefixSum[i + 1] = (prefixSum[i] + dp[i]) % MOD;
                lastRunStart[i] = startOfRun[i];
                runDpSum[i] = dp[i];
                continue;
            }

            if (startOfRun[i] == i) {
                if (word.charAt(i) != word.charAt(i - 1)) {
                    int lastRunEnd = i - 1;
                    int lastRunSt = startOfRun[lastRunEnd];
                    if (lastRunStart[lastRunEnd] == lastRunSt) {
                        long sum = runDpSum[lastRunEnd];
                        dp[i] = (1 + sum) % MOD;
                    } else {
                        long sum = (prefixSum[lastRunEnd + 1] - prefixSum[lastRunSt] + MOD) % MOD;
                        dp[i] = (1 + sum) % MOD;
                    }
                } else {
                    dp[i] = 1;
                }
                lastRunStart[i] = startOfRun[i];
                runDpSum[i] = dp[i];
            } else {
                if (word.charAt(i) != word.charAt(i - 1)) {
                    int lastRunEnd = i - 1;
                    int lastRunSt = startOfRun[lastRunEnd];
                    if (lastRunStart[lastRunEnd] == lastRunSt) {
                        long sum = runDpSum[lastRunEnd];
                        dp[i] = (1 + sum) % MOD;
                    } else {
                        long sum = (prefixSum[lastRunEnd + 1] - prefixSum[lastRunSt] + MOD) % MOD;
                        dp[i] = (1 + sum) % MOD;
                    }
                    lastRunStart[i] = startOfRun[i];
                    runDpSum[i] = (runDpSum[startOfRun[i]] + dp[i]) % MOD;
                } else {
                    dp[i] = 1;
                    if (startOfRun[i] == i) {
                        runDpSum[i] = dp[i];
                    } else {
                        runDpSum[i] = (runDpSum[i - 1] + dp[i]) % MOD;
                    }
                    lastRunStart[i] = lastRunStart[i - 1];
                }
            }
            prefixSum[i + 1] = (prefixSum[i] + dp[i]) % MOD;
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (endOfRun[i] == n - 1) {
                if (i == 0) {
                    total = (total + dp[i]) % MOD;
                } else if (word.charAt(i) != word.charAt(i - 1)) {
                    total = (total + dp[i]) % MOD;
                } else if (startOfRun[i] == i) {
                    total = (total + dp[i]) % MOD;
                }
            }
        }

        return (int) total;
    }

}
