package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1429 {
	private static final int[][] choices = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int t = sc.nextInt();
				sc.nextLine();
				char[][] maze = new char[n][m];
				Point start = null, end = null;
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine();
					for (int j = 0; j < m; j++) {
						maze[i][j] = line.charAt(j);
						if(maze[i][j] == '@') {
							start = new Point(i, j);
						} else if(maze[i][j] == '^') {
							end = new Point(i, j);
						}
					}
				}
				EscapeMaze em = new EscapeMaze(maze, n, m, t);
				em.bfs(start, end);
			}
		}
	}
	
	private static boolean containKey(int hash, char ch) {
		boolean[] keys = new boolean[12];
		for (int i = 0; i < 12; i++) {
			hash = hash % (2 << 12 - i + 1);
			int bit = hash / (2 << 12 - i);
			keys[12 - i - 1] = bit % 2 == 1;
		}
		return keys[ch - 'A'];
	}
	
	private static int addKey(int hash, char ch) {
		int newBit = 2 << (ch - 'a' + 1);
		return hash + newBit;
	}
	
	public static class EscapeMaze {
		private Queue<Status> q;
		private Set<Status> mem;
		private char[][] maze;
		private int n;
		private int m;
		private int time;
		public EscapeMaze(char[][] maze, int n, int m, int time) {
			this.maze = maze;
			this.n = n;
			this.m = m;
			this.time = time;
			mem = new HashSet<>();
			q = new LinkedBlockingQueue<>();
		}
		
		public void bfs(Point start, Point end) {
			Status begin = new Status(start, 0, 0);
			q.add(begin);
			mem.add(begin);
			Status target = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(s.getTime() == time) {
					continue;
				}
				Point current = s.getP();
				if(current.equals(end)) {
					target = s;
					break;
				}
				int path = Math.abs(current.getX() - end.getX()) + Math.abs(current.getY() - end.getY());
				if(path >= time - s.getTime()) {
					continue;
				}
				expand(s);
			}
			if(target != null) {
				System.out.println(target.getTime());
			} else {
				System.out.println(-1);
			}
		}

		private void expand(Status status) {
			Point p = status.getP();
			for (int i = 0; i < 4; i++) {
				int newX = p.getX() + choices[i][0];
				int newY = p.getY() + choices[i][1];
				if(newX < 0 || newX >= n || newY < 0 || newY >= m) {
					continue;
				}
				char ch = maze[newX][newY];
				int keys = status.getKeys();
				if(ch == '*') {
					continue;
				} else if(ch <= 'J' && ch >= 'A') {
					if(!containKey(keys, ch)) {
						continue;
					}
				}
				Point nextP = new Point(newX, newY);
				int newKeys = keys;
				if(ch <= 'j' && ch >= 'a') {
					char targetCh = (char)(ch - 'a' + 'A');
					if(!containKey(keys, targetCh)) {
						newKeys = addKey(newKeys, ch);
					}
				}
				Status nextStatus = new Status(nextP, newKeys, status.getTime() + 1);
				if(mem.contains(nextStatus)) {
					continue;
				}
				q.add(nextStatus);
				mem.add(nextStatus);
			}
		}
	}
	
	public static class Status {
		private int keys;
		private Point p;
		private int time;
		
		public Status(Point p, int keys, int time) {
			this.p = p;
			this.keys = keys;
			this.time = time;
		}

		public Point getP() {
			return p;
		}

		public int getTime() {
			return time;
		}

		public int getKeys() {
			return keys;
		}

		@Override
		public int hashCode() {
			int hash = p.x + p.y * 20;
			hash += keys << 9;
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Status)) {
				return false;
			}
			return obj.hashCode() == hashCode();
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Position:").append(p).append("\n");
			sb.append("Key:").append(keys).append("\n");
			sb.append("Time:").append(time);
			return sb.toString();
		}
	}
	
	public static class Point {
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Point)) {
				return false;
			}
			Point t = (Point) obj;
			return t.x == x && t.y == y;
		}
		@Override
		public String toString() {
			return "[" + x + ":" + y + "]";
		}
	}

}
