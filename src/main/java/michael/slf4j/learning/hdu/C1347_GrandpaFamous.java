package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1347_GrandpaFamous {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				if (n == 0 && m == 0) {
					break;
				}
				Map<Integer, Ranking> map = new HashMap<>();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						int id = sc.nextInt();
						Ranking r = map.get(id);
						if(r == null) {
							r = new Ranking(id);
							map.put(id, r);
						}
						r.addScore();
					}
				}
				List<Ranking> list = new ArrayList<>(map.values());
				Collections.sort(list, new Comparator<Ranking>() {
					@Override
					public int compare(Ranking o1, Ranking o2) {
						if(o1.getScore() > o2.getScore()) {
							return -1;
						} else if(o1.getScore() < o2.getScore()) {
							return 1;
						}
						if(o1.getId() < o2.getId()) {
							return -1;
						}
						return 1;
					}
				});
				int maxScore = 0;
				Ranking prev = null;
				for (Ranking r : list) {
					if(r.getScore() >= maxScore) {
						maxScore = r.getScore();
						continue;
					}
					if(prev == null || prev.getScore() == r.getScore()) {
						if(prev != null) {
							System.out.print(" ");
						}
						prev = r;
						System.out.print(r.getId());
					} else {
						break;
					}
				}
				System.out.println();
			}
		}
	}
	
	public static class Ranking {
		private int id;
		private int score;
		public Ranking(int id){
			this.id = id;
			this.score = 0;
		}
		public int getId() {
			return id;
		}
		public int getScore() {
			return score;
		}
		public void addScore() {
			this.score++;
		}
	}

}
