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
		TreeNode parentNode = null;
		TreeNode deleteNode = root;
		while(deleteNode != null) {
			if(deleteNode.val == key) {
				break;
			}
			parentNode = deleteNode;
			if(key < deleteNode.val) {
				deleteNode = deleteNode.left;
			} else {
				deleteNode = deleteNode.right;
			}
		}
		if(deleteNode == null) {
			return root;
		}
		
		TreeNode replaceNode = null;
		if(deleteNode.right == null) {
			replaceNode = deleteNode.left;
		} else {
			TreeNode leftOfRight = deleteNode.right;
			TreeNode pre = null;
			while(leftOfRight != null) {
				if(leftOfRight.left == null) {
					break;
				}
				pre = leftOfRight;
				leftOfRight = leftOfRight.left;
			}
			leftOfRight.left = deleteNode.left;
			if(pre != null) {
				pre.left = leftOfRight.right;
				leftOfRight.right = deleteNode.right;
			}
			
			replaceNode = leftOfRight;
		}
		if(parentNode != null) {
			if(key < parentNode.val) {
				parentNode.left = replaceNode;
			} else {
				parentNode.right = replaceNode;
			}
		} else {
			root = replaceNode;
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
