package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class C1413 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Node node = new Node("", FileType.d, null);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				String cmd = parts[0];
				String name = parts[1];
				
				if("CD".equals(cmd)){
					if("..".equals(name)){
						if(node.parent != null){
							node = node.parent;
						}
						System.out.println("success");
						continue;
					} else if("\\".equals(name)){
						node = node.getRoot();
						System.out.println("success");
						continue;
					}
					Node childDir = node.getChild(name, FileType.d);
					if(childDir == null){
						System.out.println("no such directory");
					} else {
						System.out.println("success");
						node = childDir;
					}
				} else if("MD".equals(cmd)) {
					Node childDir = node.getChild(name, FileType.d);
					if(childDir == null && !"\\".equals(name) && !"..".equals(name)){
						childDir = new Node(name, FileType.d, node);
						node.addChild(childDir);
						System.out.println("success");
					} else {
						System.out.println("directory already exist");
					}
				} else if("RD".equals(cmd)) {
					Node childDir = node.getChild(name, FileType.d);
					if(childDir == null || !childDir.isEmpty()){
						System.out.println("can not delete the directory");
					} else {
						System.out.println("success");
						node.remove(name, FileType.d);
					}
				} else if("CREATE".equals(cmd)){
					Node childDir = node.getChild(name, FileType.f);
					if(childDir == null){
						childDir = new Node(name, FileType.f, node);
						node.addChild(childDir);
						System.out.println("success");
					} else {
						System.out.println("file already exist");
					}
				} else if("DELETE".equals(cmd)){
					Node childDir = node.getChild(name, FileType.f);
					if(childDir == null){
						System.out.println("no such file");
					} else {
						node.remove(name, FileType.f);
						System.out.println("success");
					}
				}
			}
		}
	}
	
	public static class Node {
		private final String name;
		private final FileType type;
		private final Node parent;
		private String path;
		private List<Node> children;
		public Node(String name, FileType type, Node parent){
			this.name = name;
			this.type = type;
			this.parent = parent;
			if(this.type == FileType.d){
				children = new ArrayList<>();
			}
		}
		public String getName() {
			return name;
		}
		public String getPath() {
			StringBuffer sb = new StringBuffer();
			if(parent != null){
				sb.append(parent.getPath());
			}
			sb.append("\\").append(name);
			return sb.toString();
		}
		public FileType getType() {
			return type;
		}
		public Node getParent() {
			return parent;
		}
		public void addChild(Node child) {
			this.children.add(child);
		}
		public Node getChild(String name, FileType type){
			for (Node node : children) {
				if(node.getName().equals(name) && node.getType() == type){
					return node;
				}
			}
			return null;
		}
		public Node getRoot(){
			if(parent != null){
				return parent.getRoot();
			} else {
				return this;
			}
		}
		public boolean remove(String name, FileType type){
			Iterator<Node> it = children.iterator();
			while(it.hasNext()){
				Node node = it.next();
				if(node.getName().equals(name) && node.getType() == type){
					it.remove();
					return true;
				}
			}
			return false;
		}
		public boolean isEmpty(){
			return children.isEmpty();
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
