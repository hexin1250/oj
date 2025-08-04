package michael.slf4j.learning.leetcode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class C51Queen {

	public static void main(String[] args) {
		int n = 5;
		C51Queen c = new C51Queen();
		List<List<String>> ret = c.solveNQueens(n);
		for (List<String> list : ret) {
			for (String line : list) {
				System.out.println(line);
			}
			System.out.println();
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		if(n == 1) {
			ret.add(List.of("Q"));
			return ret;
		}
		if(n <= 3) {
			return ret;
		}
		Set<PositionResult> arrSet = new TreeSet<>();
		int[][] arr = new int[n][n];
		List<int[]> possiblePoints = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			possiblePoints.add(new int[] {0, i});
		}
		traverse(arrSet, arr, 0, n, possiblePoints, new ArrayList<Point>());
		
		for (PositionResult pr : arrSet) {
			List<String> subList = new ArrayList<>();
			for (Point p : pr.list) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < p.x; j++) {
					sb.append('.');
				}
				sb.append('Q');
				for (int j = p.x + 1; j < n; j++) {
					sb.append('.');
				}
				subList.add(sb.toString());
			}
			ret.add(subList);
		}
		return ret;
	}

	private void traverse(Set<PositionResult> arrList, int[][] arr, int step, int n, List<int[]> possiblePoints, List<Point> trackList) {
		if(step == n) {
			List<Point> pointList = new ArrayList<Point>();
			for (Point point : trackList) {
				pointList.add(point);
			}
			PositionResult pr = new PositionResult(pointList);
			arrList.add(pr);
			return;
		}
		if(possiblePoints.isEmpty()) {
			return;
		}
		for (int[] point : possiblePoints) {
			int y = point[0];
			int x = point[1];
			arr[y][x] = 1;
			trackList.add(new Point(x, y));
			List<int[]> pointList = new ArrayList<int[]>();
			resume(arr, n, y, x, pointList);
			
			List<int[]> nextPointList = generateNextPointList(arr, y + 1, n);
			traverse(arrList, arr, step + 1, n, nextPointList, trackList);
			trackList.remove(step);
			
			revert(arr, pointList);
			arr[y][x] = 0;
		}
	}
	
	private List<int[]> generateNextPointList(int[][] arr, int y, int n){
		if(y == n) {
			return new ArrayList<>();
		}
		List<int[]> ret = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			if(arr[y][i] == 0) {
				ret.add(new int[] {y, i});
			}
		}
		return ret;
	}

	private void revert(int[][] arr, List<int[]> pointList) {
		for (int[] pointArr : pointList) {
			int y = pointArr[0];
			int x = pointArr[1];
			arr[y][x] = 0;
		}
	}

	private void resume(int[][] arr, int n, int y, int x, List<int[]> pointList) {
		if(y == n - 1) {
			return;
		}
		for (int j = 0; j < n; j++) {
			int x1 = x - (j - y);
			if(x1 >= 0 && x1 < n && arr[j][x1] == 0) {
				arr[j][x1] = 2;
				pointList.add(new int[] {j, x1});
			}
			int x2 = x + (j - y);
			if(x2 >= 0 && x2 < n && arr[j][x2] == 0) {
				arr[j][x2] = 2;
				pointList.add(new int[] {j, x2});
			}
			if(arr[j][x] == 0) {
				arr[j][x] = 2;
				pointList.add(new int[] {j, x});
			}
		}
		for (int i = 0; i < n; i++) {
			if(arr[y][i] == 0 && i != x) {
				arr[y][i] = 2;
				pointList.add(new int[] {y, i});
			}
			if(arr[i][x] == 0 && i != y) {
				arr[i][x] = 2;
				pointList.add(new int[] {i, x});
			}
		}
	}
	
	public static class PositionResult implements Comparable<PositionResult> {
		private List<Point> list = new ArrayList<>();
		
		public PositionResult(List<Point> list) {
			Collections.sort(list, new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					int yRet = o1.y - o2.y;
					if(yRet != 0) {
						return yRet;
					}
					return o1.x - o2.x;
				}
			});
			this.list = list;
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof PositionResult)) {
				return false;
			}
			PositionResult pr2 = (PositionResult) obj;
			List<Point> list2 = pr2.list;
			int len = list.size();
			if(len != list2.size()) {
				return false;
			}
			boolean same = true;
			for (int i = 0; i < len; i++) {
				if(!list.get(i).equals(list2.get(i))) {
					same = false;
					break;
				}
			}
			return same;
		}

		@Override
		public int compareTo(PositionResult p) {
			List<Point> list2 = p.list;
			int len = list.size();
			for (int i = 0; i < len; i++) {
				Point p1 = list.get(i);
				Point p2 = list2.get(i);
				int ret = p1.x - p2.x;
				if(ret != 0) {
					return ret;
				}
			}
			return 0;
		}
	}

}
