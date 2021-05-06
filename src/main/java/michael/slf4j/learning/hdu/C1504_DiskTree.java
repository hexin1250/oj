package michael.slf4j.learning.hdu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class C1504_DiskTree {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				Map<String, Node> map = new TreeMap<>();
				for (int i = 0; i < n; i++) {
					String path = sc.next();
					String[] dicts = path.split("\\\\");
					Node root = map.get(dicts[0]);
					if(root == null) {
						root = new Node(dicts[0]);
						map.put(dicts[0], root);
					}
					addNode(root, dicts, 1);
				}
				printNode(map, new StringBuffer());
			}
		}
	}
	
	private static void addNode(Node node, String[] dicts, int index) {
		if(index == dicts.length) {
			return;
		}
		Map<String, Node> childMap = node.getChildMap();
		String childDir = dicts[index];
		Node childNode = childMap.get(childDir);
		if(childNode == null) {
			childNode = new Node(childDir);
			childMap.put(childDir, childNode);
		}
		addNode(childNode, dicts, index + 1);
	}
	
	private static void printNode(Map<String, Node> map, StringBuffer sb) {
		for (Entry<String, Node> entry : map.entrySet()) {
			Node node = entry.getValue();
			System.out.println(sb.toString() + node.getDirName());
			StringBuffer newSb = new StringBuffer(sb);
			newSb.append(" ");
			printNode(node.getChildMap(), newSb);
		}
	}
	
	public static class Node {
		private Map<String, Node> childMap = new TreeMap<>();
		private String dirName;
		public Node(String dirName) {
			this.dirName = dirName;
		}
		public String getDirName() {
			return dirName;
		}
		public Map<String, Node> getChildMap() {
			return childMap;
		}
		public void addChild(Node node) {
			childMap.put(node.getDirName(), node);
		}
	}

}
