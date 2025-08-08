package michael.slf4j.learning.leetcode;

public class C331New {

	public static void main(String[] args) {
		C331New c = new C331New();
		String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(c.isValidSerialization(s));
	}
	
	public boolean isValidSerialization(String preorder) {
		int strLen = preorder.length();
		int nodeCount = 0;
		int index = 0;
		while(index < strLen) {
			char c = preorder.charAt(index);
			if(c == '#') {
				nodeCount--;
				if(nodeCount == -1) {
					if(index == strLen - 1) {
						return true;
					} else {
						return false;
					}
				}
				index++;
			} else {
				nodeCount++;
				while(index < strLen && preorder.charAt(index) != ',') {
					index++;
				}
			}
			index++;
		}
		return false;
	}

}
