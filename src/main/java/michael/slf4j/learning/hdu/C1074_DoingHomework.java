package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class C1074_DoingHomework {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				sc.nextLine();
				Homework[] works = new Homework[n];
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine();
					String[] parts = line.split("[\\s]+");
					works[i] = new Homework(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), i);
				}
				HomeworkOrder order = bfs(works, new int[n], 0, 0, 0, new ArrayList<Homework>(), null);
				System.out.println(order.cost);
				for (Homework homework : order.courses) {
					System.out.println(homework.course);
				}
			}
		}
	}

	private static HomeworkOrder bfs(Homework[] works, int[] mem, int step, int currentDay, int currentCost,
			List<Homework> homeworkList, HomeworkOrder min) {
		if (step == works.length) {
			return new HomeworkOrder(homeworkList, currentCost);
		}
		if (min != null && currentCost > min.cost) {
			return null;
		}
		HomeworkOrder currentmin = min;
		for (int i = 0; i < works.length; i++) {
			if (mem[i] != 0) {
				continue;
			}
			mem[i] = 1;
			Homework currentHomework = works[i];
			int nextDay = currentDay + currentHomework.cost;
			int nextCost = currentCost;
			if (nextDay > currentHomework.deadline) {
				nextCost += nextDay - currentHomework.deadline;
			}
			List<Homework> nextHomework = new ArrayList<>(homeworkList);
			nextHomework.add(currentHomework);
			HomeworkOrder currentRet = bfs(works, mem, step + 1, nextDay, nextCost, nextHomework, currentmin);
			if (currentRet != null) {
				if (currentmin == null || currentRet.compareTo(currentmin) == -1) {
					currentmin = currentRet;
				}
			}
			mem[i] = 0;
		}
		return currentmin;
	}

	public static class Homework {
		public String course;
		public int deadline;
		public int cost;
		public int order;

		public Homework(String course, int deadline, int cost, int order) {
			this.course = course;
			this.deadline = deadline;
			this.cost = cost;
			this.order = order;
		}
	}

	public static class HomeworkOrder implements Comparator<HomeworkOrder>, Comparable<HomeworkOrder> {
		public int cost;
		public List<Homework> courses;

		public HomeworkOrder(List<Homework> courses, int cost) {
			this.cost = cost;
			this.courses = courses;
		}

		@Override
		public int compare(HomeworkOrder o1, HomeworkOrder o2) {
			if (o1.cost < o2.cost) {
				return -1;
			} else if (o1.cost > o2.cost) {
				return 1;
			}
			int size = o1.courses.size();
			for (int i = 0; i < size; i++) {
				Homework h1 = o1.courses.get(i);
				Homework h2 = o2.courses.get(i);
				if (h1.order < h2.order) {
					return -1;
				} else if (h1.order > h2.order) {
					return 1;
				}
			}
			return 0;
		}

		@Override
		public int compareTo(HomeworkOrder o) {
			if (cost < o.cost) {
				return -1;
			} else if (cost > o.cost) {
				return 1;
			}
			int size = courses.size();
			for (int i = 0; i < size; i++) {
				Homework h1 = courses.get(i);
				Homework h2 = o.courses.get(i);
				if (h1.order < h2.order) {
					return -1;
				} else if (h1.order > h2.order) {
					return 1;
				}
			}
			return 0;
		}
	}

}