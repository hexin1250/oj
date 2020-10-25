package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1228_AB {
	private static Map<String, Integer> map = new HashMap<>();
	private static Pattern p = Pattern.compile("(.*) [+] (.*) =");
	
	static {
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String line = sc.nextLine();
				Matcher m = p.matcher(line);
				if(m.matches()) {
					String astr = m.group(1);
					String bstr = m.group(2);
					String[] aparts = astr.split("[\\s]+");
					int a = 0;
					for (int i = 0; i < aparts.length; i++) {
						a = a * 10 + map.get(aparts[i]);
					}
					String[] bparts = bstr.split("[\\s]+");
					int b = 0;
					for (int i = 0; i < bparts.length; i++) {
						b = b * 10 + map.get(bparts[i]);
					}
					if(a == 0 && b == 0) {
						break;
					}
					System.out.println(a + b);
				}
			}
		}
	}

}
