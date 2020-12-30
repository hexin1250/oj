package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1390_BinaryNumbers {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int i = 1;
				int times = 0;
				List<Integer> list = new ArrayList<>();
				while(i <= n) {
					if((i & n) > 0) {
						list.add(times);
					}
					times++;
					i *= 2;
				}
				System.out.println(list.stream().map(j -> j.toString()).collect(Collectors.joining(" ")));
			}
		}
	}

}
