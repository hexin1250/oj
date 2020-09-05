package michael.slf4j.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class C1084_Grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String nInput = sc.nextLine();
			int n = Integer.valueOf(nInput.trim());
			if(n == -1) {
				break;
			}
			String[] lines = new String[n];
			for (int i = 0; i < lines.length; i++) {
				lines[i] = sc.nextLine();
			}
			print(n, lines);
		}
		sc.close();
	}
	
	public static void print(int n, String[] lines) {
		List<Exam> list5 = new ArrayList<Exam>();
		List<Exam> list4 = new ArrayList<Exam>();
		List<Exam> list3 = new ArrayList<Exam>();
		List<Exam> list2 = new ArrayList<Exam>();
		List<Exam> list1 = new ArrayList<Exam>();
		List<Exam> list0 = new ArrayList<Exam>();
		for (int i = 0; i < n; i++) {
			String line = lines[i];
			String[] parts = line.split("[\\s]+");
			int solves = Integer.valueOf(parts[0]);
			String[] time = parts[1].split("[:]");
			int hours = Integer.valueOf(time[0]);
			int minutes = Integer.valueOf(time[0]);
			int seconds = Integer.valueOf(time[0]);
			Exam e = new Exam(i, solves, hours, minutes, seconds);
			if(solves == 5) {
				e.setScore(100);
				list5.add(e);
			} else if(solves == 4) {
				list4.add(e);
			} else if(solves == 3) {
				list3.add(e);
			} else if(solves == 2) {
				list2.add(e);
			} else if(solves == 1) {
				list1.add(e);
			} else {
				e.setScore(50);
				list0.add(e);
			}
		}
		Collections.sort(list4, new Exam());
		Collections.sort(list3, new Exam());
		Collections.sort(list2, new Exam());
		Collections.sort(list1, new Exam());
		int i = 1;
		int size4 = list4.size();
		for (Exam exam : list4) {
			if(i <= size4 / 2 || size4 == 1) {
				exam.setScore(95);
			} else {
				exam.setScore(90);
			}
			i++;
		}
		i = 1;
		int size3 = list3.size();
		for (Exam exam : list3) {
			if(i <= size3 / 2 || size3 == 1) {
				exam.setScore(85);
			} else {
				exam.setScore(80);
			}
			i++;
		}
		i = 1;
		int size2 = list2.size();
		for (Exam exam : list2) {
			if(i <= size2 / 2 || size2 == 1) {
				exam.setScore(75);
			} else {
				exam.setScore(70);
			}
			i++;
		}
		i = 1;
		int size1 = list1.size();
		for (Exam exam : list1) {
			if(i <= size1 / 2 || size1 == 1) {
				exam.setScore(65);
			} else {
				exam.setScore(60);
			}
			i++;
		}
		List<Exam> ret = new ArrayList<Exam>();
		ret.addAll(list0);
		ret.addAll(list1);
		ret.addAll(list2);
		ret.addAll(list3);
		ret.addAll(list4);
		ret.addAll(list5);
		Collections.sort(ret, new Comparator<Exam>() {
			@Override
			public int compare(Exam o1, Exam o2) {
				if(o1.getId() < o2.getId()) {
					return -1;
				}
				return 1;
			}
		});
		for (Exam exam : ret) {
			System.out.println(exam.getScore());
		}
		System.out.println();
	}

}

class Exam implements Comparator<Exam>{
	private int id;
	private int solves;
	private int score;
	private int hours;
	private int minutes;
	private int seconds;
	
	public Exam() {
	}
	
	public Exam(int id, int solves, int hours, int minutes, int seconds) {
		this.id = id;
		this.solves = solves;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public int getSolves() {
		return solves;
	}

	@Override
	public int compare(Exam o1, Exam o2) {
		if(o1.hours < o2.hours) {
			return -1;
		} else if(o1.hours > o2.hours) {
			return 1;
		}
		if(o1.minutes < o2.minutes) {
			return -1;
		} else if(o1.minutes > o2.minutes) {
			return 1;
		}
		if(o1.seconds < o2.seconds) {
			return -1;
		}
		return 1;
	}
	
}