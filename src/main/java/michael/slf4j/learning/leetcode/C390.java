package michael.slf4j.learning.leetcode;

public class C390 {

	public static void main(String[] args) {
		C390 c = new C390();
		int n = 979;
		int ret = c.lastRemaining(n);
		System.out.println(ret);
	}
	
	public int lastRemaining(int n) {
		if(n == 1) {
			return 1;
		}
		if(n % 2 == 1) {
			n -= 1;
		}
		int offset = 2;
		int end = n;
		int count = n / 2;
		boolean reverse = true;
		while(count != 1) {
			if(reverse || count % 2 == 1) {
				end -= offset;
			}
			count >>= 1;
			reverse = !reverse;
			offset <<= 1;
		}
		return end;
	}

}
