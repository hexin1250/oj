package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C341 {

	public static void main(String[] args) {
	}

	public static class NestedIterator implements Iterator<Integer> {
		Iterator<Integer> it;

		public NestedIterator(List<NestedInteger> nestedList) {
			List<Integer> ret = traversal(nestedList);
			it = ret.iterator();
		}

		@Override
		public Integer next() {
			return it.next();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}
		
		private List<Integer> traversal(List<NestedInteger> list){
			List<Integer> ret = new ArrayList<>();
			for (NestedInteger nestedInteger : list) {
				if(nestedInteger.isInteger()) {
					ret.add(nestedInteger.getInteger());
				} else {
					ret.addAll(traversal(nestedInteger.getList()));
				}
			}
			return ret;
		}
	}

	public interface NestedInteger {
		public boolean isInteger();

		public Integer getInteger();

		public List<NestedInteger> getList();
	}

}
