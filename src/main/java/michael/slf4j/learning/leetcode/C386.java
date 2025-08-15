package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C386 {

	public static void main(String[] args) {
		C386 c = new C386();
		List<Integer> ret = c.lexicalOrder(2);
		for (Integer i : ret) {
			System.out.println(i);
		}
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> ret = new ArrayList<>();
		int depth = getNum(n);
		for (int i = 1; i <= 9; i++) {
			if(i > n) {
				break;
			}
			ret.add(i);
			if(depth > 1) {
				traversal(ret, n, depth, 2, i);
			}
		}
		return ret;
	}
	
	private void traversal(List<Integer> list, int n, int depth, int currentDepth, int start) {
		int original = start * 10;
		for (int i = 0; i <= 9; i++) {
			int newStart = original + i;
			if(depth > currentDepth) {
				list.add(newStart);
				traversal(list, n, depth, currentDepth + 1, newStart);
			} else {
				if(newStart > n) {
					break;
				}
				list.add(newStart);
			}
		}
	}

	private int getNum(int n) {
		int len = 0;
		while(n > 0) {
			len++;
			n /= 10;
		}
		return len;
	}

}
