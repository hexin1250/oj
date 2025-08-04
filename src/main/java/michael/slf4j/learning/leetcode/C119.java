package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C119 {

	public static void main(String[] args) {
	}

	public List<Integer> getRow(int rowIndex) {
		if(rowIndex == 0) {
			return List.of(1);
		} else if(rowIndex == 1) {
			return List.of(1, 1);
		}
		List<Integer> lastRowList = new ArrayList<>();
		lastRowList.add(1);
		lastRowList.add(1);
		for (int n = 2; n <= rowIndex; n++) {
			int mid = n / 2;
			List<Integer> rowList = new ArrayList<>();
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
			lastRowList = rowList;
		}
		return lastRowList;
	}

}
