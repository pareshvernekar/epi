package revision.string;

import java.util.*;


public class WordSearch {
	

	Trie t;

	public WordSearch() {
		t = new Trie();
	}

	public void save(String word) {

		if ((word == null) || "".equals(word)) throw new IllegalArgumentException("Invalid word");
		int len = word.length();
		Trie temp = t;
		for (int i = 0;i<len;i++) {
			if (!Character.isLetter(word.charAt(i))) throw new IllegalArgumentException("Invalid word");
			if (temp.letters==null) {
				temp.letters = new Trie[26];
			}
			int index = word.charAt(i)-'a';
			if (temp.letters[index] == null) {
				temp.letters[index]=new Trie();
			}
			temp = temp.letters[index];

		}
		temp.isEnd = Boolean.TRUE;	//mark the end of word

	}

	public boolean searchWord(String word) {

		if ((word == null) || "".equals(word)) throw new IllegalArgumentException("Invalid word");
		int len = word.length();
		Trie temp = t;

		for (int i = 0;i<len;i++) {
			if (!Character.isLetter(word.charAt(i))) throw new IllegalArgumentException("Invalid word");
			if (temp.letters==null) {
				return Boolean.FALSE;
			}
			int index = word.charAt(i)-'a';
			if (index < 0 || index > temp.letters.length || temp.letters[index] == null ) {
				return Boolean.FALSE;
			}
				temp = temp.letters[index];
			}
			if (!temp.isEnd)
				return Boolean.FALSE;

			return Boolean.TRUE;
		}

	

	public static void main(String[] argv) {

		List<String> words = Arrays.asList("sad","saddle","rat","ram","rattle","bat");
		WordSearch ws = new WordSearch();
		for (String str:words) {
			ws.save(str);
		}

		System.out.println(" SAD::"+ws.searchWord("sad"));
		System.out.println(" RATTLE:"+ws.searchWord("rattle"));
		System.out.println(" RAT:"+ws.searchWord("rat"));
		System.out.println(" RAM:"+ws.searchWord("ram"));
		System.out.println(" ONE:"+ws.searchWord("ONE"));

	}


}

class Trie {
	
	boolean isEnd;
	Trie[] letters;
}