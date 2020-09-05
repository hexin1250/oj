package michael.slf4j.learning;

import java.util.Arrays;
import java.util.Scanner;

public class C1015_Safecracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			if("0 END".equalsIgnoreCase(line)) {
				break;
			}
			String[] parts = line.split("[\\s]+");
			int target = Integer.valueOf(parts[0]);
			String order = parts[1];
			char[] arr = order.toCharArray();
			Arrays.sort(arr);
			int[] numArr = convert(arr);
			int[] mem = new int[5];
			int[] visit = new int[order.length()];
			int[] ret = dfs(numArr, 0, mem, visit, target);
			if(ret != null) {
				char[] result = decode(ret);
				System.out.println(new String(result));
			} else {
				System.out.println("no solution");
			}
		}
		sc.close();
	}
	
	private static int[] dfs(int[] arr, int dept, int[] mem, int[] visit, int target) {
		if(dept == 5) {
			boolean find = find(mem, target);
			if(find) {
				return mem;
			} else {
				return null;
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if(visit[i] != 0) {
				continue;
			}
			visit[i] = 1;
			mem[dept] = arr[i];
			int[] result = dfs(arr, dept + 1, mem, visit, target);
			if(result != null) {
				return result;
			}
			visit[i] = 0;
		}
		return null;
	}
	
	private static boolean find(int[] a, int target) {
		if(a[0] - a[1]*a[1] + a[2]*a[2]*a[2] - a[3]*a[3]*a[3]*a[3] + a[4]*a[4]*a[4]*a[4]*a[4] == target) {
			return true;
		}
		return false;
	}
	
	private static int[] convert(char[] arr) {
		int[] ret = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ret[i] = arr[i] - 'A' + 1;
		}
		return ret;
	}
	
	private static char[] decode(int[] arr) {
		char[] ret = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ret[i] = (char) (arr[i] - 1 + 'A');
		}
		return ret;
	}

}
