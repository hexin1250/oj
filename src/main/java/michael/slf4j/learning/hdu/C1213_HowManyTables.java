package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1213_HowManyTables {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				int pairs = sc.nextInt();
				Set<Integer>[] sets = new Set[pairs];
				for (int i = 0; i < pairs; i++) {
					sets[i] = new HashSet<>();
					sets[i].add(sc.nextInt());
					sets[i].add(sc.nextInt());
				}
				int index = 0;
				while(index < pairs) {
					if(sets[index] == null) {
						index++;
						continue;
					}
					boolean find = false;
					for (int i = index + 1; i < pairs; i++) {
						if(sets[i] == null) {
							continue;
						}
						Set<Integer> tmp = new HashSet<>();
						tmp.addAll(sets[i]);
						tmp.retainAll(sets[index]);
						if(tmp.size() > 0) {
							sets[index].addAll(sets[i]);
							sets[i] = null;
							find = true;
						}
					}
					if(!find) {
						index++;
					}
				}
				int count = n;
				for (int i = 0; i < pairs; i++) {
					Set<Integer> set = sets[i];
					if(set == null) {
						continue;
					}
					count = count - set.size() + 1;
				}
				System.out.println(count);
			}
		}
	}

}
