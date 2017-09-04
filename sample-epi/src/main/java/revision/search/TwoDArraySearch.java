package revision.search;

import java.util.*;
public class TwoDArraySearch {

	public static void main(String[] argv) {

		int[][] input = {
					{-1,2,4,4,6},
					{1,5,5,9,21},
					{3,6,6,9,22},
					{3,6,8,10,24},
					{6,8,9,12,25},
					{8,10,12,13,40}
		};
		System.out.println(search(input,7));
		System.out.println(search(input,8));
	}
	
	public static boolean search(int[][] input, int k) {
		if (input == null || input.length==0)
			return Boolean.FALSE;
		int row=0, col = input[0].length-1;
		while (row < input.length-1 &&  col >=0) {
			if (input[row][col]==k) {
				return Boolean.TRUE;
			} else if (input[row][col] < k) {
				row++;
			} else {
				col--;
			}

		}
		return Boolean.FALSE;
	}

}