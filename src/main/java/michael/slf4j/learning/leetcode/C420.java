package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C420 {

	public static void main(String[] args) {
		C420 c = new C420();
		String s = "Aaaaa";
		System.out.println(c.strongPasswordChecker(s));
	}
	
	private int upper = 0;
	private int lower = 0;
	private int number = 0;
	private int duplicatedNum = 0;
	private Map<Integer, List<Integer>> map = new HashMap<>();

	public int strongPasswordChecker(String password) {
		map.put(0, new ArrayList<>());
		map.put(1, new ArrayList<>());
		map.put(2, new ArrayList<>());
		int len = password.length();
		char pre = password.charAt(0);
		detectChar(pre);
		int duplicated = 1;
		for (int i = 1; i < len; i++) {
			char c = password.charAt(i);
			detectChar(c);
			if(c == pre) {
				duplicated++;
			} else {
				if(duplicated >= 3) {
					int currentNum = duplicatedChangeCount(duplicated);
					duplicatedNum += currentNum;
					int mod = duplicated % 3;
					List<Integer> list = map.get(mod);
					list.add(currentNum);
				}
				duplicated = 1;
				pre = c;
			}
		}
		if(duplicated >= 3) {
			int currentNum = duplicatedChangeCount(duplicated);
			duplicatedNum += currentNum;
			int mod = duplicated % 3;
			List<Integer> list = map.get(mod);
			list.add(currentNum);
		}
		int error = 3 - (upper + lower + number);
		if(len < 6) {
			return Math.max(6 - len, error);
		} else if(len <= 20) {
			return Math.max(duplicatedNum, error);
		} else {
			int target = len - 20;
			int times = target;
			List<Integer> list0 = map.get(0);
			List<Integer> list1 = map.get(1);
			List<Integer> list2 = map.get(2);
			int sum = 0;
			
			Iterator<Integer> it = list0.iterator();
			while(it.hasNext()) {
				int num = it.next();
				
				if(target > 0) {
					num -= 1;
					target--;
				}
				sum += num;
			}
			
			Iterator<Integer> it1 = list1.iterator();
			while(it1.hasNext()) {
				int num = it1.next();
				
				if(target > 1) {
					num -= 1;
					target -= 2;
				}
				sum += num;
			}
			
			for (Integer i : list2) {
				sum += i;
			}
			int mod = target % 3;
			int count = (target - mod) / 3;
			sum -= count;
			times += Math.max(sum, error);
			return times;
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
	
	private int duplicatedChangeCount(int number) {
		int mod = number % 3;
		return (number - mod) / 3;
	}

}
