package michael.slf4j.learning.leetcode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C95 {

	public static void main(String[] args) {
		C95 c = new C95();
		for (int i = 1; i <= 19; i++) {
			List<TreeNode> list = c.generateTrees(i);
			System.out.println(i + ":" + list.size());
		}
	}
	
	Map<Point, List<TreeNode>> map = new HashMap<>();

	public List<TreeNode> generateTrees(int n) {
		return generateTreeByRange(1, n);
	}
	
	public List<TreeNode> generateTreeByRange(int left, int right){
		if(right < left) {
			return null;
		}
		Point p = new Point(left, right);
		List<TreeNode> nodeList = map.get(p);
		if(nodeList != null) {
			return nodeList;
		}
		nodeList = new ArrayList<>();
		if(left == right) {
			TreeNode node = new TreeNode(left);
			nodeList.add(node);
			map.put(p, nodeList);
			return nodeList;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftNodeList = generateTreeByRange(left, i - 1);
			List<TreeNode> rightNodeList = generateTreeByRange(i + 1, right);
			if(leftNodeList != null) {
				for (TreeNode leftNode : leftNodeList) {
					if(rightNodeList != null) {
						for (TreeNode rightNode : rightNodeList) {
							TreeNode node = new TreeNode(i);
							node.left = leftNode;
							node.right = rightNode;
							nodeList.add(node);
						}
					} else {
						TreeNode node = new TreeNode(i);
						node.left = leftNode;
						nodeList.add(node);
					}
				}
			} else {
				for (TreeNode rightNode : rightNodeList) {
					TreeNode node = new TreeNode(i);
					node.right = rightNode;
					nodeList.add(node);
				}
			}
		}
		map.put(p, nodeList);
		return nodeList;
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
