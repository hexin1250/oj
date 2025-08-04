package michael.slf4j.learning.leetcode;

public class C3330 {

	public static void main(String[] args) {
		C3330 c = new C3330();
		System.out.println(c.possibleStringCount("aaaa"));
	}

	public int possibleStringCount(String word) {
		int len = word.length();
		int ret = 1;
		for (int i = 1; i < len; i++) {
			if(word.charAt(i - 1) == word.charAt(i)) {
				ret++;
			}
		}
		return ret;
	}

}
