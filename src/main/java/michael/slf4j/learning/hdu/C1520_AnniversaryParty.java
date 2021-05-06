package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1520_AnniversaryParty {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int[] satisfy = new int[n];
				for (int i = 0; i < n; i++) {
					satisfy[i] = sc.nextInt();
				}
				Map<Integer, Node> employee = new HashMap<>();
				for (int i = 0; i < n; i++) {
					int id = i + 1;
					Node node = new Node(id, satisfy[i]);
					employee.put(id, node);
				}
				while(sc.hasNext()) {
					int childId = sc.nextInt();
					int parentId = sc.nextInt();
					if(childId == 0 && parentId == 0) {
						break;
					}
					Node childNode = employee.get(childId);
					Node parentNode = employee.get(parentId);
					childNode.setParent(parentNode);
					parentNode.addChild(childNode);
				}
				Node root = null;
				for (Entry<Integer, Node> entry : employee.entrySet()) {
					Node node = entry.getValue();
					if(node.getParent() == null) {
						root = node;
					}
				}
				int ret = dfs(root, false);
				System.out.println(ret);
			}
		}
	}
	
	private static int dfs(Node root, boolean parentChosen) {
		Map<Integer, Node> childMap = root.getChildMap();
		if(childMap.isEmpty() && !parentChosen) {
			return root.getSatisfy();
		}
		int choice1 = 0;
		if(!parentChosen) {
			choice1 += root.getSatisfy();
			for (Node child : root.getChildMap().values()) {
				choice1 += dfs(child, true);
			}
		}
		int choice2 = 0;
		for (Node child : root.getChildMap().values()) {
			choice2 += dfs(child, false);
		}
		return choice2 > choice1 ? choice2 : choice1;
	}

	public static class Node {
		private Node parent;
		private int id;
		private int satisfy;
		private Map<Integer, Node> childMap = new HashMap<>();
		public Node(int id, int satisfy) {
			this.id = id;
			this.satisfy = satisfy;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		public int getId() {
			return id;
		}
		public int getSatisfy() {
			return satisfy;
		}
		public Map<Integer, Node> getChildMap() {
			return childMap;
		}
		public void addChild(Node child) {
			childMap.put(child.getId(), child);
		}
	}

}
