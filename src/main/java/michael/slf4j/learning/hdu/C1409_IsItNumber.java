package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1409_IsItNumber {
	private static List<String> list = new ArrayList<>();
	
	static{
		/**
		 * 解决大部分数字问题，除了下面这个例子。
		 * .123E123
		 */
		list.add("^[\\d]+([.][\\d]*)?([E][+-]?[\\d]+)?$");
		/**
		 * 补齐上面缺失的部分。
		 */
		list.add("^[.][0-9]*(E[-|+]?[0-9]+)?$");
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			sc.nextLine();
			while (testcase-- > 0) {
				String line = sc.nextLine();
				if(judge(line)){
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static boolean judge(String line){
		for (String p : list) {
			Pattern pattern = Pattern.compile(p);
			Matcher m = pattern.matcher(line);
			if(m.matches()){
				return true;
			}
		}
		return false;
	}

}
