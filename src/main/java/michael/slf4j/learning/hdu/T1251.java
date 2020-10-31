package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class T1251 {
	private static final Random DICT = new Random();
	private static final Random BIT = new Random();

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		int index = 0;
		while(index < 200) {
			int bit = BIT.nextInt(5) + 1;
			char[] ch = new char[bit];
			for (int j = 0; j < bit; j++) {
				ch[j] = (char) (DICT.nextInt(26) + 'a');
			}
			String s = new String(ch);
			if(set.contains(s)) {
				continue;
			}
			set.add(s);
			index++;
		}
		
		Set<String> words = new HashSet<>();
		for (int i = 0; i < 500000; i++) {
			int bit = BIT.nextInt(10) + 1;
			char[] ch = new char[bit];
			for (int j = 0; j < bit; j++) {
				ch[j] = (char) (DICT.nextInt(26) + 'a');
			}
			words.add(new String(ch));
		}
		List<String> searches = new ArrayList<>(set);
		List<String> sorts = new ArrayList<>(set);
		List<String> dicts = new ArrayList<>(words);
		Map<String, Integer> wrongMap = C1251.check(dicts, sorts);
		Map<String, Integer> correctMap = AC1251.check(dicts);
		boolean wrong = false;
		for (String s : searches) {
			int correctNum = AC1251.getNum(s, correctMap);
			int wrongNum = C1251.getNum(s, wrongMap);
			if(correctNum != wrongNum) {
				wrong = true;
				break;
			}
			System.out.println(s + ":" + correctNum + "," + wrongNum);
		}
		if(wrong) {
			System.out.println("???");
		}
	}
	
}