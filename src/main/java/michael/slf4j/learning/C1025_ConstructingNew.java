package michael.slf4j.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1025_ConstructingNew {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = 0;
		while (sc.hasNext()) {
			testcase++;
			int count = sc.nextInt();
			sc.nextLine();
			int[] positionRArr = new int[count];
			Map<Integer, Integer> citiLMap = new HashMap<>();
			for (int i = 1; i <= count; i++) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				
				int citiL = Integer.valueOf(parts[0]);
				citiLMap.put(citiL, i);
				positionRArr[i - 1] = Integer.valueOf(parts[1]);
			}
			int[] seq = new int[count];
			for (int i = 0; i < count; i++) {
				seq[i] = citiLMap.get(positionRArr[i]);
			}
			int roads = findRoads(seq);
			System.out.printf("Case %d:", testcase);
			System.out.println();
			if(roads > 1) {
				System.out.printf("My king, at most %d roads can be built.", roads);
			} else {
				System.out.printf("My king, at most %d road can be built.", roads);
			}
			System.out.println();
			System.out.println();
		}
		sc.close();
	}
	
	public static int findRoads(int[] seq) {
		int totalLength = 1;
		int index = 0;
		int length = seq.length;
		int[] ret = new int[length];
		ret[index] = seq[0];
		for (int i = 1; i < length; i++) {
			int currentNumber = seq[i];
			if(currentNumber > ret[index]) {
				index++;
				ret[index] = currentNumber;
				if(index + 1 > totalLength) {
					totalLength = index + 1;
				}
			} else {
				int find = FindRoad.$.searchFirstLarge(ret, currentNumber, 0, index);
				ret[find] = currentNumber;
				index = find;
			}
		}
		return totalLength;
	}

}

enum FindRoad {
	$;

	public int searchFirstLarge(int[] ret, int find, int start, int end) {
		if(start > end) {
			return start;
		}
		int mid = (start + end) / 2;
		if(find < ret[mid]) {
			if(start == mid) {
				return start;
			}
			return searchFirstLarge(ret, find, start, mid);
		} else {
			if(end == mid + 1) {
				return end;
			}
			return searchFirstLarge(ret, find, mid, end);
		}
	}
}
