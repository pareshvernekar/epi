package revision.dp;
import java.util.*;

/*
*	http://www.geeksforgeeks.org/longest-increasing-subsequence/
*/

public class LISSDP {


	public int process(int[] input) {
		if (input == null || input.length==0)
			return 0;

		int[] len = new int[input.length];
		len[0]=1;
		for (int i=1;i<input.length;i++) {
			if (input[i]>input[i-1])
				len[i]=len[i-1]+1;
			else
				len[i]=len[i-1];
		}
		return len[input.length-1];
	}
	
	public static void main(String[] argv) {
		int[] input1 = {10,22,9,33,21,50,41,60,80};
		LISSDP l = new LISSDP();
		System.out.println(l.process(input1));
		int[] input2 = {3,10,2,1,20};
		System.out.println(l.process(input2));
		int[] input3 = {0};
		System.out.println(l.process(input3));
	}

}