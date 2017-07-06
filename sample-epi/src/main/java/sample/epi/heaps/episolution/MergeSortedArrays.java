package sample.epi.heaps.episolution;

import java.util.*;


public class MergeSortedArrays {
	

	public List<Integer> merge(List<List<Integer>> input) {

		List<Iterator<Integer>> iterators = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for (List<Integer> l:input) {
			iterators.add(l.iterator());
		}
		PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(iterators.size(), new Comparator<ArrayElement>() {
			public int compare(ArrayElement ae1, ArrayElement ae2) {
				return ae1.data.compareTo(ae2.data);
			}
		});
		int len = iterators.size();
		for (int i=0;i<len;i++) {
			minHeap.add(new ArrayElement(iterators.get(i).next(),i));
		}
		ArrayElement temp = null;
		while (!minHeap.isEmpty()) {
			temp = minHeap.poll();
			result.add(temp.data);
			if (iterators.get(temp.pos).hasNext()) {
				minHeap.add(new ArrayElement(iterators.get(temp.pos).next(),temp.pos));
			}
		}


		return result;

	}

	public static void main(String[] argv) {

		List<Integer> arr1 = Arrays.asList(0,0,6);
		List<Integer> arr2 = Arrays.asList(1,7,8,9);
		List<Integer> arr3 = Arrays.asList(3,4);

		List<List<Integer>> input = new ArrayList<>();
		input.add(arr1);
		input.add(arr2);
		input.add(arr3);

		MergeSortedArrays msa = new MergeSortedArrays();
		List<Integer> result = msa.merge(input);
		for (Integer i:result) {
			System.out.println(i);
		}

	}
}
class ArrayElement {

	Integer data;
	int pos;

	public ArrayElement(Integer data, int pos) {

		this.data= data;
		this.pos = pos;
	}
}