package michael.slf4j.learning;

public class T1025 {

	public static void main(String[] args) {
//		9
//		1 2
//		3 4
//		4 5
//		5 8
//		7 9
//		2  3
//		6 1
//		9 7
//		8 6
		
		int[] a = new int[] {1,3,5};
//		int[] a = new int[] {1,3,5,7,9,11,13,15};
		int length = a.length - 1;
		System.out.println("0:" + FindRoad.$.searchFirstLarge(a, 0, 0, length));
		System.out.println("2:" + FindRoad.$.searchFirstLarge(a, 2, 0, length));
		System.out.println("4:" + FindRoad.$.searchFirstLarge(a, 4, 0, length));
//		System.out.println("6:" + FindRoad.$.searchFirstLarge(a, 6, 0, length));
//		System.out.println("8:" + FindRoad.$.searchFirstLarge(a, 8, 0, length));
//		System.out.println("10:" + FindRoad.$.searchFirstLarge(a, 10, 0, length));
//		System.out.println("12:" + FindRoad.$.searchFirstLarge(a, 12, 0, length));
//		System.out.println("14:" + FindRoad.$.searchFirstLarge(a, 14, 0, length));
	}

}
