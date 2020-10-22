package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class C1199_ColorBall {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				sc.nextLine();
				List<Range> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine();
					String[] parts = line.split("[\\s]+");
					int start = Integer.valueOf(parts[0]);
					int end = Integer.valueOf(parts[1]);
					char c = parts[2].charAt(0);
					if(c == 'w') {
						list.add(new Range(start, end));
					} else {
						Stack<Integer> removeStack = new Stack<>();
						int size = list.size();
						List<Range> tmp = new ArrayList<>();
						for (int j = 0; j < size; j++) {
							Range r = list.get(j);
							if(start <= r.getX() && r.getY() <= end) {
								removeStack.push(j);
							} else if(r.getX() < start && end < r.getY()) {
								tmp.add(new Range(end + 1, r.getY()));
								r.setY(start - 1);
							} else if(r.getX() < start && start <= r.getY()) {
								r.setY(start - 1);
								if(r.getX() > r.getY()) {
									removeStack.push(j);
								}
							} else if(r.getX() <= end && end < r.getY()) {
								r.setX(end + 1);
								if(r.getX() > r.getY()) {
									removeStack.push(j);
								}
							}
						}
						while(!removeStack.isEmpty()) {
							int removeIndex = removeStack.pop();
							list.remove(removeIndex);
						}
						list.addAll(tmp);
					}
				}
				Collections.sort(list, new Comparator<Range>() {
					@Override
					public int compare(Range o1, Range o2) {
						return o1.getX() < o2.getX() ? -1 : 1;
					}
				});
				List<Range> resultList = new ArrayList<>();
				Range current = null;
				for (Range range : list) {
					if(current == null) {
						current = range;
					} else {
						if(current.getY() + 1 >= range.getX()) {
							current.setY(range.getY());
						} else {
							resultList.add(current);
							current = null;
						}
					}
				}
				Collections.sort(resultList, new Comparator<Range>() {
					@Override
					public int compare(Range o1, Range o2) {
						if(o1.getY() - o1.getX() > o2.getY() - o2.getX()) {
							return -1;
						} else if(o1.getY() - o1.getX() < o2.getY() - o2.getX()) {
							return 1;
						}
						if(o1.getX() < o2.getX()) {
							return -1;
						}
						return 1;
					}
				});
				if(list.isEmpty()) {
					System.out.println("Oh, my god");
				} else {
					Range r = list.get(0);
					System.out.println(r.getX() + " " + r.getY());
				}
			}
		}
	}
	
	public static class Range {
		public int x;
		public int y;
		public Range(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public int hashCode() {
			return x * 2001 + y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Range)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			return x + "-" + y;
		}
	}

}
