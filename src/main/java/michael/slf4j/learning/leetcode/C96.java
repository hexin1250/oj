package michael.slf4j.learning.leetcode;

public class C96 {

	public static void main(String[] args) {
		C96 c = new C96();
		for (int i = 1; i <= 19; i++) {
			System.out.println(c.numTrees(i));
		}
	}

	public int numTrees(int n) {
		long ret = 1;
		int index = n;
		for (int i = 2 * n; i > n + 1; i--) {
			ret *= i;
			if(index > 1 && ret % index == 0) {
				ret /= index;
				index--;
			}
		}
		if(index > 1) {
			for (int i = index; i > 1; i--) {
				ret /= i;
			}
		}
		return (int) ret;
	}

}
