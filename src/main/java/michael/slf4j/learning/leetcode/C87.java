package michael.slf4j.learning.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C87 {

	public static void main(String[] args) {
		C87 c = new C87();
//		String s1 = "abcde";
//		String s2 = "caebd";
//		String s1 = "great";
//		String s2 = "rgeat";
//		String s1 = "abcdbdacbdac";
//		String s2 = "bdacabcdbdac";
//		String s1 = "abcdbdac";
//		String s2 = "bdacabcd";
		String s1 = "abb";
		String s2 = "bba";
		System.out.println(c.isScramble(s1, s2));
	}
	
	private Map<String, Boolean> mem = new HashMap<>();

	public boolean isScramble(String s1, String s2) {
		String key = s1 + "/" + s2;
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		if(s1.equals(s2)) {
			return true;
		}
		if(s1.length() != s2.length()) {
			return false;
		}
		if(s1.length() == 1) {
			return false;
		} else if(s1.length() == 2) {
			if(s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0)) {
				return true;
			} else {
				return false;
			}
		}
		int len = s1.length();
		for (int i = 1; i < len; i++) {
			String leftS1 = s1.substring(0, i);
			String rightS1 = s1.substring(i, len);
			String leftS2 = s2.substring(0, i);
			String rightS2 = s2.substring(i, len);
			
			if(sameCount(leftS1, leftS2) && sameCount(rightS1, rightS2)) {
				boolean left = isScramble(leftS1, leftS2);
				boolean right = isScramble(rightS1, rightS2);
				mem.put(leftS1 + "/" + leftS2, left);
				mem.put(rightS1 + "/" + rightS2, right);
				if(left && right) {
					return true;
				}
			}
			
			String reverseLeftS2 = s2.substring(0, len - i);
			String reverseRightS2 = s2.substring(len - i, len);
			if(sameCount(leftS1, reverseRightS2) && sameCount(rightS1, reverseLeftS2)) {
				boolean left = isScramble(leftS1, reverseRightS2);
				boolean right = isScramble(rightS1, reverseLeftS2);
				mem.put(leftS1 + "/" + reverseRightS2, left);
				mem.put(rightS1 + "/" + reverseLeftS2, right);
				if(left && right) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean sameCount(String s1, String s2) {
		int[] arr1 = new int[26];
		Set<Character> set1 = new HashSet<>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			set1.add(c);
			arr1[c - 'a']++;
		}
		int[] arr2 = new int[26];
		Set<Character> set2 = new HashSet<>();
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			set2.add(c);
			arr2[c - 'a']++;
		}
		for (char c : set1) {
			if(arr1[c - 'a'] != arr2[c - 'a']) {
				return false;
			}
			set2.remove(c);
		}
		if(!set2.isEmpty()) {
			return false;
		}
		return true;
	}

}
