package michael.slf4j.learning.leetcode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C329 {

	public static void main(String[] args) {
	}
	
	private Map<Point, Integer> cache = new HashMap<>();

	public int longestIncreasingPath(int[][] matrix) {
		Set<Point> mem = new HashSet<>();
		return traversal(matrix, mem);
	}
	
	private int traversal(int[][] matrix, Set<Point> mem) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			int[] cols = matrix[i];
			for (int j = 0; j < cols.length; j++) {
				Point x = new Point(i, j);
				mem.add(x);
				int currentPath = 0;
				if(cache.containsKey(x)) {
					currentPath = cache.get(x);
				} else {
					currentPath = findLongest(matrix, mem, x);
					cache.put(x, currentPath);
				}
				if(currentPath > max) {
					max = currentPath;
				}
				mem.remove(x);
			}
		}
		return max + 1;
	}

	private int findLongest(int[][] matrix, Set<Point> mem, Point start) {
		int max = 0;
		List<Point> validPoints = getPoint(matrix, mem, start);
		for (Point x : validPoints) {
			int currentPath = 0;
			if(cache.containsKey(x)) {
				currentPath = cache.get(x);
			} else {
				currentPath = findLongest(matrix, mem, x);
				cache.put(x, currentPath);
			}
			if(currentPath > max) {
				max = currentPath;
			}
			mem.remove(x);
		}
		return max + 1;
	}
	
	private List<Point> getPoint(int[][] matrix, Set<Point> mem, Point start){
		List<Point> ret = new ArrayList<>();
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int x = start.x;
		int y = start.y;
		int val = matrix[x][y];
		if(x - 1 >= 0) {
			Point p = new Point(x - 1, y);
			if(valid(matrix, val, mem, p)) {
				ret.add(p);
			}
		}
		if(y - 1 >= 0) {
			Point p = new Point(x, y - 1);
			if(valid(matrix, val, mem, p)) {
				ret.add(p);
			}
		}
		if(x + 1 < rowLen) {
			Point p = new Point(x + 1, y);
			if(valid(matrix, val, mem, p)) {
				ret.add(p);
			}
		}
		if(y + 1 < colLen) {
			Point p = new Point(x, y + 1);
			if(valid(matrix, val, mem, p)) {
				ret.add(p);
			}
		}
		return ret;
	}
	
	private boolean valid(int[][] matrix, int val, Set<Point> mem, Point p) {
		int nextVal = matrix[p.x][p.y];
		return !mem.contains(p) && nextVal > val;
	}

}
