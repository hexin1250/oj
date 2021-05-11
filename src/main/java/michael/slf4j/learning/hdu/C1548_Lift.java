package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1548_Lift {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				int start = sc.nextInt();
				int end = sc.nextInt();
				int[] weights = new int[n];
				for (int i = 0; i < n; i++) {
					weights[i] = sc.nextInt();
				}
				FindLift lift = new FindLift(n, weights);
				lift.bfs(start, end);
			}
		}
	}
	
	public static class FindLift {
		private Queue<Status> q = new LinkedBlockingQueue<>();
		private Set<Integer> mem = new HashSet<>();
		private int[] weights;
		private int n;
		public FindLift(int n, int[] weights) {
			this.n = n;
			this.weights = weights;
		}
		
		public void bfs(int start, int end) {
			Status init = new Status(start, 0);
			q.add(init);
			mem.add(start);
			Status ret = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(s.getFloor() == end) {
					ret = s;
					break;
				}
				expand(s);
			}
			if(ret == null) {
				System.out.println("-1");
			} else {
				System.out.println(ret.getStep());
			}
		}

		private void expand(Status s) {
			int step = s.getStep();
			int floor = s.getFloor();
			for (int i = 0; i <= 1; i++) {
				int nextFloor = i == 0 ? floor - weights[floor - 1] : floor + weights[floor - 1];
				if(nextFloor < 1 || nextFloor > n) {
					continue;
				}
				if(mem.contains(nextFloor)) {
					continue;
				}
				Status nextStatus = new Status(nextFloor, step + 1);
				mem.add(nextFloor);
				q.add(nextStatus);
			}
		}
	}
	
	public static class Status {
		private int floor;
		private int step;
		public Status(int floor, int step) {
			this.floor = floor;
			this.step = step;
		}
		public int getFloor() {
			return floor;
		}
		public int getStep() {
			return step;
		}
	}

}
