package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class C1556_Color {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if (n == 0) {
					break;
				}
				Line[] lines = new Line[n];
				for (int i = 0; i < n; i++) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					lines[i] = new Line(start, end);
				}
				check(n, lines);
			}
		}
	}
	
	public static void check(int n, Line[] lines) {
		Arrays.sort(lines, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				if(o1.start < o2.start) {
					return -1;
				} else if(o1.start > o2.start) {
					return 1;
				}
				if(o1.end < o2.end) {
					return 1;
				} else if(o1.end > o2.end) {
					return -1;
				}
				return 0;
			}
		});
		TreeMap<Integer, Point> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			Line line = lines[i];
			int start = line.start;
			int end = line.end;
			Integer floorKey = map.floorKey(start);
			if(floorKey == null) {
				map.put(start, new Point(-1));
			} else {
				int floorKeyInt = floorKey;
				Point floorPoint = map.get(floorKey);
				if(floorKeyInt == start) {
					floorPoint.adjustByProperty(-1);
				} else {
					map.put(start, new Point(-1));
				}
			}
			
			Integer higherKey = map.higherKey(end - 1);
			if(higherKey == null) {
				map.put(end, new Point(1));
			} else {
				int higherKeyInt = higherKey;
				Point higherPoint = map.get(higherKey);
				if(higherKeyInt == end) {
					higherPoint.adjustByProperty(1);
				} else {
					map.put(end, new Point(1));
				}
			}
		}
		int lastPosition = 1;
		int baseCount = 0;
		StringBuffer sb = new StringBuffer();
		for (Entry<Integer, Point> entry : map.entrySet()) {
			int currentPosition = entry.getKey();
			Point p = entry.getValue();
			int direction = p.direction();
			for (int i = lastPosition; i < currentPosition; i++) {
				sb.append(" ").append(baseCount);
			}
			lastPosition = currentPosition + 1;
			if(direction == -1) {
				baseCount += p.startV;
				sb.append(" ").append((baseCount + p.self));
			} else if(direction == 1) {
				sb.append(" ").append((baseCount + p.self));
				baseCount -= p.endV;
			} else {
				sb.append(" ").append((baseCount + p.self));
			}
		}
		for (int i = lastPosition; i <= n; i++) {
			sb.append(" 0");
		}
		String result = sb.toString().replaceFirst(" ", "");
		System.out.println(result);
		if(baseCount != 0) {
			throw new RuntimeException("Base number should be 0!");
		}
	}
	
	private static class Point {
		/**
		 * -1代表开始
		 * 1代表结束
		 * 0代表仅用于自增，对前后数字都没有影响
		 */
		private int self = 0;
		private int startV = 0;
		private int endV = 0;
		public Point(int property) {
			adjustByProperty(property);
		}
		public void adjustByProperty(int property) {
			if(property == -1) {
				startV++;
			} else if(property == 1) {
				endV++;
			} else {
				self++;
			}
			if(startV == endV) {
				self += startV;
				startV = 0;
				endV = 0;
			} else if(startV > endV) {
				startV = startV - endV;
				self += endV;
				endV = 0;
			} else {
				endV = endV - startV;
				self += startV;
				startV = 0;
			}
		}
		public int direction() {
			if(startV > 0) {
				return -1;
			} else if(endV > 0) {
				return 1;
			} else {
				return 0;
			}
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Start:").append(startV).append("-Self:").append(self).append("-End:").append(endV);
			return sb.toString();
		}
	}
	
	public static class Line {
		private int start;
		private int end;
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(start).append(" ").append(end);
			return sb.toString();
		}
	}

}
