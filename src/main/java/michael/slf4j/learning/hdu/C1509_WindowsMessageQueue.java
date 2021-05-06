package michael.slf4j.learning.hdu;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

public class C1509_WindowsMessageQueue {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			TreeMap<Integer, Queue<String>> map = new TreeMap<>();
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				if("get".equalsIgnoreCase(parts[0])) {
					if(map.isEmpty()) {
						System.out.println("EMPTY QUEUE!");
					} else {
						Iterator<Entry<Integer, Queue<String>>> it = map.entrySet().iterator();
						while(it.hasNext()) {
							Entry<Integer, Queue<String>> entry = it.next();
							Queue<String> q = entry.getValue();
							String message = q.poll();
							System.out.println(message);
							if(q.isEmpty()) {
								it.remove();
							}
							break;
						}
					}
				} else {
					int priority = Integer.valueOf(parts[3]);
					Queue<String> q = map.get(priority);
					if(q == null) {
						q = new LinkedBlockingQueue<>();
						map.put(priority, q);
					}
					StringBuffer sb = new StringBuffer();
					sb.append(parts[1]).append(" ").append(parts[2]);
					String message = sb.toString();
					q.add(message);
				}
			}
		}
	}

}
