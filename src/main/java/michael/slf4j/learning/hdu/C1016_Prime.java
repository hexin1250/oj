package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class C1016_Prime {
	private static Set<Integer> set = new HashSet<Integer>();
	private static int[][] dict = new int[18][];
	
	static {
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(5);
		set.add(7);
		set.add(11);
		set.add(13);
		set.add(17);
		set.add(19);
		set.add(23);
		set.add(29);
		set.add(31);
		set.add(37);
		
		dict[0] = new int[] {2,4,6,10,12,16,18};
		dict[1] = new int[] {3,5,9,11,15,17};
		dict[2] = new int[] {2,4,8,10,14,16};
		dict[3] = new int[] {3,7,9,13,15,19};
		dict[4] = new int[] {2,6,8,12,14,18};
		dict[5] = new int[] {5,7,11,13,17};
		dict[6] = new int[] {4,6,10,12,16};
		dict[7] = new int[] {3,5,9,11,15};
		dict[8] = new int[] {2,4,8,10,14};
		dict[9] = new int[] {3,7,9,13,19};
		dict[10] = new int[] {2,6,8,12,18};
		dict[11] = new int[] {5,7,11,17,19};
		dict[12] = new int[] {4,6,10,16,18};
		dict[13] = new int[] {3,5,9,15,17};
		dict[14] = new int[] {2,4,8,14,16};
		dict[15] = new int[] {3,7,13,15};
		dict[16] = new int[] {2,6,12,14};
		dict[17] = new int[] {5,11,13,19};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 0;
		while(sc.hasNext()) {
			t += 1;
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			int[] visit = new int[n];
			int[] mem = new int[n];
			mem[0] = 1;
			visit[0] = 1;
			List<int[]> ret = dfs(arr, 0, mem, visit);
			Collections.sort(ret, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int length = o1.length;
					for (int i = 0; i < length; i++) {
						if(o1[i] < o2[i]) {
							return -1;
						} else if(o1[i] > o2[i]) {
							return 1;
						}
					}
					return 0;
				}
			});
			StringBuffer sb = new StringBuffer();
			sb.append("Case ").append(t).append(":\r\n");
			for (int[] r : ret) {
				for (int i = 0; i < r.length; i++) {
					if(i != 0) {
						sb.append(' ');
					}
					sb.append(r[i]);
				}
				sb.append("\r\n");
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

	private static List<int[]> dfs(int[] arr, int dept, int[] mem, int[] visit) {
		List<int[]> ret = new ArrayList<>();
//		第0层，即只有初始1，根据数字1生成mem队列最后一个元素。
		if(dept == 0) {
			int n = mem[0];
			int[] availableArr = dict[n - 1];
			int length = availableArr.length;
//			从大到小，减轻排序压力。
			for (int i = length - 1; i >= 0; i--) {
				int number = availableArr[i];
				int index = number - 1;
				if(number <= arr.length && visit[index] == 0) {
					visit[index] = 1;
					mem[arr.length - 1] = number;
					List<int[]> subList = dfs(arr, dept + 1, mem, visit);
					ret.addAll(subList);
					visit[index] = 0;
				}
			}
			return ret;
		} else {
//			从数组两端同时向中间遍历，当dept为总数n的一半，遍历结束。
			if(dept == arr.length / 2) {
				int[] tmp = new int[mem.length];
				for (int i = 0; i < mem.length; i++) {
					tmp[i] = mem[i];
				}
				ret.add(tmp);
				return ret;
			}
//			前面队列的最后一个元素。
			int firstNumber = mem[dept - 1];
			int[] firstAvailableArr = dict[firstNumber - 1];
//			后面队列的第一个元素。
			int lastNumber = mem[arr.length - dept];
			int[] lastAvailableArr = dict[lastNumber - 1];
			for (int i = 0; i < firstAvailableArr.length; i++) {
				int nowFirstN = firstAvailableArr[i];
				int nowFirstI = nowFirstN - 1;
//				元素超过最大数值或已经被访问过，跳过。
				if(!(nowFirstN <= arr.length && visit[nowFirstI] == 0)) {
					continue;
				}
				visit[nowFirstI] = 1;
				mem[dept] = nowFirstN;
				for (int j = lastAvailableArr.length - 1; j >= 0; j--) {
					int nowLastN = lastAvailableArr[j];
					int nowLastI = nowLastN - 1;
					if(dept == arr.length / 2 - 1) {
						int nowN = nowLastN + nowFirstN;
						if(!set.contains(nowN)) {
							continue;
						}
					}
					if(nowLastN <= arr.length && visit[nowLastI] == 0) {
						visit[nowLastI] = 1;
						mem[arr.length - dept - 1] = nowLastN;
						List<int[]> subList = dfs(arr, dept + 1, mem, visit);
						ret.addAll(subList);
						visit[nowLastI] = 0;
					}
				}
				visit[nowFirstI] = 0;
			}
			return ret;
		}
	}

}
