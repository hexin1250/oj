package michael.slf4j.learning.hdu;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class C1201_Birthday {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			sc.nextLine();
			while(testcase-- > 0) {
				String line = sc.nextLine();
				LocalDate ld = null;
				try {
//					ld = LocalDate.parse(line, DateTimeFormatter.ISO_LOCAL_DATE);
					ld = LocalDate.parse(line, DateTimeFormatter.ofPattern("yyyy-M-d"));
				} catch(Exception e) {
					System.out.println(-1);
					continue;
				}
				int year = ld.getYear();
				int month = ld.getMonthValue();
				int days = ld.getDayOfMonth();
				LocalDate birthday = null;
				try {
					birthday = LocalDate.of(year + 18, month, days);
				} catch(Exception e) {
					System.out.println(-1);
					continue;
				}
				Date bir = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date intDate = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
				System.out.println((bir.getTime() - intDate.getTime()) / (1000L * 3600L * 24L));
			}
		}
	}

}
