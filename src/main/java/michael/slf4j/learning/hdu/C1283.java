package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1283 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String memStr = sc.nextLine();
				String commands = sc.nextLine();
				String[] parts = memStr.split("[\\s]+");
				int[] mem = new int[] {Integer.valueOf(parts[0]), Integer.valueOf(parts[1])};
				char[] cmds = commands.toCharArray();
				int[] r = new int[3];
				for (int i = 0; i < cmds.length; i++) {
					if(cmds[i] == 'A') {
						r[0] = mem[0];
					} else if(cmds[i] == 'B') {
						r[1] = mem[1];
					} else if(cmds[i] == 'C') {
						mem[0] = r[2];
					} else if(cmds[i] == 'D') {
						mem[1] = r[2];
					} else if(cmds[i] == 'E') {
						r[2] = r[0] + r[1];
					} else if(cmds[i] == 'F') {
						r[2] = r[0] - r[1];
					}
				}
				System.out.println(mem[0] + "," + mem[1]);
			}
		}
	}

}
