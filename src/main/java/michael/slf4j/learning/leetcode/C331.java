package michael.slf4j.learning.leetcode;

public class C331 {

	public static void main(String[] args) {
//		String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String s = "2,1,#,#,3,#,#";
		C331 c = new C331();
		System.out.println(c.isValidSerialization(s));
	}

	public boolean isValidSerialization(String preorder) {
		if("#".equals(preorder)) {
			return true;
		}
		String[] parts = preorder.split(",");
		if(parts.length < 3 || "#".equals(parts[0]) || !"#".equals(parts[parts.length - 1])) {
			return false;
		}
		int index = 0;
		int level = 0;
		int rightIndex = traversal(parts, index, level);;
		return rightIndex == parts.length - 1;
	}

	private int traversal(String[] parts, int index, int level) {
		if(index >= parts.length) {
			return parts.length + 10;
		}
		String val = parts[index];
		if("#".equals(val)) {
			return index;
		}
		int leftIndex = traversal(parts, index + 1, level + 1);
		if(leftIndex >= parts.length - 1) {
			return parts.length + 10;
		}
		int rightIndex = traversal(parts, leftIndex + 1, level + 1);
		return rightIndex;
	}

}
