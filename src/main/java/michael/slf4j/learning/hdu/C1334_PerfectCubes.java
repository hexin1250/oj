package michael.slf4j.learning.hdu;

public class C1334_PerfectCubes {

	public static void main(String[] args) {
		for (int i = 6; i <= 200; i++) {
			for (int j = 2; j*j*j <= i*i*i / 3; j++) {
				for (int k = j; k*k*k <= (i*i*i - j*j*j) / 2; k++) {
					for (int l = k; l*l*l <= i*i*i - j*j*j - k*k*k; l++) {
						if(l*l*l + k*k*k + j*j*j == i*i*i) {
							System.out.println(String.format("Cube = %s, Triple = (%s,%s,%s)", i,j,k,l));
						}
					}
				}
			}
		}
	}

}
