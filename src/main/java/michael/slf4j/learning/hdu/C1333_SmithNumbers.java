package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1333_SmithNumbers {
	public static boolean isSmith(int n) {
		int target = n;
		List<Integer> list = new ArrayList<>();
		int mid = (int)(Math.sqrt(n));
		int index = 2;
		while(index <= mid) {
			if(n < index) {
				break;
			}
			if(n % index == 0) {
				list.add(index);
				n = n / index;
			} else {
				index++;
			}
		}
		if(n == target) {
			return false;
		} else if(n != 1) {
			list.add(n);
		}
		int sum = 0;
		for (Integer i : list) {
			sum += getSum(i);
		}
		int comparasion = getSum(target);
		return sum == comparasion;
	}
	
	public static int getSum(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
	
	public static boolean isPrime(int n) {
		int mid = (int)(Math.sqrt(n));
		for (int i = 2; i <= mid; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				while(true) {
					if(isSmith(++n)) {
						System.out.println(n);
						break;
					}
				}
			}
		}
	}

}
