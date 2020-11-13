package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class C1304_ContestingDecision {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				List<OnlineJudge> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					String team = sc.next();
					int[][] a = new int[4][2];
					for (int j = 0; j < 4; j++) {
						a[j][0] = sc.nextInt();
						a[j][1] = sc.nextInt();
					}
					list.add(new OnlineJudge(team, a));
				}
				Collections.sort(list, new Comparator<OnlineJudge>() {
					@Override
					public int compare(OnlineJudge o1, OnlineJudge o2) {
						if(o1.getQuestions() > o2.getQuestions()) {
							return -1;
						} else if(o1.getQuestions() < o2.getQuestions()) {
							return 1;
						}
						if(o1.getTime() < o2.getTime()) {
							return -1;
						} else if(o1.getTime() > o2.getTime()) {
							return 1;
						}
						return 0;
					}
				});
				System.out.println(list.get(0));
			}
		}
	}
	
	public static class OnlineJudge {
		private String team;
		private int questions = 0;
		private int time = 0;
		public OnlineJudge(String team, int[][] a) {
			this.team = team;
			for (int i = 0; i < 4; i++) {
				if(a[i][1] == 0) {
					continue;
				}
				time += a[i][1] + (a[i][0] - 1) * 20;
				questions++;
			}
		}
		public String getTeam() {
			return team;
		}
		public int getQuestions() {
			return questions;
		}
		public int getTime() {
			return time;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(team).append(' ').append(questions).append(' ').append(time);
			return sb.toString();
		}
	}

}
