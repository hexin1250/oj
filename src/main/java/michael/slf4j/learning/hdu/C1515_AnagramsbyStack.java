package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class C1515_AnagramsbyStack {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String source = sc.next();
				String target = sc.next();
				Set<String> ret = dfs(target, source, 0, "", "", new Stack<Character>());
				System.out.println("[");
				ret.stream().forEach(System.out::println);
				System.out.println("]");
			}
		}
	}

	private static Set<String> dfs(String target, String source, int index, String current, String operation, Stack<Character> stack) {
		Set<String> ret = new TreeSet<>();
		if(index == source.length() && stack.isEmpty()) {
			if(current.equals(target)) {
				ret.add(operation);
			}
			return ret;
		}
		if(index < source.length()) {
			char ch = source.charAt(index);
			stack.push(ch);

			StringBuffer operationSb = new StringBuffer();
			operationSb.append(operation).append("i ");
			String newOperation = operationSb.toString();

			ret.addAll(dfs(target, source, index + 1, current, newOperation, stack));

			stack.pop();
		}
		if(!stack.isEmpty()) {
			char ch = stack.pop();

			StringBuffer strSb = new StringBuffer();
			strSb.append(current).append(ch);
			String newStr = strSb.toString();
			if(target.startsWith(newStr)) {
				StringBuffer operationSb = new StringBuffer();
				operationSb.append(operation).append("o ");
				String newOperation = operationSb.toString();
				
				ret.addAll(dfs(target, source, index, newStr, newOperation, stack));
			}

			stack.push(ch);
		}
		return ret;
	}

}
