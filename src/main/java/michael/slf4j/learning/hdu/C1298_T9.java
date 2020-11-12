package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1298_T9 {
	private static Map<Character, Integer> keyboard = new HashMap<>();
	
	static {
		keyboard.put('a', 2);
		keyboard.put('b', 2);
		keyboard.put('c', 2);
		keyboard.put('d', 3);
		keyboard.put('e', 3);
		keyboard.put('f', 3);
		keyboard.put('g', 4);
		keyboard.put('h', 4);
		keyboard.put('i', 4);
		keyboard.put('j', 5);
		keyboard.put('k', 5);
		keyboard.put('l', 5);
		keyboard.put('m', 6);
		keyboard.put('n', 6);
		keyboard.put('o', 6);
		keyboard.put('p', 7);
		keyboard.put('q', 7);
		keyboard.put('r', 7);
		keyboard.put('s', 7);
		keyboard.put('t', 8);
		keyboard.put('u', 8);
		keyboard.put('v', 8);
		keyboard.put('w', 9);
		keyboard.put('x', 9);
		keyboard.put('y', 9);
		keyboard.put('z', 9);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			for (int k = 1; k <= testcase; k++) {
				System.out.println("Scenario #" + k + ":");
				
				int n = sc.nextInt();
				
				String[] dicts = new String[n];
				double[] rating = new double[n];
				for (int i = 0; i < n; i++) {
					dicts[i] = sc.next();
					rating[i] = sc.nextInt();
				}
				double total = Arrays.stream(rating).sum();
				Map<Integer, Map<Character, Node>> map = new HashMap<>();
				for (int i = 0; i < n; i++) {
					char[] ch = dicts[i].toCharArray();
					int startNum = keyboard.get(ch[0]);
					Map<Character, Node> nodes = map.get(startNum);
					if(nodes == null) {
						nodes = new HashMap<>();
						map.put(startNum, nodes);
					}
					Node node = nodes.get(ch[0]);
					if(node == null) {
						node = new Node(null, startNum, ch[0]);
						nodes.put(ch[0], node);
					}
					node.addRating(rating[i] / total);
					for (int j = 1; j < ch.length; j++) {
						int currentNum = keyboard.get(ch[j]);
						Node currentNode = node.getChildNode(currentNum, ch[j]);
						if(currentNode == null) {
							currentNode = new Node(node, currentNum, ch[j]);
							node.addChild(currentNode);
						}
						currentNode.addRating(rating[i] / total);
						node = currentNode;
					}
				}
				int m = sc.nextInt();
				for (int i = 0; i < m; i++) {
					String line = sc.next();
					while(!line.endsWith("1")) {
						line += sc.next();
					}
					char[] target = line.toCharArray();
					boolean nothing = false;
					List<Map<Character, Node>> nodesList = new ArrayList<>();
					for (int j = 0; j < target.length - 1; j++) {
						if(nothing) {
							System.out.println("MANUALLY");
							continue;
						}
						int currentNum = target[j] - '0';
						if(j == 0) {
							Map<Character, Node> nodes = map.get(currentNum);
							if(nodes != null) {
								nodesList = new ArrayList<>();
								nodesList.add(nodes);
							}
						} else {
							List<Map<Character, Node>> tmpList = new ArrayList<>();
							for (Map<Character, Node> nodeMap : nodesList) {
								for (Entry<Character, Node> entry : nodeMap.entrySet()) {
									Node currentNode = entry.getValue();
									Map<Character, Node> nextNodeMap = currentNode.getChildren().get(currentNum);
									if(nextNodeMap != null && !nextNodeMap.isEmpty()) {
										tmpList.add(nextNodeMap);
									}
								}
							}
							nodesList.clear();
							nodesList = tmpList;
						}
						if(nodesList.isEmpty()) {
							nothing = true;
							System.out.println("MANUALLY");
							continue;
						}
						Node best = null;
						for (Map<Character, Node> nodeMap : nodesList) {
							for (Entry<Character, Node> entry : nodeMap.entrySet()) {
								Node current = entry.getValue();
								if(best == null || best.getRating() < current.getRating()) {
									best = current;
								} else if(best.getRating() == current.getRating()) {
									int ret = compare(best, current);
									if(ret == 1) {
										best = current;
									}
								}
							}
						}
						System.out.println(output(best));
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
	
	private static String output(Node node) {
		StringBuffer sb = new StringBuffer();
		if(node != null) {
			sb.append(output(node.getParent()));
			sb.append(node.getCh());
		}
		return sb.toString();
	}
	
	private static int compare(Node n1, Node n2) {
		if(n1 != null && n2 != null) {
			int ret = compare(n1.getParent(), n2.getParent());
			if(ret != 0) {
				return ret;
			}
			if(n1.getRating() > n2.getRating()) {
				return -1;
			} else if(n1.getRating() < n2.getRating()) {
				return 1;
			}
			if(n1.getCh() < n2.getCh()) {
				return -1;
			} else if(n1.getCh() > n2.getCh()) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
	
	public static class Node {
		private Node parent;
		private int num;
		private char ch;
		private double rating = 0D;
		private Map<Integer, Map<Character, Node>> children = new HashMap<>();
		public Node(Node parent, int num, char ch) {
			this.parent = parent;
			this.num = num;
			this.ch = ch;
		}
		public Node getParent() {
			return parent;
		}
		public int getNum() {
			return num;
		}
		public char getCh() {
			return ch;
		}
		public double getRating() {
			return rating;
		}
		public Map<Integer, Map<Character, Node>> getChildren() {
			return children;
		}
		public Node getChildNode(int num, char ch) {
			Map<Character, Node> childNodes = children.get(num);
			if(childNodes == null) {
				return null;
			}
			return childNodes.get(ch);
		}
		public void addChild(Node child) {
			Map<Character, Node> childNodes = children.get(child.getNum());
			if(childNodes == null) {
				childNodes = new HashMap<>();
				children.put(child.getNum(), childNodes);
			}
			childNodes.put(child.getCh(), child);
		}
		public void addRating(double rating) {
			this.rating += rating;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(num).append(':').append(ch).append(':').append(rating).append("\n");
			return sb.toString();
		}
	}

}
