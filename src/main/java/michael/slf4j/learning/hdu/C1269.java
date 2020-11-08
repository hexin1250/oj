package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C1269 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				if(m == 0 && n == 0) {
					break;
				}
				Map<Integer, Set<Integer>> map = new HashMap<>();
				int startPoint = -1;
				int findway = 0;
				if(m < n) {
					findway = -1;
				}
				for (int i = 0; i < m; i++) {
					int source = sc.nextInt();
					int target = sc.nextInt();
					if(findway == -1 || findway == 1) {
						continue;
					}
					if(startPoint == -1) {
						startPoint = source;
						map.put(source, new HashSet<>());
					}
					Set<Integer> set = map.get(startPoint);
					if(source == startPoint) {
						set.add(target);
					} else {
						Set<Integer> targetSet = map.get(target);
						if(set.contains(source)) {
							Set<Integer> sourceSet = map.get(source);
							if(sourceSet == null) {
								sourceSet = new HashSet<>();
								map.put(source, sourceSet);
							}
							sourceSet.add(target);
							set.addAll(sourceSet);
							if(target != startPoint && targetSet != null) {
								set.addAll(targetSet);
							}
							set.add(target);
						} else {
							Set<Integer> sourceSet = map.get(source);
							if(sourceSet == null) {
								sourceSet = new HashSet<>();
							}
							if(target != startPoint && targetSet != null) {
								sourceSet.addAll(targetSet);
							}
							sourceSet.add(target);
							map.put(source, sourceSet);
						}
					}
					if(set.size() == n) {
						findway = 1;
						continue;
					}
				}
				if(findway == 1) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}
	
}
