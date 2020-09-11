package michael.slf4j.util;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumberMultiply {
	private static final int BIT = 3;

	public static int[] multiply(int a, int b) {
		return multiply(nOfArray(a), nOfArray(b));
	}

	public static int[] multiply(int[] a, int[] b) {
		int[] ret = new int[a.length + b.length];
		for (int i = 0; i < a.length; i+=BIT) {
			int numberI = getNumber(a, i, BIT);
			for (int j = 0; j < b.length; j+=BIT) {
				int numberJ = getNumber(b, j, BIT);
				ret[i + j] += numberI * numberJ;
			}
		}
		for (int i = 0; i < a.length + b.length - 1; i++) {
			if(ret[i] / 10 > 0) {
				ret[i + 1] += ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		return ret;
	}

	private static int getNumber(int[] a, int start, int bit) {
		int sum = 0;
		int initP = (start + bit) > a.length ? a.length : (start + bit);
		for (int i = initP - 1; i >= start; i--) {
			sum *= 10;
			sum += a[i];
		}
		return sum;
	}
	
	private static int[] nOfArray(int a) {
		int index = 0;
		int[] a1 = new int[6];
		while(a / 10 > 0) {
			if(a / 10 > 0) {
				a1[index] = a % 10;
				a = a / 10;
			}
			index++;
		}
		a1[index++] = a;
		return Arrays.copyOf(a1, index);
	}

}
