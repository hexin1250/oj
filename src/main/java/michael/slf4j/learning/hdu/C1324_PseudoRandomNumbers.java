package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1324_PseudoRandomNumbers {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = 0;
			while (sc.hasNext()) {
				int z = sc.nextInt();
				int i = sc.nextInt();
				int m = sc.nextInt();
				int l = sc.nextInt();
				if(z == 0 && i == 0 && m == 0 && l == 0) {
					break;
				}
				testcase++;
				List<Integer> list = new ArrayList<>();
				while(!list.contains(l)) {
					list.add(l);
					l = (z * l + i) % m;
				}
				int start = list.indexOf(l);
				int len = list.size() - start;
				System.out.println("Case " + testcase + ": " + len);
			}
		}
	}

}
