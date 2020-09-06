package michael.slf4j.learning;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Check {

	Set<Status> set;

	public Check(int xCount, int yCount, int timeCount) {
		set = new HashSet<Status>();
	}

	public void add(Status status) {
		set.add(status);
	}

	public boolean isExists(Status status) {
		return set.contains(status);
	}

}

class Maze {
	char[][] map;
	private int xCount;
	private int yCount;

	public Maze(int xCount, int yCount, Scanner scan) {
		this.xCount = xCount;
		this.yCount = yCount;
		map = new char[xCount][yCount];
		for (int y = 0; y < yCount; y++) {
			String temp = scan.next();
			for (int x = 0; x < xCount; x++)
				map[x][y] = temp.charAt(x);
		}
	}

	public boolean isIllegal(int x, int y) {
		if (x < 0 || x >= xCount)
			return false;
		if (y < 0 || y >= yCount)
			return false;
		if (map[x][y] == 'X')
			return false;
		return true;
	}
}

class Status {
	int x, y, totaltime, costtime;
	Status parent;
	String expandType;

	public Status(int x, int y, int time, int costTime) {
		this.x = x;
		this.y = y;
		this.totaltime = time;
		this.costtime = costTime;
	}

	@Override
	public String toString() {
		return "Status [x=" + x + ", y=" + y + ", totaltime=" + totaltime
				+ ", costtime=" + costtime + ", parent=" + parent
				+ ", expandType=" + expandType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costtime;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (costtime != other.costtime)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

public class AC1026 {
	private static Queue<Status> queue;
	private static Check checker;
	private static Maze maze;
	private static int xCount, yCount, timeCount;

	private static boolean isEnd(Status status) {
		if (maze.map[xCount - 1][yCount - 1] == '.')
			return (status.x == xCount - 1 && status.y == yCount - 1);
		else
			return (status.x == xCount - 1 && status.y == yCount - 1 && status.costtime == maze.map[status.x][status.y] - '0');

	}

	private static void extend(Status currentStatus) {
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };

		if (maze.map[currentStatus.x][currentStatus.y] == '.'
				|| currentStatus.costtime == maze.map[currentStatus.x][currentStatus.y] - '0') {
			for (int dir = 0; dir < 4; dir++) {
				Status nextStatus = new Status(currentStatus.x + dx[dir],
						currentStatus.y + dy[dir], currentStatus.totaltime + 1,
						0);
				if (!maze.isIllegal(nextStatus.x, nextStatus.y))
					continue;
				if (checker.isExists(nextStatus))
					continue;
				nextStatus.parent = currentStatus;
				nextStatus.expandType = String.format("(%d,%d)->(%d,%d)",
						currentStatus.y, currentStatus.x, nextStatus.y,
						nextStatus.x);
				queue.add(nextStatus);
				checker.add(nextStatus);
			}
		} else if (maze.map[currentStatus.x][currentStatus.y] != '.'
				|| currentStatus.costtime < maze.map[currentStatus.x][currentStatus.y] - '0') {
			Status nextStatus = new Status(currentStatus.x, currentStatus.y,
					currentStatus.totaltime + 1, currentStatus.costtime + 1);
			if (!maze.isIllegal(nextStatus.x, nextStatus.y))
				return;
			if (checker.isExists(nextStatus))
				return;
			nextStatus.parent = currentStatus;
			nextStatus.expandType = String.format("FIGHT AT (%d,%d)",
					currentStatus.y, currentStatus.x);
			queue.add(nextStatus);
			checker.add(nextStatus);
		}
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			yCount = scan.nextInt();
			xCount = scan.nextInt();
			if (xCount == 0 && yCount == 0)
				return;
			queue = new ArrayDeque<Status>();
			checker = new Check(xCount, yCount, timeCount);
			maze = new Maze(xCount, yCount, scan);
			bfs();
		}
	}

	private static void print(Status status) {
		if (status == null)
			return;
		if (status.totaltime == 0)
			return;
		print(status.parent);
		System.out.println(status.totaltime + "s:" + status.expandType);
	}

	private static void bfs() {
		Status initStatus = new Status(0, 0, 0, 0);
		queue.add(initStatus);
		checker.add(initStatus);

		Status endStatus = null;

		while (!queue.isEmpty()) {
			Status currentStatus = queue.poll();
			if (isEnd(currentStatus)) {
				endStatus = currentStatus;
				break;
			}

			extend(currentStatus);
		}

		if (endStatus != null) {
			System.out
					.println(String
							.format("It takes %d seconds to reach the target position, let me show you the way.",
									endStatus.totaltime));
			print(endStatus);
			System.out.println("FINISH");
		} else {
			System.out.println("God please help our poor hero.");
			System.out.println("FINISH");
		}

	}

}