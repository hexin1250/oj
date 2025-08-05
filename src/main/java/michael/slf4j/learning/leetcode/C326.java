package michael.slf4j.learning.leetcode;

public class C326 {

	public static void main(String[] args) {
	}

	public boolean isPowerOfThree(int n) {
		if(n <= 0) {
			return false;
		}
		while(n > 1) {
			if(n % 3 == 0) {
				n /= 3;
			} else {
				return false;
			}
		}
		return true;
	}

}
