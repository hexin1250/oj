package michael.slf4j.learning.leetcode;

public class C513 {
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

	private int num;
	private int level = -1;

	public int findBottomLeftValue(TreeNode root) {
		traversal(root, 0);
		return num;
	}

	private void traversal(TreeNode node, int currentLevel) {
		if(node == null) {
			return;
		}
		if(currentLevel > this.level) {
			this.level = currentLevel;
			this.num = node.val;
		}
		traversal(node.left, currentLevel + 1);
		traversal(node.right, currentLevel + 1);
	}

}
