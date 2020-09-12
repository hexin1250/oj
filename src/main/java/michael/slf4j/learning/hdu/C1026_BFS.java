package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class C1026_BFS {
	public static class BroadSearch {
		private static int[][] choices = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		private Maze maze;
		private Queue<Status> q;
		private Set<Status> mem = new HashSet<>();

		public BroadSearch(Maze maze) {
			this.maze = maze;
			this.q = new LinkedBlockingDeque<>();
		}

		public void bfs() {
			Status initStatus = new Status(0, 0, 0, 0, null);
			q.add(initStatus);
			Status endStatus = null;
			while (!q.isEmpty()) {
				Status currentStatus = q.poll();
				if (maze.isEnd(currentStatus)) {
					endStatus = currentStatus;
				}
				extend(currentStatus);
			}
			if (endStatus != null) {
				System.out.println(
						String.format("It takes %d seconds to reach the target position, let me show you the way.",
								endStatus.totalTime));
				print(endStatus);
				System.out.println("FINISH");
			} else {
				System.out.println("God please help our poor hero.");
				System.out.println("FINISH");
			}
		}

		private void extend(Status currentStatus) {
			char currentPoint = maze.map[currentStatus.x][currentStatus.y];
			if (currentPoint == '.' || currentStatus.cost == currentPoint - '0') {
				for (int i = 0; i < choices.length; i++) {
					Status nextStatus = new Status(currentStatus.x + choices[i][0], currentStatus.y + choices[i][1], 0,
							currentStatus.totalTime + 1, currentStatus);
					if (!maze.isValid(nextStatus)) {
						continue;
					}
					if (mem.contains(nextStatus)) {
						continue;
					}
					nextStatus.setCurrentInfo(String.format("%ds:(%d,%d)->(%d,%d)", nextStatus.totalTime,
							currentStatus.x, currentStatus.y, nextStatus.x, nextStatus.y));
					q.add(nextStatus);
					mem.add(nextStatus);
				}
			} else {
				Status nextStatus = new Status(currentStatus.x, currentStatus.y, currentStatus.cost + 1,
						currentStatus.totalTime + 1, currentStatus);
				if (mem.contains(nextStatus)) {
					return;
				}
				nextStatus.setCurrentInfo(
						String.format("%ds:FIGHT AT (%d,%d)", nextStatus.totalTime, currentStatus.x, currentStatus.y));
				q.add(nextStatus);
				mem.add(nextStatus);
			}
		}

		private static void print(Status status) {
			if (status == null)
				return;
			if (status.totalTime == 0)
				return;
			print(status.previousStatus);
			System.out.println(status.getCurrentInfo());
		}
	}

	public static class Maze {
		private int x;
		private int y;
		public char[][] map;

		public Maze(int x, int y, char[][] map) {
			this.x = x;
			this.y = y;
			this.map = map;
		}

		public boolean isValid(Status status) {
			if (status.x < 0 || status.x >= this.x || status.y < 0 || status.y >= this.y
					|| map[status.x][status.y] == 'X') {
				return false;
			}
			return true;
		}

		public boolean isEnd(Status status) {
			int x = status.x;
			int y = status.y;
			char point = map[x][y];
			if (x == this.x - 1 && y == this.y - 1) {
				if (point == '.') {
					return true;
				} else if (point != '.' && status.cost == point - '0') {
					return true;
				}
			}
			return false;
		}
	}

	public static class Status {
		private int x;
		private int y;
		private int cost;
		private int totalTime;
		private String currentInfo;
		private Status previousStatus;

		public Status(int x, int y, int cost, int totalTime, Status previousStatus) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.totalTime = totalTime;
			this.previousStatus = previousStatus;
		}

		public String getCurrentInfo() {
			return currentInfo;
		}

		public void setCurrentInfo(String currentInfo) {
			this.currentInfo = currentInfo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cost;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Status)) {
				return false;
			}
			Status s = (Status) obj;
			return s.x == x && s.y == y && s.cost == cost;
		}

		private String info() {
			StringBuffer sb = new StringBuffer();
			sb.append("Point[").append(x).append(',').append(y).append("] cost time:").append(cost)
					.append(" total time:").append(totalTime);
			return sb.toString();
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(info());
			if (previousStatus != null) {
				sb.append(" Previous:").append(previousStatus.info());
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				map[i] = line.toCharArray();
			}
			Maze maze = new Maze(n, m, map);
			BroadSearch bs = new BroadSearch(maze);
			bs.bfs();
		}
		sc.close();
	}

}
