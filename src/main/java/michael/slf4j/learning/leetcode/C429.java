package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class C429 {

	public static void main(String[] args) {
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> ret = new ArrayList<>();
		dfs(ret, 0, root);
		return ret;
	}
	
	private void dfs(List<List<Integer>> ret, int level, Node node) {
		if(node == null) {
			return;
		}
		int size = ret.size();
		if(size - 1 < level) {
			ret.add(new ArrayList<>());
		}
		ret.get(level).add(node.val);
		if(node.children != null) {
			int len = node.children.size();
			for (int i = 0; i < len; i++) {
				Node child = node.children.get(i);
				dfs(ret, level + 1, child);
			}
		}
	}

	public static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<List<Integer>> levelOrder1(Node root) {
		if(root == null) {
			return new ArrayList<List<Integer>>();
		}
		Queue<Node> q = new LinkedBlockingQueue<>();
		q.add(root);
		int count = 1;
		int nextCount = 0;
		int index = 0;
		List<List<Integer>> ret = new ArrayList<>();
		while(!q.isEmpty()) {
			if(index == 0) {
				ret.add(new ArrayList<>());
			}
			index++;
			Node node = q.poll();
			int size = ret.size();
			if(node.children != null) {
				ret.get(size - 1).add(node.val);
				q.addAll(node.children);
				nextCount += node.children.size();
			}
			if(index == count) {
				index = 0;
				count = nextCount;
				nextCount = 0;
			}
		}
		return ret;
	}

}
