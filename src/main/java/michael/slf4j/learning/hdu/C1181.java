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

public class C1181 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				Set<StartEnd> set = new HashSet<>();
				while(true) {
					String line = sc.nextLine();
					if("0".equals(line)) {
						break;
					}
					StartEnd se = new StartEnd(line.charAt(0), line.charAt(line.length() - 1));
					set.add(se);
				}
				int length = set.size();
				StartEnd[] arr = new StartEnd[length];
				Map<Character, List<Integer>> map = new HashMap<>();
				int index = 0;
				for (StartEnd se : set) {
					arr[index] = se;
					List<Integer> list = map.get(se.getS());
					if(list == null) {
						list = new ArrayList<>();
					}
					list.add(index);
					map.put(se.getS(), list);
					index++;
				}
				SEChecker checker = new SEChecker(arr, map);
				checker.bfs();
			}
		}
	}
	
	public static class SEChecker {
		private StartEnd[] arr;
		private Map<Character, List<Integer>> tree;
		private Queue<Status> q;
		private int[] mem;
		public SEChecker(StartEnd[] arr, Map<Character, List<Integer>> tree) {
			this.arr = arr;
			this.tree = tree;
			q = new LinkedBlockingQueue<>();
			mem = new int[arr.length];
		}
		public void bfs() {
			List<Integer> indexes = tree.get('b');
			if(indexes == null) {
				System.out.println("No.");
				return;
			}
			for (Integer i : indexes) {
				q.add(new Status(arr[i]));
				mem[i] = 1;
			}
			Status end = null;
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(isEnd(s)) {
					end = s;
					break;
				}
				expand(s);
			}
			if(end == null) {
				System.out.println("No.");
			} else {
				System.out.println("Yes.");
			}
		}
		private void expand(Status s) {
			StartEnd se = s.getSe();
			List<Integer> indexes = tree.get(se.getE());
			if(indexes == null) {
				return;
			}
			for (Integer i : indexes) {
				if(mem[i] == 1) {
					continue;
				}
				q.add(new Status(arr[i]));
				mem[i] = 1;
			}
		}
		private boolean isEnd(Status s) {
			return s.getSe().getE() == 'm';
		}
	}
	
	public static class Status {
		private StartEnd se;
		public Status(StartEnd se) {
			this.se = se;
		}
		public StartEnd getSe() {
			return se;
		}
	}
	
	public static class StartEnd {
		private char s;
		private char e;
		public StartEnd(char s, char e) {
			this.s = s;
			this.e = e;
		}
		public char getS() {
			return s;
		}
		public char getE() {
			return e;
		}
		@Override
		public int hashCode() {
			return (s - 'a') + (e - 'a') * 26;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof StartEnd)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(s).append('-').append(e);
			return sb.toString();
		}
	}

}
