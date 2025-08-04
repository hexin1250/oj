package michael.slf4j.learning.leetcode;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class C212 {

	public static void main(String[] args) {
		C212 c = new C212();
//		char[][] board = new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//		String[] words = new String[] {"oath","pea","eat","rain"};
//		char[][] board = new char[][] {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
//		String[] words = new String[] {"oa","oaa"};
//		char[][] board = new char[][] {{'a','a'}};
//		String[] words = new String[] {"aaa"};
//		char[][] board = new char[][] {{'a','b'}, {'a', 'a'}};
//		String[] words = new String[] {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		char[][] board = new char[][] {
				{ 'm', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' },
				{ 'n', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'o', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'p', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'q', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'r', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 's', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 't', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'u', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'v', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'w', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'x', 'y', 'z', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' } };
		String[] words = new String[] { "aaaaaaaaaa", "baaaaaaaaa", "caaaaaaaaa", "daaaaaaaaa", "eaaaaaaaaa",
				"faaaaaaaaa", "gaaaaaaaaa", "haaaaaaaaa", "iaaaaaaaaa", "jaaaaaaaaa", "kaaaaaaaaa", "laaaaaaaaa",
				"maaaaaaaaa", "naaaaaaaaa", "oaaaaaaaaa", "paaaaaaaaa", "qaaaaaaaaa", "raaaaaaaaa", "saaaaaaaaa",
				"taaaaaaaaa", "uaaaaaaaaa", "vaaaaaaaaa", "waaaaaaaaa", "xaaaaaaaaa", "yaaaaaaaaa", "zaaaaaaaaa",
				"abaaaaaaaa", "bbaaaaaaaa", "cbaaaaaaaa", "dbaaaaaaaa", "ebaaaaaaaa", "fbaaaaaaaa", "gbaaaaaaaa",
				"hbaaaaaaaa", "ibaaaaaaaa", "jbaaaaaaaa", "kbaaaaaaaa", "lbaaaaaaaa", "mbaaaaaaaa", "nbaaaaaaaa",
				"obaaaaaaaa", "pbaaaaaaaa", "qbaaaaaaaa", "rbaaaaaaaa", "sbaaaaaaaa", "tbaaaaaaaa", "ubaaaaaaaa",
				"vbaaaaaaaa", "wbaaaaaaaa", "xbaaaaaaaa", "ybaaaaaaaa", "zbaaaaaaaa", "acaaaaaaaa", "bcaaaaaaaa",
				"ccaaaaaaaa", "dcaaaaaaaa", "ecaaaaaaaa", "fcaaaaaaaa", "gcaaaaaaaa", "hcaaaaaaaa", "icaaaaaaaa",
				"jcaaaaaaaa", "kcaaaaaaaa", "lcaaaaaaaa", "mcaaaaaaaa", "ncaaaaaaaa", "ocaaaaaaaa", "pcaaaaaaaa",
				"qcaaaaaaaa", "rcaaaaaaaa", "scaaaaaaaa", "tcaaaaaaaa", "ucaaaaaaaa", "vcaaaaaaaa", "wcaaaaaaaa",
				"xcaaaaaaaa", "ycaaaaaaaa", "zcaaaaaaaa", "adaaaaaaaa", "bdaaaaaaaa", "cdaaaaaaaa", "ddaaaaaaaa",
				"edaaaaaaaa", "fdaaaaaaaa", "gdaaaaaaaa", "hdaaaaaaaa", "idaaaaaaaa", "jdaaaaaaaa", "kdaaaaaaaa",
				"ldaaaaaaaa", "mdaaaaaaaa", "ndaaaaaaaa", "odaaaaaaaa", "pdaaaaaaaa", "qdaaaaaaaa", "rdaaaaaaaa",
				"sdaaaaaaaa", "tdaaaaaaaa", "udaaaaaaaa", "vdaaaaaaaa", "wdaaaaaaaa", "xdaaaaaaaa", "ydaaaaaaaa",
				"zdaaaaaaaa", "aeaaaaaaaa", "beaaaaaaaa", "ceaaaaaaaa", "deaaaaaaaa", "eeaaaaaaaa", "feaaaaaaaa",
				"geaaaaaaaa", "heaaaaaaaa", "ieaaaaaaaa", "jeaaaaaaaa", "keaaaaaaaa", "leaaaaaaaa", "meaaaaaaaa",
				"neaaaaaaaa", "oeaaaaaaaa", "peaaaaaaaa", "qeaaaaaaaa", "reaaaaaaaa", "seaaaaaaaa", "teaaaaaaaa",
				"ueaaaaaaaa", "veaaaaaaaa", "weaaaaaaaa", "xeaaaaaaaa", "yeaaaaaaaa", "zeaaaaaaaa", "afaaaaaaaa",
				"bfaaaaaaaa", "cfaaaaaaaa", "dfaaaaaaaa", "efaaaaaaaa", "ffaaaaaaaa", "gfaaaaaaaa", "hfaaaaaaaa",
				"ifaaaaaaaa", "jfaaaaaaaa", "kfaaaaaaaa", "lfaaaaaaaa", "mfaaaaaaaa", "nfaaaaaaaa", "ofaaaaaaaa",
				"pfaaaaaaaa", "qfaaaaaaaa", "rfaaaaaaaa", "sfaaaaaaaa", "tfaaaaaaaa", "ufaaaaaaaa", "vfaaaaaaaa",
				"wfaaaaaaaa", "xfaaaaaaaa", "yfaaaaaaaa", "zfaaaaaaaa", "agaaaaaaaa", "bgaaaaaaaa", "cgaaaaaaaa",
				"dgaaaaaaaa", "egaaaaaaaa", "fgaaaaaaaa", "ggaaaaaaaa", "hgaaaaaaaa", "igaaaaaaaa", "jgaaaaaaaa",
				"kgaaaaaaaa", "lgaaaaaaaa", "mgaaaaaaaa", "ngaaaaaaaa", "ogaaaaaaaa", "pgaaaaaaaa", "qgaaaaaaaa",
				"rgaaaaaaaa", "sgaaaaaaaa", "tgaaaaaaaa", "ugaaaaaaaa", "vgaaaaaaaa", "wgaaaaaaaa", "xgaaaaaaaa",
				"ygaaaaaaaa", "zgaaaaaaaa", "ahaaaaaaaa", "bhaaaaaaaa", "chaaaaaaaa", "dhaaaaaaaa", "ehaaaaaaaa",
				"fhaaaaaaaa", "ghaaaaaaaa", "hhaaaaaaaa", "ihaaaaaaaa", "jhaaaaaaaa", "khaaaaaaaa", "lhaaaaaaaa",
				"mhaaaaaaaa", "nhaaaaaaaa", "ohaaaaaaaa", "phaaaaaaaa", "qhaaaaaaaa", "rhaaaaaaaa", "shaaaaaaaa",
				"thaaaaaaaa", "uhaaaaaaaa", "vhaaaaaaaa", "whaaaaaaaa", "xhaaaaaaaa", "yhaaaaaaaa", "zhaaaaaaaa",
				"aiaaaaaaaa", "biaaaaaaaa", "ciaaaaaaaa", "diaaaaaaaa", "eiaaaaaaaa", "fiaaaaaaaa", "giaaaaaaaa",
				"hiaaaaaaaa", "iiaaaaaaaa", "jiaaaaaaaa", "kiaaaaaaaa", "liaaaaaaaa", "miaaaaaaaa", "niaaaaaaaa",
				"oiaaaaaaaa", "piaaaaaaaa", "qiaaaaaaaa", "riaaaaaaaa", "siaaaaaaaa", "tiaaaaaaaa", "uiaaaaaaaa",
				"viaaaaaaaa", "wiaaaaaaaa", "xiaaaaaaaa", "yiaaaaaaaa", "ziaaaaaaaa", "ajaaaaaaaa", "bjaaaaaaaa",
				"cjaaaaaaaa", "djaaaaaaaa", "ejaaaaaaaa", "fjaaaaaaaa", "gjaaaaaaaa", "hjaaaaaaaa", "ijaaaaaaaa",
				"jjaaaaaaaa", "kjaaaaaaaa", "ljaaaaaaaa", "mjaaaaaaaa", "njaaaaaaaa", "ojaaaaaaaa", "pjaaaaaaaa",
				"qjaaaaaaaa", "rjaaaaaaaa", "sjaaaaaaaa", "tjaaaaaaaa", "ujaaaaaaaa", "vjaaaaaaaa", "wjaaaaaaaa",
				"xjaaaaaaaa", "yjaaaaaaaa", "zjaaaaaaaa", "akaaaaaaaa", "bkaaaaaaaa", "ckaaaaaaaa", "dkaaaaaaaa",
				"ekaaaaaaaa", "fkaaaaaaaa", "gkaaaaaaaa", "hkaaaaaaaa", "ikaaaaaaaa", "jkaaaaaaaa", "kkaaaaaaaa",
				"lkaaaaaaaa", "mkaaaaaaaa", "nkaaaaaaaa", "okaaaaaaaa", "pkaaaaaaaa", "qkaaaaaaaa", "rkaaaaaaaa",
				"skaaaaaaaa", "tkaaaaaaaa", "ukaaaaaaaa", "vkaaaaaaaa", "wkaaaaaaaa", "xkaaaaaaaa", "ykaaaaaaaa",
				"zkaaaaaaaa", "alaaaaaaaa", "blaaaaaaaa", "claaaaaaaa", "dlaaaaaaaa", "elaaaaaaaa", "flaaaaaaaa",
				"glaaaaaaaa", "hlaaaaaaaa", "ilaaaaaaaa", "jlaaaaaaaa", "klaaaaaaaa", "llaaaaaaaa", "mlaaaaaaaa",
				"nlaaaaaaaa", "olaaaaaaaa", "plaaaaaaaa", "qlaaaaaaaa", "rlaaaaaaaa", "slaaaaaaaa", "tlaaaaaaaa",
				"ulaaaaaaaa", "vlaaaaaaaa", "wlaaaaaaaa", "xlaaaaaaaa", "ylaaaaaaaa", "zlaaaaaaaa", "amaaaaaaaa",
				"bmaaaaaaaa", "cmaaaaaaaa", "dmaaaaaaaa", "emaaaaaaaa", "fmaaaaaaaa", "gmaaaaaaaa", "hmaaaaaaaa",
				"imaaaaaaaa", "jmaaaaaaaa", "kmaaaaaaaa", "lmaaaaaaaa", "mmaaaaaaaa", "nmaaaaaaaa", "omaaaaaaaa",
				"pmaaaaaaaa", "qmaaaaaaaa", "rmaaaaaaaa", "smaaaaaaaa", "tmaaaaaaaa", "umaaaaaaaa", "vmaaaaaaaa",
				"wmaaaaaaaa", "xmaaaaaaaa", "ymaaaaaaaa", "zmaaaaaaaa", "anaaaaaaaa", "bnaaaaaaaa", "cnaaaaaaaa",
				"dnaaaaaaaa", "enaaaaaaaa", "fnaaaaaaaa", "gnaaaaaaaa", "hnaaaaaaaa", "inaaaaaaaa", "jnaaaaaaaa",
				"knaaaaaaaa", "lnaaaaaaaa", "mnaaaaaaaa", "nnaaaaaaaa", "onaaaaaaaa", "pnaaaaaaaa", "qnaaaaaaaa",
				"rnaaaaaaaa", "snaaaaaaaa", "tnaaaaaaaa", "unaaaaaaaa", "vnaaaaaaaa", "wnaaaaaaaa", "xnaaaaaaaa",
				"ynaaaaaaaa", "znaaaaaaaa", "aoaaaaaaaa", "boaaaaaaaa", "coaaaaaaaa", "doaaaaaaaa", "eoaaaaaaaa",
				"foaaaaaaaa", "goaaaaaaaa", "hoaaaaaaaa", "ioaaaaaaaa", "joaaaaaaaa", "koaaaaaaaa", "loaaaaaaaa",
				"moaaaaaaaa", "noaaaaaaaa", "ooaaaaaaaa", "poaaaaaaaa", "qoaaaaaaaa", "roaaaaaaaa", "soaaaaaaaa",
				"toaaaaaaaa", "uoaaaaaaaa", "voaaaaaaaa", "woaaaaaaaa", "xoaaaaaaaa", "yoaaaaaaaa", "zoaaaaaaaa",
				"apaaaaaaaa", "bpaaaaaaaa", "cpaaaaaaaa", "dpaaaaaaaa", "epaaaaaaaa", "fpaaaaaaaa", "gpaaaaaaaa",
				"hpaaaaaaaa", "ipaaaaaaaa", "jpaaaaaaaa", "kpaaaaaaaa", "lpaaaaaaaa", "mpaaaaaaaa", "npaaaaaaaa",
				"opaaaaaaaa", "ppaaaaaaaa", "qpaaaaaaaa", "rpaaaaaaaa", "spaaaaaaaa", "tpaaaaaaaa", "upaaaaaaaa",
				"vpaaaaaaaa", "wpaaaaaaaa", "xpaaaaaaaa", "ypaaaaaaaa", "zpaaaaaaaa", "aqaaaaaaaa", "bqaaaaaaaa",
				"cqaaaaaaaa", "dqaaaaaaaa", "eqaaaaaaaa", "fqaaaaaaaa", "gqaaaaaaaa", "hqaaaaaaaa", "iqaaaaaaaa",
				"jqaaaaaaaa", "kqaaaaaaaa", "lqaaaaaaaa", "mqaaaaaaaa", "nqaaaaaaaa", "oqaaaaaaaa", "pqaaaaaaaa",
				"qqaaaaaaaa", "rqaaaaaaaa", "sqaaaaaaaa", "tqaaaaaaaa", "uqaaaaaaaa", "vqaaaaaaaa", "wqaaaaaaaa",
				"xqaaaaaaaa", "yqaaaaaaaa", "zqaaaaaaaa", "araaaaaaaa", "braaaaaaaa", "craaaaaaaa", "draaaaaaaa",
				"eraaaaaaaa", "fraaaaaaaa", "graaaaaaaa", "hraaaaaaaa", "iraaaaaaaa", "jraaaaaaaa", "kraaaaaaaa",
				"lraaaaaaaa", "mraaaaaaaa", "nraaaaaaaa", "oraaaaaaaa", "praaaaaaaa", "qraaaaaaaa", "rraaaaaaaa",
				"sraaaaaaaa", "traaaaaaaa", "uraaaaaaaa", "vraaaaaaaa", "wraaaaaaaa", "xraaaaaaaa", "yraaaaaaaa",
				"zraaaaaaaa", "asaaaaaaaa", "bsaaaaaaaa", "csaaaaaaaa", "dsaaaaaaaa", "esaaaaaaaa", "fsaaaaaaaa",
				"gsaaaaaaaa", "hsaaaaaaaa", "isaaaaaaaa", "jsaaaaaaaa", "ksaaaaaaaa", "lsaaaaaaaa", "msaaaaaaaa",
				"nsaaaaaaaa", "osaaaaaaaa", "psaaaaaaaa", "qsaaaaaaaa", "rsaaaaaaaa", "ssaaaaaaaa", "tsaaaaaaaa",
				"usaaaaaaaa", "vsaaaaaaaa", "wsaaaaaaaa", "xsaaaaaaaa", "ysaaaaaaaa", "zsaaaaaaaa", "ataaaaaaaa",
				"btaaaaaaaa", "ctaaaaaaaa", "dtaaaaaaaa", "etaaaaaaaa", "ftaaaaaaaa", "gtaaaaaaaa", "htaaaaaaaa",
				"itaaaaaaaa", "jtaaaaaaaa", "ktaaaaaaaa", "ltaaaaaaaa", "mtaaaaaaaa", "ntaaaaaaaa", "otaaaaaaaa",
				"ptaaaaaaaa", "qtaaaaaaaa", "rtaaaaaaaa", "staaaaaaaa", "ttaaaaaaaa", "utaaaaaaaa", "vtaaaaaaaa",
				"wtaaaaaaaa", "xtaaaaaaaa", "ytaaaaaaaa", "ztaaaaaaaa", "auaaaaaaaa", "buaaaaaaaa", "cuaaaaaaaa",
				"duaaaaaaaa", "euaaaaaaaa", "fuaaaaaaaa", "guaaaaaaaa", "huaaaaaaaa", "iuaaaaaaaa", "juaaaaaaaa",
				"kuaaaaaaaa", "luaaaaaaaa", "muaaaaaaaa", "nuaaaaaaaa", "ouaaaaaaaa", "puaaaaaaaa", "quaaaaaaaa",
				"ruaaaaaaaa", "suaaaaaaaa", "tuaaaaaaaa", "uuaaaaaaaa", "vuaaaaaaaa", "wuaaaaaaaa", "xuaaaaaaaa",
				"yuaaaaaaaa", "zuaaaaaaaa", "avaaaaaaaa", "bvaaaaaaaa", "cvaaaaaaaa", "dvaaaaaaaa", "evaaaaaaaa",
				"fvaaaaaaaa", "gvaaaaaaaa", "hvaaaaaaaa", "ivaaaaaaaa", "jvaaaaaaaa", "kvaaaaaaaa", "lvaaaaaaaa",
				"mvaaaaaaaa", "nvaaaaaaaa", "ovaaaaaaaa", "pvaaaaaaaa", "qvaaaaaaaa", "rvaaaaaaaa", "svaaaaaaaa",
				"tvaaaaaaaa", "uvaaaaaaaa", "vvaaaaaaaa", "wvaaaaaaaa", "xvaaaaaaaa", "yvaaaaaaaa", "zvaaaaaaaa",
				"awaaaaaaaa", "bwaaaaaaaa", "cwaaaaaaaa", "dwaaaaaaaa", "ewaaaaaaaa", "fwaaaaaaaa", "gwaaaaaaaa",
				"hwaaaaaaaa", "iwaaaaaaaa", "jwaaaaaaaa", "kwaaaaaaaa", "lwaaaaaaaa", "mwaaaaaaaa", "nwaaaaaaaa",
				"owaaaaaaaa", "pwaaaaaaaa", "qwaaaaaaaa", "rwaaaaaaaa", "swaaaaaaaa", "twaaaaaaaa", "uwaaaaaaaa",
				"vwaaaaaaaa", "wwaaaaaaaa", "xwaaaaaaaa", "ywaaaaaaaa", "zwaaaaaaaa", "axaaaaaaaa", "bxaaaaaaaa",
				"cxaaaaaaaa", "dxaaaaaaaa", "exaaaaaaaa", "fxaaaaaaaa", "gxaaaaaaaa", "hxaaaaaaaa", "ixaaaaaaaa",
				"jxaaaaaaaa", "kxaaaaaaaa", "lxaaaaaaaa", "mxaaaaaaaa", "nxaaaaaaaa", "oxaaaaaaaa", "pxaaaaaaaa",
				"qxaaaaaaaa", "rxaaaaaaaa", "sxaaaaaaaa", "txaaaaaaaa", "uxaaaaaaaa", "vxaaaaaaaa", "wxaaaaaaaa",
				"xxaaaaaaaa", "yxaaaaaaaa", "zxaaaaaaaa", "ayaaaaaaaa", "byaaaaaaaa", "cyaaaaaaaa", "dyaaaaaaaa",
				"eyaaaaaaaa", "fyaaaaaaaa", "gyaaaaaaaa", "hyaaaaaaaa", "iyaaaaaaaa", "jyaaaaaaaa", "kyaaaaaaaa",
				"lyaaaaaaaa", "myaaaaaaaa", "nyaaaaaaaa", "oyaaaaaaaa", "pyaaaaaaaa", "qyaaaaaaaa", "ryaaaaaaaa",
				"syaaaaaaaa", "tyaaaaaaaa", "uyaaaaaaaa", "vyaaaaaaaa", "wyaaaaaaaa", "xyaaaaaaaa", "yyaaaaaaaa",
				"zyaaaaaaaa", "azaaaaaaaa", "bzaaaaaaaa", "czaaaaaaaa", "dzaaaaaaaa", "ezaaaaaaaa", "fzaaaaaaaa",
				"gzaaaaaaaa", "hzaaaaaaaa", "izaaaaaaaa", "jzaaaaaaaa", "kzaaaaaaaa", "lzaaaaaaaa", "mzaaaaaaaa",
				"nzaaaaaaaa", "ozaaaaaaaa", "pzaaaaaaaa", "qzaaaaaaaa", "rzaaaaaaaa", "szaaaaaaaa", "tzaaaaaaaa",
				"uzaaaaaaaa", "vzaaaaaaaa", "wzaaaaaaaa", "xzaaaaaaaa", "yzaaaaaaaa", "zzaaaaaaaa" };
		List<String> ret = c.findWords(board, words);
		ret.forEach(s -> System.out.println(s));
	}

	public List<String> findWords(char[][] board, String[] words) {
		MyNode root = new MyNode('1');
		Map<Character, MyNode> dict = new HashMap<>();
		root.setChild(dict);
		for (String word : words) {
			MyNode prevNode = root;
			int len = word.length();
			for (int i = 0; i < len; i++) {
				char c = word.charAt(i);
				MyNode node = prevNode.findOrCreateChild(c);
				if (i == len - 1) {
					node.setLeaf(true);
				}
				prevNode = node;
			}
		}
//		print(dict, new StringBuffer());
		int m = board.length;
		int n = board[0].length;
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			char[] line = board[i];
			for (int j = 0; j < line.length; j++) {
				if (root.getChild().isEmpty()) {
					break;
				}
				char c = line[j];
				if (!dict.containsKey(c)) {
					continue;
				}
				StringBuffer sb = new StringBuffer();
				Set<Point> mem = new HashSet<>();
				mem.add(new Point(i, j));
				set.addAll(checkPath(board, m, n, i, j, dict, mem, sb));
			}
			if (root.getChild().isEmpty()) {
				break;
			}
		}
		return set.stream().collect(Collectors.toList());
	}

	private Set<String> checkPath(char[][] board, int m, int n, int x, int y, Map<Character, MyNode> dict,
			Set<Point> mem, StringBuffer sb) {
		char c = board[x][y];
		MyNode node = dict.get(c);
		if (node == null) {
			return new HashSet<String>();
		}
		Set<String> ret = new HashSet<>();
		StringBuffer newSb = new StringBuffer(sb);
		newSb.append(c);
		if (node.isLeaf()) {
			ret.add(newSb.toString());
			if (node.getChild() == null) {
				MyNode my = node;
				while (my.c != '1') {
					char currentC = my.c;
					MyNode parent = my.parent;
					parent.removeNode(currentC);
					if (parent.isLeaf()) {
						break;
					}
					if (!parent.getChild().isEmpty()) {
						break;
					}
					my = parent;
				}
				return ret;
			} else {
				node.setLeaf(false);
			}
		}
		int[][] arrs = new int[][] { { x - 1, y }, { x + 1, y }, { x, y - 1 }, { x, y + 1 } };
		for (int[] arr : arrs) {
			int newX = arr[0];
			int newY = arr[1];
			if (newX >= 0 && newX < m && newY >= 0 && newY < n && node.getChild() != null) {
				Point p = new Point(newX, newY);
				if (mem.contains(p)) {
					continue;
				}
				Set<Point> newMem = new HashSet<>(mem);
				newMem.add(p);
				ret.addAll(checkPath(board, m, n, newX, newY, node.getChild(), newMem, newSb));
			}
		}
		return ret;
	}

	private void print(Map<Character, MyNode> dict, StringBuffer sb) {
		for (Entry<Character, MyNode> entry : dict.entrySet()) {
			System.out.println(sb.toString() + entry.getKey() + ":" + entry.getValue().isLeaf());
			StringBuffer nextSb = new StringBuffer(sb);
			nextSb.append('\t');
			Map<Character, MyNode> nextDict = entry.getValue().getChild();
			if (nextDict != null) {
				print(nextDict, nextSb);
			}
		}
	}

	private static class MyNode {
		char c;
		boolean leaf = false;
		Map<Character, MyNode> child;
		MyNode parent;

		public MyNode(char c) {
			this.c = c;
		}

		public void setLeaf(boolean leaf) {
			this.leaf = leaf;
		}

		public Map<Character, MyNode> getChild() {
			return child;
		}

		public void setChild(Map<Character, MyNode> child) {
			this.child = child;
		}

		public boolean isLeaf() {
			return leaf;
		}

		public MyNode getParent() {
			return parent;
		}

		public MyNode findOrCreateChild(char c) {
			if (child == null) {
				child = new HashMap<>();
			}
			MyNode ret = child.get(c);
			if (ret == null) {
				ret = new MyNode(c);
				child.put(c, ret);
			}
			ret.setParent(this);
			return ret;
		}

		public void removeNode(char c) {
			child.remove(c);
		}

		public void setParent(MyNode parent) {
			this.parent = parent;
		}
	}

}
