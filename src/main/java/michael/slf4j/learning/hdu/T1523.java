package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T1523 {

	public static void main(String[] args) {
		int count = 1000;
		while (count-- > 0) {
			System.out.println("########################################");
			System.out.println(1);
			Random r = new Random();
			int length = r.nextInt(10) + 4;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				int chIndex = r.nextInt(2);
				sb.append(chIndex == 0 ? '.' : '-');
			}
			List<String> encodingList = new ArrayList<>();
			encodingList.add(sb.toString());
			System.out.println(sb);
			int dictLength = r.nextInt(40) + 1;
			System.out.println(dictLength);
			String[] dictArr = new String[dictLength];
			for (int i = 0; i < dictLength; i++) {
				int n = r.nextInt(3) + 2;
				StringBuffer strb = new StringBuffer();
				for (int j = 0; j < n; j++) {
					int chIndex = r.nextInt(10);
					strb.append((char) ('A' + chIndex));
				}
				dictArr[i] = strb.toString();
				System.out.println(dictArr[i]);
			}
			C1523_DecodingMorseSequences.calculate(dictLength, dictArr, encodingList);
		}
	}

}
