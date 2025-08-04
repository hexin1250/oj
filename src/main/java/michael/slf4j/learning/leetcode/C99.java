package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class C99 {

	public static void main(String[] args) {
	}

	public void recoverTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		traversal(root, list);
		Collections.sort(list);
		recover(root, list.iterator());
	}
	
	private void recover(TreeNode root, Iterator<Integer> it) {
		if(root.left != null) {
			recover(root.left, it);
		}
		int val = it.next();
		root.val = val;
		if(root.right != null) {
			recover(root.right, it);
		}
	}

	private void traversal(TreeNode root, List<Integer> list) {
		if(root.left != null) {
			traversal(root.left, list);
		}
		list.add(root.val);
		if(root.right != null) {
			traversal(root.right, list);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
