package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C1528_CardGame {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				Card[] adams = new Card[n];
				Card[] eves = new Card[n];
				for (int i = 0; i < n; i++) {
					adams[i] = new Card(sc.next());
				}
				for (int i = 0; i < n; i++) {
					eves[i] = new Card(sc.next());
				}
				Arrays.sort(adams, new CardComparator());
				Arrays.sort(eves, new CardComparator());
				Card source = null;
				Card target = null;
				int i = 0;
				int j = 0;
				int count = 0;
				while(true) {
					if(i == n || j == n) {
						break;
					}
					if(source == null) {
						source = adams[i];
					}
					if(target == null) {
						target = eves[j];
					}
					if(source.compare(source, target) < 0) {
						count++;
						i++;
						j++;
						source = null;
						target = null;
					} else {
						j++;
						target = null;
					}
				}
				System.out.println(count);
			}
		}
	}

	public static class Card extends CardComparator {
		private int number;
		private int priority;

		public Card(String str) {
			int number = -1;
			int priority = -1;
			char n = str.charAt(0);
			char p = str.charAt(1);
			if (n <= '9' && n >= '2') {
				number = n - '1' + 1;
			} else if (n == 'A') {
				number = 14;
			} else if (n == 'T') {
				number = 10;
			} else if (n == 'J') {
				number = 11;
			} else if (n == 'Q') {
				number = 12;
			} else if (n == 'K') {
				number = 13;
			}
			switch (p) {
			case 'H':
				priority = 4;
				break;
			case 'S':
				priority = 3;
				break;
			case 'D':
				priority = 2;
				break;
			case 'C':
				priority = 1;
				break;
			}
			this.number = number;
			this.priority = priority;
		}

		public Card(int number, int priority) {
			this.number = number;
			this.priority = priority;
		}

		public int getNumber() {
			return number;
		}

		public int getPriority() {
			return priority;
		}
	}

	public static class CardComparator implements Comparator<Card> {

		@Override
		public int compare(Card o1, Card o2) {
			if (o1.getNumber() < o2.getNumber()) {
				return -1;
			} else if (o1.getNumber() > o2.getNumber()) {
				return 1;
			}
			if (o1.getPriority() < o2.getPriority()) {
				return -1;
			}
			return 0;
		}

	}

}
