package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1257_Greedy {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				List<List<Integer>> systems = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					int current = sc.nextInt();
					List<Integer> find = null;
					int min = Integer.MAX_VALUE;
					for (List<Integer> list : systems) {
						int last = list.get(list.size() - 1);
						if(current <= last && last < min) {
							min = last;
							find = list;
						}
					}
					if(find == null) {
						find = new ArrayList<>();
						find.add(current);
						systems.add(find);
					} else {
						find.add(current);
					}
				}
				System.out.println(systems.size());
			}
		}
	}

}
