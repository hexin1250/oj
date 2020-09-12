package michael.slf4j.learning;

import java.util.Scanner;

public class C1049_Climbing {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int u = sc.nextInt();
				int d = sc.nextInt();
				if(n == 0 && u == 0 && d == 0) {
					break;
				}
				int l = 0;
				int t = 0;
				while(true) {
					l += u;
					t++;
					if(l >= n) {
						break;
					}
					t++;
					l -= d;
				}
				System.out.println(t);
			}
		}
	}

}
