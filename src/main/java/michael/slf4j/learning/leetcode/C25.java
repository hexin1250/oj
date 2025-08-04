package michael.slf4j.learning.leetcode;

public class C25 {

	public static void main(String[] args) {
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

	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 1) {
			return head;
		}
		int index = 1;
		ListNode current = head;
		ListNode[] vals = new ListNode[k];
		vals[0] = current;
		while(current.next != null) {
			index++;
			ListNode next = current.next;
			vals[index - 1] = next;
			current = next;
			
			if(index == k) {
				for (int i = 0; i < k / 2; i++) {
					ListNode first = vals[i];
					ListNode last = vals[k - i - 1];
					int val = first.val;
					first.val = last.val;
					last.val = val;
				}
				index = 0;
			}
		}
		return head;
	}

}
