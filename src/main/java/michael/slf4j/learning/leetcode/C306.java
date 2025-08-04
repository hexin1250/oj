package michael.slf4j.learning.leetcode;

public class C306 {

	public static void main(String[] args) {
		C306 c = new C306();
		String s = "101";
		System.out.println(c.isAdditiveNumber(s));
	}

	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = num.charAt(i) - '0';
		}
		/**
		 * first number length
		 */
		for (int i = 1; i <= 17 && i <= len / 2 + 1; i++) {
			int[] firstNum = extractNum(arr, i, 0);
			if(firstNum[0] == 0 && firstNum.length > 1) {
				break;
			}
			/**
			 * second num length = j - i
			 */
			for (int j = i + 1; j < len; j++) {
				int[] secondNum = extractNum(arr, j - i, i);
				if(secondNum[0] == 0 && secondNum.length > 1) {
					break;
				}
				int restLen = len - j;
				int[] restNum = new int[restLen];
				System.arraycopy(arr, j, restNum, 0, restLen);
				boolean ret = checkValid(firstNum, secondNum, restNum);
				if(ret) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkValid(int[] firstNum, int[] secondNum, int[] checkNum) {
		int[] sumNum = sum(firstNum, secondNum);
		if(sumNum.length > checkNum.length) {
			return false;
		}
		int len = sumNum.length;
		for (int i = 0; i < len; i++) {
			if(sumNum[i] != checkNum[i]) {
				return false;
			}
		}
		int restLen = checkNum.length - len;
		if(restLen == 0) {
			return true;
		}
		int[] restNum = new int[restLen];
		System.arraycopy(checkNum, len, restNum, 0, restLen);
		return checkValid(secondNum, sumNum, restNum);
	}

	private int[] extractNum(int[] arr, int length, int start) {
		int[] num = new int[length];
		for (int i = 0; i < length; i++) {
			num[i] = arr[i + start];
		}
		return num;
	}
	
	private int[] sum(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int maxLen = Math.max(len1, len2);
		int[] ret = new int[maxLen];
		int increase = 0;
		for (int i = maxLen - 1; i >= 0; i--) {
			ret[i] = increase;
			if(i >= maxLen - len1) {
				int index = i - (maxLen - len1);
				ret[i] += arr1[index];
			}
			if(i >= maxLen - len2) {
				int index = i - (maxLen - len2);
				ret[i] += arr2[index];
			}
			if(ret[i] >= 10) {
				ret[i] = ret[i] % 10;
				increase = 1;
			} else {
				increase = 0;
			}
		}
		if(increase == 1) {
			int[] result = new int[maxLen + 1];
			result[0] = 1;
			System.arraycopy(ret, 0, result, 1, len2);
			return result;
		}
		return ret;
	}

}
