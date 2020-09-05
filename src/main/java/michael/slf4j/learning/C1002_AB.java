package michael.slf4j.learning;

import java.util.Scanner;

public class C1002_AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= testcase; t++) {
			System.out.println("Case " + t + ":");
			String line = sc.nextLine();
			String[] parts = line.split("[\\s]+");
			System.out.println(parts[0] + " + " + parts[1] + " = " + plus(parts[0], parts[1]));
			if(t != testcase) {
				System.out.println();
			}
		}
		sc.close();
	}
	
	public static String plus(String s1, String s2) {
		int[] a = getArray(s1);
		int[] b = getArray(s2);
		int length = a.length > b.length ? a.length + 1 : b.length + 1;
		int[] ret = new int[length];
		for (int i = 0; i < length; i++) {
			if(i < a.length) {
				ret[i] += a[i];
			}
			if(i < b.length) {
				ret[i] += b[i];
			}
			if(ret[i] >= 10) {
				ret[i + 1] = ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		StringBuffer sb = new StringBuffer();
		boolean start = false;
		for (int i = length - 1; i >= 0; i--) {
			if(!start && ret[i] == 0) {
				continue;
			} else {
				start = true;
			}
			sb.append(ret[i]);
		}
		return sb.toString();
	}

	private static int[] getArray(String s) {
		char[] ch = s.toCharArray();
		int length = ch.length;
		int[] ret = new int[length];
		char init = '1';
		for (int i = 0; i < length; i++) {
			char c = ch[length - i - 1];
			if(c == '0') {
				ret[i] = 0;
			} else {
				ret[i] = c - init + 1;
			}
		}
		return ret;
	}

}
