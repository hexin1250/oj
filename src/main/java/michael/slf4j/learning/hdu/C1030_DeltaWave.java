package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1030_DeltaWave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int int1 = Math.min(n, m);
			int int2 = Math.max(n, m);
			int l1 = layer(int1);
			int l2 = layer(int2);
			if(l1 == l2) {
				System.out.println(int2 - int1);
			} else {
				boolean up1 = updown(int1, l1);
				boolean up2 = updown(int2, l2);
				int index1 = index(int1, l1, up1);
				int index2 = index(int2, l2, up2);
				int route = (l2 - l1) * 2;
				int offset = index2 - index1;
				if(up1 && !up2) {
					route++;
					if(offset > (l2 - l1 + 1) || offset < 0) {
						if(offset > (l2 - l1 + 1)) {
							offset = offset - (l2 - l1 + 1);
						}
						route += Math.abs(offset) * 2;
					}
				} else if(!up1 && up2) {
					route--;
					if(offset > (l2 - l1 - 1) || offset < 0) {
						if(offset > (l2 - l1 - 1)) {
							offset = offset - (l2 - l1 - 1);
						}
						route += Math.abs(offset) * 2;
					}
				} else {
					if(offset > (l2 - l1) || offset < 0) {
						if(offset > (l2 - l1)) {
							offset = offset - (l2 - l1);
						}
						route += Math.abs(offset) * 2;
					}
				}
				System.out.println(route);
			}
		}
		sc.close();
	}
	
	private static boolean updown(int n, int layer) {
		if((n % 2 + layer % 2) % 2 == 0) {
			return false;
		}
		return true;
	}

	private static int layer(int n) {
		int l = (int) Math.sqrt(n);
		if(l * l == n) {
			return l;
		} else {
			return l + 1;
		}
	}
	
	private static int index(int n, int layer, boolean isUp) {
		int minus = 1;
		if(isUp) {
			minus = 2;
		}
		return (n - (layer - 1) * (layer - 1) - minus) / 2;
	}

}
