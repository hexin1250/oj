package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class C2040 {

	public static void main(String[] args) {
		C2040 c = new C2040();
		int[] a = new int[] {-500,-499,-498,-496,-493,-487,-484,-482,-482,-480,-478,-477,-475,-467,-462,-460,-460,-460,-459,-454,-453,-453,-449,-445,-443,-441,-440,-439,-438,-434,-432,-431,-431,-428,-426,-424,-423,-421,-421,-416,-414,-414,-412,-411,-410,-408,-408,-405,-404,-403,-402,-402,-394,-394,-393,-391,-387,-386,-384,-384,-377,-377,-374,-374,-370,-369,-367,-366,-364,-361,-360,-358,-356,-356,-353,-352,-349,-343,-341,-339,-338,-338,-332,-332,-330,-330,-321,-320,-319,-318,-317,-314,-313,-312,-312,-303,-300,-300,-299,-299,-298,-292,-291,-290,-289,-288,-287,-286,-283,-282,-281,-281,-280,-278,-276,-276,-275,-274,-271,-270,-270,-270,-270,-268,-265,-259,-259,-254,-254,-252,-251,-251,-247,-246,-246,-245,-245,-242,-242,-240,-238,-235,-234,-234,-233,-231,-227,-225,-224,-220,-219,-217,-216,-216,-215,-215,-214,-214,-213,-212,-210,-210,-208,-206,-206,-201,-199,-197,-196,-195,-193,-193,-191,-189,-188,-186,-183,-180,-180,-178,-173,-173,-172,-169,-166,-163,-161,-159,-158,-152,-152,-151,-151,-151,-150,-150,-149,-146,-145,-143,-140,-137,-137,-127,-122,-122,-119,-117,-117,-115,-110,-108,-108,-108,-104,-102,-100,-99,-95,-92,-92,-87,-84,-78,-72,-72,-71,-70,-68,-67,-67,-64,-64,-61,-61,-60,-60,-57,-57,-56,-55,-50,-48,-47,-42,-42,-41,-41,-40,-36,-34,-34,-29,-28,-28,-26,-26,-26,-21,-21,-20,-20,-15,-13,-12,-11,-8,-7,-7,-6,-6,-5,-4,0,1,2,2,3,5,6,6,6,8,12,14,19,19,22,24,26,27,29,31,33,35,35,36,36,36,41,43,43,45,46,49,50,53,55,56,56,57,57,57,61,62,65,65,69,71,72,73,73,74,75,78,78,79,80,82,82,91,91,94,94,94,96,99,101,103,104,105,105,110,114,114,114,116,117,119,120,123,123,124,126,127,127,129,129,130,132,133,133,134,135,138,145,146,147,151,156,158,158,164,165,166,168,170,170,172,174,174,175,176,177,179,180,180,181,182,184,185,186,189,189,190,192,192,193,193,194,195,195,199,199,202,202,203,204,204,208,209,210,215,217,223,224,224,228,230,231,232,233,236,238,239,240,243,247,249,249,253,257,258,259,259,261,263,264,265,267,274,275,275,275,278,279,280,284,284,285,286,292,294,295,295,296,298,299,306,309,309,311,319,323,324,327,329,332,332,334,347,349,350,351,351,353,353,353,355,357,357,363,364,366,367,367,368,369,371,371,372,374,375,377,378,379,382,386,387,389,390,394,402,405,406,408,409,413,414,416,418,420,421,421,422,422,423,424,425,426,427,428,428,431,431,431,436,442,443,444,444,448,450,454,457,457,459,459,460,462,462,463,464,465,468,468,468,469,470,471,475,478,478,479,482,484,485,485,486,487,490,493,494,494,494,495};
		int[] b = new int[] {-500,-500,-500,-498,-497,-496,-496,-495,-494,-494,-491,-487,-482,-482,-480,-479,-478,-475,-471,-469,-469,-469,-467,-465,-464,-464,-459,-457,-454,-454,-453,-452,-452,-450,-445,-442,-441,-435,-434,-433,-432,-430,-430,-429,-429,-429,-428,-427,-426,-425,-424,-424,-421,-420,-420,-419,-416,-414,-413,-410,-408,-405,-404,-404,-403,-400,-400,-396,-396,-395,-395,-394,-390,-390,-390,-390,-385,-384,-384,-381,-380,-377,-377,-375,-373,-371,-371,-369,-367,-366,-362,-358,-357,-353,-352,-342,-338,-337,-337,-336,-335,-334,-334,-332,-330,-328,-327,-327,-327,-326,-325,-325,-323,-322,-321,-319,-316,-315,-315,-314,-314,-313,-307,-304,-304,-303,-303,-302,-302,-302,-302,-301,-300,-300,-297,-294,-292,-292,-290,-289,-289,-289,-288,-287,-286,-282,-280,-278,-277,-271,-269,-268,-268,-262,-261,-261,-261,-259,-255,-253,-252,-251,-250,-250,-250,-249,-248,-248,-248,-243,-243,-243,-241,-241,-240,-238,-238,-238,-235,-235,-234,-234,-234,-229,-229,-227,-226,-224,-220,-219,-217,-215,-214,-212,-212,-211,-211,-210,-210,-210,-207,-205,-205,-200,-198,-198,-198,-197,-196,-195,-194,-194,-194,-194,-194,-193,-191,-191,-189,-188,-183,-183,-180,-180,-178,-176,-176,-175,-175,-174,-173,-173,-173,-172,-171,-171,-170,-169,-168,-167,-167,-167,-166,-165,-165,-165,-164,-160,-158,-154,-154,-153,-152,-150,-150,-150,-146,-145,-144,-142,-140,-139,-136,-136,-136,-134,-134,-134,-132,-132,-131,-129,-128,-127,-124,-123,-123,-116,-115,-114,-112,-111,-110,-109,-106,-106,-103,-103,-101,-100,-99,-98,-98,-98,-95,-95,-94,-91,-91,-90,-90,-88,-88,-86,-86,-84,-83,-83,-82,-81,-79,-78,-78,-77,-76,-75,-74,-70,-69,-69,-69,-69,-68,-67,-66,-64,-64,-63,-62,-62,-61,-60,-59,-59,-56,-52,-52,-49,-48,-48,-48,-47,-46,-45,-45,-44,-39,-38,-36,-34,-34,-33,-32,-25,-25,-24,-24,-22,-22,-22,-17,-15,-14,-12,-11,-10,-10,-8,-7,-7,-6,-3,-2,3,3,7,8,9,9,12,13,14,15,20,21,23,23,25,28,29,32,35,36,37,38,38,41,41,43,43,43,44,44,45,47,47,48,48,50,50,53,54,54,56,57,58,60,61,61,61,63,64,64,65,65,70,73,74,77,79,79,80,81,82,83,84,84,85,86,88,89,89,91,92,93,95,96,97,98,98,100,105,107,109,111,112,113,115,115,116,116,117,120,121,122,125,130,131,132,132,132,133,135,135,135,138,138,139,139,144,144,147,148,150,151,152,154,155,156,156,156,157,158,160,161,161,161,163,164,165,167,172,173,179,180,180,183,185,185,186,186,188,188,192,192,193,193,198,199,200,200,201,203,206,206,207,208,208,209,209,210,210,210,211,215,216,216,219,221,221,221,225,225,228,228,228,233,233,233,235,236,237,239,241,243,246,247,247,251,252,254,255,256,256,258,258,259,260,261,262,262,263,264,267,267,268,269,270,270,271,271,271,274,275,277,277,280,283,283,283,287,288,288,290,291,292,293,293,296,297,298,300,309,311,313,314,315,319,323,326,328,329,332,332,332,333,334,334,341,343,343,346,347,349,351,352,355,356,356,356,358,360,365,366,368,368,368,373,373,374,375,377,380,381,383,384,384,385,388,388,390,391,394,396,396,397,398,399,400,405,409,409,410,411,413,413,414,416,418,418,418,418,419,421,423,427,427,427,428,428,431,432,432,433,436,437,438,438,438,440,440,440,441,442,443,445,446,447,449,450,450,452,454,455,458,459,460,461,462,463,469,470,473,475,476,478,479,482,483,485,486,486,489,490,493,494,496,496,496,498,498,498,499,500};
		System.out.println(c.kthSmallestProduct(a, b, 390525));
//		for (int i = 1; i <= a.length * b.length; i++) {
//			System.out.println(c.kthSmallestProduct(a, b, i));
//		}
	}

	public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int negCount1 = 0, zeroCount1 = 0;
		for (int i = 0; i < len1; i++) {
			if (nums1[i] < 0) {
				negCount1++;
			} else if (nums1[i] == 0) {
				zeroCount1++;
			} else {
				break;
			}
		}
		int negCount2 = 0, zeroCount2 = 0;
		for (int i = 0; i < len2; i++) {
			if (nums2[i] < 0) {
				negCount2++;
			} else if (nums2[i] == 0) {
				zeroCount2++;
			} else {
				break;
			}
		}
		int posCount1 = len1 - negCount1 - zeroCount1;
		int posCount2 = len2 - negCount2 - zeroCount2;
		long negTotal = posCount1 * negCount2 + posCount2 * negCount1;
		long zeroTotal = zeroCount1 * (posCount2 + negCount2) + zeroCount2 * (negCount1 + posCount1)
				+ zeroCount1 * zeroCount2;
		if (negTotal < k && k <= (negTotal + zeroTotal)) {
			return 0L;
		} else if (k <= negTotal) {
			return calNegative(nums1, negCount1, posCount1, nums2, negCount2, posCount2, k);
		} else {
			return calPositive(nums1, negCount1, posCount1, nums2, negCount2, posCount2, k - negTotal - zeroTotal);
		}
	}

	private long calPositive(int[] nums1, int negCount1, int posCount1, int[] nums2, int negCount2, int posCount2,
			long k) {
		int[] posNums1 = new int[posCount1];
		System.arraycopy(nums1, nums1.length - posCount1, posNums1, 0, posCount1);
		
		int[] posNums2 = new int[posCount2];
		System.arraycopy(nums2, nums2.length - posCount2, posNums2, 0, posCount2);
		
		Map<Long, List<int[]>> heapMap1 = new TreeMap<>();
		int[] indexArr1 = null;
		if(posNums1.length > 0 && posNums2.length > 0) {
			List<int[]> list1 = new ArrayList<>();
			list1.add(new int[] { 0, 0 });
			long initV1 = (long) posNums1[0] * (long) posNums2[0];
			heapMap1.put(initV1, list1);
			indexArr1 = new int[posCount1];
			for (int i = 0; i < posCount1; i++) {
				indexArr1[i] = -1;
			}
			indexArr1[0] = 0;
		}
		
		int[] negNums1 = reverseArray(nums1, 0, negCount1 - 1);
		int[] negNums2 = reverseArray(nums2, 0, negCount2 - 1);
		
		Map<Long, List<int[]>> heapMap2 = new TreeMap<>();
		int[] indexArr2 = null;
		if(negNums1.length > 0 && negNums2.length > 0) {
			List<int[]> list2 = new ArrayList<>();
			list2.add(new int[] { 0, 0 });
			long initV2 = (long) negNums1[0] * (long) negNums2[0];
			heapMap2.put(initV2, list2);
			indexArr2 = new int[negCount1];
			for (int i = 0; i < negCount1; i++) {
				indexArr2[i] = -1;
			}
			indexArr2[0] = 0;
		}
		
		long count = 0L;
		while (!heapMap1.isEmpty() || !heapMap2.isEmpty()) {
			long v1 = Long.MAX_VALUE;
			if (!heapMap1.isEmpty()) {
				List<Long> l = new ArrayList<>(heapMap1.keySet());
				v1 = l.get(0);
			}
			long v2 = Long.MAX_VALUE;
			if (!heapMap2.isEmpty()) {
				List<Long> l = new ArrayList<>(heapMap2.keySet());
				v2 = l.get(0);
			}
			count++;
			if (count == k) {
				return Math.min(v1, v2);
			}
			if (v1 <= v2) {
				spreadPosMap(heapMap1, v1, posNums1, posCount1, posNums2, posCount2, indexArr1);
			} else if (v1 > v2) {
				spreadPosMap(heapMap2, v2, negNums1, negCount1, negNums2, negCount2, indexArr2);
			}
		}
		return 0L;
	}
	
	private void spreadPosMap(Map<Long, List<int[]>> heapMap, long v, int[] nums1, int posCount1, int[] nums2,
			int posCount2, int[] indexArr1) {
		List<int[]> list = heapMap.remove(v);
		int[] pos = list.remove(0);
		if(!list.isEmpty()) {
			heapMap.put(v, list);
		}
		int x = pos[0], y = pos[1];
		if(y + 1 < posCount2) {
			int newY = y + 1;
			indexArr1[x]++;
			int[] newPos2 = new int[] {x, newY};
			if(checkPosPosition(heapMap, newPos2)) {
				long newNum2 = (long)nums1[x] * (long)nums2[newY];
				List<int[]> targetList = heapMap.get(newNum2);
				if(targetList == null) {
					targetList = new ArrayList<>();
					heapMap.put(newNum2, targetList);
				}
				targetList.add(newPos2);
			} else {
				indexArr1[x]--;
			}
		}
		if(x + 1 < posCount1) {
			int newX = x + 1;
			indexArr1[newX]++;
			int newY = indexArr1[newX];
			int[] newPos1 = new int[] {newX, newY};
			if(checkPosPosition(heapMap, newPos1)) {
				long newNum1 = (long)nums1[newX] * (long)nums2[newY];
				List<int[]> targetList = heapMap.get(newNum1);
				if(targetList == null) {
					targetList = new ArrayList<>();
					heapMap.put(newNum1, targetList);
				}
				targetList.add(newPos1);
			} else {
				indexArr1[newX]--;
			}
		}
	}
	
	private boolean checkPosPosition(Map<Long, List<int[]>> heapMap, int[] pos) {
		for (List<int[]> list : heapMap.values()) {
			for (int[] existingPos : list) {
				if((pos[0] == existingPos[0] && pos[1] > existingPos[1]) || (pos[0] > existingPos[0] && pos[1] == existingPos[1])) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int[] reverseArray(int[] arr, int start, int end) {
		int[] ret = new int[end - start + 1];
		for (int i = end; i >= start; i--) {
			ret[end - i] = arr[i];
		}
		return ret;
	}

	private long calNegative(int[] nums1, int negCount1, int posCount1, int[] nums2, int negCount2, int posCount2,
			long k) {
		int[] negNums1 = new int[negCount1];
		System.arraycopy(nums1, 0, negNums1, 0, negCount1);
		int[] posNums2 = reverseArray(nums2, nums2.length - posCount2, nums2.length - 1);
		
		Map<Long, List<int[]>> heapMap1 = new TreeMap<>();
		int[] indexArr1 = null;
		if(negNums1.length > 0 && posNums2.length > 0) {
			List<int[]> list1 = new ArrayList<>();
			list1.add(new int[] { 0, 0 });
			heapMap1.put((long) negNums1[0] * (long) posNums2[0], list1);
			indexArr1 = new int[negCount1];
			for (int i = 0; i < negCount1; i++) {
				indexArr1[i] = -1;
			}
			indexArr1[0] = 0;
		}
		
		int[] negNums2 = new int[negCount2];
		System.arraycopy(nums2, 0, negNums2, 0, negCount2);
		int[] posNums1 = reverseArray(nums1, nums1.length - posCount1, nums1.length - 1);
		
		Map<Long, List<int[]>> heapMap2 = new TreeMap<>();
		int[] indexArr2 = null;
		if(negNums2.length > 0 && posNums1.length > 0) {
			List<int[]> list2 = new ArrayList<>();
			list2.add(new int[] { 0, 0 });
			heapMap2.put((long) negNums2[0] * (long) posNums1[0], list2);
			indexArr2 = new int[negCount2];
			for (int i = 0; i < negCount2; i++) {
				indexArr2[i] = -1;
			}
			indexArr2[0] = 0;
		}

		long count = 0L;
		while (!heapMap1.isEmpty() || !heapMap2.isEmpty()) {
			long v1 = Long.MAX_VALUE;
			if (!heapMap1.isEmpty()) {
				List<Long> l = new ArrayList<>(heapMap1.keySet());
				v1 = l.get(0);
			}
			long v2 = Long.MAX_VALUE;
			if (!heapMap2.isEmpty()) {
				List<Long> l = new ArrayList<>(heapMap2.keySet());
				v2 = l.get(0);
			}
			count++;
			if (count == k) {
				return Math.min(v1, v2);
			}
			if (v1 <= v2) {
				spreadPosMap(heapMap1, v1, negNums1, negCount1, posNums2, posCount2, indexArr1);
			} else if (v1 > v2) {
				spreadPosMap(heapMap2, v2, negNums2, negCount2, posNums1, posCount1, indexArr2);
			}
		}
		return 0L;
	}

}
