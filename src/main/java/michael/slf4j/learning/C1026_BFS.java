package michael.slf4j.learning;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class C1026_BFS {

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
		}
		sc.close();
	}

}

class BroadSearch{
	private static int[][] choices = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
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
		while(!q.isEmpty()) {
			Status currentStatus = q.poll();
			
		}
	}
}

class Maze {
	private int x;
	private int y;
	public char[][] map;
	public Maze(int x, int y, char[][] map) {
		this.x = x;
		this.y = y;
		this.map = map;
	}
	
	public boolean isValid(int x, int y) {
		if(x < 0 || x >= this.x || y < 0 || y >= this.y) {
			return false;
		}
		return true;
	}
	
	public boolean isEnd(int x, int y) {
		if(x == this.x - 1 && y == this.y - 1) {
			return true;
		}
		return false;
	}
}

class Status {
	private int x;
	private int y;
	private int cost;
	private int totalTime;
	private Status previousStatus;
	public Status(int x, int y, int cost, int totalTime, Status previousStatus) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.totalTime = totalTime;
		this.previousStatus = previousStatus;
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
		if(!(obj instanceof Status)) {
			return false;
		}
		Status s = (Status) obj;
		boolean isSame = s.x == x && s.y == y && s.cost == cost && s.totalTime == totalTime;
		if(!isSame) {
			return false;
		}
		return (s.previousStatus == null && previousStatus == null) || s.previousStatus.equals(previousStatus);
	}
	@Override
	public String toString() {
		return super.toString();
	}
}