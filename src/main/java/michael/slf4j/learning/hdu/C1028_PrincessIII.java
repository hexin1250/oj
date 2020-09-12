package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1028_PrincessIII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			long b = System.currentTimeMillis();
			int cons = combination(n, new int[] {7}, 1);
			long a = System.currentTimeMillis();
			System.out.println(n + ":" + (cons + 1) + ":" + (a - b));
		}
		sc.close();
	}

	private static int combination(int n, int[] arr, int last) {
		int sum = 0;
		int index = last;
		while(n - index >= index && index >= last) {
			int[] newArr = new int[arr.length + 1];
			for (int i = 0; i < arr.length - 1; i++) {
				newArr[i] = arr[i];
			}
			newArr[arr.length - 1] = index;
			newArr[arr.length] = n - index;
//			print(newArr);
			sum += combination(n - index, newArr, index) + 1;
			index++;
		}
		return sum;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(i != 0) {
				System.out.print('+');
			}
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
