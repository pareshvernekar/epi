package revision.arrays;

import java.util.*;

public class ArrayIncrement {
	
	public List<Integer> increment(List<Integer> input) {
		int len = input.size() -1 ;
		input.set(len, input.get(len)+1);
		for (int i=len;i > 0 && input.get(i)==10;i--) {

			input.set(i,0);
			input.set(i-1,input.get(i-1)+1);
		}
		if (input.get(0)==10) {
			input.set(0,0);
			input.add(0,1);
		}
		return input;
	}

	public static void main(String[] argv) {
		ArrayIncrement ai = new ArrayIncrement();
		List<Integer> input = Arrays.asList(1,3,0);
		input = ai.increment(input);
		for (Integer i:input) {
			System.out.print(i);System.out.print("\t");
		}
	}
}