package michael.slf4j.learning.hdu;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class C1072_Nightmare {
	private static final int[][] choices = new int[][] {{0,-1},{0,1},{1,0},{-1,0}};
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int[][] map = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						map[i][j] = sc.nextInt();
					}
				}
				Maze maze = new Maze(n, m, map);
				Process p = new Process(maze);
				p.bfs();
			}
		}
	}
	
	public static class Process {
		private Maze maze;
		private Queue<Status> q;
		private int[][] mem;
		public Process(Maze maze) {
			this.maze = maze;
			q = new LinkedBlockingQueue<>();
			mem = new int[maze.n][maze.m];
		}
		
		public void bfs() {
			Status init = null;
			boolean find = false;
			for (int i = 0; i < maze.n; i++) {
				for (int j = 0; j < maze.m; j++) {
					if(maze.map[i][j] == 2) {
						init = new Status(i, j, 0, 0, 1);
						find = true;
						break;
					}
				}
				if(find) {
					break;
				}
			}
			q.add(init);
			mem[init.x][init.y] = 1;
			Status endStatus = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(isEnd(s)) {
					endStatus = s;
					break;
				}
				if(isBoom(s)) {
					continue;
				}
				expand(s);
			}
			if(endStatus == null) {
				System.out.println(-1);
			} else {
				System.out.println(endStatus.totalCost);
			}
		}
		
		private void expand(Status s) {
			int x = s.x;
			int y = s.y;
			int level = s.level;
			int cost = s.cost;
			int totalCost = s.totalCost;
			for (int i = 0; i < choices.length; i++) {
				int[] choice = choices[i];
				int newX = x + choice[0];
				int newY = y + choice[1];
				if(maze.isValid(newX, newY)) {
					if(mem[newX][newY] >= level) {
						continue;
					}
					int newLevel = level;
					int newCost = cost + 1;
					if(maze.map[newX][newY] == 4 && mem[newX][newY] == 0) {
						newLevel += 1;
						newCost = 0;
					}
					Status nextStatus = new Status(newX, newY, newCost, totalCost + 1, newLevel);
					mem[newX][newY]++;
					q.add(nextStatus);
				}
			}
		}

		private boolean isEnd(Status s) {
			int x = s.x;
			int y = s.y;
			if(maze.map[x][y] == 3) {
				return true;
			}
			return false;
		}
		
		private boolean isBoom(Status s) {
			if(s.cost == 5) {
				return true;
			}
			return false;
		}
		
	}
	
	public static class Maze {
		private int n;
		private int m;
		private int[][] map;
		public Maze(int n, int m, int[][] map) {
			this.n = n;
			this.m = m;
			this.map = map;
		}
		public boolean isValid(int x, int y) {
			if(x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 0) {
				return false;
			}
			return true;
		}
	}
	
	public static class Status {
		public int x;
		public int y;
		public int cost;
		public int totalCost;
		public int level;
		public Status(int x, int y, int cost, int totalCost, int level) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.totalCost = totalCost;
			this.level = level;
		}
		@Override
		public int hashCode() {
			final int prime = 15;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			result = prime * result + level;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Status)) {
				return false;
			}
			Status s = (Status) obj;
			return x == s.x && y == s.y && level == s.level;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(level).append(":[").append(x).append(',').append(y).append("]:")
				.append(cost).append('-').append(totalCost);
			return sb.toString();
		}
	}

}
