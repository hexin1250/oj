package michael.slf4j.learning.leetcode;

public class C443 {

	public static void main(String[] args) {
		char[] arr = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		C443 c = new C443();
		int ret = c.compress(arr);
		System.out.println(ret);
	}

	public int compress(char[] chars) {
		int index = 0;
		char pre = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if (pre == chars[i]) {
				count++;
			} else {
				chars[index++] = pre;
				index = generateCount(chars, index, count);
				count = 1;
				pre = chars[i];
			}
		}
		chars[index++] = pre;
		index = generateCount(chars, index, count);
		return index;
	}

	private int generateCount(char[] chars, int index, int count) {
		int digit = 0;
		if (count > 1) {
			if (count < 10) {
				digit = 1;
			} else if (count < 100) {
				digit = 2;
			} else if (count < 1000) {
				digit = 3;
			} else {
				digit = 4;
			}
		}
		for (int i = digit - 1; i >= 0; i--) {
			chars[index + i] = (char)(count % 10 + '0');
			count = count / 10;
		}
		return index + digit;
	}

	public int compress2(char[] chars) {
		StringBuffer sb = new StringBuffer();
		char pre = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if (pre == chars[i]) {
				count++;
			} else {
				sb.append(pre);
				if (count > 1) {
					sb.append(count);
				}
				count = 1;
				pre = chars[i];
			}
		}
		sb.append(pre);
		if (count > 1) {
			sb.append(count);
		}
		for (int i = 0; i < sb.length(); i++) {
			chars[i] = sb.charAt(i);
		}
		return sb.length();
	}

}
