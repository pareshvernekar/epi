package sample.epi.search.bruteforce;

import java.util.*;

public class FindMinMaxSimul {


	public int[] findMinMax(int[] input) {

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		if (input == null || input.length==0) return new int[]{-1,-1};
		if (input.length==1) return new int[]{input[0],input[0]};
		int len = input.length;
		for (int i = 0;i<len;i++) {
			min = Math.min(min,input[i]);
			max = Math.max(max,input[i]);
		}
		return new int[]{min,max};
	}
	
	public static void main(String[] argv) {

			int[] input = new int[]{3,2,5,1,2,4};

			FindMinMaxSimul fMMS = new  FindMinMaxSimul();
			int[] result = fMMS.findMinMax(input);
			System.out.println("Min:"+result[0]+":Max:"+result[1]);
	}
}