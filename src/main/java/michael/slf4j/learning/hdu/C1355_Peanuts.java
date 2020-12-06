package michael.slf4j.learning.hdu;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class C1355_Peanuts {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int t = sc.nextInt();
				List<Peanuts> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						int c = sc.nextInt();
						if(c > 0) {
							Point p = new Point(i, j);
							list.add(new Peanuts(p, c));
						}
					}
				}
				Collections.sort(list, new Comparator<Peanuts>() {
					@Override
					public int compare(Peanuts o1, Peanuts o2) {
						if(o1.getC() > o2.getC()) {
							return -1;
						}
						return 1;
					}
				});
				Point last = null;
				int total = 0;
				int cost = 2;
				for (Peanuts peanuts : list) {
					Point p = peanuts.getP();
					int c = peanuts.getC();
					cost += 1;
					if(last == null) {
						cost += p.getX();
					} else {
						cost += Math.abs(p.getX() - last.getX()) + Math.abs(p.getY() - last.getY());
					}
					if(cost + p.getX() > t) {
						break;
					} else {
						total += c;
					}
					last = p;
				}
				System.out.println(total);
			}
		}
	}
	
	public static class Peanuts {
		private int c;
		private Point p;
		public Peanuts(Point p, int c) {
			this.p = p;
			this.c = c;
		}
		public int getC() {
			return c;
		}
		public Point getP() {
			return p;
		}
	}

}
