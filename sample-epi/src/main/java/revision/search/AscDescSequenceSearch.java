package revision.search;
import java.util.*;

public class AscDescSequenceSearch {

	public static void main(String[] argv) {
		int[] input = {88,89,90,120,110,108,107};
		int[] input1 = {88,89,90,120,1,2,3};
		AscDescSequenceSearch adss = new AscDescSequenceSearch();
		System.out.println(adss.search(input));
		System.out.println(adss.search(input1));
	}
	public int search(int[] input) {
		if (input == null || input.length==0)
			throw new IllegalArgumentException("Invalid parameter values");
		int left = 0;
		int right = input.length-1;

		return helper(input, left,right);
	}

	public int helper(int[] input, int left, int right) {


		int middle = left + (right-left)/2;
		if ((middle==0 || input[middle-1] <= input[middle])
		 && (middle==input.length-1 || input[middle] >= input[middle+1])) {
			return input[middle];
		} else if (middle > 0 && input[middle] > input[middle-1])
			return helper(input, middle,right);
		else 
			return helper(input,left,middle-1);

	}
}