package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1311_Relatives {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			for (int k = 1; k <= testcase; k++) {
				int n = sc.nextInt();
				Map<String, Relative> map = new HashMap<>();
				for (int i = 0; i < n; i++) {
					String fname = sc.next();
					String name = sc.next();
					int offset = sc.nextInt();
					Relative p = map.get(fname);
					if(p == null) {
						p = new Relative(fname);
						map.put(fname, p);
					}
					Relative r = map.get(name);
					if(r == null) {
						r = new Relative(name);
						map.put(name, r);
					}
					r.setP(p);
					r.setOffset(offset);
					p.addChild(r);
				}
				Relative ted = map.remove("Ted");
				ted.setAge(100);
				ages(ted);
				List<Relative> list = new ArrayList<>(map.values());
				Collections.sort(list, new Comparator<Relative>() {
					@Override
					public int compare(Relative o1, Relative o2) {
						if(o1.getAge() > o2.getAge()) {
							return -1;
						} else if(o1.getAge() < o2.getAge()) {
							return 1;
						}
						return o1.getName().compareTo(o2.getName());
					}
				});
				System.out.println("DATASET " + k);
				list.forEach(r -> System.out.println(r));
			}
		}
	}
	
	private static void ages(Relative r) {
		for (Relative c : r.getC()) {
			c.calc();
			ages(c);
		}
	}
	
	public static class Relative {
		private Relative p;
		private String name;
		private List<Relative> c;
		private int offset;
		private int age;
		public Relative(String name) {
			this.name = name;
			c = new ArrayList<>();
		}
		public String getName() {
			return name;
		}
		public List<Relative> getC() {
			return c;
		}
		public int getAge() {
			return age;
		}
		public void setP(Relative p) {
			this.p = p;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public void addChild(Relative child) {
			c.add(child);
		}
		public void calc() {
			int init = 100;
			if(p != null) {
				init = p.getAge();
			}
			age = init - offset;
		}
		@Override
		public String toString() {
			return name + " " + age;
		}
	}

}
