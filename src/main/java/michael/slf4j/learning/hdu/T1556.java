package michael.slf4j.learning.hdu;

import java.util.Random;

import michael.slf4j.learning.hdu.C1556_Color.Line;

public class T1556 {

	public static void main(String[] args) {
		Random r = new Random();
		int count = 100;
		while(count-- > 0) {
			int n = r.nextInt(5) + 1;
			Line[] lines = new Line[n];
			for (int i = 0; i < n; i++) {
				int start = r.nextInt(n) + 1;
				int end;
				if(start == n) {
					end = n;
				} else {
					end = r.nextInt(n - start + 1) + start;
				}
				lines[i] = new Line(start, end);
			}
			System.out.println("#######################");
			System.out.println(n);
			for (int i = 0; i < lines.length; i++) {
				System.out.println(lines[i]);
			}
			try {
				C1556_Color.check(n, lines);
				System.out.println("#######################");
			} catch(RuntimeException e) {
				System.out.println("???????????????????????");
				throw e;
			}
		}
	}

}
