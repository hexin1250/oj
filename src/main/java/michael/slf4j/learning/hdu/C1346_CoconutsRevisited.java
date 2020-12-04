package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1346_CoconutsRevisited {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == -1) {
					break;
				}
				System.out.print(n + " coconuts, ");
				int ret = maxPeople(n);
				if(ret == 1) {
					System.out.println("no solution");
				} else {
					System.out.println(ret + " people and 1 monkey");
				}
			}
		}
	}

	private static int maxPeople(int n) {
		int index = (n - 1) / 2;
		while(index > 1) {
			if((n - 1) % index == 0) {
				if(isFind(n, index, index)) {
					return index;
				}
			}
			index--;
		}
		return 1;
	}

	private static boolean isFind(int n, int part, int step) {
		if(step == 0) {
			if(n % part == 0) {
				return true;
			} else {
				return false;
			}
		}
		int nWithoutMonkey = n - 1;
		if(nWithoutMonkey % part != 0) {
			return false;
		}
		return isFind(nWithoutMonkey - nWithoutMonkey / part, part, step - 1);
	}

}
