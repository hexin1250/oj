package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class C1307_NCredibleMazes {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = 0;
			while (sc.hasNext()) {
				testcase++;
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				int[] start = new int[n];
				int[] end = new int[n];
				for (int i = 0; i < n; i++) {
					start[i] = sc.nextInt();
				}
				for (int i = 0; i < n; i++) {
					end[i] = sc.nextInt();
				}
				sc.nextLine();
				Map<Integer, Node> map = new HashMap<>();
				while(true) {
					String line = sc.nextLine();
					if("-1".equals(line)) {
						break;
					}
					String[] parts = line.split("[\\s]+");
					int[] pre = new int[n];
					for (int i = 0; i < n; i++) {
						pre[i] = Integer.valueOf(parts[i]);
					}
					int[] next = new int[n];
					for (int i = 0; i < n; i++) {
						next[i] = Integer.valueOf(parts[i + n]);
					}
					int preHash = getHash(pre);
					int nextHash = getHash(next);
					Node preNode = map.get(preHash);
					if(preNode == null) {
						preNode = new Node(new NPoint(pre));
						map.put(preHash, preNode);
					}
					Node nextNode = map.get(nextHash);
					if(nextNode == null) {
						nextNode = new Node(new NPoint(next));
						map.put(nextHash, nextNode);
					}
					preNode.addChildren(nextNode);
					nextNode.addChildren(preNode);
				}
				int startHash = getHash(start);
				int endHash = getHash(end);
				Node startNode = map.get(startHash);
				Node endNode = map.get(endHash);
				if(startNode == null || endNode == null) {
					System.out.println("Maze #" + testcase + " cannot be travelled");
				} else {
					Set<Node> mem = new HashSet<>();
					Queue<Node> q = new LinkedBlockingQueue<>();
					q.add(startNode);
					mem.add(startNode);
					boolean find = false;
					while(!q.isEmpty()) {
						Node node = q.poll();
						if(node.equals(endNode)) {
							find = true;
							break;
						}
						for (Node child : node.getChildren()) {
							if(mem.contains(child)) {
								continue;
							}
							q.add(child);
							mem.add(child);
						}
					}
					if(find) {
						System.out.println("Maze #" + testcase + " can be travelled");
					} else {
						System.out.println("Maze #" + testcase + " cannot be travelled");
					}
				}
			}
		}
	}
	
	public static class Node {
		private NPoint p;
		private List<Node> children;
		public Node(NPoint p) {
			this.p = p;
			children = new ArrayList<>();
		}
		public List<Node> getChildren() {
			return children;
		}
		public void addChildren(Node child) {
			children.add(child);
		}
		public NPoint getP() {
			return p;
		}
		@Override
		public String toString() {
			return p.toString();
		}
	}
	
	public static class NPoint {
		private int[] a;
		public NPoint(int[] a) {
			this.a = a;
		}
		public int[] getA() {
			return a;
		}
		@Override
		public int hashCode() {
			return getHash(a);
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof NPoint)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append('[');
			sb.append(Arrays.stream(a).mapToObj(i -> i + "").collect(Collectors.joining(",")));
			sb.append(']');
			return sb.toString();
		}
	}
	
	public static int getHash(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += sum * 10 + a[i];
		}
		return sum;
	}

}
