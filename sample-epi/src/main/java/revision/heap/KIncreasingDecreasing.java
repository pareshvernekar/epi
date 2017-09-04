package revision.heap;

import java.util.*;

class ArrayElement {

	Integer data;
	int arrayId;

	public ArrayElement(Integer data, int arrayPos) {
		this.data = data;
		this.arrayId = arrayPos;
	}
}
public class KIncreasingDecreasing {

	public List<Integer> mergeSortedArray(List<List<Integer>> input) {
		if (input == null || input.size() == 0)
			return null;

		List<Iterator<Integer>> iteratorList = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		int len = input.size();
		for (int i=0;i<len;i++) {
			iteratorList.add(input.get(i).iterator());
		}
		PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(len, 
			new Comparator<ArrayElement>() {
				public int compare(ArrayElement ae1, ArrayElement ae2) {
					return Integer.compare(ae1.data,ae2.data);
				}
			});
		for (int i=0;i<len;i++) {
			if (iteratorList.get(i).hasNext())
				minHeap.add(new ArrayElement(iteratorList.get(i).next(),i));
		}

		while (!minHeap.isEmpty()) {
			ArrayElement temp = minHeap.poll();
			result.add(temp.data);
			if (iteratorList.get(temp.arrayId).hasNext())
				minHeap.add(new ArrayElement(iteratorList.get(temp.arrayId).next(),
					temp.arrayId));
		}
		return result;

	}

	public List<Integer> sort(List<Integer> input, int k) {

		if (input==null || input.size() == 0)
			return input;

		List<List<Integer>> intermediate = new ArrayList<>();
		Boolean inc = Boolean.TRUE;
		int i = 0;
		int len = input.size();
		while (i<len) {
			if (inc) {
				System.out.println(i+"::"+k);
				intermediate.add(input.subList(i,i+k));
				i=i+k;
				inc=Boolean.FALSE;
			} else {
				int start=i;
				int j = i+k-2;
				while (i<j) {
					int temp = input.get(i);
					input.set(i,input.get(j));
					input.set(j,temp);
					i++;j--;
				}
				i+=1;
				intermediate.add(input.subList(start,start+k-1));
				inc=Boolean.TRUE;
			}
		}
	/*	for (List<Integer> list:intermediate) {
			for (Integer i1:list) {
				System.out.print(i1);System.out.print("\t");
			}
			System.out.println();
		} */
		return mergeSortedArray(intermediate);
	}	

	public static void main(String[] argv) {
		List<Integer> input = Arrays.asList(57,131,493,294,221,339,418,452,442,190);
		KIncreasingDecreasing kid = new KIncreasingDecreasing();
		List<Integer> result = kid.sort(input,3);
		for (Integer i:result) {
			System.out.print(i);System.out.print("\t");
		}
		System.out.println();
	}

}