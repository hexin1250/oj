package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C2021 {
	private static final int[] arr = new int[]{100,50,10,5,2,1};

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()){
				int n = sc.nextInt();
				if(n == 0){
					break;
				}
				int sum = 0;
				for (int i = 0; i < n; i++) {
					int c = sc.nextInt();
					for (int p : arr) {
						if(c == 0){
							break;
						}
						if(c >= p){
							sum += c / p;
							c = c % p;
						}
					}
				}
				System.out.println(sum);
			}
		}
	}

}
