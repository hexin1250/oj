package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1254 {
	private static final int[][] choices = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				int[][] maze = new int[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						maze[i][j] = sc.nextInt();
					}
				}
				PushBox pb = new PushBox(m, n, maze);
				pb.bfs();
			}
		}
	}
	
	public static class PushBox {
		private int m;
		private int n;
		private int[][] maze;
		private MovePlayer mp;
		private Set<Integer> mem;
		private Queue<Status> q;
		public PushBox(int m, int n, int[][] maze) {
			this.m = m;
			this.n = n;
			this.maze = maze;
			mp = new MovePlayer(m, n, maze, null);
			mem = new HashSet<>();
			q = new LinkedBlockingQueue<>();
		}
		
		public void bfs() {
			int[] box = null;
			int[] player = null;
			int[] target = null;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(maze[i][j] == 2) {
						box = new int[] {i, j};
					} else if(maze[i][j] == 3) {
						target = new int[] {i, j};
					} else if(maze[i][j] == 4) {
						player = new int[] {i, j};
						maze[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int x = box[0] + choices[i][0];
				int y = box[1] + choices[i][1];
				if(x < 0 || x >= m || y < 0 || y >= n) {
					continue;
				}
				if(maze[x][y] == 1) {
					continue;
				}
				int[] nextBox = new int[] {box[0] * 2 - x, box[1] * 2 - y};
				if(nextBox[0] < 0 || nextBox[0] >= m || nextBox[1] < 0 || nextBox[1] >= n) {
					continue;
				}
				if(maze[nextBox[0]][nextBox[1]] == 1) {
					continue;
				}
				int[] playerTarget = new int[] {x,y};
				mp.reset(box);
				if(!mp.bfs(player, playerTarget)) {
					continue;
				}
				Status nextStatus = new Status(box, playerTarget);
				if(mem.contains(nextStatus.hashCode())) {
					continue;
				}
				nextStatus.setTotalCost(0);
				nextStatus.genPath();
				nextStatus.setParent(null);
				q.add(nextStatus);
				mem.add(nextStatus.hashCode());
			}
			Status endStatus = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				int[] currentBox = s.getBox();
				if(currentBox[0] == target[0] && currentBox[1] == target[1]) {
					endStatus = s;
					break;
				}
				expand(s);
			}
			if(endStatus == null) {
				System.out.println(-1);
			} else {
				System.out.println(endStatus.getTotalCost());
			}
		}

		private void expand(Status s) {
			int[] nextPlayer = s.getBox();
			int[] currentPlayer = s.getPlayer();
			int[] box = new int[] {nextPlayer[0] * 2 - currentPlayer[0], nextPlayer[1] * 2 - currentPlayer[1]};
			
			for (int i = 0; i < 4; i++) {
				int x = box[0] + choices[i][0];
				int y = box[1] + choices[i][1];
				if(x < 0 || x >= m || y < 0 || y >= n) {
					continue;
				}
				int[] playerTarget = new int[] {x,y};
				if(maze[x][y] == 1) {
					continue;
				}
				int[] nextBox = new int[] {box[0] * 2 - x, box[1] * 2 - y};
				if((maze[box[0]][box[1]] != 3)) {
					if(nextBox[0] < 0 || nextBox[0] >= m || nextBox[1] < 0 || nextBox[1] >= n) {
						continue;
					}
					if(maze[nextBox[0]][nextBox[1]] == 1) {
						continue;
					}
				}
				mp.reset(box);
				if(!mp.bfs(nextPlayer, playerTarget)) {
					continue;
				}
				Status nextStatus = new Status(box, playerTarget);
				if(mem.contains(nextStatus.hashCode())) {
					continue;
				}
				nextStatus.setTotalCost(s.getTotalCost() + 1);
				nextStatus.setParent(s);
				nextStatus.genPath();
				q.add(nextStatus);
				mem.add(nextStatus.hashCode());
			}
		}
		
	}
	
	public static class MovePlayer {
		private int m;
		private int n;
		private int[][] maze;
		private Queue<Status> q;
		private Set<Integer> mem;
		private int[] box;
		public MovePlayer(int m, int n, int[][] maze, int[] box) {
			this.m = m;
			this.n = n;
			this.maze = maze;
			this.box = box;
			q = new LinkedBlockingQueue<>();
			mem = new HashSet<>();
		}
		
		public boolean bfs(int[] start, int[] target) {
			Status init = new Status(new int[] {0, 0}, start);
			q.add(init);
			while(!q.isEmpty()) {
				Status s = q.poll();
				int[] current = s.getPlayer();
				if(current[0] == target[0] && current[1] == target[1]) {
					return true;
				}
				expand(s);
			}
			return false;
		}
		
		public void expand(Status s) {
			int[] current = s.getPlayer();
			for (int i = 0; i < 4; i++) {
				int[] newPosition = new int[2];
				int x = current[0] + choices[i][0];
				int y = current[1] + choices[i][1];;
				if(x < 0 || x >= m || y < 0 || y >= n) {
					continue;
				}
				if(maze[x][y] == 1 || (box[0] == x && box[1] == y)) {
					continue;
				}
				newPosition[0] = x;
				newPosition[1] = y;
				Status nextStatus = new Status(new int[] {0, 0}, newPosition);
				if(mem.contains(nextStatus.hashCode())) {
					continue;
				}
				mem.add(nextStatus.hashCode());
				q.add(nextStatus);
			}
		}
		
		public void reset(int[] box) {
			this.box = box;
			q.clear();
			mem.clear();
		}
	}
	
	public static class Status {
		private int[] box;
		private int[] player;
		private int totalCost;
		private String path;
		private Status parent;
		private Status(int[] box, int[] player) {
			this.box = box;
			this.player = player;
		}
		public int[] getBox() {
			return box;
		}
		public int[] getPlayer() {
			return player;
		}
		public int getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(int totalCost) {
			this.totalCost = totalCost;
		}
		public Status getParent() {
			return parent;
		}
		public void setParent(Status parent) {
			this.parent = parent;
		}
		public String getPath() {
			return path;
		}
		public void genPath() {
			StringBuffer sb = new StringBuffer();
			if(parent != null) {
				sb.append(parent.getPath());
				sb.append("->");
			}
			sb.append(toString());
			this.path = sb.toString();
		}
		@Override
		public int hashCode() {
			int hash = box[0];
			hash += hash * 7 + box[1];
			hash += hash * 7 + player[0];
			hash += hash * 7 + player[1];
			return hash;
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
			sb.append("Player:[").append(player[0]).append(',').append(player[1]).append(']');
			sb.append(" Box:[").append(box[0]).append(',').append(box[1]).append(']');
			return sb.toString();
		}
	}

}
