package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class C1314_NumericallySpeaking {
	private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String line = sc.nextLine();
				if("*".equals(line)) {
					break;
				}
				Matcher m = NUMBER_PATTERN.matcher(line);
				String word = null;
				int[] number = null;
				char[] ch = line.toCharArray();
				if(m.matches()) {
					number = new int[ch.length];
					List<Character> list = new ArrayList<>();
					for (int i = 0; i < ch.length; i++) {
						number[i] = ch[i] - '0';
					}
					BigDecimal num = new BigDecimal(line);
					BigDecimal base = new BigDecimal(26);
					BigDecimal zero = new BigDecimal(0);
					while(num.compareTo(zero) > 0) {
						BigDecimal[] result = num.divideAndRemainder(base);
						int mod = result[1].intValue();
						char c = (char) (mod - 1 + 'a');
						if(mod == 0) {
							c = 'z';
						}
						list.add(c);
						num = result[0];
					}
					Collections.reverse(list);
					word = list.stream().map(c -> c.toString()).collect(Collectors.joining());
				} else {
					word = line;
					BigDecimal b = new BigDecimal(0);
					BigDecimal fix = new BigDecimal(26);
					for (int i = 0; i < ch.length; i++) {
						int num = ch[i] - 'a' + 1;
						b = b.multiply(fix).add(new BigDecimal(num));
					}
					String ret = b.toString();
					number = new int[ret.length()];
					for (int i = 0; i < ret.length(); i++) {
						number[i] = ret.charAt(i) - '0';
					}
				}
				StringBuffer sb = new StringBuffer();
				sb.append(word);
				for (int i = 1; i <= 22 - word.length(); i++) {
					sb.append(' ');
				}
				int index = number.length % 3;
				for (int i = 1; i <= number.length; i++) {
					if(i != 1 && (i - 1) % 3 == index) {
						sb.append(',');
					}
					sb.append(number[i - 1]);
				}
				System.out.println(sb);
			}
		}
	}

}
