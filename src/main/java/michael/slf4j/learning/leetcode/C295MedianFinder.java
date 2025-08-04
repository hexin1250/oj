package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class C295MedianFinder {
	private List<Double> list = null;

	public C295MedianFinder() {
		this.list = new ArrayList<>();
	}

	public void addNum(int num) {
		if(list.size() < 2) {
			list.add((double) num);
			Collections.sort(list);
		} else {
			int len = list.size() - 1;
			int index = findIndex(num, 0, len);
			if(index == list.size()) {
				list.add((double) num);
			} else {
				list.add(index, (double) num);
			}
		}
		System.out.println("Insert:" + num + ", Array:" + list.stream().map(d -> d.toString()).collect(Collectors.joining(" ")));
	}
	
	private int findIndex(int num, int leftIndex, int rightIndex) {
		double left = list.get(leftIndex);
		double right = list.get(rightIndex);
		if(num < left) {
			return leftIndex;
		} else if(num > right) {
			return rightIndex + 1;
		}
		if(leftIndex + 1 == rightIndex) {
			return rightIndex;
		}
		int mid = (leftIndex + rightIndex) / 2;
		double d = list.get(mid);
		if(d == num) {
			return mid;
		} else if(num < d) {
			return findIndex(num, leftIndex, mid);
		} else {
			return findIndex(num, mid, rightIndex);
		}
	}

	public double findMedian() {
		int size = list.size();
		if (size % 2 == 1) {
			return list.get(size / 2);
		}
		return (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
	}

	public static void main(String[] args) {
		C295MedianFinder c = new C295MedianFinder();
		c.addNum(6);
		System.out.println(c.findMedian());
		c.addNum(10);
		System.out.println(c.findMedian());
		c.addNum(2);
		System.out.println(c.findMedian());
		c.addNum(6);
		System.out.println(c.findMedian());
		c.addNum(5);
		System.out.println(c.findMedian());
		c.addNum(0);
		System.out.println(c.findMedian());
		c.addNum(6);
		System.out.println(c.findMedian());
		c.addNum(3);
		System.out.println(c.findMedian());
		c.addNum(1);
		System.out.println(c.findMedian());
		c.addNum(0);
		System.out.println(c.findMedian());
		c.addNum(0);
		System.out.println(c.findMedian());
	}
}