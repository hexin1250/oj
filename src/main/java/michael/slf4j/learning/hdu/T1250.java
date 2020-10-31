package michael.slf4j.learning.hdu;

import java.util.Comparator;

public class T1250 {

	public static void main(String[] args) {
		int max = C1250_HatFibonacci.map.keySet().stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}).get();
		System.out.println(max);
		for (int i = 1; i <= max; i++) {
			String correct = C1250_HatFibonacci.map.get(i);
			String wrong = C1250_HatFibonacciBigDecimal.getResult(i).toString();
			if(!correct.equals(wrong)) {
				System.out.println(i);
				System.out.println(correct);
				System.out.println(wrong);
				break;
			}
		}
	}

}
