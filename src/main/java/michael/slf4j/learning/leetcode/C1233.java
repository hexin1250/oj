package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class C1233 {

	public static void main(String[] args) {
	}
	
	public List<String> removeSubfolders(String[] folder) {
		Set<String> set = new HashSet<>();
		for (String path : folder) {
			boolean find = false;
			for (String existingPath : set) {
				if(path.contains(existingPath) && path.replaceAll(existingPath, "").contains("/")) {
					find = true;
					break;
				}
			}
			if(!find) {
				set.add(path);
			}
		}
		return set.stream().collect(Collectors.toList());
	}

	public List<String> removeSubfolders1(String[] folder) {
		MyNode root = new MyNode("");
		for (int i = 0; i < folder.length; i++) {
			root.addNode(folder[i]);
		}
		return getRootList(root);
	}
	
	private List<String> getRootList(MyNode node){
		List<String> ret = new ArrayList<>();
		if(node.root) {
			ret.add(node.path);
			return ret;
		}
		for (MyNode childNode : node.child.values()) {
			ret.addAll(getRootList(childNode));
		}
		return ret;
	}
	
	private static class MyNode {
		private String path = "";
		private Map<String, MyNode> child = new HashMap<>();
		private boolean root = false;
		
		public MyNode(String path) {
			this.path = path;
		}
		
		private void addNode(String fullPath) {
			String[] parts = fullPath.split("/");
			boolean findRoot = false;
			MyNode tmp = this;
			for (int i = 1; i < parts.length; i++) {
				String currentNodePath = parts[i];
				MyNode childNode = tmp.child.get(currentNodePath);
				if(childNode == null) {
					childNode = new MyNode(Arrays.stream(parts, 1, i + 1).map(str -> "/" + str).collect(Collectors.joining()));
					tmp.child.put(currentNodePath, childNode);
				}
				if(childNode.root && !findRoot) {
					findRoot = true;
				}
				if(i == parts.length - 1 && !findRoot) {
					childNode.root = true;
				}
				tmp = childNode;
			}
		}
	}

}
