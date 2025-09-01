package michael.slf4j.learning.leetcode;

public class C405 {

	public static void main(String[] args) {
		C405 c = new C405();
		System.out.println(c.toHex(26));
	}
	
	public String toHex(int num) {
		int[] nums = new int[8];
		int count = 1;
		for (int i = 1; i <= 8; i++) {
			nums[8 - i] = count;
			count <<= 4;
		}
		int[] arr = null;
		if(num < 0) {
			arr = new int[] {15,15,15,15,15,15,15,15};
			num += 1;
		} else {
			arr = new int[] {0,0,0,0,0,0,0,0};
		}
		boolean first = true;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			arr[i] += num / nums[i];
			num = num % nums[i];
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
