package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//深度优先搜索，超时
//应参考广度优先搜索策略，参考https://blog.csdn.net/weixin_40953222/article/details/80544928
public class C1026_PrincessI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				map[i] = line.toCharArray();
			}
			SearchPath sp = new SearchPath(n, m, map);
			int[] position = new int[] { 0, 0 };
			int[][] mem = new int[n][m];
			mem[0][0] = 1;
			List<String> ret = new ArrayList<String>();
			int min = 0;
			List<String> path = new ArrayList<>();
			int[][] choices = new int[2][2];
			choices[0] = new int[]{0, 1};
			choices[1] = new int[]{1, 0};
			for (int i = 0; i < 2; i++) {
				int[] choice = choices[i];
				mem[choice[0]][choice[1]] = 1;
				List<String> nextStep = sp.find(position, choice, mem, path, min);
				mem[choice[0]][choice[1]] = 0;
				if(nextStep.size() > 0){
					min = nextStep.size();
					ret = nextStep;
				}
			}
			if(min == 0){
				System.out.println("God please help our poor hero.");
				System.out.println("FINISH");
			} else {
				StringBuffer sb = new StringBuffer();
				sb.append(String.format("It takes %d seconds to reach the target position, let me show you the way.", ret.size())).append("\r\n");
				int index = 1;
				for (String step : ret) {
					sb.append(index++).append("s:").append(step);
					sb.append("\r\n");
				}
				sb.append("FINISH");
				System.out.println(sb.toString());
			}
		}
		sc.close();
	}

}

class SearchPath {
	private int n;
	private int m;
	private char[][] map;
	
	public SearchPath(int n, int m, char[][] map){
		this.n = n;
		this.m = m;
		this.map = map;
	}
	
	public List<String> find(int[] previousP, int[] position, int[][] mem, List<String> path, int minTimes) {
		int x = position[0];
		int y = position[1];
		char currentPosition = map[x][y];
		if(currentPosition == 'X'){
			return new ArrayList<>();
		}
		List<String> nextPath = new ArrayList<>();
		for (String step : path) {
			nextPath.add(step);
		}
		nextPath.add(getStatus(previousP, position));
		if(!(currentPosition == '.')){
			int fightTime = fightTime(currentPosition);
			for (int i = 0; i < fightTime; i++) {
				nextPath.add(getFightStatus(position));
			}
		}
//		超过目前最短时间，剪枝
		if(minTimes != 0 && nextPath.size() == minTimes){
			return new ArrayList<>();
		}
//		到达终点
		if(x == n - 1 && y == m - 1){
			return nextPath;
		}
		List<String> ret = new ArrayList<String>();
		int min = minTimes;
		int[][] choices = new int[4][2];
		choices[0] = new int[]{x, y + 1};
		choices[1] = new int[]{x, y - 1};
		choices[2] = new int[]{x + 1, y};
		choices[3] = new int[]{x - 1, y};
		for (int i = 0; i < 4; i++) {
			int[] nextPosition = choices[i];
//			不可达或已经访问过
			if(!isValid(nextPosition[0], nextPosition[1]) || mem[nextPosition[0]][nextPosition[1]] == 1){
				continue;
			}
			mem[nextPosition[0]][nextPosition[1]] = 1;
			List<String> currentChoice = find(position, nextPosition, mem, nextPath, min);
			mem[nextPosition[0]][nextPosition[1]] = 0;
			if((min == 0) || (currentChoice.size() > 0 && currentChoice.size() < min)){
				ret = currentChoice;
				min = currentChoice.size();
			}
		}
		return ret;
	}
	
	private int fightTime(char c){
		return c - '1' + 1;
	}
	
	private String getStatus(int[] prevP, int[] currentP){
		return String.format("(%d,%d)->(%d,%d)", prevP[0], prevP[1], currentP[0], currentP[1]);
	}
	
	private String getFightStatus(int[] currentP){
		return String.format("FIGHT AT (%d,%d)", currentP[0], currentP[1]);
	}
	
	private boolean isValid(int x, int y){
		if(x < 0 || x >= n || y < 0 || y >= m){
			return false;
		}
		return true;
	}
}
