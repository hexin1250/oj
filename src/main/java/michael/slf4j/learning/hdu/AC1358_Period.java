package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class AC1358_Period {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = 0;
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				String str = sc.next();
				System.out.println("Test case #" + (++testcase));
				System.out.println(getResult(str));
			}
		}
	}
	
	public static String getResult(String str) {
		StringBuffer sb = new StringBuffer();
		char[] ch = str.toCharArray();
		int[] next = getNext(ch);
		int len = ch.length;
		for (int i = 1; i < len; i++) {
			if (next[i + 1] != 0 && (i + 1) % (i + 1 - next[i + 1]) == 0) {
				sb.append(i + 1 + " " + (i + 1) / (i + 1 - next[i + 1]));
				sb.append("\r\n");
			}
		}
		return sb.toString();

	}
	
	public static int[] getNext(char[] ch) {
		int len = ch.length;
		int[] next = new int[ch.length + 1];
		int i = 0, j = -1;
		next[0] = -1;
		while (i < len) {
			if (j == -1 || ch[i] == ch[j]) {
				i++;
				j++;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;
	}

}
