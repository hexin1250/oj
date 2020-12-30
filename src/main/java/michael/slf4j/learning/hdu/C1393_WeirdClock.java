package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1393_WeirdClock {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				if(s == 0 && d == 0) {
					break;
				}
				Set<Integer> set = new HashSet<>();
				int c = 0;
				boolean find = false;
				while(true) {
					if(s % 60 == 0) {
						find = true;
						break;
					}
					if(set.contains(s)) {
						break;
					}
					c++;
					set.add(s);
					s = (s + s * d) % 60;
				}
				if(find) {
					System.out.println(c);
				} else {
					System.out.println("Impossible");
				}
			}
		}
	}

}
