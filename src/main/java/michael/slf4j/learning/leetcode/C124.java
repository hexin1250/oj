package michael.slf4j.learning.leetcode;

public class C124 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(6);
		root.right = new TreeNode(-3);
		
		root.right.left = new TreeNode(-6);
		root.right.right = new TreeNode(2);
		
		root.right.right.left = new TreeNode(2);
		root.right.right.left.left = new TreeNode(-6);
		root.right.right.left.left.left = new TreeNode(-6);
		root.right.right.left.right = new TreeNode(-6);
		
		C124 c = new C124();
		System.out.println(c.maxPathSum(root));
	}
	
	private int maxPath = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		getMaxLength(root);
		return maxPath;
	}
	
	private int getMaxLength(TreeNode node) {
		int self = node.val;
		Integer leftPath = null;
		Integer rightPath = null;
		if(node.left != null) {
			leftPath = getMaxLength(node.left);
			self = Math.max(self, self + leftPath);
		}
		if(node.right != null) {
			rightPath = getMaxLength(node.right);
			self = Math.max(self, self + rightPath);
		}
		if(self > maxPath) {
			maxPath = self;
		}
		
		int retPath = node.val;
		if(leftPath == null && rightPath != null) {
			retPath = Math.max(retPath, retPath + rightPath);
		} else if(leftPath != null && rightPath == null) {
			retPath = Math.max(retPath, retPath + leftPath);
		} else if(leftPath != null && rightPath != null) {
			retPath = Math.max(retPath, retPath + Math.max(leftPath, rightPath));
		}
		return retPath;
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
