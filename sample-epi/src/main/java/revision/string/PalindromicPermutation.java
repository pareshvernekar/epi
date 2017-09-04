package revision.string;

import java.util.*;

public class PalindromicPermutation {

	public static void main(String[] argv) {
		PalindromicPermutation pp = new PalindromicPermutation();
		System.out.println(pp.test("edified"));
		System.out.println(pp.test("true"));
	}

	public boolean test(String input) {
		if (input==null || input.isEmpty())
			return Boolean.FALSE;

		Map<Character,Integer> charCountMap = new HashMap<>();
		int len = input.length();
		for (int i=0;i<len;i++) {
			if (charCountMap.containsKey(input.charAt(i))) {
				charCountMap.put(input.charAt(i),charCountMap.get(input.charAt(i))+1);
			} else {
				charCountMap.put(input.charAt(i),1);
			}
		}
		Boolean oddFound = Boolean.FALSE;
		for(char ch:charCountMap.keySet()) {
			int count = charCountMap.get(ch);
			if (count%2==1 && !oddFound) {
				oddFound=Boolean.TRUE;
			} else if (count%2==1 && oddFound) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
}