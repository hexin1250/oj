package michael.slf4j.learning.leetcode;

public class C443 {

	public static void main(String[] args) {
		char[] arr = new char[] {'a','a','b','b','c','c','c'};
		C443 c = new C443();
		int ret = c.compress(arr);
		System.out.println(ret);
	}
	
	public int compress(char[] chars) {
		int index = 0;
		char pre = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if(pre == chars[i]) {
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
		if(count > 1) {
			if(count < 10) {
				chars[index++] = (char)('0' + count);
			} else if(count < 100){
				chars[index++] = (char)('0' + count / 10);
				chars[index++] = (char)('0' + count % 10);
			} else if(count < 1000) {
				chars[index++] = (char)('0' + count / 100);
				count = count % 100;
				chars[index++] = (char)('0' + count / 10);
				chars[index++] = (char)('0' + count % 10);
			} else {
				chars[index++] = (char)('0' + count / 1000);
				count = count % 1000;
				chars[index++] = (char)('0' + count / 100);
				count = count % 100;
				chars[index++] = (char)('0' + count / 10);
				chars[index++] = (char)('0' + count % 10);
			}
		}
		return index;
	}

}
