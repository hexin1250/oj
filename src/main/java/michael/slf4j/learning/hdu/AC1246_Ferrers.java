package michael.slf4j.learning.hdu;

public class AC1246_Ferrers {

	public static void main(String[] args) {
		int a[] = new int[311];
		a[0] = 1;
		a[1] = 1;
		for (int i = 3; i < 310; i += 2) {
			for (int j = 310; j >= 0; j--) {
				if (i + j <= 310)
					a[i + j] += a[j];
			}
		}
		for (int i = 1; i <= 300; i++) {
			System.out.println(i + "->" + a[i] + ":" + C1246_Ferrers.mem[i]);
		}
	}

}
