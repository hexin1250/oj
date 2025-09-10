package michael.slf4j.learning.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class C432New {
	
	public static void main(String[] args) {
		C432New c = new C432New();
		c.inc("a");
		c.inc("b");
		c.inc("c");
		c.inc("d");
		c.inc("e");
		c.inc("f");
		c.inc("g");
		c.inc("h");
		c.inc("i");
		c.inc("j");
		c.inc("k");
		c.inc("l");
		c.dec("a");
		c.dec("b");
		c.dec("c");
		c.dec("d");
		c.dec("e");
		c.dec("f");
		c.inc("g");
		c.inc("h");
		c.inc("i");
		c.inc("j");
		System.out.println("Max:" + c.getMaxKey());
		System.out.println("Min:" + c.getMinKey());
		c.inc("k");
		c.inc("l");
		System.out.println("Max:" + c.getMaxKey());
		System.out.println("Min:" + c.getMinKey());
		c.inc("a");
		c.dec("j");
		System.out.println("Max:" + c.getMaxKey());
		System.out.println("Min:" + c.getMinKey());
	}

	public C432New() {
	}
	
	private TreeMap<Integer, MyNode> countMap = new TreeMap<>();
	private Map<String, MyNode> keyMap = new HashMap<>();
	
	private static class MyNode {
		MyNode pre = null;
		MyNode next = null;
		private String key;
		private int count;
		
		public MyNode(String key) {
			this.key = key;
			this.count = 1;
		}
		
		public String toString() {
			return key + ":" + count;
		}
	}

	public void inc(String key) {
		if(keyMap.containsKey(key)) {
			MyNode node = keyMap.get(key);
			cleanupOldNode(key, node);
			
			node.count = node.count + 1;
			node.pre = null;
			node.next = null;
			
			addNewNode(node);
		} else {
			MyNode node = new MyNode(key);
			keyMap.put(key, node);
			
			addNewNode(node);
		}
	}

	public void dec(String key) {
		MyNode node = keyMap.get(key);
		cleanupOldNode(key, node);
		
		node.count = node.count - 1;
		node.pre = null;
		node.next = null;
		
		if(node.count == 0) {
			keyMap.remove(key);
		} else {
			addNewNode(node);
		}
	}

	private void addNewNode(MyNode node) {
		MyNode newNode = countMap.get(node.count);
		if(newNode == null) {
			newNode = node;
			countMap.put(node.count, newNode);
		} else {
			newNode.next = node;
			node.pre = newNode;
			newNode = node;
			countMap.put(node.count, newNode);
		}
	}

	private void cleanupOldNode(String key, MyNode node) {
		MyNode oldNode = countMap.get(node.count);
		if(oldNode.next == null && oldNode.pre == null) {
			countMap.remove(oldNode.count);
		} else {
			MyNode pre = null;
			MyNode next = null;
			if(node.pre != null) {
				pre = node.pre;
				pre.next = node.next;
			}
			if(node.next != null) {
				next = node.next;
				next.pre = node.pre;
			}
			if(oldNode.key.equals(key)) {
				oldNode = pre;
				countMap.put(node.count, oldNode);
			}
		}
	}

	public String getMaxKey() {
		Entry<Integer, MyNode> entry = countMap.lastEntry();
		if(entry == null) {
			return "";
		}
		return entry.getValue().key;
	}

	public String getMinKey() {
		Entry<Integer, MyNode> entry = countMap.firstEntry();
		if(entry == null) {
			return "";
		}
		return entry.getValue().key;
	}

}
