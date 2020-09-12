package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1010_Tempter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
			if(n == 0 || m == 0 || t == 0) {
				break;
			}
			sc.nextLine();
			int sX = -1;
			int sY = -1;
			char[][] ch = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				ch[i] = line.toCharArray();
				if(sY == -1) {
					sX = i;
					sY = line.indexOf("S");
				}
			}
			if(n * m <= t) {
				System.out.println("NO");
			} else {
				int[][] visit = new int[n][m];
				visit[sX][sY] = 1;
				int[] position = new int[] {sX, sY};
				boolean findDoor = findDoor(ch, 0, position, visit, n, m, t);
				if(findDoor) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		sc.close();
	}

	private static boolean findDoor(char[][] ch, int step, int[] position, int[][] visit, int n, int m, int target) {
		int x = position[0];
		int y = position[1];
		if(step == target) {
			if(ch[x][y] == 'D') {
				return true;
			} else {
				return false;
			}
		}
		if(ch[x][y] == 'D' || ch[x][y] == 'X') {
			return false;
		}
		if(x + 1 < n && visit[x + 1][y] == 0) {
			visit[x + 1][y] = 1;
			if(findDoor(ch, step + 1, new int[] {x + 1, y}, visit, n, m, target)) {
				return true;
			}
			visit[x + 1][y] = 0;
		}
		
		if(x - 1 >= 0 && visit[x - 1][y] == 0) {
			visit[x - 1][y] = 1;
			if(findDoor(ch, step + 1, new int[] {x - 1, y}, visit, n, m, target)) {
				return true;
			}
			visit[x - 1][y] = 0;
		}
		
		if(y + 1 < m && visit[x][y + 1] == 0) {
			visit[x][y + 1] = 1;
			if(findDoor(ch, step + 1, new int[] {x, y + 1}, visit, n, m, target)) {
				return true;
			}
			visit[x][y + 1] = 0;
		}
		
		if(y - 1 >= 0 && visit[x][y - 1] == 0) {
			visit[x][y - 1] = 1;
			if(findDoor(ch, step + 1, new int[] {x, y - 1}, visit, n, m, target)) {
				return true;
			}
			visit[x][y - 1] = 0;
		}
		return false;
	}

}
