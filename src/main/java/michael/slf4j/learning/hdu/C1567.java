package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1567 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				sc.nextLine();
				String[] matches = new String[n - 1];
				for (int i = 0; i < n - 1; i++) {
					matches[i] = sc.nextLine();
				}
				if(n % 2 == 1) {
					System.out.println("No");
				} else {
					int[] arr = new int[n];
					boolean isMatchPlayers = true;
					for (int i = 0; i < n - 1 && isMatchPlayers; i++) {
						String line = matches[i];
						String[] parts = line.split("[\\s]+");
						Set<Integer> roundSet = new HashSet<>();
						for (int j = 0; j < parts.length && isMatchPlayers; j++) {
							String singleMatch = parts[j];
							String[] players = singleMatch.split("-");
							for (String player : players) {
								int num = Integer.valueOf(player);
								if(roundSet.contains(num)) {
									isMatchPlayers = false;
									break;
								}
								roundSet.add(num);
							}
						}
						if(isMatchPlayers) {
							for (int num : roundSet) {
								arr[num - 1]++;
							}
						}
					}
					if(isMatchPlayers) {
						for (int i = 0; i < n; i++) {
							if(arr[i] != n - 1) {
								isMatchPlayers = false;
								break;
							}
						}
					}
					if(!isMatchPlayers) {
						System.out.println("No");
					} else {
						System.out.println("Yes");
					}
				}
			}
		}
	}

}
