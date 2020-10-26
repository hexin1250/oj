package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1242_Rescue {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				sc.nextLine();
				char[][] maze = new char[m][n];
				for (int i = 0; i < m; i++) {
					maze[i] = sc.nextLine().toCharArray();
				}
				FindFriend ff = new FindFriend(m, n, maze);
				ff.bfs();
			}
		}
	}
	
	public static class FindFriend {
		private static final int[][] choices = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
		
		private int m;
		private int n;
		private char[][] maze;
		private Set<Status> mem;
		private Queue<Status> q;
		public FindFriend(int m, int n, char[][] maze) {
			this.m = m;
			this.n = n;
			this.maze = maze;
			mem = new HashSet<>();
			q = new LinkedBlockingQueue<>();
		}
		public void bfs() {
			int startX = -1;
			int startY = -1;
			int endX = -1;
			int endY = -1;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(maze[i][j] == 'a') {
						endX = i;
						endY = j;
					}
					if(maze[i][j] == 'r') {
						startX = i;
						startY = j;
					}
				}
			}
			Status init = new Status(startX, startY, 0);
			q.add(init);
			mem.add(init);
			Status end = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(s.getX() == endX && s.getY() == endY) {
					end = s;
					break;
				}
				expand(s);
			}
			if(end == null) {
				System.out.println("Poor ANGEL has to stay in the prison all his life.");
			} else {
				System.out.println(end.getTotalCost());
			}
		}
		public void expand(Status s) {
			if(s.cost > 0) {
				s.killGuard();
				q.add(s);
				return;
			}
			int x = s.getX();
			int y = s.getY();
			int totalCost = s.getTotalCost();
			for (int i = 0; i < choices.length; i++) {
				int[] choice = choices[i];
				int newX = choice[0] + x;
				int newY = choice[1] + y;
				if(newX < 0 || newX >= m || newY < 0 || newY >= n) {
					continue;
				}
				if(maze[newX][newY] == '#') {
					continue;
				}
				Status nextS = new Status(newX, newY, totalCost + 1);
				if(mem.contains(nextS)) {
					continue;
				}
				if(maze[newX][newY] == 'x') {
					nextS.setCost(1);
				}
				q.add(nextS);
				mem.add(nextS);
			}
		}
	}
	
	public static class Status {
		private int x;
		private int y;
		private int cost;
		private int totalCost;
		public Status(int x, int y, int totalCost) {
			this.x = x;
			this.y = y;
			this.totalCost = totalCost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getCost() {
			return cost;
		}
		public int getTotalCost() {
			return totalCost;
		}
		public void killGuard() {
			cost--;
			totalCost++;
		}
		@Override
		public int hashCode() {
			return x * 200 + y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Status)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			if(cost > 0) {
				sb.append("Kill guard at ");
			} else {
				sb.append("Walk through ");
			}
			sb.append("[").append(x).append(",").append(y).append("]");
			return sb.toString();
		}
	}

}
