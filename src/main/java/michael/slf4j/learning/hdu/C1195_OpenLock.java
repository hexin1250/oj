package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class C1195_OpenLock {
	private static final int[][] STEP = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int t = sc.nextInt();
			while(t-- > 0) {
				int[] lock = getLockN(sc.nextInt());
				int[] target = getLockN(sc.nextInt());
				OpenLock op = new OpenLock(lock, target);
				op.bfs();
			}
		}
	}
	
	private static int[] getLockN(int n) {
		int[] ret = new int[4];
		ret[0] = n / 1000;
		ret[1] = (n / 100) % 10;
		ret[2] = (n / 10) % 10;
		ret[3] = n % 10;
		return ret;
	}
	
	private static int getHash(int[] arr) {
		return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
	}

	public static class OpenLock {
		private int[] lock;
		private int[] target;
		private Queue<Statement> q;
		private Set<Statement> mem;
		public OpenLock(int[] lock, int[] target) {
			this.lock = lock;
			this.target = target;
			q = new LinkedBlockingQueue<>();
			mem = new HashSet<>();
		}
		public void bfs() {
			Statement end = null;
			Statement init = new Statement(lock, 0);
			mem.add(init);
			q.add(init);
			while(!q.isEmpty()) {
				Statement state = q.poll();
				if(end(state)) {
					end = state;
					break;
				}
				expand(state);
			}
			System.out.println(end.getCost());
		}
		public void expand(Statement state) {
			for (int i = 0; i < 4; i++) {
				if(state.lock[i] == target[i]) {
					continue;
				}
				boolean quit = true;
				for (int j = 0; j < 4; j++) {
					int[] direction = STEP[j];
					int[] newMaze = new int[4];
					for (int k = 0; k < 4; k++) {
						newMaze[k] = state.lock[k];
					}
					if(direction[1] == 0) {
						newMaze[i] = newMaze[i] + direction[0];
						if(newMaze[i] > 9) {
							newMaze[i] = 1;
						} else if(newMaze[i] < 1) {
							newMaze[i] = 9;
						}
					} else {
						if((i == 0 && direction[1] == -1) || (i == 3 && direction[1] == 1)) {
							continue;
						}
						int left = i;
						int right = i + direction[1];
						int tmp = newMaze[left];
						newMaze[left] = newMaze[right];
						newMaze[right] = tmp;
					}
					Statement newState = new Statement(newMaze, state.cost + 1);
					if(mem.contains(newState)) {
						continue;
					}
					mem.add(newState);
					q.add(newState);
					quit = false;
				}
				if(quit) {
					break;
				}
			}
		}
		public boolean end(Statement state) {
			for (int i = 0; i < 4; i++) {
				if(state.lock[i] != target[i]) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static class Statement {
		private int[] lock;
		private int cost;
		public Statement(int[] lock, int cost){
			this.lock = lock;
			this.cost = cost;
		}
		public int getCost() {
			return cost;
		}
		@Override
		public int hashCode() {
			return getHash(lock);
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Statement)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			return Arrays.stream(lock).mapToObj(i -> new Integer(i).toString()).collect(Collectors.joining(""));
		}
	}

}
