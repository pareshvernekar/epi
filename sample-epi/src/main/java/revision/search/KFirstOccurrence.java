package revision.search;
import java.util.*;
public class KFirstOccurrence {

	public static void main(String[] argv) {
		KFirstOccurrence kfo = new KFirstOccurrence();
		int[] input = {-14,-10,2,108,108,243,285,285,285,401};
		int pos = kfo.search(input,108);
		System.out.println(pos);
		pos = kfo.search(input,285);
		System.out.println(pos);
		pos=kfo.searchFirstGreaterThan(input,285);
		System.out.println(pos);
		pos=kfo.searchFirstGreaterThan(input,-13);
		System.out.println(pos);
		pos=kfo.searchFirstGreaterThan(input,3);
		System.out.println(pos);
	}
	
	public int search(int[] input, int k) {

		if (input==null || input.length==0)
			return -1;

		int left = 0, right = input.length-1;
		int currPos = -1;
		while (left <= right) {
			int middle = left + (right-left)/2;
			if (k > input[middle])
				left=middle+1;
			else if (k < input[middle])
				right=middle-1;
			else {
				System.out.println("middle:"+middle);
				currPos=middle;
				right=middle-1;
			}
		}
		return currPos;
	}

	public int searchFirstGreaterThan(int[] input, int k) {

		if (input==null || input.length==0)
			return -1;

		int left = 0, right = input.length-1;
		int currPos = -1;
		while (left <= right) {
			int middle = left + (right-left)/2;
			if (k > input[middle]) {

				left=middle+1;
				currPos=left;
			} else if (k < input[middle]) {
				currPos=middle;
				right=middle-1;
			} else {
	 			left=middle+1;
			}
		}
		return currPos;
	}
}