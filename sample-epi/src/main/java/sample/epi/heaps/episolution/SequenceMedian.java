package sample.epi.heaps.episolution;

import java.util.*;

public class SequenceMedian {
	

	public static void median(List<Integer> sequence) {
		Iterator<Integer> iterator = sequence.iterator();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(sequence.size(),
			Collections.reverseOrder());

		while (iterator.hasNext()) {
			int x = iterator.next();
			if (minHeap.isEmpty()) {
				minHeap.add(x);
			} else {
				if (x >= minHeap.peek()) {
					minHeap.add(x);
				} else {
					maxHeap.add(x);
				}
			}

			if (minHeap.size() > maxHeap.size()+1) {
				maxHeap.add(minHeap.remove());
			} else if (minHeap.size() < maxHeap.size()) {
				minHeap.add(maxHeap.remove());
			}
			if (minHeap.size() == maxHeap.size()) {
				System.out.println(0.5 * (minHeap.peek()+maxHeap.peek()));
			} else {
				System.out.println(minHeap.peek());
			}

		}

	}

	public static void main(String[] argv) {

		median(Arrays.asList(1,0,3,5,2,0,1));
	}

}