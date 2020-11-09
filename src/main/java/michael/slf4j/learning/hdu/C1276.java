package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1276 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				List<Integer> list = new ArrayList<>();
				for (int i = 1; i <= n; i++) {
					list.add(i);
				}
				int count = 2;
				while(list.size() > 3) {
					Iterator<Integer> it = list.iterator();
					int index = 0;
					while(it.hasNext()) {
						index++;
						it.next();
						if(index % count == 0) {
							it.remove();
						}
					}
					if(count == 2) {
						count = 3;
					} else {
						count = 2;
					}
				}
				System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
			}
		}
	}

}
