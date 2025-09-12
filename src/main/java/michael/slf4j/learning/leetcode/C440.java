package michael.slf4j.learning.leetcode;

public class C440 {

	public static void main(String[] args) {
		C440 c = new C440();
//		int n = 100;
//		int k = 10;
		int n = 13;
		int k = 8;
//		int n = 169;
//		int k = 154;
		System.out.println(c.findKthNumber(n, k));
	}
	
	private int[] allPermutationArr = null;
	private int[] excludedPermutationArr = null;
	private int[] inputArr = null;
	private int n;
	
	public int findKthNumber(int n, int k) {
		if(n < 10) {
			return k;
		}
		this.n = n;
		int depth = getNum(this.n);
		inputArr = getNumArr(this.n, depth);
		
		allPermutationArr = new int[depth];
		excludedPermutationArr = new int[depth - 1];
		int count = 0;
		int decimal = 1;
		int num = -1;
		for (int i = depth - 1; i >= 0; i--) {
			allPermutationArr[i] = count;
			count += 1;
			count = count * 10;
			
			if(num == -1) {
				num = inputArr[i];
				continue;
			}
			decimal = decimal * 10;
			num = n % decimal;
			excludedPermutationArr[i] = decimal - num - 1;
		}
		return traversal(k, 1, 0, depth - 1, 0, 0);
	}

	public int traversal(int k, int start, int level, int depth, int preNum, int targetNum) {
		int realPermutationCount = allPermutationArr[level];
		for (int i = start; i <= 9; i++) {
			boolean skipLastLevel = false;
			int currentTargetNum = targetNum * 10 + inputArr[level];
			int currentNum = preNum * 10 + i;
			if(k == 1) {
				return currentNum;
			}
			k--;
			if(currentNum > currentTargetNum) {
				realPermutationCount = allPermutationArr[level + 1];
				skipLastLevel = true;
			} else if(currentTargetNum == currentNum){
				realPermutationCount -= excludedPermutationArr[level];
			}
			if(k <= realPermutationCount) {
				if(level == depth || (skipLastLevel && level == depth - 1)) {
					return currentNum + k - 1;
				} else {
					return traversal(k, 0, level + 1, depth, currentNum, currentTargetNum);
				}
			} else {
				k -= realPermutationCount;
			}
		}
		return -1;
	}

	private int getNum(int n) {
		int len = 0;
		while(n > 0) {
			len++;
			n /= 10;
		}
		return len;
	}
	
	private int[] getNumArr(int n, int len) {
		int[] arr = new int[len];
		int index = len - 1;
		while(n > 0) {
			arr[index] = n % 10;
			index--;
			n /= 10;
		}
		return arr;
	}

}
