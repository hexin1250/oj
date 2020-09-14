package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1067_Gap {
	private static final int BIT = 3;
	private static final int h = 4;
	private static final int w = 8;

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			while(testcase-- > 0){
				Map<Integer, Position> positionMap = new HashMap<>();
				int[][] arr = new int[h][w];
				for (int i = 0; i < h; i++) {
					for (int j = 1; j < w; j++) {
						arr[i][j] = sc.nextInt();
						positionMap.put(arr[i][j], new Position(i, j));
					}
				}
				Maze maze = new Maze(arr);
				Process p = new Process(maze, positionMap);
				System.out.println(p.calc());
				p.close();
			}
		}
	}
	
	public static class Process {
		private Maze maze;
		private Map<Integer, Position> positionMap;
		private List<Position> emptySet = new ArrayList<>();
		private int status;
		private Map<String, Integer> mem = new HashMap<>();
		
		public Process(Maze maze, Map<Integer, Position> positionMap){
			this.maze = maze;
			this.positionMap = positionMap;
			init();
			this.status = maze.status();
		}
		
		public int calc() {
			return bfs(emptySet, status, 0, -1);
		}
		
		private int bfs(List<Position> emptySet, int status, int cost, int min) {
			/**
			 * 全部棋子在所在位置结束
			 */
			if(status == 0) {
				return 0;
			}
			/**
			 * 盘面没有移动的位置结束
			 */
			boolean noChoice = true;
			for (Position p : emptySet) {
				int x = p.x;
				int y = p.y;
				if(!(maze.map[x][y - 1] == 29 || maze.map[x][y - 1] % 10 == 7)) {
					noChoice = false;
					break;
				}
			}
			if(noChoice) {
				return -1;
			}
			/**
			 * 当前步数超过已知的最小步数，剪枝结束
			 */
			if(min != -1 && cost >= min) {
				return -1;
			}
			String hash = maze.myHashCode();
			if(mem.get(hash) != null) {
				int ret = mem.get(hash);
				return ret;
			}
			List<Position> tmpSet = new ArrayList<>();
			Collections.sort(emptySet, new Comparator<Position>() {
				@Override
				public int compare(Position o1, Position o2) {
					if(o1.x < o2.x) {
						return -1;
					} else if(o1.x > o2.x) {
						return 1;
					}
					if(o1.y < o2.y) {
						return -1;
					}
					return 1;
				}
			});
			tmpSet.addAll(emptySet);
			int currentMin = -1;
			for (Position p : emptySet) {
				int x = p.x;
				int y = p.y;
				int prevN = maze.map[x][y - 1];
				if(prevN == 29 || prevN % 10 == 7) {
					continue;
				}
				int targetN = prevN + 1;
				
				tmpSet.remove(p);
				Position targetP = positionMap.remove(targetN);
				/**
				 * 交换当前empty position和targetP
				 */
				boolean prevStatus = maze.isInPosition(targetN, targetP.x, targetP.y);
				maze.map[x][y] = targetN;
				maze.map[targetP.x][targetP.y] = 29;
				/**
				 * 判断移动之后是否在正确的位置上
				 */
				if(maze.isInPosition(targetN, x, y)) {
					status--;
				} else if(prevStatus) {
					status++;
				}
				positionMap.put(targetN, new Position(x, y));
				/**
				 * 判断新的空位是否能够放置数字
				 */
				tmpSet.add(targetP);
				/**
				 * 深度优先遍历
				 */
				int remain = -1;
				int nextMin = currentMin == -1 ? -1 : currentMin + cost + 1;
				remain = bfs(tmpSet, status, cost + 1, nextMin);
				if(remain != -1) {
					if(currentMin == -1 || remain < currentMin) {
						currentMin = remain;
					}
				}
				/**
				 * 回滚之前的操作
				 */
				tmpSet.remove(targetP);
				positionMap.remove(targetN);
				if(maze.isInPosition(targetN, x, y)) {
					status++;
				} else if(prevStatus) {
					status--;
				}
				maze.map[x][y] = 29;
				maze.map[targetP.x][targetP.y] = targetN;
				positionMap.put(targetN, targetP);
				tmpSet.add(p);
				
				if(mem.get(hash) != null) {
					return mem.get(hash);
				}
			}
			int ret = currentMin;
			if(currentMin != -1) {
				ret = currentMin + 1;
			}
			mem.put(hash, ret);
			return ret;
		}
		
		private void init() {
			Position p1 = positionMap.remove(11);
			maze.map[0][0] = 11;
			maze.map[p1.x][p1.y] = 29;
			emptySet.add(p1);
			positionMap.put(11, new Position(0, 0));
			
			Position p2 = positionMap.remove(21);
			maze.map[1][0] = 21;
			maze.map[p2.x][p2.y] = 29;
			emptySet.add(p2);
			positionMap.put(21, new Position(1, 0));
			
			Position p3 = positionMap.remove(31);
			maze.map[2][0] = 31;
			maze.map[p3.x][p3.y] = 29;
			emptySet.add(p3);
			positionMap.put(31, new Position(2, 0));
			
			Position p4 = positionMap.remove(41);
			maze.map[3][0] = 41;
			maze.map[p4.x][p4.y] = 29;
			emptySet.add(p4);
			positionMap.put(41, new Position(3, 0));
		}
		
		public void close() {
			this.emptySet.clear();
			this.positionMap.clear();
			this.maze = null;
			this.mem.clear();
		}
	}

	public static class Maze {
		public int[][] map;
		public Maze(int[][] map) {
			this.map = map;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Maze)) {
				return false;
			}
			Maze m = (Maze) obj;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(this.map[i][j] != m.map[i][j]) {
						return false;
					}
				}
			}
			return true;
		}
		public Maze copy() {
			int[][] ret = new int[h][w];
			for (int i = 0; i < h; i++) {
				ret[i] = map[i];
			}
			return new Maze(ret);
		}
		public int status(){
			int status = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w - 1; j++) {
					int n = map[i][j];
					if(!isInPosition(n, i, j)){
						status++;
					}
				}
			}
			return status;
		}
		public boolean isInPosition(int n, int tx, int ty){
			if(n == 29) {
				return false;
			}
			int x = n / 10;
			int y = n % 10;
			return (x - 1 == tx && y - 1 == ty);
		}
		public String myHashCode() {
			int[] total = new int[] {0};
			for (int i = h - 1; i >= 0; i--) {
				total = multiply(total, new int[] {0,5,2});
				int sum = 0;
				for (int j = 0; j < w; j++) {
					sum *= 8;
					sum += decode(map[i][j]);
				}
				total = plus(total, nOfArray(sum));
			}
			return getHashKey(total);
		}
		private int decode(int n) {
			if(n != 29) {
				return (n / 10 - 1) * 7 + n % 10;
			}
			return 29;
		}
	}
	
	public static class Position {
		public int x;
		public int y;
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null){
				return false;
			}
			if(!(obj instanceof Position)){
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public int hashCode() {
			return x * 100 + y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public static String getHashKey(int[] arr) {
		StringBuffer sb = new StringBuffer();
		boolean start = false;
		for (int i = arr.length - 1; i >= 0; i--) {
			if(!start && arr[i] == 0) {
				continue;
			} else {
				start = true;
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}
	
	public static int[] multiply(int[] a, int[] b) {
		int[] ret = new int[a.length + b.length];
		for (int i = 0; i < a.length; i+=BIT) {
			int numberI = getNumber(a, i, BIT);
			for (int j = 0; j < b.length; j+=BIT) {
				int numberJ = getNumber(b, j, BIT);
				ret[i + j] += numberI * numberJ;
			}
		}
		for (int i = 0; i < a.length + b.length - 1; i++) {
			if(ret[i] / 10 > 0) {
				ret[i + 1] += ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		return ret;
	}

	private static int getNumber(int[] a, int start, int bit) {
		int sum = 0;
		int initP = (start + bit) > a.length ? a.length : (start + bit);
		for (int i = initP - 1; i >= start; i--) {
			sum *= 10;
			sum += a[i];
		}
		return sum;
	}
	
	private static int[] nOfArray(int a) {
		int index = 0;
		int[] a1 = new int[10];
		while(a / 10 > 0) {
			if(a / 10 > 0) {
				a1[index] = a % 10;
				a = a / 10;
			}
			index++;
		}
		a1[index++] = a;
		return Arrays.copyOf(a1, index);
	}
	
	public static int[] plus(int[] a, int[] b) {
		int length = a.length > b.length ? a.length + 1 : b.length + 1;
		int[] ret = new int[length];
		for (int i = 0; i < length; i++) {
			if(i < a.length) {
				ret[i] += a[i];
			}
			if(i < b.length) {
				ret[i] += b[i];
			}
			if(ret[i] >= 10) {
				ret[i + 1] = ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		return ret;
	}

}
