package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1107_KongFuWorld {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				sc.nextLine();
				int index = 0;
				Map<Point, List<Clan>> movePoint = new HashMap<>();
				Map<Point, List<Clan>> fightPoint = new HashMap<>();
				while(sc.hasNext()) {
					String line = sc.nextLine();
					if("0".equals(line)) {
						break;
					}
					String[] parts = line.split("[\\s]+");
					Clan clan;
					if("S".equals(parts[0])) {
						clan = new Shaolin(index++, Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Integer.valueOf(parts[5]));
					} else if("W".equals(parts[0])) {
						clan = new Wudang(index++, Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Integer.valueOf(parts[5]));
					} else {
						clan = new Emei(index++, Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Integer.valueOf(parts[5]));
					}
					addPoint2Map(clan, movePoint, fightPoint);
				}
				while(n-- > 0) {
					Map<Point, List<Clan>> tmpMovePoint = new HashMap<>();
					Map<Point, List<Clan>> tmpFightPoint = new HashMap<>();
					List<Clan> clans = new ArrayList<>();
					for (Entry<Point, List<Clan>> entry : fightPoint.entrySet()) {
						List<Clan> fightList = entry.getValue();
						Clan c1 = fightList.get(0);
						Clan c2 = fightList.get(1);
						if(c1.type() != c2.type()) {
							int att1 = c1.attack();
							int att2 = c2.attack();
							c1.life -= att2;
							c2.life -= att1;
							if(c1.life > 0) {
								clans.add(c1);
							}
							if(c2.life > 0) {
								clans.add(c2);
							}
						} else {
							clans.addAll(fightList);
						}
					}
					for (Clan clan : clans) {
						clan.move();
						addPoint2Map(clan, tmpMovePoint, tmpFightPoint);
					}
					for (List<Clan> clanList : movePoint.values()) {
						for (Clan clan : clanList) {
							clan.move();
							addPoint2Map(clan, tmpMovePoint, tmpFightPoint);
						}
					}
					movePoint = tmpMovePoint;
					fightPoint = tmpFightPoint;
				}
				int sC = 0;
				int sLife = 0;
				int wC = 0;
				int wLife = 0;
				int eC = 0;
				int eLife = 0;
				for (List<Clan> list : movePoint.values()) {
					for (Clan clan : list) {
						if(clan.type() == ClanEnum.shaolin) {
							sC++;
							sLife += clan.life;
						} else if(clan.type() == ClanEnum.wudang) {
							wC++;
							wLife += clan.life;
						} else {
							eC++;
							eLife += clan.life;
						}
					}
				}
				for (List<Clan> list : fightPoint.values()) {
					for (Clan clan : list) {
						if(clan.type() == ClanEnum.shaolin) {
							sC++;
							sLife += clan.life;
						} else if(clan.type() == ClanEnum.wudang) {
							wC++;
							wLife += clan.life;
						} else {
							eC++;
							eLife += clan.life;
						}
					}
				}
				System.out.println(sC + " " + sLife);
				System.out.println(wC + " " + wLife);
				System.out.println(eC + " " + eLife);
				System.out.println("***");
			}
		}
	}

	private static void addPoint2Map(Clan clan, Map<Point, List<Clan>> movePoint, Map<Point, List<Clan>> fightPoint) {
		Point p = new Point(clan.x, clan.y);
		if(movePoint.containsKey(p)) {
			List<Clan> list = movePoint.remove(p);
			if(list.size() == 1) {
				list.add(clan);
				fightPoint.put(p, list);
			} else {
				list.add(clan);
				movePoint.put(p, list);
			}
		} else {
			List<Clan> list = null;
			if(fightPoint.containsKey(p)) {
				list = fightPoint.remove(p);
			} else {
				list = new ArrayList<>();
			}
			list.add(clan);
			movePoint.put(p, list);
		}
	}

	public static abstract class Clan {
		protected boolean direction = true;
		protected int id;
		protected int x;
		protected int y;
		protected int inside;
		protected int outside;
		protected int life;
		public Clan(int id, int x, int y, int inside, int outside, int life) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.inside = inside;
			this.outside = outside;
			this.life = life;
		}
		
		public abstract int[] getNextStep();
		public abstract double insideRate();
		public abstract double outsideRate();
		public abstract ClanEnum type();
		
		public Point nowPosition() {
			return new Point(x, y);
		}
		public void move() {
			int[] next = getNextStep();
			x = x + next[0];
			y = y + next[1];
		}
		protected boolean isValid(int x, int y) {
			if(x < 1 || x > 12 || y < 1 || y > 12) {
				return false;
			}
			return true;
		}
		public int attack() {
			return (int)((insideRate() * (double)inside + outsideRate() * (double)outside) * ((double)life + 10D) / 100D);
		}
	}
	
	public static class Shaolin extends Clan {
		public Shaolin(int id, int x, int y, int inside, int outside, int life) {
			super(id, x, y, inside, outside, life);
		}

		@Override
		public int[] getNextStep() {
			int offsetX = direction ? 1 : -1;
			if(isValid(offsetX + x, y)) {
				return new int[] {offsetX, 0};
			}
			direction = !direction;
			return new int[] {offsetX * -1, 0};
		}

		@Override
		public double insideRate() {
			return 0.5D;
		}

		@Override
		public double outsideRate() {
			return 0.5D;
		}

		@Override
		public ClanEnum type() {
			return ClanEnum.shaolin;
		}
	}
	
	public static class Wudang extends Clan {
		public Wudang(int id, int x, int y, int inside, int outside, int life) {
			super(id, x, y, inside, outside, life);
		}

		@Override
		public int[] getNextStep() {
			int offsetX = direction ? 1 : -1;
			if(isValid(x, offsetX + y)) {
				return new int[] {0, offsetX};
			}
			direction = !direction;
			return new int[] {0, offsetX * -1};
		}

		@Override
		public double insideRate() {
			return 0.8D;
		}

		@Override
		public double outsideRate() {
			return 0.2D;
		}

		@Override
		public ClanEnum type() {
			return ClanEnum.wudang;
		}
	}
	
	public static class Emei extends Clan {
		public Emei(int id, int x, int y, int inside, int outside, int life) {
			super(id, x, y, inside, outside, life);
		}

		@Override
		public int[] getNextStep() {
			int offsetX = direction ? 1 : -1;
			if(isValid(offsetX + x, offsetX + y)) {
				return new int[] {offsetX, offsetX};
			}
			direction = !direction;
			offsetX = offsetX * -1;
			if(isValid(offsetX + x, offsetX + y)) {
				return new int[] {offsetX, offsetX};
			}
			return new int[] {0, 0};
		}

		@Override
		public double insideRate() {
			return 0.2D;
		}

		@Override
		public double outsideRate() {
			return 0.8D;
		}

		@Override
		public ClanEnum type() {
			return ClanEnum.emei;
		}
	}
	
	public static enum ClanEnum {
		wudang,
		shaolin,
		emei
	}
	
	public static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			return x * 13 + y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Point)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append('(').append(x).append(',').append(y).append(')');
			return sb.toString();
		}
	}

}
