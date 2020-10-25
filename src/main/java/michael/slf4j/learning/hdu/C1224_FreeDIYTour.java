package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1224_FreeDIYTour {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			for (int cases = 0; cases < testcase; cases++) {
				int n = sc.nextInt();
				int[] itst = new int[n];
				for (int i = 0; i < n; i++) {
					itst[i] = sc.nextInt();
				}
				int lines = sc.nextInt();
				/**
				 * 路径逆推，3->4，在map中则是存储map.put(4,3)
				 */
				Map<Integer, List<Integer>> map = new HashMap<>();
				for (int i = 0; i < lines; i++) {
					int source = sc.nextInt() - 1;
					int target = sc.nextInt() - 1;
					List<Integer> choices = map.get(target);
					if(choices == null) {
						choices = new ArrayList<>();
					}
					choices.add(source);
					map.put(target, choices);
				}
				/**
				 * choices数组即为dp
				 */
				TourChoice[][] choices = new TourChoice[n][n + 1];
				for (int source = n; source > 0; source--) {
					List<Integer> targetList = map.get(source);
					if(targetList == null) {
						continue;
					}
					for (Integer target : targetList) {
						if(source == n) {
							/**
							 * 从终点开始遍历，直接赋值即可。
							 */
							choices[target][source] = new TourChoice();
							choices[target][source].setTotalPoint(itst[target]);
							choices[target][source].add(source);
						} else {
							/**
							 * 想要从source(假设为4)到target(假设为3)，则先找到source层最大值。
							 */
							TourChoice bestChoice = null;
							for (int j = source + 1; j <= n; j++) {
								if(choices[source][j] != null) {
									if(bestChoice == null) {
										bestChoice = choices[source][j];
									} else {
										if(bestChoice.getTotalPoint() < choices[source][j].getTotalPoint()) {
											bestChoice = choices[source][j];
										}
									}
								}
							}
							if(bestChoice == null) {
								continue;
							}
							/**
							 * 然后找到target层最大值与source层最大值bestChoice + itst[target]进行比较。<p>
							 * 如果target层最大值不够大，则将bestChoice + itst[target]作为choices[target][source]的值，否则为null。<p>
							 */
							boolean find = false;
							for (int j = target; j < choices.length; j++) {
								TourChoice currentChoice = choices[target][source];
								if(currentChoice == null) {
									continue;
								}
								if(currentChoice.getTotalPoint() >= bestChoice.getTotalPoint() + itst[target]) {
									find = true;
									break;
								}
							}
							if(!find) {
								choices[target][source] = new TourChoice();
								choices[target][source].setTotalPoint(bestChoice.getTotalPoint() + itst[target]);
								choices[target][source].addAll(bestChoice.getTourList());
								choices[target][source].add(source);
							}
						}
					}
				}
				TourChoice bestChoice = null;
				for (int i = 1; i < n + 1; i++) {
					if(choices[0][i] != null) {
						if(bestChoice == null) {
							bestChoice = choices[0][i];
						} else if(choices[0][i].getTotalPoint() > bestChoice.getTotalPoint()) {
							bestChoice = choices[0][i];
						}
					}
				}
				if(cases != 0) {
					System.out.println();
				}
				System.out.println("CASE " + (cases + 1) + "#");
				System.out.println("points : " + bestChoice.getTotalPoint());
				StringBuffer sb = new StringBuffer();
				sb.append('1');
				/**
				 * 路径在存放时是逆序的，所以遍历输出路径时也需要逆序。
				 */
				int size = bestChoice.getTourList().size();
				for (int i = size - 1; i >= 0; i--) {
					int number = bestChoice.getTourList().get(i);
					if(number == n) {
						number = 0;
					}
					number++;
					sb.append("->").append(number);
				}
				System.out.println("circuit : " + sb.toString());
			}
		}
	}
	
	public static class TourChoice {
		private List<Integer> tourList = new ArrayList<>();
		private int totalPoint;
		public int getTotalPoint() {
			return totalPoint;
		}
		public void setTotalPoint(int totalPoint) {
			this.totalPoint = totalPoint;
		}
		public void add(Integer i) {
			tourList.add(i);
		}
		public void addAll(List<Integer> list) {
			for (Integer i : list) {
				tourList.add(i);
			}
		}
		public List<Integer> getTourList() {
			return tourList;
		}
	}

}
