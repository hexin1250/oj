package michael.slf4j.learning.leetcode;

public class C404 {

	public static void main(String[] args) {
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return traversal(root);
	}

	private int traversal(TreeNode root) {
		int ret = 0;
		TreeNode left = root.left;
		if(left != null) {
			if(left.left == null && left.right == null) {
				ret += left.val;
			} else {
				ret += traversal(left);
			}
		}
		if(root.right != null) {
			ret += traversal(root.right);
		}
		return ret;
	}

	public static class TreeNode {
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
