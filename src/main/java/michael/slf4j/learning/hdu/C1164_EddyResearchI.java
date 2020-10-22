package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1164_EddyResearchI {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				List<Integer> list = new ArrayList<>();
				while(true) {
					int max = (int) Math.sqrt(n);
					boolean quit = true;
					for (int i = 2; i <= max; i++) {
						if(n % i == 0) {
							list.add(i);
							n /= i;
							quit = false;
							break;
						}
					}
					if(quit) {
						if(n > 1) {
							list.add(n);
						}
						break;
					}
				}
				System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining("*")));
			}
		}
	}

}
