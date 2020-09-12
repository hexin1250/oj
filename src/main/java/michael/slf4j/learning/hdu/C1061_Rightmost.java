package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1061_Rightmost {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				
				int a = n;
				int b = n;
				int tail = a % 10;
				int ret = -1;
				if(tail == 0 || tail == 1 || tail == 5 || tail == 6) {
					ret = tail;
				} else if(tail == 9 || tail == 4) {
					int times = b % 2;
					int[] nine = new int[] {1,9};
					int[] four = new int[] {6,4};
					if(tail == 9) {
						ret = nine[times];
					} else {
						ret = four[times];
					}
				} else {
					int times = b % 4;
					int[] three = new int[] {1,3,9,7};
					int[] seven = new int[] {1,7,9,3};
					int[] two = new int[] {6,2,4,8};
					int[] eight = new int[] {6,8,4,2};
					if(tail == 3) {
						ret = three[times];
					} else if(tail == 7) {
						ret = seven[times];
					} else if(tail == 2) {
						ret = two[times];
					} else {
						ret = eight[times];
					}
				}
				System.out.println(ret);
			}
		}
	}

}
