package sample.epi.search.bruteforce;

import java.util.*;

public class SortedArrayIntervalSearch {
	

	public int[] search(int[] input, int element) {

		if (input == null || input.length==0) return new int[]{-1,-1};
		if (input.length==1 && input[0]==element) return new int[]{0,0};
		int minPos = -1, maxPos = -1, start = 0, end = input.length-1;
		int middle = 0;
		while (start<=end) {
			middle = start + (end-start)/2;
			if (input[middle] < element) {
				start=middle+1;
			} else if (input[middle]==element) {
				end=middle-1;
				minPos = middle;
			} else if (input[middle] > element) {
				end=middle-1;
			}
		}

		 start = 0; end = input.length-1;
		while (start<=end) {
			middle = start + (end-start)/2;
			if (input[middle] < element) {
				start=middle+1;
			} else if (input[middle]==element) {
				start=middle+1;
				maxPos = middle;
			} else if (input[middle] > element) {
				end=middle-1;
			}
		}
		return new int[]{minPos,maxPos};

	}
	public static void main(String[] argv) {
		int[] input = new int[]{1,2,2,4,4,4,7,11,11,13};
		SortedArrayIntervalSearch sais = new SortedArrayIntervalSearch();
		int[] result = sais.search(input,11);
		System.out.println(result[0]+"::"+result[1]);

	}


}