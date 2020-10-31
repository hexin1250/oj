package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AC1251 {

	public static int getNum(String quest, Map<String, Integer> map) {
		int retCount = 0;
		if (map.containsKey(quest)) {
			retCount = map.get(quest);
		}
		return retCount;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> dicts = new ArrayList<>();
		List<String> searches = new ArrayList<>();
		while (true) {
			String str = scan.nextLine();
			if (str.equals("")) {
				break;
			}
			dicts.add(str);
		}
		while (scan.hasNext()) {
			String str = scan.next();
			searches.add(str);
		}
		scan.close();
		Map<String, Integer> map = check(dicts);
		for (String quest : searches) {
			System.out.println(getNum(quest, map));
		}
	}

	public static Map<String, Integer> check(List<String> dicts) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : dicts) {
			for (int i = 1; i <= str.length(); i++) {
				String subStr = str.substring(0, i);
				if (map.containsKey(subStr)) {
					int count = map.get(subStr);
					map.replace(subStr, count + 1);
				} else {
					map.put(subStr, 1);
				}
			}
		}
		return map;
	}
}