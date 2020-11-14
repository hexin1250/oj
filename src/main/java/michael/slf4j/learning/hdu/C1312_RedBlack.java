package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class C1312_RedBlack {
	private static final int[][] choices = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				if(n == 0 && m == 0) {
					break;
				}
				sc.nextLine();
				char[][] ch = new char[m][n];
				int[] start = new int[2];
				boolean fillStart = false;
				for (int i = 0; i < m; i++) {
					ch[i] = sc.nextLine().toCharArray();
					if(fillStart) {
						continue;
					}
					for (int j = 0; j < n; j++) {
						if(ch[i][j] == '@') {
							start[0] = i;
							start[1] = j;
							fillStart = true;
						}
					}
				}
				Set<Integer> mem = new HashSet<>();
				Queue<int[]> q = new LinkedBlockingQueue<>();
				mem.add(getHash(start));
				q.add(start);
				while(!q.isEmpty()) {
					int[] p = q.poll();
					expand(m, n, ch, mem, p, q);
				}
				System.out.println(mem.size());
			}
		}
	}

	private static void expand(int m, int n, char[][] ch, Set<Integer> mem, int[] p, Queue<int[]> q) {
		for (int i = 0; i < 4; i++) {
			int[] choice = choices[i];
			int x = choice[0] + p[0];
			int y = choice[1] + p[1];
			if(x < 0 || x >= m || y < 0 || y >= n) {
				continue;
			}
			int[] np = new int[] {x, y};
			if(ch[x][y] == '#') {
				continue;
			}
			int hash = getHash(np);
			if(mem.contains(hash)) {
				continue;
			}
			q.add(np);
			mem.add(hash);
		}
	}

	public static int getHash(int[] p) {
		return p[0] * 21 + p[1];
	}

}
