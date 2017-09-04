package revision.hashtable;

import java.util.*;

public class LetterFromMagazine {
	
public static void main(String[] arg) {
	LetterFromMagazine lfm = new LetterFromMagazine();
	System.out.println(lfm.test("aa","aabbcc"));
	System.out.println(lfm.test("aa","abbcc"));
}
public boolean test(String letterText, String magazineText) {
	if (letterText==null || letterText.isEmpty() 
		|| magazineText == null || magazineText.isEmpty())
		return Boolean.FALSE;

	Map<Character, Integer> letterCharCount = new HashMap<>();
	Map<Character, Integer> magazineCharCount = new HashMap<>();

	int magLen = magazineText.length();
	int letterLen = letterText.length();
	for (int i=0;i<magLen;i++) {
		if (magazineCharCount.containsKey(magazineText.charAt(i)))
			magazineCharCount.put(magazineText.charAt(i), magazineCharCount.get(magazineText.charAt(i))+1);
		else
			magazineCharCount.put(magazineText.charAt(i), 1);
	}

	for (int i = 0;i<letterLen;i++) {
		if (!magazineCharCount.containsKey(letterText.charAt(i))) 
			return Boolean.FALSE;
		else {
			if (magazineCharCount.get(letterText.charAt(i))==1) {
				magazineCharCount.remove(letterText.charAt(i));
			} else {
				magazineCharCount.put(letterText.charAt(i), 
					magazineCharCount.get(letterText.charAt(i))-1);
			}
		}
	}
	return Boolean.TRUE;
}

}