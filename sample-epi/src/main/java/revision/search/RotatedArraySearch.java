package revision.search;

import java.util.*;

public class RotatedArraySearch {
	
	public int search(int[] input) {
		if (input == null || input.length==0)
			return -1;

		int left = 0;
		int right = input.length-1;
		while (left <= right) {
			int middle=left+(right-left)/2;
			if (input[middle] < input[left] && input[middle] < input[right]) {
				return middle;
			} else if (input[middle] > input[right]) {
				left=middle+1;
			} else {
				right=middle;
			}
		}

		return -1;
	}

	public static void main(String[] argv) {
		int[] input = {378,478,550,631,103,203,220,234,279,368};
		RotatedArraySearch ras = new RotatedArraySearch();
		int i = ras.search(input);
		System.out.println("Index:"+i);
	}
}