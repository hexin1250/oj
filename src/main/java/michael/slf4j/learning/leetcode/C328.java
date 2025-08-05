package michael.slf4j.learning.leetcode;

public class C328 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		C328 c = new C328();
		ListNode ret = c.oddEvenList(node1);
		while(ret != null) {
			System.out.print(ret.val + " ");
			ret = ret.next;
		}
		System.out.println();
	}

	public ListNode oddEvenList(ListNode head) {
		int index = 0;
		ListNode oddHead = null;
		ListNode evenHead = null;
		ListNode odd = null;
		ListNode even = null;
		while(head != null) {
			index++;
			if(index % 2 == 1) {
				if(odd == null) {
					odd = head;
					oddHead = odd;
				} else {
					odd.next = head;
					odd = odd.next;
				}
			} else {
				if(even == null) {
					even = head;
					evenHead = even;
				} else {
					even.next = head;
					even = even.next;
				}
			}
			head = head.next;
		}
		if(evenHead != null) {
			even.next = null;
			odd.next = evenHead;
		}
		return oddHead;
	}

	public static class ListNode {
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
		
		public String toString() {
			return val + "";
		}
	}

}
