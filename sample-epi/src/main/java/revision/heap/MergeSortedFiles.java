package revision.heap;
import java.util.*;

public class MergeSortedFiles {
	
	public List<Integer> merge(List<List<Integer>>  input) {

		List<Iterator<Integer>> iteratorList = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(input.size(), 
			new Comparator<ArrayElement>() {
				public int compare(ArrayElement ae1, ArrayElement ae2) {
					return Integer.compare(ae1.data, ae2.data);
				}
			} );
		int i = 0;
		
		for (List<Integer> list:input) {
			iteratorList.add(list.iterator());
			if (iteratorList.get(i).hasNext())
				minHeap.add(new ArrayElement(iteratorList.get(i).next(),i));
			i++;
		} 

		while (!minHeap.isEmpty()) {
			ArrayElement ae = minHeap.poll();
			result.add(ae.data);
			if (iteratorList.get(ae.arrayId).hasNext())
				minHeap.add(new ArrayElement(iteratorList.get(ae.arrayId).next(),ae.arrayId));
		}

		return result;			
	}

	public static void main(String[] argv) {
		MergeSortedFiles msf = new MergeSortedFiles();
		List<Integer> l1 = Arrays.asList(3,5,7);
		List<Integer> l2 = Arrays.asList(0,6);
		List<Integer> l3 = Arrays.asList(0,6,28);
		List<List<Integer>> input = new ArrayList<>();
		input.add(l1);
		input.add(l2);
		input.add(l3);

		List<Integer> result = msf.merge(input);
			for (Integer i:result) {
				System.out.print(i);System.out.print("\t");
			}
			System.out.println();
	}
}

class ArrayElement{
	Integer data;
	Integer arrayId;

	public ArrayElement(Integer data, Integer arrayId) {
		this.data=data;
		this.arrayId=arrayId;
	}

}