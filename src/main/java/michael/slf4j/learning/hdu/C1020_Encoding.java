package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1020_Encoding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		while (testcase-- > 0) {
			String line = sc.nextLine();
			char[] ch = line.toCharArray();
			char prev = ch[0];
			int times = 1;
			List<Map<String, Integer>> list = new ArrayList<>();
			for (int i = 1; i < ch.length; i++) {
				if(ch[i] == prev) {
					times++;
				} else {
					Map<String, Integer> map = new HashMap<>();
					map.put(prev + "", times);
					list.add(map);
					times = 1;
					prev = ch[i];
				}
			}
			Map<String, Integer> map = new HashMap<>();
			map.put(prev + "", times);
			list.add(map);
			StringBuffer sb = new StringBuffer();
			for (Map<String, Integer> item : list) {
				for (Entry<String, Integer> entry : item.entrySet()) {
					String key = entry.getKey();
					int t = entry.getValue();
					if(t > 1) {
						sb.append(t);
					}
					sb.append(key);
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

}
