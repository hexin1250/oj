package michael.slf4j.learning.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class C432 {
	
	public static void main(String[] args) {
		C432 c = new C432();
		c.inc("hello");
		c.inc("hello");
		System.out.println("Max:" + c.getMaxKey());
		System.out.println("Min:" + c.getMinKey());
		c.inc("leet");
		System.out.println("Max:" + c.getMaxKey());
		System.out.println("Min:" + c.getMinKey());
	}

	public C432() {
	}
	
	private TreeMap<Integer, Set<String>> sizeMap = new TreeMap<>();
	private Map<String, Integer> keyMap = new HashMap<>();

	public void inc(String key) {
		if(keyMap.containsKey(key)) {
			int count = keyMap.get(key);
			Set<String> keySet = sizeMap.get(count);
			keySet.remove(key);
			if(keySet.isEmpty()) {
				sizeMap.remove(count);
			}
			
			count++;
			keyMap.put(key, count);
			
			Set<String> newKeySet = sizeMap.get(count);
			if(newKeySet == null) {
				newKeySet = new HashSet<>();
				sizeMap.put(count, newKeySet);
			}
			newKeySet.add(key);
		} else {
			int count = 1;
			keyMap.put(key, count);
			
			Set<String> newKeySet = sizeMap.get(count);
			if(newKeySet == null) {
				newKeySet = new HashSet<>();
				sizeMap.put(count, newKeySet);
			}
			newKeySet.add(key);
		}
	}

	public void dec(String key) {
		int count = keyMap.get(key);
		Set<String> keySet = sizeMap.get(count);
		keySet.remove(key);
		if(keySet.isEmpty()) {
			sizeMap.remove(count);
		}
		
		count--;
		if(count == 0) {
			keyMap.remove(key);
		} else {
			keyMap.put(key, count);
			
			Set<String> newKeySet = sizeMap.get(count);
			if(newKeySet == null) {
				newKeySet = new HashSet<>();
				sizeMap.put(count, newKeySet);
			}
			newKeySet.add(key);
		}
	}

	public String getMaxKey() {
		Entry<Integer, Set<String>> entry = sizeMap.lastEntry();
		return getKey(entry);
	}

	public String getMinKey() {
		Entry<Integer, Set<String>> entry = sizeMap.firstEntry();
		return getKey(entry);
	}
	
	private String getKey(Entry<Integer, Set<String>> entry) {
		String key = "";
		if(entry == null) {
			return key;
		}
		Set<String> set = entry.getValue();
		return set.stream().findFirst().get();
	}

}
