package michael.slf4j.learning;

import java.util.Scanner;

public class C1091_SumIII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0)
				break;
			System.out.println(a + b);
		}
		sc.close();
	}

}
