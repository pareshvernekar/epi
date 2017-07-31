package sample.epi.hashtable.bruteforce;

import java.util.*;

public class PalindromePermutation {
	
	public static void main(String[] argv) {
			boolean flag = Boolean.TRUE;
			String input = "aababa";
			Map<Character,Integer> keyCountMap = new HashMap<>();
			char[] inputArr = input.toCharArray();
			for (int i=0;i<inputArr.length;i++) {
				if (keyCountMap.containsKey(inputArr[i])){
					keyCountMap.put(inputArr[i],keyCountMap.get(inputArr[i])+1);
				} else {
					keyCountMap.put(inputArr[i],1);
				}
			}
			boolean oddCount = Boolean.FALSE;
			for (Integer i:keyCountMap.values()) {
				if (i%2==0)
					continue;
				if (oddCount && i%2==1) {
					flag = Boolean.FALSE;
					break;
				} else if (!oddCount) {
					oddCount = Boolean.TRUE;
				}
			}
			System.out.println("Palindrome permutation:"+input+":"+flag);
	}
}