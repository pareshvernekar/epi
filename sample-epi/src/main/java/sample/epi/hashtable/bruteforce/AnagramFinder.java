package sample.epi.hashtable.bruteforce;

import java.util.*;

public class AnagramFinder {

	public void findAnagram(List<String> input) {

		Map<String,String> map = new HashMap<>();
		for(String str:input) {
			char[] ch = str.toCharArray();Arrays.sort(ch);
			if (map.containsKey(new String(ch))) {
				System.out.println("Anagram:"+(map.get(new String(ch)))+"::"+str);
			} else {
				map.put(new String(ch),str);
			}
		}
	}

	public static void main(String[] argv) {
		List<String> input=Arrays.asList("debitcard","elvis","silent","badcredit","lives",
			"freedom","listen","levis","money");
		AnagramFinder af = new AnagramFinder();
		af.findAnagram(input);
	}
}