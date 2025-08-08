package michael.slf4j.learning.leetcode;

import java.util.Map.Entry;
import java.util.TreeMap;

public class C352 {

	public static void main(String[] args) {
		SummaryRanges s = new SummaryRanges();
		s.addNum(1);
		int[][] ret1 = s.getIntervals();
		for (int i = 0; i < ret1.length; i++) {
			System.out.println(ret1[i][0] + "," + ret1[i][1]);
		}
		s.addNum(3);
		int[][] ret2 = s.getIntervals();
		for (int i = 0; i < ret2.length; i++) {
			System.out.println(ret2[i][0] + "," + ret2[i][1]);
		}
	}
	
	public static class SummaryRanges {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

	    public SummaryRanges() {
	    }
	    
	    public void addNum(int value) {
	    	int start = value;
	    	int end = value;
	    	Entry<Integer, Integer> floorEntry = map.floorEntry(value);
	    	if(floorEntry != null) {
	    		if(floorEntry.getValue() == value - 1) {
	    			start = floorEntry.getKey();
	    			map.remove(start);
	    		} else if(floorEntry.getValue() >= value || floorEntry.getKey() == value) {
	    			return;
	    		}
	    	}
	    	
	    	Entry<Integer, Integer> highEntry = map.higherEntry(value);
	    	if(highEntry != null && highEntry.getKey() == value + 1) {
	    		end = highEntry.getValue();
	    		map.remove(highEntry.getKey());
	    	}
	    	
	    	map.put(start, end);
	    }
	    
	    public int[][] getIntervals() {
	    	int len = map.size();
	    	int[][] ret = new int[len][2];
	    	int index = 0;
	    	for (Entry<Integer, Integer> entry : map.entrySet()) {
				ret[index][0] = entry.getKey();
				ret[index][1] = entry.getValue();
				index++;
			}
	    	return ret;
	    }
	}

}
