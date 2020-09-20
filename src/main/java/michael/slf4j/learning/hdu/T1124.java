package michael.slf4j.learning.hdu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class T1124 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		for (long i = 1000000000; i >= 500000; i-=500000) {
			sb.append("else if(n >= ").append(i).append("){\ncount = ").append(C1124_Factorial.count(i)).append(';');
			sb.append("start = ").append(i).append(";\n}");
		}
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/test.txt"))))){
			bw.write(sb.toString());
		}
	}

}
