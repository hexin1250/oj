package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1523_DecodingMorseSequences {
	private static final Map<String, Character> encodeMap = new HashMap<>();
	private static final Map<Character, String> decodeMap = new HashMap<>();
	
	static {
		encodeMap.put(".-", 'A');
		encodeMap.put("-...", 'B');
		encodeMap.put("-.-.", 'C');
		encodeMap.put("-..", 'D');
		encodeMap.put(".", 'E');
		encodeMap.put("..-.", 'F');
		encodeMap.put("--.", 'G');
		encodeMap.put("....", 'H');
		encodeMap.put("..", 'I');
		encodeMap.put(".---", 'J');
		encodeMap.put("-.-", 'K');
		encodeMap.put(".-..", 'L');
		encodeMap.put("--", 'M');
		encodeMap.put("-.", 'N');
		encodeMap.put("---", 'O');
		encodeMap.put(".--.", 'P');
		encodeMap.put("--.-", 'Q');
		encodeMap.put(".-.", 'R');
		encodeMap.put("...", 'S');
		encodeMap.put("-", 'T');
		encodeMap.put("..-", 'U');
		encodeMap.put("...-", 'V');
		encodeMap.put(".--", 'W');
		encodeMap.put("-..-", 'X');
		encodeMap.put("-.--", 'Y');
		encodeMap.put("--..", 'Z');
		for (Entry<String, Character> entry : encodeMap.entrySet()) {
			decodeMap.put(entry.getValue(), entry.getKey());
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int dataLength = sc.nextInt();
			List<String> encodingList = new ArrayList<>();
			for (int i = 0; i < dataLength; i++) {
				encodingList.add(sc.next());
			}
			int dictLength = sc.nextInt();
			String[] dictArr = new String[dictLength];
			for (int i = 0; i < dictLength; i++) {
				dictArr[i] = sc.next();
			}
			calculate(dictLength, dictArr, encodingList);
		}
	}
	
	public static void calculate(int dictLength, String[] dictArr, List<String> encodingList) {
		Map<Character, Node> map = generateDict(dictLength, dictArr);
		SearchDict sd = new SearchDict(map);
		for (String encode : encodingList) {
			List<StringBuffer> indexList = new ArrayList<>();
			indexList.add(new StringBuffer(""));
			int ret = sd.dfs(encode, map, 0, new ArrayList<>(), indexList);
			System.out.println(ret);
		}
	}

	private static Map<Character, Node> generateDict(int dictLength, String[] dictArr) {
		Map<Character, Node> map = new HashMap<>();
		for (int i = 0; i < dictLength; i++) {
			String dict = dictArr[i];
			int length = dict.length();
			Node node = null;
			for (int j = 0; j < length; j++) {
				boolean complete = false;
				if(j == length - 1) {
					complete = true;
				}
				char ch = dict.charAt(j);
				Node childNode = new Node(ch, complete);
				Map<Character, Node> childMap = null;
				if(j == 0) {
					childMap = map;
				} else {
					childMap = node.getChildMap();
				}
				if(!childMap.containsKey(ch)) {
					childMap.put(ch, childNode);
					node = childNode;
				} else {
					node = childMap.get(ch);
					node.setComplete(childNode.isComplete() || node.isComplete());
				}
			}
		}
		return map;
	}
	
	public static class SearchDict {
		private Map<Character, Node> initMap;
		
		public SearchDict(Map<Character, Node> map) {
			this.initMap = map;
		}
		
		private int dfs(String encode, Map<Character, Node> map, int index, List<Character> group, List<StringBuffer> indexList) {
			if(index == encode.length()) {
				if(indexList.size() == 0) {
					return 0;
				}
				StringBuffer last = indexList.get(indexList.size() - 1);
				String lastStr = last.toString();
				if(lastStr.length() != 0) {
					return 0;
				}
				System.out.println(indexList.stream().map(sb -> sb.toString()).collect(Collectors.joining(",")));
				return 1;
			}
			if(map.isEmpty()) {
				return 0;
			}
			int ret = 0;
			char currentCodeCh = encode.charAt(index);
			group.add(currentCodeCh);
			String currentPiece = group.stream().map(c -> c.toString()).collect(Collectors.joining());
			boolean find = false;
			for (Node node : map.values()) {
				char ch = node.getCh();
				String decode = decodeMap.get(ch);
				if(decode.startsWith(currentPiece)) {
					find = true;
					break;
				}
			}
			if(!find) {
				return 0;
			}
			if(group.size() <= 4) {
				char chDict = encodeMap.get(currentPiece);
				Node node = map.get(chDict);
				if(node != null) {
					List<StringBuffer> newIndexList = copyOf(indexList);
					newIndexList.get(newIndexList.size() - 1).append(node.getCh());
					if(node.isComplete()) {
						newIndexList.add(new StringBuffer(""));
						ret += dfs(encode, initMap, index + 1, new ArrayList<>(), newIndexList);
						newIndexList.remove(newIndexList.size() - 1);
					}
					ret += dfs(encode, node.getChildMap(), index + 1, new ArrayList<>(), newIndexList);
				}
				if(group.size() <= 3 && index < encode.length() - 1) {
					List<StringBuffer> newIndexList = copyOf(indexList);
					ret += dfs(encode, map, index + 1, group, newIndexList);
				}
			}
			return ret;
		}
		
		public List<StringBuffer> copyOf(List<StringBuffer> list){
			List<StringBuffer> ret = new ArrayList<>();
			for (StringBuffer sb : list) {
				StringBuffer newS = new StringBuffer(sb);
				ret.add(newS);
			}
			return ret;
		}
	}

	public static class Node {
		private char ch;
		private boolean complete;
		private Map<Character, Node> childMap = new HashMap<>();
		public Node(char ch, boolean complete) {
			this.ch = ch;
			this.complete = complete;
		}
		public char getCh() {
			return ch;
		}
		public Map<Character, Node> getChildMap() {
			return childMap;
		}
		public boolean isComplete() {
			return complete;
		}
		public void setComplete(boolean complete) {
			this.complete = complete;
		}
		public void addChild(Node childNode) {
			childMap.put(childNode.getCh(), childNode);
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(ch).append("(").append(complete).append(")->");
			sb.append(childMap);
			return sb.toString();
		}
	}

}
