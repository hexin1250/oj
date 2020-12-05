package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class C1350_TaxiCabScheme {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				Map<BookTime, List<MyOrder>> orderMap = new TreeMap<>();
				for (int i = 0; i < n; i++) {
					BookTime bt = new BookTime(sc.next());
					MyOrder o = new MyOrder(new MyPosition(sc.nextInt(), sc.nextInt()), new MyPosition(sc.nextInt(), sc.nextInt()));
					List<MyOrder> list = orderMap.get(bt);
					if(list == null) {
						list = new ArrayList<>();
						orderMap.put(bt, list);
					}
					list.add(o);
				}
				List<Taxi> q = new ArrayList<>();
				for (Entry<BookTime, List<MyOrder>> entry : orderMap.entrySet()) {
					List<MyOrder> list = entry.getValue();
					Collections.sort(list, new Comparator<MyOrder>() {
						@Override
						public int compare(MyOrder o1, MyOrder o2) {
							return 0;
						}
					});
					BookTime bt = entry.getKey();
					for (MyOrder myOrder : list) {
						Taxi findTaxi = null;
						int cost = 0;
						for (Taxi t : q) {
							if(t.getTime().compareTo(bt) == -1) {
								BookTime taxiArriveBt = new BookTime(t.getTime().getH(), t.getTime().getM());
								MyPosition source = myOrder.getSource();
								taxiArriveBt.plus(Math.abs(t.getP().getX() - source.getX()) + Math.abs(t.getP().getY() - source.getY()));
								if(taxiArriveBt.compareTo(bt) == -1) {
									int currentCost = taxiArriveBt.closeTime(bt);
									if(findTaxi == null || currentCost < cost) {
										findTaxi = t;
										cost = currentCost;
									}
								}
							}
						}
						if(findTaxi != null) {
							q.remove(findTaxi);
						}
						BookTime taxiArriveBt = new BookTime(bt.getH(), bt.getM());
						MyPosition source = myOrder.getSource();
						MyPosition target = myOrder.getTarget();
						taxiArriveBt.plus(Math.abs(source.getX() - target.getX()) + Math.abs(source.getY() - target.getY()));
						Taxi taxi = new Taxi(taxiArriveBt, target);
						q.add(taxi);
					}
				}
				System.out.println(q.size());
			}
		}
	}
	
	public static class BookTime implements Comparable<BookTime> {
		private int h;
		private int m;
		public BookTime(String s) {
			String[] parts = s.split("[:]");
			h = Integer.valueOf(parts[0]);
			m = Integer.valueOf(parts[1]);
		}
		public BookTime(int h, int m) {
			this.h = h;
			this.m = m;
		}
		public int getH() {
			return h;
		}
		public int getM() {
			return m;
		}
		public void plus(int cost) {
			m += cost;
			if(m >= 60) {
				h += m / 60;
				m = m % 60;
			}
		}
		public int closeTime(BookTime bt) {
			int h = bt.getH() - this.h;
			int m = bt.getM() - this.m;
			return h * 60 + m;
		}
		@Override
		public int hashCode() {
			return h * 60 + m;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof BookTime)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			return h + ":" + m;
		}
		@Override
		public int compareTo(BookTime o) {
			if(h < o.getH()) {
				return -1;
			} else if(h > o.getH()) {
				return 1;
			}
			return m < o.getM() ? -1 : 1;
		}
	}
	
	public static class MyOrder {
		private MyPosition source;
		private MyPosition target;
		public MyOrder(MyPosition source, MyPosition target) {
			this.source = source;
			this.target = target;
		}
		public MyPosition getSource() {
			return source;
		}
		public MyPosition getTarget() {
			return target;
		}
		@Override
		public int hashCode() {
			return source.hashCode() * 40000 + target.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof MyOrder)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Source:").append(source).append("->Target:").append(target);
			return sb.toString();
		}
	}
	
	public static class MyPosition {
		private int x;
		private int y;
		public MyPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		@Override
		public int hashCode() {
			return 200 * x + y;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("[").append(x).append(",").append(y).append("]");
			return sb.toString();
		}
	}
	
	public static class Taxi {
		private BookTime time;
		private MyPosition p;
		public Taxi(BookTime time, MyPosition p) {
			this.time = time;
			this.p = p;
		}
		public MyPosition getP() {
			return p;
		}
		public void setP(MyPosition p) {
			this.p = p;
		}
		public BookTime getTime() {
			return time;
		}
	}

}
