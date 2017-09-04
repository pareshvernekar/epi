package revision.search;

import java.util.*;

public class IndexValueMatch {

	public static void main(String[] argv) {
		int[] input = {-2,0,2,3,6,7,9};
		IndexValueMatch ivm = new IndexValueMatch();
		System.out.println(ivm.match(input));
	}
	
	public int match(int[] input) {
		if (input == null || input.length==0)
			return -1;

		int left = 0;
		int right=input.length-1;
		while (left <= right) {
			int middle=left + (right-left)/2;
			if (middle==input[middle])
				return middle;
			else if (middle < input[middle]) {
				right = middle-1;
			} else {
				left=middle+1;
			}
		}
		return -1;
	}


}