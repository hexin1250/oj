package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class C1571 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				int[][] city = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						city[i][j] = sc.nextInt();
					}
				}
				int t = sc.nextInt();
				int position = 0;
				int distance = 0;
				Queue<Integer> q = new LinkedBlockingQueue<>(7);
				Map<Integer, Integer> countMap = new HashMap<>();
				int passenger = 0;
				while(t-- > 0) {
					String command = sc.next();
					if("GO".equalsIgnoreCase(command)) {
						if(!q.isEmpty()) {
							int target = q.poll();
							distance += city[position][target];
							passenger -= countMap.remove(target);
							position = target;
						}
					} else {
						int target = sc.nextInt();
						if(passenger < 7 && target != position) {
							passenger++;
							Integer count = countMap.get(target);
							if(count == null) {
								q.offer(target);
								count = 0;
							}
							count += 1;
							countMap.put(target, count);
						}
					}
				}
				System.out.println(distance);
			}
		}
	}

}
