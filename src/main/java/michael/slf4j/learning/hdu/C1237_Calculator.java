package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Stack;

public class C1237_Calculator {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String line = sc.nextLine();
				if("0".equals(line)) {
					break;
				}
				String[] parts = line.split("[\\s]+");
				boolean isNumber = true;
				Stack<Double> numberStack = new Stack<>();
				Stack<Character> charStack = new Stack<>();
				for (int i = 0; i < parts.length; i++) {
					if(i % 2 == 0) {
						isNumber = true;
					} else {
						isNumber = false;
					}
					if(isNumber) {
						double number = Double.valueOf(parts[i]);
						if(numberStack.isEmpty()) {
							numberStack.push(number);
						} else {
							Character ch = charStack.pop();
							if(ch == '*' || ch == '/') {
								double preNumber = numberStack.pop();
								double currentRet = 0D;
								if(ch == '*') {
									currentRet = preNumber * number;
								} else {
									currentRet = preNumber / number;
								}
								numberStack.push(currentRet);
							} else {
								charStack.push(ch);
								numberStack.push(number);
							}
							if(numberStack.size() > 1) {
								if(i + 1 < parts.length) {
									char c = getCh(parts[i + 1]);
									if(c == '+' || c == '-') {
										char preCh = charStack.pop();
										double nowN = numberStack.pop();
										double preN = numberStack.pop();
										double ret = 0D;
										if(preCh == '+') {
											ret = preN + nowN;
										} else {
											ret = preN - nowN;
										}
										numberStack.push(ret);
									}
								} else {
									char c = charStack.pop();
									double nowN = numberStack.pop();
									double preN = numberStack.pop();
									double ret = 0D;
									if(c == '+') {
										ret = preN + nowN;
									} else {
										ret = preN - nowN;
									}
									numberStack.push(ret);
								}
							}
						}
					} else {
						charStack.push(getCh(parts[i]));
					}
				}
				System.out.printf("%.2f\r\n", numberStack.pop());
			}
		}
	}
	
	private static char getCh(String s) {
		return s.charAt(0);
	}

}
