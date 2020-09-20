package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C1114_PiggyBank {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int empty = sc.nextInt();
				int full = sc.nextInt();
				int n = sc.nextInt();
				PackageValue[] arr = new PackageValue[n];
				for (int i = 0; i < n; i++) {
					arr[i] = new PackageValue(sc.nextInt(), sc.nextInt());
				}
				Arrays.sort(arr, new Comparator<PackageValue>() {
					@Override
					public int compare(PackageValue o1, PackageValue o2) {
						if(o1.p < o2.p) {
							return 1;
						} else if(o1.p > o2.p) {
							return -1;
						}
						if(o1.v < o2.v) {
							return 1;
						} else if(o1.v > o2.v) {
							return -1;
						}
						return 0;
					}
				});
				int packageP = full - empty;
				int min = getMinV(n, arr, 0, packageP, 0, -1);
				if(min == -1) {
					System.out.println("This is impossible.");
				} else {
					System.out.println("The minimum amount of money in the piggy-bank is " + min + ".");
				}
			}
		}
	}

	private static int getMinV(int n, PackageValue[] arr, int index, int packageP, int currentValue, int min) {
		if(packageP < 0) {
			return -1;
		}
		int v = arr[index].v;
		int p = arr[index].p;
		if(index == n - 1) {
			if(packageP % p != 0) {
				return -1;
			} else {
				return currentValue + packageP * v / p;
			}
		}
		if(min != -1 && currentValue >= min) {
			return -1;
		}
		int maxCount = packageP / p + 1;
		int minVal = -1;
		for (int i = 0; i <= maxCount; i++) {
			int ret = getMinV(n, arr, index + 1, packageP - p * i, currentValue + v * i, minVal);
			if(ret != -1) {
				if(minVal == -1 || ret < minVal) {
					minVal = ret;
				}
			}
		}
		return minVal;
	}
	
	public static class PackageValue {
		public int p;
		public int v;
		public PackageValue(int v, int p) {
			this.v = v;
			this.p = p;
		}
	}

}
