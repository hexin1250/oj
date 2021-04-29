package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1426_Sudoku {
	private static final Map<Integer, Integer> TEMPLATE = new HashMap<>();
	
	static {
		for (int i = 1; i <= 9; i++) {
			TEMPLATE.put(i, i);
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int[][] sudoku = new int[9][9];
				int maze = 0;
				for (int i = 0; i < 9; i++) {
					String line = sc.nextLine();
					if(line.trim().length() == 0) {
						i--;
					}
					String parts = line.replaceAll("[\\s]+", "");
					for (int j = 0; j < 9; j++) {
						char ch = parts.charAt(j);
						if(ch == '?') {
							sudoku[i][j] = 0;
							maze++;
						} else {
							sudoku[i][j] = ch - '0';
						}
					}
				}
				while(true) {
					boolean end = true;
					for (int i = 0; i < 9 && end; i++) {
						for (int j = 0; j < 9 && end; j++) {
							if(sudoku[i][j] == 0) {
								Map<Integer, Integer> possible = generatePossible(sudoku, i, j);
								if(possible.size() == 1) {
									sudoku[i][j] = possible.keySet().stream().findFirst().get();
									maze--;
									end = false;
									break;
								}
							}
						}
					}
					if(end || maze == 0) {
						break;
					}
				}
				while(true && maze != 0) {
					boolean end = true;
					for (int i = 0; i <= 2 && end; i++) {
						for (int j = 0; j <= 2 && end; j++) {
							Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
							for (int row = i * 3; row <= i * 3 + 2; row++) {
								for (int col = j * 3; col <= j * 3 + 2; col++) {
									if(sudoku[row][col] == 0) {
										int hash = row * 9 + col;
										Map<Integer, Integer> possible = generatePossible(sudoku, row, col);
										map.put(hash, possible);
									}
								}
							}
							for (int row = i * 3; row <= i * 3 + 2 && end; row++) {
								for (int col = j * 3; col <= j * 3 + 2 && end; col++) {
									if(sudoku[row][col] == 0) {
										int hash = row * 9 + col;
										Map<Integer, Integer> current = map.get(hash);
										for (int target : current.keySet()) {
											boolean find = false;
											for (Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
												int comparison = entry.getKey();
												if(comparison == hash) {
													continue;
												}
												Map<Integer, Integer> otherMap = entry.getValue();
												if(otherMap.containsKey(target)) {
													find = true;
													break;
												}
											}
											if(!find) {
												sudoku[row][col] = target;
												maze--;
												end = false;
												break;
											}
										}
									}
								}
							}
						}
					}
					if(end) {
						break;
					}
				}
				System.out.println(Arrays.stream(sudoku)
						.map(row -> Arrays.stream(row).mapToObj(e -> e + "").collect(Collectors.joining(" ")))
						.collect(Collectors.joining("\r\n")));
				if(maze > 0) {
					SudokuDFS d = new SudokuDFS(sudoku);
					d.dfs();
					sudoku = d.getFinal();
				}
				System.out.println(Arrays.stream(sudoku)
						.map(row -> Arrays.stream(row).mapToObj(e -> e + "").collect(Collectors.joining(" ")))
						.collect(Collectors.joining("\r\n")));
			}
		}
	}
	
	private static Map<Integer, Integer> generatePossible(int[][] soduku, int i, int j){
		Map<Integer, Integer> ret = new HashMap<>();
		ret.putAll(TEMPLATE);
		for (int row = 0; row < 9; row++) {
			if(soduku[row][j] != 0) {
				ret.remove(soduku[row][j]);
			}
		}
		if(ret.size() == 1) {
			return ret;
		}
		for (int col = 0; col < 9; col++) {
			if(soduku[i][col] != 0) {
				ret.remove(soduku[i][col]);
			}
		}
		if(ret.size() == 1) {
			return ret;
		}
		int rowPart = i / 3;
		int colPart = j / 3;
		for (int row = rowPart * 3; row <= rowPart * 3 + 2; row++) {
			for (int col = colPart * 3; col <= colPart * 3 + 2; col++) {
				ret.remove(soduku[row][col]);
			}
		}
		return ret;
	}
	
	public static class SudokuDFS {
		private int[][] memory;
		
		public SudokuDFS(int[][] sudoku) {
			this.memory = sudoku;
		}
		
		public boolean dfs() {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(memory[i][j] == 0) {
						Map<Integer, Integer> possible = generatePossible(memory, i, j);
						if(possible.isEmpty()) {
							return false;
						}
						for (Integer key : possible.keySet()) {
							memory[i][j] = key;
							boolean nested = dfs();
							if(!nested) {
								memory[i][j] = 0;
							} else {
								return true;
							}
						}
					}
				}
			}
			return false;
		}
		
		public int[][] getFinal(){
			return memory;
		}
	}

}
