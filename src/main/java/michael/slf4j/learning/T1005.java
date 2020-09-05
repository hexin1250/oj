package michael.slf4j.learning;

import java.util.Random;

public class T1005 {

	public static void main(String[] args) {
//		59 70 71
//		68 20 61
//		34 62 30
//		3 6 56
		Random r = new Random();
		while(true) {
			int a = r.nextInt(10) + 1;
			int b = r.nextInt(10) + 1;
			int c = r.nextInt(50) + 50;
//			int a = 3, b = 6, c = 56;
			for (int i = 1; i <= c; i++) {
				int[] arr = C1005_Number_Sequence.print(a, b, i);
				int trueRet = AC1005.f(i, a, b);
				System.out.println(a + " " + b + " " + i + "-----My Output:" + arr[0] + ", AC Output:" + trueRet);
//				if(arr[0] != arr[1] && trueRet != arr[0]) {
//					System.out.println(a + " " + b + " " + c + "-----My Output:" + arr[0] + ", AC Output:" + trueRet);
//					break;
//				}
			}
			break;
		}
	}

}
