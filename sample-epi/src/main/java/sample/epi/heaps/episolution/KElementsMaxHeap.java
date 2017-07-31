package sample.epi.heaps.episolution;

import java.util.*;

public class KElementsMaxHeap {
	
	public List<Integer> getKMaxElements(List<Integer> input, int k) {
		List<Integer> result = new ArrayList();
		int len = input.size();
		int i = 0;
		result.add(input.get(0));
		while (i < len-1) {
			if (result.size()==k)
				break;
			int leftChild = 2*i+1;
			int rightChild = 2*i+2;
			System.out.println();
			if (leftChild < len) {
				if (rightChild<len) {
					if (input.get(leftChild) > input.get(rightChild)) {
						result.add(input.get(leftChild) );
						i=leftChild;
						continue;
					} else {
						result.add(input.get(rightChild) );
						i=rightChild;
						continue;
					}
				} else {
					result.add(input.get(leftChild) );
					i=leftChild;
					continue;
				}
			}
			i++;
		}
		return result;
	}

	public static void main(String[] argv) {
		List<Integer> input = Arrays.asList(561,314,401,28,156,359,271,11,3);
		KElementsMaxHeap kHeap = new KElementsMaxHeap();
		List<Integer> result = kHeap.getKMaxElements(input,4);
		for (Integer i:result) {
			System.out.print(i);	System.out.print("\t");
		}
	}
}