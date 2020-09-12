package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1054_StrategicGame {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				sc.nextLine();
				Node[] nodes = new Node[n];
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine().replaceAll("[(]", "");
					String[] p1 = line.split(":");
					int nodeNumber = Integer.valueOf(p1[0]);
					if(nodes[nodeNumber] == null) {
						nodes[nodeNumber] = new Node(nodeNumber);
					}
					int neighbor = Integer.valueOf(p1[1].split("[)]")[0]);
					if(neighbor > 0) {
						String nnn = p1[1].split("[)]")[1].trim();
						for (String s : nnn.split("[\\s]+")) {
							int nextNodeNumber = Integer.valueOf(s);
							if(nodes[nextNodeNumber] == null) {
								nodes[nextNodeNumber] = new Node(nextNodeNumber);
								nodes[nextNodeNumber].add(nodes[nodeNumber]);
							}
							nodes[nodeNumber].add(nodes[nextNodeNumber]);
						}
					}
				}
				System.out.println(soldier(n, nodes));
			}
		}
	}
	
	private static int soldier(int length, Node[] nodes) {
		int[] mem = new int[length];
		try {
			Node init = nodes[0];
			mem[0] = 1;
			return Math.min(findSoldier(mem, init, 1) + 1, findSoldier(mem, init, 0));
		} finally {
			mem[1] = 0;
		}
	}
	
	/**
	 * @param nodes
	 * @param mem
	 * @param prev
	 * @param status
	 * @return
	 * 1 - set soldier, 0 - no soldier
	 */
	private static int findSoldier(int[] mem, Node prev, int status) {
		int sum = 0;
		for (Node n : prev.list) {
		}
		return 0;
	}

	public static class Node {
		public List<Node> list = new ArrayList<>();
		public int n;
		public Node(int n) {
			this.n = n;
		}
		public void add(Node d) {
			list.add(d);
		}
		@Override
		public int hashCode() {
			return n;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Node)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(n);
			if(!list.isEmpty()) {
				sb.append(":[");
				int index = 0;
				for (Node node : list) {
					if(index++ != 0) {
						sb.append(",");
					}
					sb.append(node.n);
				}
				sb.append("]");
			}
			return sb.toString();
		}
	}

}
