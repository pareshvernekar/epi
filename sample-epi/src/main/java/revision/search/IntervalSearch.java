package revision.search;

import java.util.*;

public class IntervalSearch {

	public static void main(String[] argv) {
		IntervalSearch is = new IntervalSearch();
		int[] input = {1,2,2,4,4,4,7,11,11,13};
		List<Integer> results = is.search(input,11);
		for (Integer i:results) {
			System.out.print(i);System.out.print("\t");
		}
		System.out.println();
		results = is.search(input,4);
		for (Integer i:results) {
			System.out.print(i);System.out.print("\t");
		}
	}
	
	public List<Integer> search(int[] input, int k) {
		if (input == null || input.length==0)
			return Arrays.asList(-1,-1);
		List<Integer> result = new ArrayList<>();
		result.add(findLowest(input,k));
		result.add(findLargest(input,k));
		return result;
	}

	public int findLowest(int[] input, int k) {
		int left = 0;
		int right = input.length-1;
		int currPos = -1;
		while (left <= right) {
			int middle=left + (right-left)/2;
			if (input[middle] > k) {
				right=middle-1;
			} else if (input[middle] < k) {
				left=middle+1;
			} else {
				currPos=middle;
				right=middle-1;
			}

		}
		return currPos;
	}

	public int findLargest(int[] input, int k) {
		int left = 0;
		int right = input.length-1;
		int currPos = -1;
		while (left <= right) {
			int middle=left + (right-left)/2;
			if (input[middle] > k) {
				right=middle-1;
			} else if (input[middle] < k) {
				left=middle+1;
			} else {
				currPos=middle;
				left=middle+1;
			}

		}
		return currPos;
	}

}