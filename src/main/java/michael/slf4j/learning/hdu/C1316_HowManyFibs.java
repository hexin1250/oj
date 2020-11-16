package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.Scanner;

public class C1316_HowManyFibs {
	private static BigDecimal[] mem = new BigDecimal[500];
	private static int index = 2;
	
	static {
		mem[0] = new BigDecimal(1);
		mem[1] = new BigDecimal(2);
		while(true) {
			mem[index] = mem[index - 1].add(mem[index - 2]);
			if(mem[index].toString().length() > 100) {
				break;
			}
			index++;
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String lowerStr = sc.next();
				String upperStr = sc.next();
				if("0".equals(lowerStr) && "0".equals(upperStr)) {
					break;
				}
				BigDecimal lower = new BigDecimal(lowerStr);
				BigDecimal upper = new BigDecimal(upperStr);
				int count = 0;
				for (int i = 0; i <= index; i++) {
					if(mem[i].compareTo(lower) < 0) {
						continue;
					}
					if(mem[i].compareTo(upper) > 0) {
						break;
					}
					count++;
				}
				System.out.println(count);
			}
		}
	}

}
