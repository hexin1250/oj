package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1358_Period {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = 0;
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				String str = sc.next();
				System.out.println("Test case #" + (++testcase));
				System.out.println(getResult(str));
			}
		}
	}
	
	public static String getResult(String str) {
		StringBuffer sb = new StringBuffer();
		int n = str.length();
		char[] ch = str.toCharArray();
		int repLen = 1;
		List<Character> repList = new ArrayList<>();
		repList.add(ch[0]);
		repList.add(ch[1]);
		List<Character> compList = new ArrayList<>();
		if(ch[0] == ch[1]) {
			repLen = 1;
			sb.append("2 2\r\n");
		} else {
			repLen = 0;
		}
		for (int i = 2; i < n; i++) {
			if(repLen > 0) {
				repList.add(ch[i]);
				int index = (i + 1) % repLen;
				if(index == 0) {
					index = repLen;
				}
				if(repList.get(index - 1) != ch[i]) {
					repLen = 0;
					continue;
				} else if(index == repLen) {
					sb.append((i + 1) + " " + ((i + 1) / repLen));
					sb.append("\r\n");
				}
			} else {
				repList.add(ch[i]);
				compList.add(ch[i]);
				while(!compList.isEmpty()) {
					int size = compList.size();
					if(repList.get(size - 1) != compList.get(size - 1)) {
						compList.remove(0);
						continue;
					}
					break;
				}
				if(repList.size() == compList.size() * 2){
					repLen = compList.size();
					sb.append((i + 1) + " 2");
					sb.append("\r\n");
					compList.clear();
				}
			}
		}
		return sb.toString();
	}

}
