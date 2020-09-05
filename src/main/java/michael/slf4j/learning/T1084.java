package michael.slf4j.learning;

import java.util.Random;

public class T1084 {

	public static void main(String[] args) {
		Random r = new Random();
		int n = r.nextInt(10);
		System.out.println(n);
		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(r.nextInt(6));
			sb.append(' ');
			sb.append(r.nextInt(23));
			sb.append(':');
			sb.append(r.nextInt(59));
			sb.append(':');
			sb.append(r.nextInt(59));
			lines[i] = sb.toString();
			System.out.println(lines[i]);
		}
		System.out.println("-----------------------------------");
		C1084_Grade.print(n, lines);
		System.out.println("-----------------------------------");
		AC1084_Grade.print(n, lines);
		System.out.println("-----------------------------------");
	}

}
