package michael.slf4j.learning.hdu;

public class C1012_Exp {

	public static void main(String[] args) {
		System.out.println("n e");
		System.out.println("- -----------");
		System.out.println("0 1");
		System.out.println("1 2");
		System.out.println("2 2.5");
		System.out.println("3 2.666666667");
		System.out.println("4 2.708333333");
		System.out.println("5 2.716666667");
		System.out.println("6 2.718055556");
		System.out.println("7 2.718253968");
		System.out.println("8 2.718278770");
		System.out.println("9 2.718281526");
	}
	
	public static void check() {
		System.out.println("n e");
		System.out.println("- -----------");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + nMultiply(i));
		}
	}
	
	private static double nMultiply(int n) {
		if(n == 0) {
			return 1D;
		}
		double m = 1D;
		for (int i = 1; i <= n; i++) {
			m *= i;
		}
		return 1 / m + nMultiply(n - 1);
	}

}
