package revision.hashtable;

import java.util.*;
public class KFrequentQueries {
	
	public static void main(String[] argv) {
		List<String> input = Arrays.asList("a","a","a","b","b","c");
		KFrequentQueries kfq = new KFrequentQueries();
		List<String> result = kfq.process(input,2);
		for (String str:result) {
			System.out.println(str);
		}

	}


	public List<String> process(List<String> input, int k) {
		if (input == null || input.size()==0)
			return null;
		PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(k, 
			new Comparator<HeapEntry>() {
				public int compare(HeapEntry he1, HeapEntry he2) {
					return Integer.compare(he1.count, he2.count);
				}
			} );
		Map<String,Integer> stringCountMap = new HashMap<>();
		Iterator<String> iter = input.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			int count = 0;
			if (stringCountMap.containsKey(temp))
				count = stringCountMap.get(temp)+1;
			else
				count = 1;

				stringCountMap.put(temp, count);

			if (minHeap.size() < k) {
				if (!minHeap.isEmpty() && minHeap.peek().data.equals(temp)) {
					minHeap.poll();
				}
				minHeap.add(new HeapEntry(temp,count));
			
			} else {
				if (minHeap.peek().count < count) {
					minHeap.poll();
					minHeap.add(new HeapEntry(temp,count));
				}
			}
		}

		List<String> result = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll().data);
		}
		return result;
	}

}

class HeapEntry {
	String data;
	int count;
	public HeapEntry(String data, int count) {
		this.data = data;
		this.count = count;
	}
}