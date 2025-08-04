package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class C301 {

	public static void main(String[] args) {
		C301 c = new C301();
		List<String> list = c.removeInvalidParentheses("((i)");
		for (String s : list) {
			System.out.println(s);
		}
	}

	private int maxLength = -1;
	private int minDecrease = Integer.MAX_VALUE;
	public List<String> removeInvalidParentheses(String s) {
		int len = s.length();
		StringBuffer rightS = findRight(s, len, '(', ')');
		StringBuffer leftS = findRight(rightS.toString(), rightS.length(), ')', '(');
		String finalStr = leftS.toString();
		
		List<Character> list = new ArrayList<>();
		Set<String> set = traversal(finalStr, 0, 0, 0, list);
		final int strMax = maxLength;
		return set.stream().filter(str -> str.length() == strMax).collect(Collectors.toList());
	}

	private Set<String> traversal(String s, int index, int level, int decrease, List<Character> trackList) {
		Set<String> ret = new HashSet<String>();
		if(level > s.length() - index || decrease > minDecrease) {
			return ret;
		}
		if(index == s.length()) {
			if(level == 0 && trackList.size() >= maxLength) {
				maxLength = trackList.size();
				ret.add(trackList.stream().map(c -> c.toString()).collect(Collectors.joining()));
				if(minDecrease >= decrease) {
					minDecrease = decrease;
				}
			}
			return ret;
		}
		char c = s.charAt(index);
		if(c == '(') {
			/**
			 * use this char
			 */
			trackList.add(c);
			ret.addAll(traversal(s, index + 1, level + 1, decrease, trackList));
			
			/**
			 * revert
			 */
			trackList.remove(trackList.size() - 1);
			
			/**
			 * skip this char
			 */
			ret.addAll(traversal(s, index + 1, level, decrease + 1, trackList));
		} else if(c == ')') {
			if(level > 0) {
				/**
				 * use this char
				 */
				trackList.add(c);
				ret.addAll(traversal(s, index + 1, level - 1, decrease, trackList));
				
				/**
				 * revert
				 */
				trackList.remove(trackList.size() - 1);
			}
			
			/**
			 * skip this char
			 */
			ret.addAll(traversal(s, index + 1, level, decrease + 1, trackList));
		} else {
			trackList.add(c);
			ret.addAll(traversal(s, index + 1, level, decrease, trackList));
			/**
			 * revert
			 */
			trackList.remove(trackList.size() - 1);
		}
		return ret;
	}
	
	private StringBuffer findRight(String s, int len, char skip, char valid) {
		StringBuffer a = new StringBuffer();
		boolean findInvalid = true;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(len - i - 1);
			if(c == skip && findInvalid) {
				/**
				 * skip
				 */
				continue;
			} else if(c == valid && findInvalid) {
				findInvalid = false;
			} else if(findInvalid) {
				a.append(c);
			}
			if(!findInvalid) {
				a.append(c);
			}
		}
		return a;
	}

}
