package michael.slf4j.learning.leetcode;

import java.math.BigDecimal;

public class C445 {

	public static void main(String[] args) {
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigDecimal ten = new BigDecimal(10);
		
		BigDecimal bd1 = new BigDecimal(0);
		while(l1 != null) {
			BigDecimal currentBd = new BigDecimal(l1.val);
			bd1 = bd1.multiply(ten).add(currentBd);
			l1 = l1.next;
		}
		BigDecimal bd2 = new BigDecimal(0);
		while(l2 != null) {
			BigDecimal currentBd = new BigDecimal(l2.val);
			bd2 = bd2.multiply(ten).add(currentBd);
			l2 = l2.next;
		}
		BigDecimal bd = bd1.add(bd2);
		String s = bd.toString();
		
		ListNode ret = null;
		ListNode pre = null;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - '0';
			ListNode node = new ListNode(val);
			if(pre != null) {
				pre.next = node;
			}
			if(ret == null) {
				ret = node;
			}
			pre = node;
		}
		return ret;
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
