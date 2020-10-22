package michael.slf4j.util;

import java.util.Arrays;

public class BigNumberMultiply {
	private static final int BIT = 3;
	
	public static void main(String[] args) {
		String a = "1234567";
		String b = "2233445";
		print(multiply(basedOnStr(a), basedOnStr(b)));
	}
	
	public static int[] basedOnStr(String s) {
		char[] ch = s.toCharArray();
		int[] ret = new int[ch.length];
		for (int i = 0; i < ch.length; i++) {
			ret[ch.length - i - 1] = ch[i] - '0';
		}
		return ret;
	}
	
	public static void print(int[] arr) {
		StringBuffer sb = new StringBuffer();
		boolean start = false;
		for (int i = arr.length - 1; i >= 0; i--) {
			if(!start && arr[i] == 0) {
				continue;
			} else {
				start = true;
			}
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}

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
		int[] a1 = new int[10];
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
