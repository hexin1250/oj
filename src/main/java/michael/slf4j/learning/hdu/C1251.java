package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1251 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<String> dicts = new ArrayList<>();
			List<String> searches = new ArrayList<>();
			while (true) {
				String str = sc.nextLine();
				if (str.equals("")) {
					break;
				}
				dicts.add(str);
			}
			while (sc.hasNext()) {
				String str = sc.next();
				searches.add(str);
			}
			List<String> sorts = new ArrayList<>(searches);
			Map<String, Integer> countMap = check(dicts, sorts);
			for (String s : searches) {
				System.out.println(getNum(s, countMap));
			}
		}
	}

	public static Map<String, Integer> check(List<String> dicts, List<String> sorts) {
		Collections.sort(sorts, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() > o2.length()) {
					return 1;
				}
				return o1.compareTo(o2);
			}
		});
		Node root = new Node("");
		for (String s : sorts) {
			addNode(root, s);
		}
		Map<String, Integer> countMap = new HashMap<>();
		for (String s : dicts) {
			findNode(root, s, countMap);
		}
		return countMap;
	}

	public static int getNum(String s, Map<String, Integer> map) {
		int retCount = 0;
		if (map.containsKey(s)) {
			retCount = map.get(s);
		}
		return retCount;
	}

	public static boolean addNode(Node n, String s) {
		List<Node> children = n.getChildren();
		boolean find = false;
		for (Node child : children) {
			String currentS = child.getS();
			if (!s.startsWith(currentS)) {
				continue;
			}
			find = addNode(child, s);
			if (find) {
				break;
			}
		}
		if (!find) {
			Node newChildNode = new Node(s);
			children.add(newChildNode);
		}
		return true;
	}

	public static void findNode(Node n, String s, Map<String, Integer> map) {
		for (Node child : n.getChildren()) {
			String start = child.getS();
			if (s.startsWith(start)) {
				Integer counter = map.get(start);
				if (counter == null) {
					counter = 0;
				}
				counter++;
				map.put(start, counter);
				findNode(child, s, map);
				break;
			}
		}
	}

	public static class Node {
		private String s;
		private List<Node> children;

		public Node(String s) {
			this.s = s;
			this.children = new ArrayList<>();
		}

		public void addChild(Node child) {
			children.add(child);
		}

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}

		public List<Node> getChildren() {
			return children;
		}

		public void setChildren(List<Node> children) {
			this.children = children;
		}

		@Override
		public String toString() {
			return s;
		}
	}

}
