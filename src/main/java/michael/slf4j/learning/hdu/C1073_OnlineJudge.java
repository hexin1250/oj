package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1073_OnlineJudge {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int testcase = sc.nextInt();
			
			while(testcase-- > 0) {
				StringBuffer sb1 = new StringBuffer();
				while(sc.hasNext()) {
					String line = sc.nextLine();
					if("START".equals(line)) {
						continue;
					} else if("END".equals(line)) {
						break;
					} else {
						sb1.append(line).append('\n');
					}
				}
				StringBuffer sb2 = new StringBuffer();
				while(sc.hasNext()) {
					String line = sc.nextLine();
					if("START".equals(line)) {
						continue;
					} else if("END".equals(line)) {
						break;
					} else {
						sb2.append(line).append('\n');
					}
				}
				String output1 = sb1.toString();
				String output2 = sb2.toString();
				boolean answer = output1.equals(output2);
				String empty1 = output1.replaceAll("[\\s]+", "");
				String empty2 = output2.replaceAll("[\\s]+", "");
				boolean answer2 = empty1.equals(empty2);
				if(!answer2) {
					System.out.println("Wrong Answer");
				} else if(!answer) {
					System.out.println("Presentation Error");
				} else {
					System.out.println("Accepted");
				}
			}
		}
	}

}
