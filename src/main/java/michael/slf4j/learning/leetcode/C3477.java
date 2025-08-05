package michael.slf4j.learning.leetcode;

public class C3477 {

	public static void main(String[] args) {
		C3477 c = new C3477();
		int[] fruits = new int[] {4,2,5};
		int[] baskets = new int[] {3,5,4};
		System.out.println(c.numOfUnplacedFruits(fruits, baskets));
	}

	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int rest = 0;
		for (int i = 0; i < fruits.length; i++) {
			int fruit = fruits[i];
			boolean find = false;
			for (int j = 0; j < baskets.length; j++) {
				if(fruit <= baskets[j]) {
					find = true;
					baskets[j] = -1;
					break;
				}
			}
			if(!find) {
				rest++;
			}
		}
		return rest;
	}

}
