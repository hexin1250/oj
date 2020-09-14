package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C1067_Gap {
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
		private Set<Position> emptySet = new HashSet<>();
		private int status;
		private Map<Long, Integer> mem = new HashMap<>();
		
		public Process(Maze maze, Map<Integer, Position> positionMap){
			this.maze = maze;
			this.positionMap = positionMap;
			init();
			this.status = maze.status();
		}
		
		public int calc() {
			return bfs(emptySet, status, 0, -1);
		}
		
		private int bfs(Set<Position> emptySet, int status, int cost, int min) {
			/**
			 * 全部棋子在所在位置结束
			 */
			if(status == 0) {
				return cost;
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
			if(cost >= min && min != -1) {
				return -1;
			}
			long hash = maze.myHashCode();
			if(mem.get(hash) != null) {
				return mem.get(hash);
			}
			Set<Position> tmpSet = new HashSet<>();
			tmpSet.addAll(emptySet);
			int currentMin = min;
			for (Position p : emptySet) {
				int x = p.x;
				int y = p.y;
				int prevN = maze.map[x][y - 1];
				int targetN = prevN + 1;
				if(prevN == 29 || prevN % 10 == 7) {
					continue;
				}
				
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
				int ret = -1;
				ret = bfs(tmpSet, status, cost + 1, currentMin);
				if(ret != -1) {
					if(currentMin == -1 || ret < currentMin) {
						currentMin = ret;
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
			}
			mem.put(hash, currentMin);
			return currentMin;
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
		public long myHashCode() {
			int total = 0;
			for (int i = 0; i < h; i++) {
				total *= 30L;
				int sum = 0;
				for (int j = 0; j < w; j++) {
					sum *= 8;
					sum += decode(map[i][j]);
				}
				total += sum;
			}
			return total;
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


}
