package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Stack;

public class C1274 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				String s = sc.next();
				char[] ch = s.toCharArray();
				String ret = output(ch);
				System.out.println(ret);
			}
		}
	}

	private static String output(char[] ch) {
		Stack<Integer> st = new Stack<>();
		Stack<StringBuffer> strStack = new Stack<>();
		st.push(1);
		strStack.push(new StringBuffer());
		int len = ch.length;
		for (int i = 0; i < len; i++) {
			if(ch[i] <= '9' && ch[i] >= '0') {
				int times = ch[i] - '0';
				if(i + 1 < len) {
					if(ch[i + 1] != '(') {
						StringBuffer sb = strStack.pop();
						for (int j = 0; j < times; j++) {
							sb.append(ch[i + 1]);
						}
						strStack.push(sb);
					} else {
						st.push(times);
						strStack.push(new StringBuffer());
					}
				}
				i++;
			} else if(ch[i] == '(') {
				st.push(1);
				strStack.push(new StringBuffer());
			} else if(ch[i] == ')') {
				StringBuffer embedded = strStack.pop();
				int times = st.pop();
				StringBuffer target = strStack.pop();
				for (int j = 0; j < times; j++) {
					target.append(embedded);
				}
				strStack.push(target);
			} else {
				StringBuffer sb = strStack.pop();
				sb.append(ch[i]);
				strStack.push(sb);
			}
		}
		StringBuffer ret = strStack.pop();
		return ret.toString();
	}

}
