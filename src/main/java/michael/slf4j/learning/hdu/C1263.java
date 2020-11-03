package michael.slf4j.learning.hdu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class C1263 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				Map<String, Map<String, Integer>> map = new TreeMap<>();
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					String name = sc.next();
					String location = sc.next();
					int count = sc.nextInt();
					
					Map<String, Integer> nameMap = map.get(location);
					if(nameMap == null) {
						nameMap = new TreeMap<>();
					}
					Integer counter = nameMap.get(name);
					if(counter == null) {
						counter = 0;
					}
					counter += count;
					nameMap.put(name, counter);
					map.put(location, nameMap);
				}
				String ret = map.entrySet().stream().map(entry -> {
					StringBuffer sb = new StringBuffer();
					sb.append(entry.getKey()).append("\r\n");
					sb.append(entry.getValue().entrySet().stream().map(nameEntry -> {
						StringBuffer nameSb = new StringBuffer();
						nameSb.append("   |----");
						nameSb.append(nameEntry.getKey());
						nameSb.append("(").append(nameEntry.getValue()).append(")");
						return nameSb.toString();
					}).collect(Collectors.joining("\r\n")));
					sb.append("");
					return sb.toString();
				}).collect(Collectors.joining("\r\n"));
				System.out.println(ret);
				if(testcase != 0) {
					System.out.println();
				}
			}
		}
	}

}
