package revision.heap;

import java.util.*;

public class KMaxHeap {

	public List<Integer> kMax(List<Integer> input,int k) {
		if (input == null || input.size() == 0 || k <=0)
			throw new IllegalArgumentException("Invalid parameter values");

		List<Integer> result = new ArrayList<>();
		PriorityQueue<MaxHeapElement> maxHeap = 
		new PriorityQueue<>(16, new Comparator<MaxHeapElement>() {
			public int compare(MaxHeapElement mhe1, MaxHeapElement mhe2) {
				return Integer.compare(mhe2.data, mhe1.data);
			}
		});

		maxHeap.add(new MaxHeapElement(input.get(0),0));


		while (result.size() != k) {

			MaxHeapElement temp = maxHeap.poll();
			result.add(temp.data);
			int leftIdx = 2 * temp.arrayId+1;
			if (leftIdx < input.size())
				maxHeap.add(new MaxHeapElement(input.get(leftIdx),leftIdx));
			int rightIdx = 2 * temp.arrayId+2;
			if (rightIdx < input.size())
				maxHeap.add(new MaxHeapElement(input.get(rightIdx),rightIdx));
			
		}
		return result;

	}

	public static void main(String[] argv) {

		List<Integer> input = Arrays.asList(561,314,401,28,156,359,271,11,3);
		KMaxHeap kmh = new KMaxHeap();
		List<Integer> results = kmh.kMax(input,4);
		for (Integer i:results) {
			System.out.print(i);System.out.print("\t");
		}
	}
	

}

class MaxHeapElement {

	Integer data;
	int arrayId;
	public MaxHeapElement(Integer data, int id) {
		this.data = data;
		this.arrayId=id;
	}
}