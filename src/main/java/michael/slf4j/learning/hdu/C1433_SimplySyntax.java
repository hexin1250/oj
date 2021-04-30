package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Stack;

public class C1433_SimplySyntax {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String line = sc.nextLine();
				Stack<Character> stack = new Stack<>();
				for (int i = 0; i < line.length(); i++) {
					stack.push(line.charAt(i));
				}
				boolean correct = validate(line);
				System.out.println(correct ? "YES" : "NO");
			}
		}
	}
	
	public static boolean validate(String line) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			stack.push(line.charAt(i));
		}
		boolean correct = false;
		int group = 0;
		while(!stack.isEmpty()) {
			char ch = stack.pop();
			if(group == 0) {
				if(ch <= 'z' && ch >= 'p') {
					correct = true;
					group = 1;
				} else {
					correct = false;
					break;
				}
			} else if(group == 1) {
				if(ch <= 'z' && ch >= 'p') {
					correct = false;
					group = 2;
				} else if(ch == 'N') {
					correct = true;
				} else {
					correct = false;
					break;
				}
			} else {
				if(ch == 'C' || ch == 'D' || ch == 'E' || ch == 'I') {
					group = 1;
					correct = true;
				} else {
					correct = false;
					break;
				}
			}
		}
		return correct;
	}

}
