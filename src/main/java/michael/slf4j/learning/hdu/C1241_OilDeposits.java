package michael.slf4j.learning.hdu;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class C1241_OilDeposits {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				if(m == 0) {
					break;
				}
				sc.nextLine();
				char[][] maze = new char[m][n];
				for (int i = 0; i < m; i++) {
					String line = sc.nextLine();
					maze[i] = line.toCharArray();
				}
				Detector d = new Detector(m, n, maze);
				d.bfs();
			}
		}
	}
	
	public static class Detector {
		private static final int[][] choices = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		
		private int m;
		private int n;
		private char[][] maze;
		private int[][] mem;
		private Queue<int[]> q;
		public Detector(int m, int n, char[][] maze) {
			this.m = m;
			this.n = n;
			this.maze = maze;
			this.mem = new int[m][n];
			q = new LinkedBlockingQueue<>();
		}
		
		public void bfs() {
			int count = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(mem[i][j] == 1) {
						continue;
					}
					if(maze[i][j] == '*') {
						mem[i][j] = 1;
						continue;
					}
					int[] init = new int[] {i, j};
					q.add(init);
					while(!q.isEmpty()) {
						int[] p = q.poll();
						expand(p);
					}
					count++;
				}
			}
			System.out.println(count);
		}
		
		public void expand(int[] p) {
			int x = p[0];
			int y = p[1];
			for (int i = 0; i < 8; i++) {
				int[] choice = choices[i];
				int xO = choice[0];
				int yO = choice[1];
				int newX = x + xO;
				int newY = y + yO;
				if(newX < 0 || newX >= m || newY < 0 || newY >= n) {
					continue;
				}
				if(mem[newX][newY] == 1) {
					continue;
				}
				mem[newX][newY] = 1;
				if(maze[newX][newY] == '*') {
					continue;
				}
				q.add(new int[] {newX, newY});
			}
		}
		
	}

}
