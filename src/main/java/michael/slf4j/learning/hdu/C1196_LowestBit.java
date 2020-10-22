package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1196_LowestBit {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				System.out.println(getBit(n, 64));
			}
		}
	}
	
	private static int getBit(int n, int mod) {
		if(mod == 1) {
			return mod;
		}
		if(n % mod == 0) {
			return mod;
		}
		return getBit(n % mod, mod / 2);
	}

}
