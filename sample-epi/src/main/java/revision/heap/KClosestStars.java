package revision.heap;

import java.util.*;

public class KClosestStars {
	
	public List<Integer> closest(List<Integer> stars, int k) {
		if (stars == null || stars.isEmpty() || k <= 0)
			throw new IllegalArgumentException("Invalid input parameters");
		PriorityQueue<Integer> maxHeap = 
				new PriorityQueue<>(k, Collections.reverseOrder());
		for (int i=0;i<k;i++) {
			maxHeap.add(stars.get(i));
		}
		int len = stars.size();
		for (int i=k;i<len;i++) {
			maxHeap.add(stars.get(i));
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		List<Integer> result = new ArrayList<>(maxHeap);
		Collections.sort(result);
		return result;
	}

	public static void main(String[] argv) {

		List<Integer> stars = Arrays.asList(100,90,3,1,75,2,85,95,5,6,7,4);

		KClosestStars kcs = new KClosestStars();
		List<Integer> results = kcs.closest(stars,4);
		for (Integer i:results) {
			System.out.print(i);System.out.print("\t");
		}
		System.out.println();
	}
}