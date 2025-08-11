package michael.slf4j.learning.leetcode;

public class C343 {

	public static void main(String[] args) {
	}

	public int integerBreak(int n) {
		if(n == 2) {
			return 1;
		} else if(n == 3) {
			return 2;
		}
		int mod = n % 3;
		int target = n;
		int x = mod;
		if(x == 1) {
			x = x + 3;
			target = target - x;
		} else if (x == 2) {
			target = target - x;
		} else {
			x = 1;
		}
		int count = target / 3;
		return (int) (Math.pow(3, count) * x);
	}

}
