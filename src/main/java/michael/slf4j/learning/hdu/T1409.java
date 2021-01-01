package michael.slf4j.learning.hdu;

import java.util.Random;

public class T1409 {

	public static void main(String[] args) {
		Random r = new Random();
		int count = 100000;
		while (count-- > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 10; i++) {
				int d = r.nextInt(17);
				char c = ' ';
				if (d < 10) {
					c = (char) ('0' + d);
				} else if (d == 10) {
					c = ' ';
				} else if (d == 11) {
					c = '-';
				} else if (d == 12) {
					c = '+';
				} else if (d == 13) {
					c = 'E';
				} else if (d == 14) {
					c = 'e';
				} else if (d == 15) {
					c = 'F';
				} else if (d == 16) {
					c = '.';
				}
				sb.append(c);
			}
			String line = sb.toString();
			boolean ac = AC1409_IsItNumber.judge(line);
			boolean wa = C1409_IsItNumber.judge(line);
			if (ac != wa) {
				System.out.println(line + "->ac:" + ac + ",wa:" + wa);
				break;
			}
		}
	}

}
