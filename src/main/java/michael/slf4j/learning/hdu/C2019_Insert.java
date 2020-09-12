package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C2019_Insert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			if(n == 0 && x == 0) {
				break;
			}
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			StringBuffer sb = new StringBuffer();
			if(x <= a[0]) {
				sb.append(x);
				for (int i = 0; i < n; i++) {
					sb.append(" ").append(a[i]);
				}
			} else if(x >= a[n - 1]) {
				for (int i = 0; i < n; i++) {
					sb.append(a[i]).append(" ");
				}
				sb.append(x);
			} else {
				int index = searchFirstLarge(a, x, 0, n - 1);
				for (int i = 0; i < n; i++) {
					if(i != 0) {
						sb.append(' ');
					}
					sb.append(a[i]);
					if(i == index) {
						sb.append(' ').append(x);
					}
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

	public static int searchFirstLarge(int[] ret, int find, int start, int end) {
		int mid = (start + end) / 2;
		if(ret[mid] == find) {
			return mid;
		}
		if(find < ret[mid]) {
			if(start == mid) {
				return start - 1;
			}
			return searchFirstLarge(ret, find, start, mid - 1);
		} else {
			if(end == mid + 1) {
				return mid;
			} else if(end == mid && mid == start) {
				return mid;
			}
			return searchFirstLarge(ret, find, mid + 1, end);
		}
	}

}
