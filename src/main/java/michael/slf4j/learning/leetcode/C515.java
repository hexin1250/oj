package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class C515 {

	public static void main(String[] args) {
	}
	
	private List<Integer> list = new ArrayList<>();

	public List<Integer> largestValues(TreeNode root) {
		traversal(root, 1);
		return list;
	}

	private void traversal(TreeNode node, int level) {
		if(node == null) {
			return;
		}
		if(list.size() < level) {
			list.add(node.val);
		} else {
			int num = list.get(level - 1);
			if(num < node.val) {
				list.set(level - 1, node.val);
			}
		}
		traversal(node.left, level + 1);
		traversal(node.right, level + 1);
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
