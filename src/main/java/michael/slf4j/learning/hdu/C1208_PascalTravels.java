package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1208_PascalTravels {
	private static Map<Integer, Long> mem = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == -1) {
					break;
				}
				sc.nextLine();
				int[][] maze = new int[n][n];
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine();
					for (int j = 0; j < n; j++) {
						maze[i][j] = line.charAt(j) - '0';
					}
				}
				int[][] choices = new int[n][n];
				for (int i = n - 2; i >= 0; i--) {
					int nRight = maze[n - 1][i];
					if(nRight + i == n - 1) {
						choices[n - 1][i] = choices[n - 1][i] | 2;
					} else if(nRight + i < n - 1) {
						choices[n - 1][i] = choices[n - 1][nRight + i];
					}
					int nDown = maze[i][n - 1];
					if(nDown + i == n - 1) {
						choices[i][n - 1] = choices[i][n - 1] | 1;
					} else if(nDown + i < n - 1) {
						choices[i][n - 1] = choices[nDown + i][n - 1];
					}
				}
				for (int i = n - 2; i >= 0; i--) {
					for (int j = i; j >= 0; j--) {
						int number = maze[i][j];
						if(number + j <= n - 1 && choices[i][number + j] != 0) {
							choices[i][j] = choices[i][j] | 2;
						}
						if(number + i <= n - 1 && choices[number + i][j] != 0) {
							choices[i][j] = choices[i][j] | 1;
						}
						if(i != j) {
							int otherNumber = maze[j][i];
							if(otherNumber + i <= n - 1 && choices[j][otherNumber + i] != 0) {
								choices[j][i] = choices[j][i] | 2;
							}
							if(otherNumber + j <= n - 1 && choices[otherNumber + j][i] != 0) {
								choices[j][i] = choices[j][i] | 1;
							}
						}
					}
				}
				long ret = dfs(maze, choices, 0, 0);
				System.out.println(ret);
				mem.clear();
			}
		}
	}

	private static long dfs(int[][] maze, int[][] choices, int x, int y) {
		if(x == maze.length - 1 && y == maze.length - 1) {
			return 1;
		}
		int hash = getHash(x, y);
		if(mem.get(hash) != null) {
			return mem.get(hash);
		}
		int choice = choices[x][y];
		long sum = 0;
		int number = maze[x][y];
		if((choice & 1) == 1) {
			int newX = x + number;
			if(newX < maze.length) {
				sum += dfs(maze, choices, newX, y);
			}
		}
		if((choice & 2) == 2) {
			int newY = y + number;
			if(newY < maze.length) {
				sum += dfs(maze, choices, x, newY);
			}
		}
		mem.put(hash, sum);
		return sum;
	}
	
	public static int getHash(int x, int y) {
		return x * 35 + y;
	}

}
