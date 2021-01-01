package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1407 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				boolean find = false;
				for (int i = 1; i <= 100; i++) {
					for (int j = i; j <= 100 && i*i+j*j<n; j++) {
						for (int k = j; k <= 100; k++) {
							if(i*i+j*j+k*k==n){
								System.out.println(i + " " + j + " " + k);
								find = true;
								break;
							}
						}
						if(find){
							break;
						}
					}
					if(find){
						break;
					}
				}
			}
		}
	}

}
