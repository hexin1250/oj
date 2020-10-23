package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1212_BigNumber {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				int[] nArr = getArr(parts[0]);
				int mod = Integer.valueOf(parts[1]);
				
				int index = 0;
				int ret = 0;
				while(index < nArr.length) {
					ret = nArr[index] + ret * 10;
					if(ret >= mod) {
						nArr[index] = ret % mod;
						ret = 0;
						continue;
					}
					index++;
				}
				System.out.println(ret % mod);
			}
		}
	}
	
	private static int[] getArr(String bigNumber) {
		char[] ch = bigNumber.toCharArray();
		int[] ret = new int[bigNumber.length()];
		for (int i = 0; i < bigNumber.length(); i++) {
			ret[i] = ch[i] - '0';
		}
		return ret;
	}

}
