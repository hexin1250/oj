package michael.slf4j.learning;

import java.util.Scanner;

public class C1089_SumI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(sc.nextInt() + sc.nextInt());
		}
		sc.close();
	}

}
