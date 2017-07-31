package sample.epi.search.bruteforce;

import java.util.*;

public class FirstOccurElementSearch {
	
	public int findFirst(int[] input, int element) {

		if (input == null || input.length==0) return -1;

		if (input.length==1 && input[0] == element) return 0;

		int start = 0, end = input.length-1, middle = 0;
		int minPos = Integer.MAX_VALUE;

		while (start<=end) {

			middle = start + (end - start)/2;
			if (element == input[middle]) {
				minPos=middle;
				end=middle-1;
			} else if (element <input[middle]) {
				end = middle-1;
			} else {
				start=middle+1;
			}

		}

		return (minPos==Integer.MAX_VALUE?-1:minPos);

	}


	public int findMaxAfter(int[] input, int element) {

		if (input == null || input.length==0) return -1;

		if (input.length==1 && input[0] == element) return 0;

		int start = 0, end = input.length-1, middle = 0;
		int minPos = Integer.MAX_VALUE;

		while (start<=end) {

			middle = start + (end - start)/2;
			if (element == input[middle]) {
				minPos=middle;
				start=middle+1;
			} else if (element <input[middle]) {
				end = middle-1;
			} else {
				start=middle+1;
			}

		}

		return (minPos==Integer.MAX_VALUE?-1:minPos+1);

	}


	public static void main(String[] argv) {

		int[] input = new int[]{-14,-10,2,108,108,243,285,285,285,401};
		FirstOccurElementSearch fos = new FirstOccurElementSearch();
		System.out.println(" Pos 208:"+fos.findFirst(input,108));
		System.out.println(" Pos 285:"+fos.findFirst(input,285));
		System.out.println(" Pos 500:"+fos.findFirst(input,500));

		System.out.println(" Pos 208:"+fos.findMaxAfter(input,108));
		System.out.println(" Pos 285:"+fos.findMaxAfter(input,285));
		System.out.println(" Pos 500:"+fos.findMaxAfter(input,500));

	}
}