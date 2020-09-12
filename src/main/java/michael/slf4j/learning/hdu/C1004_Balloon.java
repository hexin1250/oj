package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1004_Balloon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			int testcase = sc.nextInt();
			if(testcase == 0) {
				break;
			}
			sc.nextLine();
			int n = 0;
			String max = null;
			for (int i = 0; i < testcase; i++) {
				String line = sc.nextLine();
				Integer number = map.get(line);
				if(number == null) {
					number = 0;
				}
				number += 1;
				map.put(line, number);
				if(number > n) {
					n = number.intValue();
					max = line;
				}
			}
			System.out.println(max);
		}
		sc.close();
	}

}
