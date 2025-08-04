package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C22 {

	public static void main(String[] args) {
		C22 c = new C22();
		List<String> ret = c.generateParenthesis(5);
		System.out.println(ret);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		traversal(n, 0, 0, sb, list);
		return list;
	}

	private void traversal(int n, int left, int right, StringBuffer sb, List<String> list) {
		if(left == right && right == n) {
			list.add(sb.toString());
			return;
		}
		if(left < n) {
			sb.append("(");
			traversal(n, left + 1, right, sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(right < left) {
			sb.append(")");
			traversal(n, left, right + 1, sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
