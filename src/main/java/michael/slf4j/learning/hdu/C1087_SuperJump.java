package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1087_SuperJump {
	private static Map<Integer, Integer> record = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0)
				break;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				max = Math.max(max, jump(arr, i, -1));
			}
			System.out.println(max);
			record.clear();
		}
		sc.close();
	}
	
	private static int jump(int[] arr, int start, int previous) {
		int max = 0;
		for (int i = start; i < arr.length; i++) {
			if(arr[i] <= previous) {
				continue;
			}
			int score = arr[i];
			if(record.get(new Integer(i + 1)) != null) {
				score += record.get(new Integer(i + 1));
			} else {
				int nextScore = jump(arr, i+1, arr[i]);
				record.put(new Integer(i + 1), nextScore);
				score = arr[i] + nextScore;
			}
			max = Math.max(score, max);
		}
		return max;
	}

}
