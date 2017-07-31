package sample.epi.search.bruteforce;

import java.util.*;

public class TwoDSortedArraySearch {
	
	public int[][] find(int[][] input, int element) {
		if (input==null || input.length==0) return new int[][]{{-1,-1}};
		if (input.length==1 && input[0].length==1) {
			if (input[0][0] == element)
				return new int[][]{{0,0}};
			else
				return new int[][]{{-1,-1}};
		}  

		int rowLen = input.length;
		int colLen = input[0].length;

		for (int i=0;i<rowLen;i++) {

			if (input[i][0] > element || input[i][colLen-1] < element) continue;	//row & column elimination
			int pos = binarySearch(input[i],element);
			if (pos == -1) continue;
			return new int[][]{{i,pos}};
		}

		return new int[][]{{-1,-1}};
	}

	private int binarySearch(int[] input, int element) {

		int left = 0, right=input.length-1, middle = 0;
		while (left <=right) {

			middle=left+(right-left)/2;
			if (input[middle] < element)
				left=middle+1;
			else if (input[middle]==element)
				return middle;
			else right=middle-1;
		}
		return -1;
	}
	public static void main(String[] argv) {
		int[][] input = new int[][]{
							{-1,2,4,4,6},
							{1,5,5,9,21},
							{3,6,6,9,22},
							{6,8,9,12,25},
							{8,10,12,13,40}
						};

		TwoDSortedArraySearch sAs = new TwoDSortedArraySearch();
		int[][] result = sAs.find(input,8);
		System.out.println("Position:"+result[0][0]+"::"+result[0][1]);

		result = sAs.find(input,7);
		System.out.println("Position:"+result[0][0]+"::"+result[0][1]);
	}
}