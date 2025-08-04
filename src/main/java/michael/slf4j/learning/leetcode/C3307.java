package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C3307 {

	public static void main(String[] args) {
		C3307 c = new C3307();
//		long k = 3;
//		int[] operations = new int[] {1,0};
		long k = 5;
		int[] operations = new int[] {0,0,0};
		System.out.println(c.kthCharacter(k, operations));
	}
	
	public char kthCharacter(long k, int[] operations) {
//		if(k == 1) {
//			return 'a';
//		}
		long ret = k;
		List<Long> list = new ArrayList<>();
		while(ret > 1) {
			list.add(ret);
			long lastDepth = getIndex(ret);
			ret -= lastDepth;
		} 
		list.add(1L);
		Collections.sort(list);
		System.out.println(list);
		int size = list.size();
		int count = 0;
		for (int i = 0; i < operations.length && i < size; i++) {
			if(operations[i] == 1) {
				count++;
			}
		}
		count = count % 26;
		return (char)('a' + count);
	}
	
	private long getIndex(long k) {
		long prev = 0;
		long index = 1;
		while(k > index) {
			prev = index;
			index *= 2;
		}
		return prev;
	}

}
