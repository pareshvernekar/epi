package revision.heap;

import java.util.*;

public class RunningMedian {
	
	public static void main(String[] argv) {
		RunningMedian rm = new RunningMedian();
		rm.median(Arrays.asList(1,0,3,5,2,0,1));

	}
	public void median(List<Integer> list) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, 
			Collections.reverseOrder());

		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {

			Integer i = iterator.next();
			if (minHeap.isEmpty()) {
				minHeap.add(i);
			} else {
				if (i >= minHeap.peek()) 
					minHeap.add(i);
				else
					maxHeap.add(i);
			}

			if (minHeap.size() > maxHeap.size()+1) {
				maxHeap.add(minHeap.remove());
			} else if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.remove());
			}
			System.out.println("Median:"+
				(minHeap.size()==maxHeap.size()?
					0.5*(minHeap.peek()+maxHeap.peek()):minHeap.peek()));
		}
	}
}