package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class C1389_MarkovTrainsPoss {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				Map<String, Map<String, List<PathTrain>>> pathMap = new TreeMap<>();
				for (int i = 0; i < n; i++) {
					String from = sc.next();
					TimeUnit start = TimeUnit.valueOf(sc.next());
					String to = sc.next();
					TimeUnit end = TimeUnit.valueOf(sc.next());
					double cancel = sc.nextDouble();
					PathTrain pt = new PathTrain(start, end, 1 - cancel);

					Map<String, List<PathTrain>> toPath = pathMap.get(from);
					if (toPath == null) {
						toPath = new TreeMap<>();
						pathMap.put(from, toPath);
					}
					List<PathTrain> paths = toPath.get(to);
					if (paths == null) {
						paths = new ArrayList<>();
						toPath.put(to, paths);
					}
					paths.add(pt);
				}
				for (Entry<String, Map<String, List<PathTrain>>> entry : pathMap.entrySet()) {
					for (Entry<String, List<PathTrain>> embeddedEntry : entry.getValue().entrySet()) {
						List<PathTrain> list = embeddedEntry.getValue();
						Collections.sort(list, new Comparator<PathTrain>() {
							@Override
							public int compare(PathTrain o1, PathTrain o2) {
								return o1.getStart().compareTo(o2.getStart());
							}
						});
					}
				}
				String from = sc.next();
				TimeUnit start = TimeUnit.valueOf(sc.next());
				String to = sc.next();
				TimeUnit end = TimeUnit.valueOf(sc.next());
				Set<String> mem = new HashSet<>();
				mem.add(from);
				PathResult ret = dfs(pathMap, from, start, to, end, mem, new TreeMap<>());
				/**
				 * 四舍五入
				 */
				ret.addStation(from);
				ret.print();
			}
		}
	}

	public static PathResult dfs(Map<String, Map<String, List<PathTrain>>> pathMap, String from, TimeUnit start,
			String to, TimeUnit end, Set<String> mem, Map<TimeUnit, Double> possibleMap) {
		if (from.equals(to)) {
			double ret = 0D;
			for (Entry<TimeUnit, Double> entry : possibleMap.entrySet()) {
				TimeUnit tu = entry.getKey();
				if (tu.compareTo(end) > 0) {
					continue;
				}
				ret += entry.getValue();
			}
			return new PathResult(ret);
		}
		Map<String, List<PathTrain>> toPath = pathMap.get(from);
		if (toPath == null) {
			return new PathResult(0D);
		}
		PathResult ret = new PathResult(0D);
		for (Entry<String, List<PathTrain>> entry : toPath.entrySet()) {
			String destination = entry.getKey();
			if (mem.contains(destination)) {
				continue;
			}
			mem.add(destination);
			List<PathTrain> paths = entry.getValue();
			Map<TimeUnit, Double> next = new TreeMap<>();
			TimeUnit nextStart = null;
			if (possibleMap.isEmpty()) {
				double totalCancel = 1D;
				for (PathTrain pt : paths) {
					if (start.compareTo(pt.getStart()) <= 0) {
						double currentPoss = pt.getPossible() * totalCancel;
						totalCancel *= (1 - pt.getPossible());
						if (next.containsKey(pt.getEnd())) {
							double prePoss = next.get(pt.getEnd());
							currentPoss += prePoss;
						}
						next.put(pt.getEnd(), currentPoss);
					}
				}
			} else {
				for (Entry<TimeUnit, Double> possEntry : possibleMap.entrySet()) {
					double totalCancel = 1D;
					TimeUnit tu = possEntry.getKey();
					double poss = possEntry.getValue();
					for (PathTrain pt : paths) {
						if(tu.compareTo(pt.getStart()) < 0) {
							double ptPoss = pt.getPossible();
							double currentPoss = poss * ptPoss * totalCancel;
							totalCancel *= (1 - ptPoss);
							if (next.containsKey(pt.getEnd())) {
								double prePoss = next.get(pt.getEnd());
								currentPoss += prePoss;
							}
							next.put(pt.getEnd(), currentPoss);
						}
					}
				}
			}
			PathResult p = dfs(pathMap, destination, nextStart, to, end, mem, next);
			if (p.getPossible() > ret.getPossible()) {
				p.addStation(destination);
				ret = p;
			}
			mem.remove(destination);
		}
		return ret;
	}

	public static class PathResult {
		private double possible;
		private List<String> list = new ArrayList<>();

		public PathResult(double possible) {
			this.possible = possible;
		}

		public void addStation(String station) {
			list.add(station);
		}

		public void print() {
			Collections.reverse(list);
			System.out.println(list.stream().collect(Collectors.joining(" ")));
			System.out.println(String.format("%.4f", possible));
		}

		public double getPossible() {
			return possible;
		}
	}

	public static class PathTrain {
		private TimeUnit start;
		private TimeUnit end;
		private double possible;

		public PathTrain(TimeUnit start, TimeUnit end, double possible) {
			this.start = start;
			this.end = end;
			this.possible = possible;
		}

		public TimeUnit getStart() {
			return start;
		}

		public TimeUnit getEnd() {
			return end;
		}

		public double getPossible() {
			return possible;
		}

		@Override
		public int hashCode() {
			return start.hashCode() * 24 * 60 + end.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof PathTrain)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("start[").append(start).append("] - end[").append(end).append("] -> ").append(possible);
			return sb.toString();
		}
	}

	public static class TimeUnit implements Comparator<TimeUnit>, Comparable<TimeUnit> {
		private final int hour;
		private final int minute;

		private TimeUnit(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}

		public int getHour() {
			return hour;
		}

		public int getMinute() {
			return minute;
		}

		@Override
		public int hashCode() {
			return hour * 60 + minute;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof TimeUnit)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}

		@Override
		public String toString() {
			return hour + ":" + minute;
		}

		public static TimeUnit valueOf(String time) {
			String[] parts = time.split(":");
			return new TimeUnit(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
		}

		@Override
		public int compare(TimeUnit o1, TimeUnit o2) {
			if (o1.hour < o2.hour) {
				return -1;
			} else if (o1.hour > o2.hour) {
				return 1;
			}
			if (o1.minute < o2.minute) {
				return -1;
			} else if (o1.minute > o2.minute) {
				return 1;
			}
			return 0;
		}
		@Override
		public int compareTo(TimeUnit o) {
			if (hour < o.hour) {
				return -1;
			} else if (hour > o.hour) {
				return 1;
			}
			if (minute < o.minute) {
				return -1;
			} else if (minute > o.minute) {
				return 1;
			}
			return 0;
		}
	}

}