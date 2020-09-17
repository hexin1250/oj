package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C1106_Sort {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String str = line.replaceAll("5", " ");
				String[] parts = str.split("[\\s]+");
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < parts.length; i++) {
					if(parts[i].trim().length() > 0) {
						list.add(Integer.valueOf(parts[i]));
					}
				}
				Collections.sort(list);
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					if(i != 0) {
						sb.append(' ');
					}
					sb.append(list.get(i));
				}
				System.out.println(sb.toString());
			}
		}
	}

}
