package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1372_KnightMoves {
	private static final int[][] CHOICES = new int[][] {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String source = sc.next();
				String target = sc.next();
				KnightMove km = new KnightMove();
				km.bfs(source, target);
			}
		}
	}
	
	private static int[] getPoint(String s) {
		return new int[] {s.charAt(0) - 'a', s.charAt(1) - '1'};
	}
	
	public static class KnightMove {
		private Set<Integer> mem = new HashSet<>();
		private Queue<Status> q;
		public KnightMove() {
			q = new LinkedBlockingQueue<>();
		}
		public void bfs(String s1, String s2) {
			int[] source = getPoint(s1);
			int[] target = getPoint(s2);
			Status init = new Status(0, source);
			q.add(init);
			mem.add(hash(source));
			Status end = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				int[] current = s.getPoint();
				if(current[0] == target[0] && current[1] == target[1]) {
					end = s;
					break;
				}
				expand(s);
			}
			if(end != null) {
				System.out.println("To get from " + s1 + " to " + s2 + " takes " + end.getStep() + " knight moves.");
			}
		}
		
		private void expand(Status s) {
			int[] current = s.getPoint();
			for (int[] choice : CHOICES) {
				int[] nextPoint = new int[] {current[0] + choice[0], current[1] + choice[1]};
				if(nextPoint[0] < 0 || nextPoint[0] >= 8 || nextPoint[1] < 0 || nextPoint[1] >= 8) {
					continue;
				}
				if(mem.contains(hash(nextPoint))) {
					continue;
				}
				Status next = new Status(s.getStep() + 1, nextPoint);
				mem.add(hash(nextPoint));
				q.add(next);
			}
		}
		
		private int hash(int[] point) {
			return point[0] + point[1] * 8;
		}
	}
	
	public static class Status {
		private int step;
		private int[] point;
		public Status(int step, int[] point) {
			this.step = step;
			this.point = point;
		}
		public int getStep() {
			return step;
		}
		public int[] getPoint() {
			return point;
		}
	}

}
