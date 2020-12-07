package michael.slf4j.learning.hdu;

import java.util.Random;

public class T1358 {

	public static void main(String[] args) {
		mock();
//		String str = "adccaddccacbccdcddcd";
//		String correct = AC1358_Period.getResult(str);
//		String wrong = C1358_Period.getResult(str);
//		System.out.println(correct);
//		System.out.println("###################");
//		System.out.println(wrong);
	}
	
	public static void mock() {
		int testcase = 1000000;
		Random r = new Random();
		while(testcase-- > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 20; i++) {
				char c = (char) (r.nextInt(4) + 'a');
				sb.append(c);
			}
			String str = sb.toString();
			boolean equals = judge(str);
			String correct = AC1358_Period.getResult(str);
			if(!equals && correct.trim().length() > 0) {
				System.out.println(str);
				System.out.println(correct);
				System.out.println("###################");
				System.out.println(C1358_Period.getResult(str));
				break;
			}
		}
	}
	
	public static boolean judge(String str) {
		String correct = AC1358_Period.getResult(str);
		String wrong = C1358_Period.getResult(str);
		return correct.equals(wrong);
	}

}
