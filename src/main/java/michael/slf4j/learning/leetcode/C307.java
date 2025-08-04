package michael.slf4j.learning.leetcode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C307 {

	public static void main(String[] args) {
	}
	
	public static class NumArray {
		private List<Map<Integer, Integer>> versionList = new ArrayList<>();
		/**
		 * Map<Index, Map<Version, Number>> statusMap
		 */
		private Map<Integer, List<int[]>> statusMap = new HashMap<>();
		private Map<Point, int[]> cache = new HashMap<>();
		private int version = 0;
		private boolean noRead = true;

	    public NumArray(int[] nums) {
	    	Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
	    	for (int i = 0; i < nums.length; i++) {
	    		numMap.put(i, nums[i]);
	    		List<int[]> status = new ArrayList<>();
	    		status.add(new int[] {version, nums[i]});
	    		statusMap.put(i, status);
			}
	    	versionList.add(numMap);
	    }
	    
	    public void update(int index, int val) {
	    	if(!noRead) {
	    		version++;
	    	}
	    	Map<Integer, Integer> changeMap = null;
	    	if(changeMap == null) {
	    		changeMap = new HashMap<Integer, Integer>();
	    		versionList.add(changeMap);
	    	}
	    	changeMap.put(index, val);
	    	List<int[]> status = statusMap.get(index);
	    	int statusSize = status.size();
	    	int[] lastStatus = status.get(statusSize - 1);
	    	if(lastStatus[0] == version) {
	    		lastStatus[1] = val;
	    	} else {
	    		status.add(new int[] {version, val});
	    	}
	    }
	    
	    public int sumRange(int left, int right) {
	    	noRead = false;
	    	Point p = new Point(left, right);
	    	int[] ret = cache.get(p);
	    	Set<Integer> set = new HashSet<>();
	    	if(ret == null) {
	    		int sum = 0;
	    		int size = versionList.size();
	    		for (int i = size - 1; i >= 1; i--) {
	    			Map<Integer, Integer> changeMap = versionList.get(i);
	    			for (Entry<Integer, Integer> entry : changeMap.entrySet()) {
						int index = entry.getKey();
						if(set.contains(index) || index < left || index > right) {
							continue;
						}
						int val = entry.getValue();
						sum += val;
						set.add(index);
					}
				}
	    		Map<Integer, Integer> changeMap = versionList.get(0);
	    		for (int i = left; i <= right; i++) {
					if(set.contains(i)) {
						continue;
					}
					sum += changeMap.get(i);
				}
	    		
	    		ret = new int[2];
	    		ret[0] = version;
	    		ret[1] = sum;
	    		cache.put(p, ret);
	    		return sum;
	    	}
	    	int currentVersion = ret[0];
	    	int sum = ret[1];
	    	if(currentVersion == version) {
	    		return sum;
	    	}
	    	int size = versionList.size();
	    	for (int i = size - 1; i > currentVersion; i--) {
	    		Map<Integer, Integer> changeMap = versionList.get(i);
	    		for (Entry<Integer, Integer> entry : changeMap.entrySet()) {
					int index = entry.getKey();
					if(set.contains(index) || index < left || index > right) {
						continue;
					}
					set.add(index);
					int val = entry.getValue();
					List<int[]> status = statusMap.get(index);
					int statusSize = status.size();
					for (int j = statusSize - 1; j >= 0; j--) {
						int[] lastStatus = status.get(j);
						if(lastStatus[0] <= currentVersion) {
							sum += val - lastStatus[1];
							break;
						}
					}
				}
			}
	    	
	    	ret[0] = version;
	    	ret[1] = sum;
	    	return sum;
	    }
	}

}
