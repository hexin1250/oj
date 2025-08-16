package michael.slf4j.learning.leetcode;

import java.util.Stack;

public class C394 {

	public static void main(String[] args) {
		C394 c = new C394();
		String s = "3[a]2[bc]";
		System.out.println(c.decodeString(s));
	}

	public String decodeString(String s) {
		int len = s.length();
		int repeat = 0;
		Stack<StringBuffer> stack = new Stack<>();
		Stack<Integer> countStack = new Stack<>();
		stack.push(new StringBuffer());
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				int num = c - '0';
				repeat = repeat * 10 + num;
			} else if(c == '[') {
				countStack.push(repeat);
				stack.push(new StringBuffer());
				repeat = 0;
			} else if(c == ']') {
				int repeatNum = countStack.pop();
				StringBuffer newSb = stack.pop();
				
				StringBuffer sb = stack.peek();
				sb.append(newSb.toString().repeat(repeatNum));
			} else {
				StringBuffer sb = stack.peek();
				sb.append(c);
			}
		}
		return stack.pop().toString();
	}

}
