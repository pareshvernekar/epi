package sample.epi.hashtable.bruteforce;
import java.util.*;
public class NearestRepEntries {


	PriorityQueue<WordEntry> minHeap = new PriorityQueue<>(16, 
		new Comparator<WordEntry>() {
		public int compare(WordEntry we1, WordEntry we2) {
			return we1.gap.compareTo(we2.gap);
		}
	});

	public List<String> nearestRep(String[] input) {

		Map<String,Integer> entryMap = new HashMap<>();
		List<String> result = new ArrayList<>();
		for (int i=0;i<input.length;i++) {
			if (entryMap.containsKey(input[i])) {
				int diff = i-entryMap.get(input[i]);
				minHeap.offer(new WordEntry(input[i],diff));
			} 
			entryMap.put(input[i],i);
		}

		while (!minHeap.isEmpty()) {
			WordEntry  we = minHeap.poll();
			System.out.println("Word:"+we.word+":Gap:"+we.gap);
			result.add(we.word);
		}
		return result;
	}

	public static void main(String[] argv) {

		String[] input = new String[]{"All","work","and","no","play","makes",
						"for","no","work","no","fun","and","no","results"};

		NearestRepEntries entries = new NearestRepEntries();
		List<String> result = entries.nearestRep(input);
		for (int i=0;i<result.size();i++) {
			System.out.print(result.get(i));	System.out.print("\t");
		}
	}
	
}

class WordEntry {

	String word;
	Integer gap;

	public WordEntry(String word, Integer gap) {
		this.word = word;
		this.gap=gap;
	}
}