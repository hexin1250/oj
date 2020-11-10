package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1282 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String line = sc.nextLine();
				char[] ch = line.toCharArray();
				int[] a = new int[line.length()];
				for (int i = 0; i < a.length; i++) {
					a[a.length - i - 1] = ch[i] - '0';
				}
				int times = 0;
				List<int[]> list = new ArrayList<>();
				list.add(a);
				while(!check(a)) {
					a = getSumArray(a);
					list.add(a);
					times++;
				}
				System.out.println(times);
				System.out.println(list.stream().map(arr -> {
					StringBuffer sb = new StringBuffer();
					for (int i = arr.length - 1; i >= 0; i--) {
						sb.append(arr[i]);
					}
					return sb.toString();
				}).collect(Collectors.joining("--->")));
			}
		}
	}
	
	private static boolean check(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			if(a[i] != a[a.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	private static int[] getSumArray(int[] a) {
		int len = a.length;
		int[] b = new int[len];
		int index = 0;
		for (int i = len - 1; i >= 0; i--) {
			if(index == 0 && a[i] == 0) {
				continue;
			}
			b[index++] = a[i];
		}
		int[] ret = new int[len];
		for (int i = 0; i < len; i++) {
			ret[i] += a[i] + b[i];
			if(i != len - 1) {
				ret[i + 1] = ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		if(ret[len - 1] >= 10) {
			int[] tmp = new int[len + 1];
			for (int i = 0; i < len; i++) {
				tmp[i] = ret[i];
			}
			tmp[len] = tmp[len - 1] / 10;
			tmp[len - 1] = tmp[len - 1] % 10;
			return tmp;
		}
		return ret;
	}

}
