package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class C382 {

	public static void main(String[] args) {
	}

	public static class Solution {
		List<Integer> list = new ArrayList<>();
		int maxBound = 10000; //根据题目限制的最大边界
		int len = -1;//当前数组list是否包含全部链表数据，即数组是否完整。正整数为是，-1为否
		Random r = new Random();
		
		ListNode head = null;

		public Solution(ListNode head) {
			this.head = head;
		}

		public int getRandom() {
			int index = getValidIndex();
			return list.get(index);
		}
		
		private int getValidIndex() {
			int index = -1;
			while(true) {
				int currentBound = maxBound;
				if(len > 0) {//若数组完整，则用数组list的长度
					currentBound = len;
				}
				index = r.nextInt(currentBound);
				int size = list.size();
				if(size >= currentBound) {//此时list包含index下标，index可以直接使用
					break;
				}
				//此时数组list不包含index下标，需要从链表中获取
				for (int i = 0; i < index + 1 - size && head != null; i++) {
					list.add(head.val);
					head = head.next;
				}
				if(head == null) {//判断链表是否遍历完成
					len = list.size();
				}
			}
			return index;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
