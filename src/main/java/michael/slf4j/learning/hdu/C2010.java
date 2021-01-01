package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C2010 {
	private static List<Integer> list = new ArrayList<>();
	
	static {
		for (int i = 100; i <= 999; i++) {
			if(find(i)){
				list.add(i);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(x > y){
					int tmp = x;
					x = y;
					y = tmp;
				}
				List<Integer> ret = new ArrayList<Integer>();
				for (int i : list) {
					if(i >= x && i <= y){
						ret.add(i);
					}
				}
				if(ret.isEmpty()){
					System.out.println("no");
				} else {
					System.out.println(ret.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
				}
			}
		}
	}
	
	private static int[] getByte(int n){
		int[] ret = new int[3];
		ret[0] = n / 100;
		ret[1] = (n / 10) % 10;
		ret[2] = n % 10;
		return ret;
	}
	
	private static boolean find(int n){
		int[] ret = getByte(n);
		return ret[0]*ret[0]*ret[0]+ret[1]*ret[1]*ret[1]+ret[2]*ret[2]*ret[2] == n;
	}

}
