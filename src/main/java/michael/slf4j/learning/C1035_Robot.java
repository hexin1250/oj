package michael.slf4j.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1035_Robot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int start = sc.nextInt();
			if(x == 0 && y == 0) {
				break;
			}
			sc.nextLine();
			char[][] map = new char[x][y];
			for (int i = 0; i < x; i++) {
				map[i] = sc.nextLine().toCharArray();
			}
			Map<Integer, Position> mem = new HashMap<>();
			int i = 0, j = start - 1, step = 1;
			while(true) {
				Position p = new Position(i, j, step++);
				mem.put(p.hashCode(), p);
				int nextX = 0;
				int nextY = 0;
				if(map[i][j] == 'E') {
					nextY = 1;
				} else if(map[i][j] == 'S') {
					nextX = 1;
				} else if(map[i][j] == 'W') {
					nextY = -1;
				} else if(map[i][j] == 'N') {
					nextX = -1;
				}
				if(!isValid(i + nextX, j + nextY, x, y)) {
					System.out.printf("%d step(s) to exit\r\n", p.getStep());
					break;
				} else {
					Position np = new Position(i + nextX, j + nextY, step);
					if(mem.containsKey(np.hashCode())) {
						Position cycleStartP = mem.get(np.hashCode());
						int enterCycle = cycleStartP.getStep() - 1;
						int cycleStep = p.getStep() - cycleStartP.getStep() + 1;
						System.out.printf("%d step(s) before a loop of %d step(s)\r\n", enterCycle, cycleStep);
						break;
					}
					i = i + nextX;
					j = j + nextY;
				}
			}
		}
		sc.close();
	}
	
	private static boolean isValid(int x, int y, int row, int column) {
		if(x < 0 || y < 0 || x >= row || y >= column) {
			return false;
		}
		return true;
	}
	
	public static class Position {
		private int x;
		private int y;
		private int step;
		public Position(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
		public int getStep() {
			return step;
		}
		@Override
		public int hashCode() {
			return x * 100 + y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Position)){
				return false;
			}
			Position p = (Position) obj;
			return this.hashCode() == p.hashCode();
		}
		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}

}
