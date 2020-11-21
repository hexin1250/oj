package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1335_BasicallySpeaking {
	private static Map<Character, Integer> map = new HashMap<>();
	private static Map<Integer, Character> reverse = new HashMap<>();
	static {
		for (int i = 0; i < 10; i++) {
			char c = (char)('0' + i);
			map.put(c, i);
			reverse.put(i, c);
		}
		for (int i = 0; i < 6; i++) {
			char c = (char)('A' + i);
			int n = i + 10;
			map.put(c, n);
			reverse.put(n, c);
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String source = sc.next();
				int current = sc.nextInt();
				int next = sc.nextInt();
				char[] ch = source.toCharArray();
				int sum = 0;
				for (int i = 0; i < ch.length; i++) {
					sum = sum * current + map.get(ch[i]);
				}
				List<Character> list = new ArrayList<>();
				while(sum > 0) {
					int mod = sum % next;
					list.add(reverse.get(mod));
					sum = (sum - mod) / next;
				}
				Collections.reverse(list);
				String ret = list.stream().map(c -> c.toString()).collect(Collectors.joining());
				if(ret.length() > 7) {
					System.out.println(String.format("%7s","ERROR"));
				} else {
					System.out.println(String.format("%7s", ret));
				}
			}
		}
	}

}
