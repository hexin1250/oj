package michael.slf4j.learning;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class C1027_PrincessII {
	private static final int f[] = new int[] {1, 1, 2, 6, 24, 120, 720, 5040};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int start = 0;
			int l = n;
			if(n > 8) {
				for (int i = 1; i <= n - 8; i++) {
					System.out.print(i + " ");
				}
				start = n - 8;
				l = 8;
			}
//			题目中的第1小，对应逆康托展开中的是0，所以此处为了代码AC，进行m-1
			int mod = m - 1;
			int index = 0;
			int[] arr = new int[l];
			List<Integer> list = new LinkedList<>();
			for (int i = 1; i <= l; i++) {
				list.add(i);
			}
			for (int i =  l - 1; i >= 1; i--) {
				int rank = mod / f[i];
				arr[index++] = list.remove(rank);
				mod = mod % f[i];
			}
			arr[index] = list.remove(0);
			for (int i = 0; i <= index; i++) {
				if(i != 0) {
					System.out.print(" ");
				}
				System.out.print(arr[i] + start);
			}
			System.out.println();
		}
		sc.close();
	}

}
