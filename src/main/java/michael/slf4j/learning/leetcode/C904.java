package michael.slf4j.learning.leetcode;

public class C904 {

	public static void main(String[] args) {
		C904 c = new C904();
//		int[] nums = new int[] {0,1,0,0};
		int[] nums = new int[] {1,0,3,4,3};
		System.out.println(c.totalFruit(nums));
	}

	public int totalFruit(int[] fruits) {
		int len = fruits.length;
		if(len <= 2) {
			return len;
		}
		int[][] mem = new int[2][2];
		mem[0][0] = fruits[0];
		mem[0][1] = 1;
		if(fruits[1] == fruits[0]) {
			mem[0][1] = 2;
			mem[1][0] = -1;
		} else {
			mem[1][0] = fruits[1];
			mem[1][1] = 1;
		}
		int max = Math.max(mem[0][1], mem[1][1]);
		int seq = 2;
		for (int i = 2; i < len; i++) {
			if(fruits[i] == mem[1][0]) {
				mem[1][1]++;
			} else if(mem[1][0] == -1) {
				if(fruits[i] == mem[0][0]) {
					mem[0][1]++;
				} else {
					mem[1][0] = fruits[i];
					mem[1][1] = 1;
				}
			} else {
				if(fruits[i] != mem[0][0]) {
					if(seq > max) {
						max = seq;
					}
					seq = mem[1][1];
				}
				mem[0][0] = mem[1][0];
				mem[0][1] = mem[1][1];
				mem[1][0] = fruits[i];
				mem[1][1] = 1;
			}
			seq++;
		}
		return Math.max(max, seq);
	}

}
