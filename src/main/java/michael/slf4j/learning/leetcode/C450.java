package michael.slf4j.learning.leetcode;

public class C450 {

	public static void main(String[] args) {
		C450 c = new C450();
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node5.left = node3;
		node5.right = node6;
		node3.left = node2;
		node3.right = node4;
		node6.right = node7;
		TreeNode root = node5;
		int key = 7;
		
//		TreeNode root = new TreeNode(0);
//		int key = 0;
		
		c.deleteNode(root, key);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) {
			return root;
		}
		TreeNode parent = null;
		TreeNode node = root;
		while(node != null) {
			if(node.val == key) {
				break;
			}
			parent = node;
			if(key < node.val) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		if(node == null) {
			return root;
		}
		
		TreeNode newNode = null;
		if(node.right == null) {
			newNode = node.left;
		} else {
			TreeNode leftOfRight = node.right;
			TreeNode pre = null;
			while(leftOfRight != null) {
				if(leftOfRight.left == null) {
					break;
				}
				pre = leftOfRight;
				leftOfRight = leftOfRight.left;
			}
			leftOfRight.left = node.left;
			if(pre != null) {
				pre.left = leftOfRight.right;
				leftOfRight.right = node.right;
			}
			
			newNode = leftOfRight;
		}
		if(parent != null) {
			if(key < parent.val) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		} else {
			root = newNode;
		}
		return root;
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
