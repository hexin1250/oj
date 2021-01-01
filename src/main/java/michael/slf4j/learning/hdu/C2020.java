package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C2020 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()){
				int n = sc.nextInt();
				if(n == 0){
					break;
				}
				Integer[] arr = new Integer[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				Arrays.sort(arr, new Comparator<Integer>(){

					@Override
					public int compare(Integer arg0, Integer arg1) {
						int i = Math.abs(arg0);
						int j = Math.abs(arg1);
						return i > j ? -1 : 1;
					}
					
				});
				System.out.println(Arrays.stream(arr).map(i -> i.toString()).collect(Collectors.joining(" ")));
			}
		}
	}

}
