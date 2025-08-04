package michael.slf4j.learning.leetcode;

public class C1957 {

	public static void main(String[] args) {
	}

	public String makeFancyString(String s) {
		int len = s.length();
		StringBuffer sb = new StringBuffer();
		char pre = '1';
		int count = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c != pre) {
				pre = c;
				count = 1;
			} else {
				count++;
			}
			if(count < 3) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
