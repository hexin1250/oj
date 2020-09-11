package michael.slf4j.learning;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C2012_Prime {
	private static Set<Integer> set = new HashSet<>();
	static {
		set.add(1);
		set.add(2);
		set.add(3);
		for (int i = 4; i <= 2600; i++) {
			if(isPrime(i)) {
				set.add(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x == 0 && y == 0) {
				break;
			}
			boolean isAllPrime = true;
			for (int i = x; i <= y; i++) {
				int n = i * i + i + 41;
				if(!set.contains(n)) {
					isAllPrime = false;
					break;
				}
			}
			if(isAllPrime) {
				System.out.println("OK");
			} else {
				System.out.println("Sorry");
			}
		}
		sc.close();
	}
	
	private static boolean isPrime(int n) {
		int mid = (int) Math.sqrt(n) + 1;
		for (int i = 2; i <= mid; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
