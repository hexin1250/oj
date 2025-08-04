package michael.slf4j.learning.leetcode;

public class C3612 {

	public static void main(String[] args) {
	}

	public String processStr(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c <= 'z' && c >= 'a') {
				sb.append(c);
			} else if(c == '*') {
				if(sb.length() > 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else if(c == '#') {
				sb.append(sb.toString());
			} else if(c == '%') {
				sb = sb.reverse();
			}
		}
		return sb.toString();
	}

}
