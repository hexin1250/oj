package michael.slf4j.learning;

import java.util.Scanner;

public class C1014_Uniform {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int step = sc.nextInt();
			int mod = sc.nextInt();
			int[] arr = new int[mod];
			int index = 0;
			int init = 0;
			while(index < mod) {
				int nextNum = generator(init, step, mod);
				if(index > 0 && nextNum == arr[0]) {
					break;
				}
				arr[index++] = nextNum;
				init = nextNum;
			}
			System.out.printf("% 10d% 10d", step, mod);
			if(index == mod) {
				System.out.print("    Good Choice");
			} else {
				System.out.print("    Bad Choice");
			}
			System.out.println();
			System.out.println();
		}
		sc.close();
	}

	private static int generator(int current, int step, int mod) {
		return (current + step) % mod;
	}

}
