package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1354_ChooseYourOwnAdventure {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			for (int k = 1; k <= testcase; k++) {
				Map<Integer, Node> map = new HashMap<>();
				int chapter = sc.nextInt();
				sc.nextLine();
				for (int i = 1; i <= chapter; i++) {
					Node node = map.get(i);
					String line = sc.nextLine();
					char type = line.charAt(0);
					if(node == null) {
						node = new Node(i);
						map.put(i, node);
					}
					boolean start = false;
					StringBuffer sb = new StringBuffer();
					for (int j = 1; j < line.length(); j++) {
						if(line.charAt(j) != '"' && !start) {
							continue;
						} else if(line.charAt(j) == '"' && !start) {
							start = true;
							continue;
						} else if(line.charAt(j) == '"' && start) {
							break;
						}
						sb.append(line.charAt(j));
					}
					String content = sb.toString();
					node.setContent(content);
					if(type == 'C') {
						String[] parts = line.split("[\\s]+");
						for (int j = 0; j < 2; j++) {
							int nextC = Integer.valueOf(parts[parts.length - 1 - j]);
							Node childNode = map.get(nextC);
							if(childNode == null) {
								childNode = new Node(nextC);
								map.put(nextC, childNode);
							}
							childNode.setParent(node);
							node.addChildren(childNode);
						}
					} else {
						node.setEnding(true);
						String[] parts = line.split("[\\s]+");
						String ending = parts[parts.length - 1];
						if("happy".equalsIgnoreCase(ending)) {
							node.setHappy(true);
						} else {
							node.setHappy(false);
						}
					}
				}
				System.out.println("STORY " + k);
				ReadChapter rc = new ReadChapter(map);
				rc.bfs();
			}
		}
	}
	
	public static class ReadChapter {
		private Map<Integer, Node> map;
		private Queue<Status> q = new LinkedBlockingQueue<>();
		private Set<Integer> mem = new HashSet<>();
		public ReadChapter(Map<Integer, Node> map) {
			this.map = map;
		}
		public void bfs() {
			Status init = new Status(null, 1);
			mem.add(1);
			q.add(init);
			Status end = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				int id = s.getId();
				if(map.get(id) != null && map.get(id).isHappy) {
					end = s;
					break;
				}
				expand(s);
			}
			StringBuffer sb = getChapter(end);
			System.out.println(sb.toString());
		}
		private void expand(Status s) {
			int id = s.getId();
			Node node = map.get(id);
			for (Node child : node.getChildren()) {
				if(child.ending && !child.isHappy) {
					continue;
				}
				int nextId = child.getId();
				if(mem.contains(nextId)) {
					continue;
				}
				mem.add(nextId);
				Status nextStatus = new Status(s, nextId);
				q.add(nextStatus);
			}
		}
		private StringBuffer getChapter(Status s) {
			StringBuffer ret = new StringBuffer();
			Status prev = s.getPrevious();
			if(prev != null) {
				ret.append(getChapter(prev)).append("\r\n");
			}
			Node node = map.get(s.getId());
			ret.append(node.getContent());
			return ret;
		}
	}
	
	public static class Status {
		private int id;
		private Status previous;
		public Status(Status previous, int id) {
			this.previous = previous;
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public Status getPrevious() {
			return previous;
		}
	}
	
	public static class Node {
		private int id;
		private Node parent;
		private boolean ending = false;
		private String content;
		private boolean isHappy;
		private List<Node> children = new ArrayList<>();
		public Node(int id) {
			this.id = id;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		public boolean isEnding() {
			return ending;
		}
		public void setEnding(boolean ending) {
			this.ending = ending;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public List<Node> getChildren() {
			return children;
		}
		public void addChildren(Node child) {
			this.children.add(child);
		}
		public boolean isHappy() {
			return isHappy;
		}
		public void setHappy(boolean isHappy) {
			this.isHappy = isHappy;
		}
		public int getId() {
			return id;
		}
	}

}
