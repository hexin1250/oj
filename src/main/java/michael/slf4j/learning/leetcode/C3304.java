package michael.slf4j.learning.leetcode;

public class C3304 {

	public static void main(String[] args) {
		C3304 c = new C3304();
		System.out.println(c.kthCharacter(10));
	}

	public char kthCharacter(int k) {
		int ret = k;
		int count = 0;
		while(ret > 1) {
			int lastDepth = getIndex(ret);
			ret -= lastDepth;
			count++;
		}
		return (char)('a' + count);
	}
	
	private int getIndex(int k) {
		int prev = 0;
		int index = 1;
		while(k > index) {
			prev = index;
			index *= 2;
		}
		return prev;
	}

}
