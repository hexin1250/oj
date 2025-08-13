package michael.slf4j.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

public class C383 {

	public static void main(String[] args) {
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
		if(magazine.length() < ransomNote.length()) {
			return false;
		}
		
		int[] arr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			int index = c - 'a';
			arr[index]++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			int index = c - 'a';
			if((arr[index] = arr[index] - 1) < 0) {
				return false;
			}
		}
		return true;
    }

}
