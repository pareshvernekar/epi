package sample.epi.heaps.episolution;

import java.util.*;

public class KSortedArray {
	
	public List<Integer> sort(List<Integer> input, int k) {

			List<Integer> result = new ArrayList<>();
			PriorityQueue<Integer> q = new PriorityQueue<>(k);
			Iterator<Integer> iter = input.iterator();
			for(int i=0;i<k;i++) {
				if (iter.hasNext())
					q.add(iter.next());
			}

			while (!q.isEmpty()) {
				result.add(q.remove());
				if (iter.hasNext())
					q.add(iter.next());
			}

			return result;
	}
	public static void main(String[] argv) {

		List<Integer> partiallySorted = Arrays.asList(3,-1,2,6,4,5,8);
		KSortedArray sa = new KSortedArray();
		List<Integer> result = sa.sort(partiallySorted,2);
		for (Integer i:result) {
			System.out.print(i);System.out.print("\t");
		}

	}
}