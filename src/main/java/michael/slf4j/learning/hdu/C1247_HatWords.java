package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class C1247_HatWords {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, Map<Character, List<String>>> map = new TreeMap<>();
			List<String> dictList = new ArrayList<>();
			while (sc.hasNext()) {
				String line = sc.nextLine();
				if (line.trim().length() == 0) {
					continue;
				}
				dictList.add(line);
				Map<Character, List<String>> lengthMap = map.get(line.length());
				if (lengthMap == null) {
					lengthMap = new HashMap<>();
				}
				char c = line.charAt(0);
				List<String> list = lengthMap.get(c);
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(line);
				lengthMap.put(c, list);
				map.put(line.length(), lengthMap);
			}
			List<String> list = new ArrayList<>();
			for (String s : dictList) {
				int length = s.length();
				char c = s.charAt(0);
				boolean isFind = false;
				for (Entry<Integer, Map<Character, List<String>>> entry : map.entrySet()) {
					int currentLength = entry.getKey();
					if (currentLength >= length) {
						break;
					}
					List<String> cList = entry.getValue().get(c);
					if (cList == null) {
						continue;
					}
					for (String startStr : cList) {
						if (s.startsWith(startStr)) {
							int endLength = length - currentLength;
							char endC = s.charAt(currentLength);
							String endStr = s.substring(currentLength, length);
							Map<Character, List<String>> endLengthMap = map.get(endLength);
							if (endLengthMap == null) {
								break;
							}
							List<String> endCharList = endLengthMap.get(endC);
							if (endCharList == null) {
								break;
							}
							if (endCharList.contains(endStr)) {
								list.add(s);
								isFind = true;
								break;
							}
						}
					}
					if (isFind) {
						break;
					}
				}
			}
			Collections.sort(list);
			for (String s : list) {
				System.out.println(s);
			}
		}
	}

}