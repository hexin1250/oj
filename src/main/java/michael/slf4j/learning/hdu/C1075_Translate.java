package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1075_Translate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> dict = new HashMap<String, String>();
		boolean isDictFill = false;
		List<String> seq = new ArrayList<String>();
		while(sc.hasNext()) {
			String line = sc.nextLine();
			if("START".equals(line)) {
				continue;
			} else if("END".equals(line)) {
				if(!isDictFill) {
					isDictFill = true;
				} else {
					break;
				}
			} else if(!isDictFill) {
				String[] parts = line.split("[\\s]+");
				dict.put(parts[1], parts[0]);
			} else {
				seq.add(line);
			}
		}
		int startPoint = 0;
		for (String s : seq) {
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] <= 'z' && arr[i] >= 'a') {
					continue;
				} else {
					if(startPoint != i) {
						char[] chars = new char[i - startPoint];
						for (int j = startPoint; j < i; j++) {
							chars[j - startPoint] = arr[j];
						}
						String word = new String(chars);
						if(dict.get(word) != null) {
							System.out.print(dict.get(word));
						} else {
							System.out.print(word);
						}
					}
					System.out.print(arr[i]);
					startPoint = i + 1;
				}
			}
			System.out.println();
			startPoint = 0;
		}
		sc.close();
	}

}
