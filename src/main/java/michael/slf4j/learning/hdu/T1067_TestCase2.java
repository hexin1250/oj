package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class T1067_TestCase2 {

	public static void main(String[] args) {
		Map<BigDecimal, Integer> map = new HashMap<>();
		map.put(new BigDecimal("1"), 1);
		map.put(new BigDecimal("1000000000000000000000000000000000000"), 1);
		map.put(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000"), 1);
		
		System.out.println(map.get(new BigDecimal("1000000000000000000000000000000000000")));
	}

}
