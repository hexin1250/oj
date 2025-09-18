package michael.slf4j.learning.leetcode;

public class C405 {

	public static void main(String[] args) {
		C405 c = new C405();
		System.out.println(c.toHex(-2098));
	}
	
	public String toHex(int num) {
		int[] arr = null;
		if(num < 0) {
			arr = new int[] {15,15,15,15,15,15,15,15};
			num += 1;
		} else {
			arr = new int[] {0,0,0,0,0,0,0,0};
		}
		boolean first = true;
		StringBuffer sb = new StringBuffer();
		int mod = 1 << 28;
		for (int i = 0; i < 8; i++) {
			arr[i] += num / mod;
			num = num % mod;
			mod = mod >> 4;
			if(arr[i] == 0 && first == true) {
				continue;
			}
			first = false;
			if(arr[i] >= 0 && arr[i] <= 9) {
				sb.append((char)(arr[i] + '0'));
			} else {
				sb.append((char)(arr[i] - 10 + 'a'));
			}
		}
		if(sb.isEmpty()) {
			return "0";
		}
        return sb.toString();
    }

}
