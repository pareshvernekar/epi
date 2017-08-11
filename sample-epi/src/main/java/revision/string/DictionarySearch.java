
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

package revision.string;

import java.util.*;

public class DictionarySearch {

	public boolean segment(String input,String[] dict) {

		if (input == null || input.isEmpty())
			return Boolean.FALSE;

		Trie dictionary = buildDictionary(dict);

		if (dictionary == null || dictionary.characters==null)
			return Boolean.FALSE;
		int len = input.length();

		for (int i=0;i<len;i++) {

				if (dictionary != null && dictionary.characters!= null && dictionary.characters[input.charAt(i)-'a'] == null) {
					return Boolean.FALSE;
				}
				dictionary = dictionary!=null && dictionary.characters!=null?dictionary.characters[input.charAt(i)-'a']:null;
		}
		return Boolean.TRUE;
	}
	
	private Trie buildDictionary(String[] dict) {

		if (dict == null || dict.length==0)
			return null;

		int len = dict.length;
		Trie dictionary = null;
		Trie temp = null; 
		for (int i=0;i<len;i++) {

			String str = dict[i];
			int strLen = str.length();
			for (int j=0;j<strLen;j++) {

				if (dictionary == null) {
					dictionary = new Trie();
					temp = dictionary;					
				}
				if (temp.characters==null || temp.characters.length==0) {
					temp.characters=new Trie[26];
				}
				if (temp.characters[str.charAt(j)-'a']==null) {
					temp.characters[str.charAt(j)-'a'] = new Trie();
				}
				temp=temp.characters[str.charAt(j)-'a'];
		
			}
			temp.end=Boolean.TRUE;
			temp=dictionary;

		}
		return dictionary;
	}
	public static void main(String[] argv) {
		DictionarySearch ds = new DictionarySearch();
		String[] words = {"leet","code"};
		System.out.println(ds.segment("leetcode",words));
		words = new String[]{"lbc","code"};
		System.out.println(ds.segment("leetcode",words));
	}
}

class Trie {
	boolean end;
	Trie[] characters;
}