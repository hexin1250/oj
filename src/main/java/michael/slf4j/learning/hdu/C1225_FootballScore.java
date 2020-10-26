package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1225_FootballScore {
	private static final Pattern p = Pattern.compile("(.*) VS (.*) ([0-9]):([0-9])");

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				long n = sc.nextLong();
				sc.nextLine();
				Map<String, FootballScore> map = new HashMap<>();
				for (long i = 0; i < (n * (n - 1)); i++) {
					String line = sc.nextLine();
					Matcher m = p.matcher(line);
					if(m.matches()) {
						String teamA = m.group(1);
						String teamB = m.group(2);
						long goalA = Long.valueOf(m.group(3));
						long goalB = Long.valueOf(m.group(4));
						
						FootballScore sa = map.get(teamA);
						FootballScore sb = map.get(teamB);
						if(sa == null) {
							sa = new FootballScore(teamA);
						}
						if(sb == null) {
							sb = new FootballScore(teamB);
						}
						if(goalA > goalB) {
							sa.addWin();
						} else if(goalA < goalB) {
							sb.addWin();
						} else {
							sa.addTie();
							sb.addTie();
						}
						sa.addTotal(goalA);
						sb.addTotal(goalB);
						sa.addNet(goalA - goalB);
						sb.addNet(goalB - goalA);
						map.put(teamA, sa);
						map.put(teamB, sb);
					}
				}
				List<FootballScore> list = new ArrayList<>(map.values());
				Collections.sort(list, new Comparator<FootballScore>() {
					@Override
					public int compare(FootballScore o1, FootballScore o2) {
						if(o1.getScore() > o2.getScore()) {
							return -1;
						} else if(o1.getScore() < o2.getScore()) {
							return 1;
						}
						if(o1.getNet() > o2.getNet()) {
							return -1;
						} else if(o1.getNet() < o2.getNet()) {
							return 1;
						}
						if(o1.getTotal() > o2.getTotal()) {
							return 1;
						} else if(o1.getTotal() < o2.getTotal()) {
							return -1;
						}
						return o1.getTeam().compareTo(o2.getTeam());
					}
				});
				for (FootballScore f : list) {
					System.out.println(f.getTeam() + " " + f.getScore());
				}
				System.out.println();
			}
		}
	}
	
	public static class FootballScore {
		private String team;
		public long win = 0;
		public long tie = 0;
		public long net = 0;
		public long total = 0;
		public FootballScore(String team) {
			this.team = team;
		}
		public void addWin() {
			this.win += 1;
		}
		public void addTie() {
			this.tie += 1;
		}
		public void addNet(long net) {
			this.net += net;
		}
		public void addTotal(long total) {
			this.total += total;
		}
		public String getTeam() {
			return team;
		}
		public long getWin() {
			return win;
		}
		public long getTie() {
			return tie;
		}
		public long getNet() {
			return net;
		}
		public long getTotal() {
			return total;
		}
		public long getScore() {
			return win * 3 + tie;
		}
	}

}
