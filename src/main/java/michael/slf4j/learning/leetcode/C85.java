package michael.slf4j.learning.leetcode;

public class C85 {

	public static void main(String[] args) {
		C85 c = new C85();
		char[][] matrix = new char[][] {{'0','1'}};
		System.out.println(c.maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dpRows = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(matrix[i][j] != '1') {
					continue;
				}
				if(j == 0) {
					dpRows[i][j] = 1;
				} else {
					dpRows[i][j] = dpRows[i][j - 1] + 1;
				}
			}
		}
		int max = 0;
		for (int j = 0; j < cols; j++) {
			if(max < dpRows[0][j]) {
				max = dpRows[0][j];
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int minWidth = Integer.MAX_VALUE;
				for (int k = i; k >= 0; k--) {
					minWidth = Math.min(minWidth, dpRows[k][j]);
					int area = minWidth * (i - k + 1);
					if(area > max) {
						max = area;
					}
				}
			}
		}
		return max;
	}

}
