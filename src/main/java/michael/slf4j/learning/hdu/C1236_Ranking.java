package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class C1236_Ranking {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				int m = sc.nextInt();
				int baseLine = sc.nextInt();
				int[] ques = new int[m];
				IntStream.range(0, m).forEach(i -> ques[i] = sc.nextInt());
				sc.nextLine();
				List<StudentResult> list = new ArrayList<>();
				IntStream.range(0, n).forEach(i -> {
					String line = sc.nextLine();
					String[] parts = line.split("[\\s]+");
					int myQues = Integer.valueOf(parts[1]);
					int sum = 0;
					for (int j = 0; j < myQues; j++) {
						int currentQuesId = Integer.valueOf(parts[2 + j]);
						sum += ques[currentQuesId - 1];
					}
					if(sum >= baseLine) {
						list.add(new StudentResult(parts[0], sum));
					}
				});
				Collections.sort(list, new Comparator<StudentResult>() {
					@Override
					public int compare(StudentResult o1, StudentResult o2) {
						if(o1.getScore() > o2.getScore()) {
							return -1;
						} else if(o1.getScore() < o2.getScore()) {
							return 1;
						}
						return o1.getId().compareTo(o2.getId());
					}
				});
				System.out.println(list.size());
				list.forEach(r -> System.out.println(r));
			}
		}
	}
	
	public static class StudentResult {
		private String id;
		private int score = 0;
		public StudentResult(String id, int score) {
			this.id = id;
			this.score = score;
		}
		public String getId() {
			return id;
		}
		public int getScore() {
			return score;
		}
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(id).append(' ').append(score);
			return sb.toString();
		}
	}

}
