package michael.slf4j.learning.leetcode;

public class C1290 {

	public static void main(String[] args) {
	}

	public int getDecimalValue(ListNode head) {
		int ret = 0;
		ListNode tmp = head;
		while(tmp != null) {
			ret *= 2;
			ret += tmp.val;
			tmp = tmp.next;
		}
		return ret;
	}

	private static class ListNode {
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
