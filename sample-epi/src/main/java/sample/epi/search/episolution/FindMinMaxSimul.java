package sample.epi.search.episolution;

import java.util.*;

public class FindMinMaxSimul {


	public int[] findMinMax(int[] input) {

		int globalMin = Integer.MAX_VALUE, globalMax = Integer.MIN_VALUE;
		if (input == null || input.length==0) return new int[]{-1,-1};
		if (input.length==1) return new int[]{input[0],input[0]};

		int len = input.length;
		
		if (input[0] > input[1]) {
			globalMin 	= 	input[1];
			globalMax	=	input[0];
		} else {
			globalMin	=	input[0];
			globalMax	=	input[1];
		}

		for (int i = 2;i+1<len;i=i+2) {
			if (input[i] > input[i+1]) {
				globalMax = Math.max(input[i],globalMax);
				globalMin = Math.min(input[i+1],globalMin);
			} else {
				globalMax = Math.max(input[i+1],globalMax);
				globalMin = Math.min(input[i],globalMin);
			}
		}
		if (len %2 != 0) {
			globalMax = Math.max(input[len-1],globalMax);
			globalMin = Math.min(input[len-1],globalMin);
		}
		return new int[]{globalMin,globalMax};
	}
	
	public static void main(String[] argv) {

			int[] input = new int[]{3,2,5,1,2,4};

			FindMinMaxSimul fMMS = new  FindMinMaxSimul();
			int[] result = fMMS.findMinMax(input);
			System.out.println("Min:"+result[0]+":Max:"+result[1]);
	}
}