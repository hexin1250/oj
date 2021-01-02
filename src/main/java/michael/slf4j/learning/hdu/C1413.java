package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Set;

public class C1413 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String line = sc.nextLine();
			}
		}
	}
	
	public static class Node {
		private String name;
		private String path;
		private FileType type;
		private Node parent;
		private Set<Node> children;
		public String getName() {
			return name;
		}
		public String getPath() {
			return path;
		}
		public FileType getType() {
			return type;
		}
		public Node getParent() {
			return parent;
		}
		public Set<Node> getChildren() {
			return children;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Node)){
				return false;
			}
			Node target = (Node) obj;
			return name.equals(target.name) && path.equals(target.path) && type == target.type;
		}
		@Override
		public int hashCode() {
			StringBuffer sb = new StringBuffer();
			sb.append(path).append('\\').append(name);
			int code = 0;
			if(type == FileType.d){
				code = 1;
			}
			return sb.hashCode() * 10 + code;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Type[").append(type).append("], Path:").append(path).append(", Name:").append(name);
			return sb.toString();
		}
	}
	
	public static enum FileType {
		f,
		d;
	}

}
