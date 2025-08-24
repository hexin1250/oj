package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C39 {

	public static void main(String[] args) {
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return traversal(candidates, target, 0, new ArrayList<>());
	}

	private List<List<Integer>> traversal(int[] candidates, int target, int index, List<Integer> queue) {
		List<List<Integer>> ret = new ArrayList<>();
		if(target == 0) {
			List<Integer> currentRet = new ArrayList<>(queue);
			ret.add(currentRet);
			return ret;
		}
		int size = queue.size();
		for (int i = index; i < candidates.length; i++) {
			if(candidates[i] > target) {
				break;
			}
			queue.add(candidates[i]);
			ret.addAll(traversal(candidates, target - candidates[i], i, queue));
			queue.remove(size);
		}
		return ret;
	}

}
