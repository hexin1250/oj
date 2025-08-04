package michael.slf4j.learning.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class C1948 {

	public static void main(String[] args) {
	}

	public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
		return null;
	}
	
	private static class MyNode {
		private MyNode parent;
		private String folder;
		private TreeMap<String, MyNode> child = new TreeMap<>();
		public MyNode(MyNode parent, String folder) {
			this.parent = parent;
			this.folder = folder;
		}
		public MyNode(String folder) {
			this.folder = folder;
		}
		public MyNode getParent() {
			return parent;
		}
		public void setParent(MyNode parent) {
			this.parent = parent;
		}
		public String getFolder() {
			return folder;
		}
		public void setFolder(String folder) {
			this.folder = folder;
		}
		@Override
		public int hashCode() {
			int ret = folder.hashCode();
			for (MyNode childNode : child.values()) {
				ret += childNode.hashCode() * 10;
			}
			return ret;
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof MyNode)) {
				return false;
			}
			MyNode node = (MyNode) obj;
			if(!folder.equals(node.getFolder())) {
				return false;
			}
			if(child.size() != node.child.size()) {
				return false;
			}
			for (String key : child.keySet()) {
				MyNode childNodeA = child.get(key);
				MyNode childNodeB = node.child.get(key);
				if(childNodeB == null) {
					return false;
				}
				boolean same = childNodeA.equals(childNodeB);
				if(!same) {
					return false;
				}
			}
			return true;
		}
	}
	
	private static class MyFolderSet {
		private Set<String> folderSet = new HashSet<>();

		public void addFolder(String folder) {
			folderSet.add(folder);
		}

		@Override
		public int hashCode() {
			int ret = 0;
			for (String folder : folderSet) {
				ret += folder.hashCode();
			}
			return ret;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof MyFolderSet)) {
				return false;
			}
			MyFolderSet mySet = (MyFolderSet) obj;
			if(folderSet.size() != mySet.folderSet.size()) {
				return false;
			}
			return folderSet.containsAll(mySet.folderSet);
		}
	}

}
