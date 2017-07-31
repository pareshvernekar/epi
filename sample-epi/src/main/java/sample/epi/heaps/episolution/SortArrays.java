package sample.epi.heaps.episolution;

import java.util.*;


//Sort partially sorted arrays
public class SortArrays {
	

	public List<Integer> sort(List<Integer> input) {


		List<Integer> result = new ArrayList<>();
		List<List<Integer>> processedArr = new ArrayList<>();
		int len = input.size();

		List<Integer> temp = new ArrayList<>();
		int startPos = 0;
		int i = startPos+1;
		boolean increasing = true;
		while (i < len) {
			if (increasing) {
				if (input.get(i).compareTo(input.get(i-1)) >= 0) {
					temp.add(input.get(i-1));
				}  else {
					processedArr.add(temp);
					temp=new ArrayList<>();
					startPos=i;
					System.out.println("startPos;:"+startPos);
					increasing = false;
				}
				i++;
			} else {
				if (input.get(i).compareTo(input.get(i-1)) < 0) {
					temp.add(input.get(i-1));
				}  else {
					processedArr.add(temp);
					temp=new ArrayList<>();
					startPos=i;
					increasing = true;
					System.out.println("startPos;:"+startPos);
				}
				i++;

			}
		}
		System.out.println(processedArr.size());
		List<Iterator<Integer>> iterator = new ArrayList<>(processedArr.size());
		for (int k=0;k<processedArr.size();k++) {
			iterator.add(processedArr.get(k).iterator());
		}
		PriorityQueue<ArrayElement> queue = new PriorityQueue<>(processedArr.size(), 
			new Comparator<ArrayElement>() {

				public int compare(ArrayElement ae1, ArrayElement ae2) {
					return ae1.data.compareTo(ae2.data);
				}

				});
	

System.out.println(iterator.size());	
		for (int j=0;j<iterator.size();j++) {
			System.out.println("j:"+j);

			queue.add(new ArrayElement(iterator.get(j).next(),j));
		}

		while (!queue.isEmpty()) {
			ArrayElement temp1 = queue.poll();
			result.add(temp1.data);
			if (iterator.get(temp1.arrayPos).hasNext()) {
				queue.add(new ArrayElement(iterator.get(temp1.arrayPos).next(),temp1.arrayPos))	;
			}
		}

		return result;
	}

	public static void main(String[] argv) {

		Integer[] arr = new Integer[] {5,6,7, 3,2,12,13,14,9,8};
		List<Integer> input = Arrays.asList(arr);
		SortArrays sa = new SortArrays();
		List<Integer> result = sa.sort(input);
		
		for (Integer i:result) {
			System.out.print(result);System.out.print("\t");
		}
	}

}
class ArrayElement {

	Integer data;
	int arrayPos;

	public ArrayElement(Integer data, int arrayPos) {

		this.data = data;
		this.arrayPos = arrayPos;
	}
}