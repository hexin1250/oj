package michael.slf4j.learning.leetcode;

public class C357 {

	public static void main(String[] args) {
	}

	public int countNumbersWithUniqueDigits(int n) {
		if(n == 0) {
			return 1;
		}
		int sum = 10;
		int multi = 9;
		for (int i = 0; i < n - 1; i++) {
			multi *= (9 - i);
			sum += multi;
		}
		return sum;
	}

}
