package michael.slf4j.learning.leetcode;

public class C2081 {

	public static void main(String[] args) {
		C2081 c = new C2081();
		System.out.println(c.kMirror(7, 17));
	}

	public long kMirror(int k, int n) {
		long ret = 0L;
		int count = 0;
		for (int i = 1; i <= 9 && count < n; i++) {
			String s = Integer.toString(i, k);
			if(check(s)) {
				count++;
				ret += i;
			}
		}
		int currentDigit = 1;
		int[] arr = null;
		boolean start = true;
		boolean single = false;
		while(count < n) {
			boolean complete = false;
			if(start) {
				arr = new int[currentDigit];
				arr[currentDigit - 1] = 1;
				start = false;
			} else {
				for (int i = 0; i < currentDigit; i++) {
					arr[i]++;
					if(arr[i] == 10) {
						arr[i] = 0;
					} else {
						break;
					}
				}
				if(arr[currentDigit - 1] == 0) {
					complete = true;
				}
			}
			if(complete) {
				start = true;
				if(single) {
					single = false;
				} else {
					single = true;
					currentDigit++;
				}
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < currentDigit; i++) {
				if(!(single && i == currentDigit - 1)) {
					sb.append(arr[currentDigit - 1 - i]);
				}
			}
			for (int i = 0; i < currentDigit; i++) {
				sb.append(arr[i]);
			}
			long value = Long.valueOf(sb.toString());
			String nValue = Long.toString(value, k);
			if(check(nValue)) {
				ret += value;
				count++;
			}
		}
		return ret;
	}
	
	private boolean check(String s) {
		int len = s.length();
		boolean correct = true;
		for (int i = 0; i < len / 2; i++) {
			char a = s.charAt(i);
			char b = s.charAt(len - i - 1);
			if(a != b) {
				correct = false;
				break;
			}
		}
		return correct;
	}

}
