package revision.heap;

import java.util.*;

public class KSortedArray {

	public static void main(String[] argv) {
		List<Integer> input = Arrays.asList(3,-1,2,6,4,5,8);
		KSortedArray ksa = new KSortedArray();
		List<Integer> result = ksa.sort(input,2);
		for (Integer i1:result) {
				System.out.print(i1);System.out.print("\t");
			}
		System.out.println();
	}
	
	public List<Integer> sort(List<Integer> input, int k) {
		if (input == null || input.size() ==0)
			return input;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

		Iterator<Integer> iterator = input.iterator();
		if (iterator.hasNext()) {
			minHeap.add(iterator.next());
		}
		
		List<Integer> result = new ArrayList<>();
		while (iterator.hasNext()) {
				System.out.println("FIRST::"+minHeap.peek());
			if (iterator.hasNext())
				minHeap.add(iterator.next());
			if (minHeap.size() > k) {
				result.add(minHeap.poll());
			}
		}
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll());
		}
		return result;
	}
}