package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class C1327_DefiniteValues {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = 0;
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				testcase++;
				sc.nextLine();
				Set<String> set = new TreeSet<>();
				set.add("a");
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine().replaceAll("[\\s]+", "");
					String[] parts = line.split("=");
					String a = parts[0];
					String b = parts[1];
					if(set.contains(b)) {
						set.add(a);
					} else {
						set.remove(a);
					}
				}
				System.out.println("Program #" + testcase);
				if(set.isEmpty()) {
					System.out.print("none");
				} else {
					for (String s : set) {
						System.out.print(s + " ");
					}
				}
				System.out.println();
				System.out.println();
			}
		}
	}

}
