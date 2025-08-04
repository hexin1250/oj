package michael.slf4j.learning.leetcode;

public class C2138 {
	public String[] divideString(String s, int k, char fill) {
		String[] ret = null;
        int len = s.length();
        int group = len / k;
        boolean complete = true;
        if(len % k != 0) {
        	complete = false;
        	ret = new String[group + 1];
        } else {
        	ret = new String[group];
        }
        for (int i = 0; i < group; i++) {
			ret[i] = s.substring(i * k, i * k + k);
		}
        if(!complete) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(s.substring(group * k));
        	for (int i = 0; i < k - len % k; i++) {
    			sb.append(fill);
    		}
        	ret[group] = sb.toString();
        }
        return ret;
    }
}
