package michael.slf4j.learning.hdu;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1234_OpenClose {
	private static final Pattern p = Pattern.compile("(.*) ([0-9]*[:][0-9]*[:][0-9]*) ([0-9]*[:][0-9]*[:][0-9]*)");

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				sc.nextLine();

				LocalTime startTime = null;
				String startName = null;
				LocalTime endTime = null;
				String endName = null;
				for (int i = 0; i < n; i++) {
					String line = sc.nextLine();
					Matcher m = p.matcher(line);
					if (m.matches()) {
						String name = m.group(1);
						String start = m.group(2);
						String end = m.group(3);

						LocalTime currentStartTime = LocalTime.parse(start);
						LocalTime currentEndTime = LocalTime.parse(end);
						if (startName == null) {
							startTime = currentStartTime;
							startName = name;
							endTime = currentEndTime;
							endName = name;
						} else {
							if (currentStartTime.compareTo(startTime) < 0) {
								startTime = currentStartTime;
								startName = name;
							}
							if (currentEndTime.compareTo(endTime) > 0) {
								endTime = currentEndTime;
								endName = name;
							}
						}
					}
				}
				System.out.println(startName + " " + endName);
			}
		}
	}

}