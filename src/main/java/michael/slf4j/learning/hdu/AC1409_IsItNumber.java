package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class AC1409_IsItNumber {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			sc.nextLine();
			while (testcase-- > 0) {
				String line = sc.nextLine();
				if(judge(line)){
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static boolean judge(String line){
		return isnum(line);
	}

	private static boolean isnum(String line) {
		char[] a = line.toCharArray();
		int n = 0;
		while (n < a.length && a[n] >= '0' && a[n] <= '9')
			n++;
		if (n == a.length)
			return true;
		else if (a[n] == '.') {
			n++;
			while (n < a.length && a[n] >= '0' && a[n] <= '9')
				n++;
			if (n == a.length)
				return true;
			if (a[n] == 'E') {
				n++;
				if (n < a.length && (a[n] == '+' || a[n] == '-'))
					n++;
				if (n == a.length)
					return false;
				while (n < a.length && a[n] >= '0' && a[n] <= '9')
					n++;
				if (n == a.length)
					return true;
				return false;
			}
		} else if (a[n] == 'E') {
			if (n == 0)
				return false;
			n++;
			if (n < a.length && (a[n] == '+' || a[n] == '-'))
				n++;
			if (n == a.length)
				return false;
			while (n < a.length && a[n] >= '0' && a[n] <= '9')
				n++;
			if (n == a.length)
				return true;
			return false;
		}
		return false;
	}

}
