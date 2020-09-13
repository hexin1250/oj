package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C1067_Gap {
	private static final int h = 4;
	private static final int w = 8;

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			while(testcase-- > 0){
				Map<Integer, Position> positionMap = new HashMap<>();
				Set<Position> emptySet = new HashSet<>();
				int[][] arr = new int[h][w];
				for (int i = 0; i < h; i++) {
					for (int j = 1; j < w; j++) {
						arr[i][j] = sc.nextInt();
					}
				}
			}
		}
	}
	
	public static class Process {
		private int[][] map;
		private Map<Integer, Position> positionMap;
		private Set<Position> emptySet = new HashSet<>();
		private int status;
		public Process(int[][] map, Map<Integer, Position> positionMap){
			this.map = map;
			this.positionMap = positionMap;
			this.status = status();
		}
		
		private int status(){
			int status = 0;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h - 1; j++) {
					int n = map[i][j];
					if(!isInPosition(n, i, j)){
						status++;
					}
				}
			}
			return status;
		}
		
		private boolean isInPosition(int n, int tx, int ty){
			int x = n / 10;
			int y = n % 10;
			return (x - 1 == tx && y - 1 == ty);
		}
	}
	
	public static class Position {
		public int x;
		public int y;
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null){
				return false;
			}
			if(!(obj instanceof Position)){
				return false;
			}
			return hashCode() == obj.hashCode();
		}
		@Override
		public int hashCode() {
			return x * 100 + y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}


}
