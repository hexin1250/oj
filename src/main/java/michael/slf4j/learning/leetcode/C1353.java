package michael.slf4j.learning.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class C1353 {

	public static void main(String[] args) {
		C1353 c = new C1353();
		int[][] events = new int[][] { { 1, 5 }, { 1, 2 }, { 3, 3 }, { 1, 2 }, { 1, 5 } };
		System.out.println(c.maxEvents(events));
	}

	public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> {
        	if(a[0] - b[0] == 0) {
        		return a[1] - b[1];
        	}
        	return a[0] - b[0];
        });
        int ans = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        
        return ans;
    }

}
