package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1287 {
	
	private static Map<Character, List<Integer>> map = new HashMap<>();
	private static Map<Character, Map<Integer, Character>> recordMap = new HashMap<>();
	
	static {
		for (int i = 0; i < 26; i++) {
			char a = (char) ('A' + i);
			List<Integer> list = new ArrayList<>();
			Map<Integer, Character> record = new HashMap<>();
			for (int j = 0; j < 26; j++) {
				char b = (char) ('A' + j);
				list.add(a ^ b);
				record.put(a ^ b, b);
			}
			Collections.sort(list);
			map.put(a, list);
			recordMap.put(a, record);
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int[] arr = new int[n];
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
					if(!list.contains(arr[i])) {
						list.add(arr[i]);
					}
				}
				Collections.sort(list);
				char target = '0';
				for (Entry<Character, List<Integer>> entry : map.entrySet()) {
					boolean find = true;
					List<Integer> targetList = entry.getValue();
					for (int i = 0; i < list.size(); i++) {
						if(targetList.get(i) != list.get(i)) {
							find = false;
							break;
						}
					}
					if(find) {
						target = entry.getKey();
						break;
					}
				}
				Map<Integer, Character> record = recordMap.get(target);
				System.out.println(Arrays.stream(arr).mapToObj(i -> record.get(i).toString()).collect(Collectors.joining()));
			}
		}
	}

}
