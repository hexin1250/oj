package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C118 {

	public static void main(String[] args) {
		C118 c = new C118();
		System.out.println(c.generate(5));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(List.of(1));
		if(numRows >= 2) {
			ret.add(List.of(1, 1));
		}
		for (int n = 2; n < numRows; n++) {
			int mid = n / 2;
			List<Integer> rowList = new ArrayList<>();
			List<Integer> lastRowList = ret.get(n - 1);
			for (int j = 0; j <= mid; j++) {
				if(j == 0) {
					rowList.add(1);
				} else {
					rowList.add(lastRowList.get(j) + lastRowList.get(j - 1));
				}
			}
			for (int j = mid + 1; j <= n; j++) {
				int offset = n - j;
				rowList.add(rowList.get(offset));
			}
			ret.add(rowList);
		}
		return ret;
	}

}
