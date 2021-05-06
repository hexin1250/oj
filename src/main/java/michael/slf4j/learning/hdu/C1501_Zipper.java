package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class C1501_Zipper {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			sc.nextLine();
			for (int i = 1; i <= testcase; i++) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				String[] sources = Arrays.copyOfRange(parts, 0, 2);
				SplitWords sw = new SplitWords(sources, parts[2]);
				boolean find = sw.bfs();
				System.out.println("Data set " + i + ": " + (find ? "yes" : "no"));
			}
		}
	}
	
	public static class SplitWords {
		private Set<Status> mem = new HashSet<>();
		private Queue<Status> q = new LinkedBlockingQueue<>();
		private int n;
		private String[] dicts;
		private String source;
		
		public SplitWords(String[] dicts, String source) {
			this.n = dicts.length;
			this.source = source;
			this.dicts = dicts;
		}
		
		public boolean bfs() {
			int length = source.length();
			int position = -1;
			String[] currentWords = new String[n];
			for (int i = 0; i < currentWords.length; i++) {
				currentWords[i] = "";
			}
			Status init = new Status(currentWords, position);
			mem.add(init);
			q.add(init);
			while(!q.isEmpty()) {
				Status s = q.poll();
				if(s.getPosition() == length - 1) {
					String[] words = s.getCurrentWords();
					for (int i = 0; i < n; i++) {
						if(!words[i].equals(dicts[i])) {
							return false;
						}
					}
					return true;
				}
				expand(s);
			}
			return false;
		}

		private void expand(Status s) {
			String[] words = s.getCurrentWords();
			int position = s.getPosition();
			int nextPosition = position + 1;
			for (int i = 0; i < n; i++) {
				if(words[i].length() == dicts[i].length()) {
					continue;
				}
				StringBuffer sb = new StringBuffer();
				sb.append(words[i]);
				sb.append(this.source.charAt(nextPosition));
				String thisWord = sb.toString();
				if(!dicts[i].startsWith(thisWord)) {
					continue;
				}
				String[] newWords = new String[n];
				for (int j = 0; j < n; j++) {
					newWords[j] = words[j];
					if(i == j) {
						newWords[j] = thisWord;
					}
				}
				Status nextStatus = new Status(newWords, nextPosition);
				if(mem.contains(nextStatus)) {
					continue;
				}
				q.add(nextStatus);
				mem.add(nextStatus);
			}
		}
	}
	
	public static class Status {
		private String[] currentWords;
		private int position;
		public Status(String[] sources, int position) {
			this.currentWords = sources;
			this.position = position;
		}
		public String[] getCurrentWords() {
			return currentWords;
		}
		public int getPosition() {
			return position;
		}
		@Override
		public int hashCode() {
			int length = currentWords.length;
			Object[] objs = new Object[length];
			for (int i = 0; i < length; i++) {
				objs[i] = currentWords[i];
			}
			return Objects.hash(objs);
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Status)) {
				return false;
			}
			return obj.hashCode() == hashCode();
		}
		@Override
		public String toString() {
			return Arrays.stream(currentWords).collect(Collectors.joining(","));
		}
	}

}
