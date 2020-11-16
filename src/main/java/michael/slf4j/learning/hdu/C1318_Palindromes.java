package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C1318_Palindromes {
	private static Map<Character, Character> mirrorMap = new HashMap<>();
	private static Set<Character> sameSet = new HashSet<>();
	
	static {
		sameSet.add('A');
		sameSet.add('H');
		sameSet.add('I');
		sameSet.add('M');
		sameSet.add('O');
		sameSet.add('T');
		sameSet.add('U');
		sameSet.add('V');
		sameSet.add('W');
		sameSet.add('X');
		sameSet.add('Y');
		sameSet.add('1');
		sameSet.add('8');
		
		mirrorMap.put('E', '3');
		mirrorMap.put('J', 'L');
		mirrorMap.put('L', 'J');
		mirrorMap.put('S', '2');
		mirrorMap.put('Z', '5');
		mirrorMap.put('2', 'S');
		mirrorMap.put('3', 'E');
		mirrorMap.put('5', 'Z');
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String line = sc.nextLine();
				char[] ch = line.replaceAll("0", "O").toCharArray();
				int len = ch.length;
				int middle = len / 2;
				if(len % 2 == 1) {
					middle++;
				}
				/**
				 * 0 -> is not a palindrome
				 * 1 -> is a regular palindrome
				 * 2 -> is a mirrored string
				 * 3 -> is a mirrored palindrome
				 */
				int status = 0;
				for (int i = 0; i < middle; i++) {
					char c = ch[i];
					if(ch[i] != ch[len - 1 - i]) {
						Character targetC = mirrorMap.get(c);
						if(targetC == null || targetC != ch[len - 1 - i]) {
							status = 0;
							break;
						} else {
							status = 2;
						}
					} else {
						if(sameSet.contains(c) && (status == 3 || status == 0)) {
							status = 3;
						} else if(status == 3 || status == 1 || status == 0) {
							status = 1;
						}
					}
				}
				String ret = null;
				switch(status) {
				case 0:
					ret = "is not a palindrome.";
					break;
				case 1:
					ret = "is a regular palindrome.";
					break;
				case 2:
					ret = "is a mirrored string.";
					break;
				case 3:
					ret = "is a mirrored palindrome.";
					break;
				}
				System.out.println(line + " -- " + ret);
				System.out.println();
			}
		}
	}

}
