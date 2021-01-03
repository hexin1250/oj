package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1415_Jugs {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				FillWater fw = new FillWater(a, b);
				fw.bfs(c);
			}
		}
	}
	
	public static class FillWater {
		private final int a;
		private final int b;
		private Queue<Status> q;
		private Set<Status> mem;
		public FillWater(int a, int b){
			this.a = a;
			this.b = b;
			q = new LinkedBlockingQueue<>();
			mem = new HashSet<>();
		}
		public void bfs(int c){
			Status init = new Status(null, 0, 0, null);
			q.add(init);
			mem.add(init);
			Status end = null;
			while(!q.isEmpty()){
				Status s = q.poll();
				if(s.getB() == c){
					end = s;
					break;
				}
				expand(s);
			}
			if(end != null){
				System.out.println(end.getPath());
				System.out.println("success");
			}
		}
		private void expand(Status s) {
			int a = s.getA();
			int b = s.getB();
			for (int i = 0; i < 6; i++) {
				int nextA = a;
				int nextB = b;
				Status next = null;
				String path = null;
				boolean skip = false;
				switch(i){
				case 0:
					path = "fill A";
					if(nextA != 0){
						skip = true;
					} else {
						nextA = this.a;
					}
					break;
				case 1:
					path = "fill B";
					if(nextB != 0){
						skip = true;
					} else {
						nextB = this.b;
					}
					break;
				case 2:
					path = "empty A";
					if(nextA != this.a){
						skip = true;
					} else {
						nextA = 0;
					}
					break;
				case 3:
					path = "empty B";
					if(nextB != this.b){
						skip = true;
					} else {
						nextB = 0;
					}
					break;
				case 4:
					path = "pour A B";
					if(nextB == this.b || nextA == 0){
						skip = true;
					} else {
						nextB += nextA;
						if(nextB >= this.b){
							nextA = nextB - this.b;
							nextB = this.b;
						} else {
							nextA = 0;
						}
					}
					break;
					default:
						path = "pour B A";
						if(nextA == this.a || nextB == 0){
							skip = true;
						} else {
							nextA += nextB;
							if(nextA >= this.a){
								nextB = nextA - this.a;
								nextA = this.a;
							} else {
								nextB = 0;
							}
						}
						break;
				}
				if(skip){
					continue;
				}
				next = new Status(s, nextA, nextB, path);
				if(mem.contains(next)){
					continue;
				}
				mem.add(next);
				q.add(next);
			}
		}
	}
	
	public static class Status {
		private final Status pre;
		private final int a;
		private final int b;
		private final String path;
		public Status(Status pre, int a, int b, String path){
			this.pre = pre;
			this.a = a;
			this.b = b;
			this.path = path;
		}
		public int getA() {
			return a;
		}
		public int getB() {
			return b;
		}
		public String getPath(){
			StringBuffer sb = new StringBuffer();
			if(pre != null){
				if(!pre.getPath().isEmpty()){
					sb.append(pre.getPath()).append("\r\n");
				}
				sb.append(path);
			}
			return sb.toString();
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Status)){
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public int hashCode() {
			return a + 1000 * b;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("A[").append(a).append("]-B[").append(b).append("]");
			return sb.toString();
		}
	}

}
