package michael.slf4j.learning.leetcode;

public class C3136 {

	public static void main(String[] args) {
	}

	public boolean isValid(String word) {
		if(word.length() < 3) {
			return false;
		}
		char[] arr = word.toCharArray();
		boolean keyChar = false;
		boolean wordChar = false;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
				return false;
			}
			if(keyChar && wordChar) {
				continue;
			}
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				keyChar = true;
			} else if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
				wordChar = true;
			}
		}
		return keyChar && wordChar;
	}

}
