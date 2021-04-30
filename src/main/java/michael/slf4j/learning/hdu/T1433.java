package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T1433 {
	private static final char[] ARR = new char[] {'p','q','r','s','t','u','v','w','x','y','z','C','D','E','I','N'};

	public static void main(String[] args) {
		Random r = new Random();
		List<String> ret = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			int correct = 0;
			int incorrect = 0;
			while(correct < 5 || incorrect < 5) {
				StringBuffer sb = new StringBuffer();
				for (int k = 0; k < i; k++) {
					int bit = r.nextInt(ARR.length);
					sb.append(ARR[bit]);
				}
				String line = sb.toString();
				boolean valid = C1433_SimplySyntax.validate(line);
				if(valid && correct < 5) {
					correct++;
					ret.add(line + ":" + (valid ? "YES" : "NO"));
				} else if(!valid && incorrect < 5) {
					incorrect++;
					ret.add(line + ":" + (valid ? "YES" : "NO"));
				}
			}
		}
		for (String s : ret) {
			System.out.println(s);
		}
	}

}
