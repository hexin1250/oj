package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class C382 {

	public static void main(String[] args) {
	}

	public static class Solution {
		List<Integer> list = new ArrayList<>();
		int maxBound = 10000;
		int len = -1;
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
				int scope = maxBound;
				if(len > 0) {
					scope = len;
				}
				index = r.nextInt(scope);
				int size = list.size();
				if(size >= scope) {
					break;
				}
				for (int i = 0; i < index + 1 - size && head != null; i++) {
					list.add(head.val);
					head = head.next;
				}
				if(head == null) {
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
