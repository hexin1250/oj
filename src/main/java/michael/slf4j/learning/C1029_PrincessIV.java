package michael.slf4j.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1029_PrincessIV {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			sc.nextLine();
			String line = sc.nextLine();
			Map<Integer, Integer> map = new HashMap<>();
			int number = 0;
			for (String s : line.split("[\\s]+")) {
				int v = Integer.valueOf(s);
				Integer times = map.get(v);
				if(times == null) {
					times = 0;
				}
				times++;
				map.put(v, times);
				if(times == (n + 1) / 2) {
					number = v;
					break;
				}
			}
			System.out.println(number);
		}
		sc.close();
	}

}
