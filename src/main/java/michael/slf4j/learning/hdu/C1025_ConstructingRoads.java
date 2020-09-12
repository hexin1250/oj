package michael.slf4j.learning.hdu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class C1025_ConstructingRoads {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = 0;
		while (sc.hasNext()) {
			testcase++;
			int count = sc.nextInt();
			sc.nextLine();
			int[] positionLArr = new int[count];
			int[] positionRArr = new int[count];
			Map<Integer, Integer> citiLMap = new LinkedHashMap<>();
			Map<Integer, Integer> citiRMap = new LinkedHashMap<>();
			for (int i = 1; i <= count; i++) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				
				int citiL = Integer.valueOf(parts[0]);
				positionLArr[i - 1] = citiL;
				citiLMap.put(citiL, i);
				int citiR = Integer.valueOf(parts[1]);
				positionRArr[i - 1] = citiR;
				citiRMap.put(citiR, i);
			}
			// mem stack is for citi #
			int roads = findRoads(positionLArr, positionRArr, citiLMap, citiRMap, 1, true, -1);
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

	private static int findRoads(int[] positionLArr, int[] positionRArr, Map<Integer, Integer> citiLMap,
			Map<Integer, Integer> citiRMap, int startPosition, boolean isLeft, int preCity) {
		if (startPosition > positionLArr.length) {
			return 0;
		}
		int tragetCity = positionRArr[startPosition - 1];
		if (isLeft) {
			tragetCity = positionLArr[startPosition - 1];
		}
		boolean findRoad = buildRoad(positionLArr, positionRArr, citiLMap, citiRMap, tragetCity, preCity);
		int roads = 0;
		if (findRoad) {
			int positionL = citiLMap.get(tragetCity);
			int positionR = citiRMap.get(tragetCity);
			boolean nextIsLeft = positionL > positionR;
			int nextPosition = nextIsLeft ? positionL : positionR;
			roads = findRoads(positionLArr, positionRArr, citiLMap, citiRMap, nextPosition + 1, nextIsLeft, tragetCity)
					+ 1;
		}
		int roadsWithoutCurrentPosition = findRoads(positionLArr, positionRArr, citiLMap, citiRMap, startPosition + 1,
				isLeft, preCity);
		return Math.max(roads, roadsWithoutCurrentPosition);
	}

	private static boolean buildRoad(int[] positionLArr, int[] positionRArr, Map<Integer, Integer> citiLMap,
			Map<Integer, Integer> citiRMap, int targetCity, int preCity) {
		if (preCity == -1) {
			return true;
		}
		int targetPositionL = citiLMap.get(targetCity);
		int targetPositionR = citiRMap.get(targetCity);
		int positionL = citiLMap.get(preCity);
		int positionR = citiRMap.get(preCity);
		if ((targetPositionL - positionL) * (targetPositionR - positionR) < 0) {
			return false;
		}
		return true;
	}

}
