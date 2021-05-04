package michael.slf4j.learning.hdu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class C1434 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				
				Map<Integer, TreeMap<Passenger, String>> trains = new HashMap<>();
				for (int i = 1; i <= n; i++) {
					int count = sc.nextInt();
					TreeMap<Passenger, String> map = new TreeMap<>(new PassengerComparator());
					for (int j = 0; j < count; j++) {
						String name = sc.next();
						int v = sc.nextInt();
						Passenger p = new Passenger(name, v);
						map.put(p, null);
					}
					trains.put(i, map);
				}
				
				sc.nextLine();
				for (int i = 0; i < m; i++) {
					String line = sc.nextLine();
					String[] parts = line.split("[\\s]+");
					String operation = parts[0];
					int target = Integer.valueOf(parts[1]);
					if("join".equalsIgnoreCase(operation)) {
						int source = Integer.valueOf(parts[2]);
						TreeMap<Passenger, String> sourceMap = trains.remove(source);
						TreeMap<Passenger, String> targetMap = trains.remove(target);
						targetMap.putAll(sourceMap);
						trains.put(target, targetMap);
					} else if("geton".equalsIgnoreCase(operation)) {
						String name = parts[2];
						int value = Integer.valueOf(parts[3]);
						Passenger p = new Passenger(name, value);
						TreeMap<Passenger, String> targetMap = trains.get(target);
						if(targetMap == null) {
							targetMap = new TreeMap<>(new PassengerComparator());
							trains.put(target, targetMap);
						}
						targetMap.put(p, null);
					} else {
						TreeMap<Passenger, String> targetMap = trains.get(target);
						Entry<Passenger, String> entry = targetMap.pollFirstEntry();
						System.out.println(entry.getKey().getName());
					}
				}
			}
		}
	}
	
	public static final class Passenger {
		private String name;
		private int value;
		public Passenger(String name, int value) {
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public int getValue() {
			return value;
		}
		@Override
		public int hashCode() {
			return name.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Passenger)) {
				return false;
			}
			Passenger p = (Passenger) obj;
			return p.getValue() == value && p.getName().equals(name);
		}
		@Override
		public String toString() {
			return name + ":" + value;
		}
	}
	
	public static final class PassengerComparator implements Comparator<Passenger> {

		@Override
		public int compare(Passenger o1, Passenger o2) {
			if(o1.value < o2.value) {
				return -1;
			} else if(o1.value > o2.value) {
				return 1;
			}
			return o1.name.compareTo(o2.name) * -1;
		}
		
	}

}
