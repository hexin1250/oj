package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C1045_Fire {
	public static class HouseCheck{
		private int l;
		private char[][] map;
		private Map<Position, Set<Position>> relation = new HashMap<>();
		private Set<Position> ps = new HashSet<>();
		public HouseCheck(int l, char[][] map) {
			this.l = l;
			this.map = map;
			generateRelation();
		}
		
		public int maxHouse() {
			int base = 0;
			Set<Position> baseList = new HashSet<>();
			for (Position p : ps) {
				Set<Position> list = relation.get(p);
				if(list.isEmpty()) {
					base++;
					baseList.add(p);
					relation.remove(p);
				}
			}
			for (Position p : baseList) {
				ps.remove(p);
			}
			return base + arrangeHouse(ps);
		}
		
		private int arrangeHouse(Set<Position> set) {
			if(set.isEmpty()) {
				return 0;
			}
			Set<Position> tmp = new HashSet<>();
			tmp.addAll(set);
			int max = 0;
			for (Position p : set) {
				Set<Position> relationList = relation.get(p);
				Set<Position> crossSet = new HashSet<>();
				crossSet.addAll(tmp);
				crossSet.retainAll(relationList);
				crossSet.add(p);
				
				tmp.removeAll(crossSet);
				int currentHouse = arrangeHouse(tmp) + 1;
				if(currentHouse > max) {
					max = currentHouse;
				}
				tmp.addAll(crossSet);
			}
			return max;
		}
		
		private void generateRelation() {
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					char c = map[i][j];
					if(c == 'X') {
						continue;
					}
					Position p = new Position(i, j, c);
					ps.add(p);
					Set<Position> list = relation.get(p);
					if(list == null) {
						list = new HashSet<>();
					}
					for (int k = j + 1; k < l; k++) {
						char nc = map[i][k];
						if(nc == 'X') {
							break;
						}
						Position np = new Position(i, k, nc);
						list.add(np);
						
						Set<Position> listN = relation.get(np);
						if(listN == null) {
							listN = new HashSet<>();
						}
						listN.add(p);
						relation.put(np, listN);
					}
					for (int k = i + 1; k < l; k++) {
						char nc = map[k][j];
						if(nc == 'X') {
							break;
						}
						Position np = new Position(k, j, nc);
						list.add(np);
						
						Set<Position> listN = relation.get(np);
						if(listN == null) {
							listN = new HashSet<>();
						}
						listN.add(p);
						relation.put(np, listN);
					}
					relation.put(p, list);
				}
			}
		}
	}
	
	public static class Position{
		private int x;
		private int y;
		private char c;
		public Position(int x, int y, char c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
		@Override
		public int hashCode() {
			return x * 101 + y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Position)) {
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("[").append(x).append(",").append(y).append("]:").append(c);
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			sc.nextLine();
			char[][] map = new char[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = sc.nextLine().toCharArray();
			}
			HouseCheck check = new HouseCheck(n, map);
			System.out.println(check.maxHouse());
		}
		sc.close();
	}

}
