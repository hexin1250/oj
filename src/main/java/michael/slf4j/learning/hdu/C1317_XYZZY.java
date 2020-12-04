package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class C1317_XYZZY {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == -1) {
					break;
				}
				Map<Integer, Node> map = new HashMap<>();
				int index = 1;
				while(true) {
					int energy = sc.nextInt();
					int rooms = sc.nextInt();
					if(energy == 0 && rooms == 0) {
						break;
					}
					Node c = map.get(index);
					if(c == null) {
						c = new Node(index);
						map.put(index, c);
					}
					c.setEnergy(energy);
					for (int i = 0; i < rooms; i++) {
						int id = sc.nextInt();
						Node child = map.get(id);
						if(child == null) {
							child = new Node(id);
							map.put(id, child);
						}
						c.addChild(child);
					}
					index++;
				}
				WalkRoom wr = new WalkRoom(map);
				Node start = map.get(1);
				Node end = map.get(n);
				wr.bfs(start, end);
			}
		}
	}
	
	public static class WalkRoom {
		private Map<Integer, Node> maze;
		private Map<Integer, Status> mem = new HashMap<>();
		private Queue<Status> q = new LinkedBlockingQueue<>();
		public WalkRoom(Map<Integer, Node> maze) {
			this.maze = maze;
		}
		public void bfs(Node start, Node end) {
			if(end == null) {
				System.out.println("hopeless");
				return;
			}
			Status init = new Status(100, start.id);
			q.add(init);
			mem.put(start.getId(), init);
			Status endStatus = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(s.getRoom() == end.getId()) {
					endStatus = s;
					break;
				}
				expand(s);
			}
			if(endStatus == null) {
				System.out.println("hopeless");
			} else {
				System.out.println("winnable");
			}
		}
		private void expand(Status s) {
			int room = s.getRoom();
			Node n = maze.get(room);
			if(n == null) {
				return;
			}
			Iterator<Node> it = n.getChildren().iterator();
			while(it.hasNext()) {
				Node child = it.next();
				Status next = new Status(s.getEnergy() + child.getEnergy(), child.getId());
				if(next.getEnergy() <= 0) {
					continue;
				}
				Status knownS = mem.get(child.getId());
				if(knownS != null) {
//					it.remove();
					if(knownS.getEnergy() >= next.getEnergy()) {
						continue;
					}
					next.setEnergy(next.getEnergy() + 100000);
					mem.remove(child.getId());
				}
				mem.put(child.getId(), next);
				q.add(next);
			}
		}
	}
	
	public static class Status {
		private int energy;
		private int room;
		public Status(int energy, int room) {
			this.energy = energy;
			this.room = room;
		}
		public int getEnergy() {
			return energy;
		}
		public void setEnergy(int energy) {
			this.energy = energy;
		}
		public int getRoom() {
			return room;
		}
		public void setRoom(int room) {
			this.room = room;
		}
		@Override
		public int hashCode() {
			return room;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Status)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			return room + ":" + energy;
		}
	}
	
	public static class Node {
		private int id;
		private int energy;
		private List<Node> children = new ArrayList<>();
		public Node(int id) {
			this.id = id;
		}
		public int getEnergy() {
			return energy;
		}
		public void setEnergy(int energy) {
			this.energy = energy;
		}
		public int getId() {
			return id;
		}
		public List<Node> getChildren() {
			return children;
		}
		public void addChild(Node child) {
			children.add(child);
		}
		@Override
		public String toString() {
			return id + ":" + energy;
		}
	}

}
