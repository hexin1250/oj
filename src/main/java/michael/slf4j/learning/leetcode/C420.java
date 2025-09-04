package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C420 {

	public static void main(String[] args) {
		C420 c = new C420();
		String s = "aaaABCD5555ABCD134kkkkk";
		System.out.println(c.strongPasswordChecker(s));
	}
	
	private int upper = 0;
	private int lower = 0;
	private int number = 0;
	private int duplicatedSum = 0;
	private Map<Integer, List<Integer>> duplicatedMap = new HashMap<>();

	public int strongPasswordChecker(String password) {
		duplicatedMap.put(0, new ArrayList<>());
		duplicatedMap.put(1, new ArrayList<>());
		duplicatedMap.put(2, new ArrayList<>());
		int len = password.length();
		char pre = password.charAt(0);
		detectChar(pre);
		int duplicatedCount = 1;
		for (int i = 1; i < len; i++) {
			char c = password.charAt(i);
			detectChar(c);
			if(c == pre) {
				duplicatedCount++;
			} else {
				if(duplicatedCount >= 3) {
					int replaceNum = duplicatedReplaceCount(duplicatedCount);
					duplicatedSum += replaceNum;
					int mod = duplicatedCount % 3;
					List<Integer> duplicatedArr = duplicatedMap.get(mod);
					duplicatedArr.add(replaceNum);
				}
				duplicatedCount = 1;
				pre = c;
			}
		}
		if(duplicatedCount >= 3) {
			int replaceNum = duplicatedReplaceCount(duplicatedCount);
			duplicatedSum += replaceNum;
			int mod = duplicatedCount % 3;
			List<Integer> duplicatedArr = duplicatedMap.get(mod);
			duplicatedArr.add(replaceNum);
		}
		int cap = upper + lower + number;
		if(len < 6) {
			return Math.max(6 - len, 3 - cap);
		} else if(len <= 20) {
			return Math.max(duplicatedSum, 3 - cap);
		} else {
			int targetDeleteCharCount = len - 20;
			int ret = targetDeleteCharCount;
			List<Integer> duplicatedArr0 = duplicatedMap.get(0);
			List<Integer> duplicatedArr1 = duplicatedMap.get(1);
			List<Integer> duplicatedArr2 = duplicatedMap.get(2);
			int updatedReplaceSum = 0;
			
			/**
			 * 优先对余数为0的做删除字符操作，删除一个字符，减少一次操作
			 */
			Iterator<Integer> it = duplicatedArr0.iterator();
			while(it.hasNext()) {
				int replaceNum = it.next();
				if(targetDeleteCharCount > 0) {
					replaceNum -= 1;
					targetDeleteCharCount--;
				}
				updatedReplaceSum += replaceNum;
			}
			
			/**
			 * 对余数为1的做删除字符操作，删除两个字符，减少一次操作
			 */
			Iterator<Integer> it1 = duplicatedArr1.iterator();
			while(it1.hasNext()) {
				int replaceNum = it1.next();
				if(targetDeleteCharCount > 1) {
					replaceNum -= 1;
					targetDeleteCharCount -= 2;
				}
				updatedReplaceSum += replaceNum;
			}
			
			for (Integer i : duplicatedArr2) {
				updatedReplaceSum += i;
			}
			int mod = targetDeleteCharCount % 3;
			/**
			 * 对余数为2的做删除字符操作，删除三个字符，减少一次操作
			 */
			int count = (targetDeleteCharCount - mod) / 3;
			updatedReplaceSum -= count;
			ret += Math.max(updatedReplaceSum, 3 - cap);
			return ret;
		}
	}
	
	private void detectChar(char c) {
		if(c <= 'Z' && c >= 'A') {
			upper = 1;
		} else if(c <= 'z' && c >= 'a') {
			lower = 1;
		} else if(c <= '9' && c >= '0') {
			number = 1;
		}
	}
	
	private int duplicatedReplaceCount(int number) {
		int mod = number % 3;
		return (number - mod) / 3;
	}

}
