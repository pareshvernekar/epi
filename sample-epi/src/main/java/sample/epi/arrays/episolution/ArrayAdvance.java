package sample.epi.arrays.episolution;

import java.util.*;

public class ArrayAdvance {


	public static boolean canAdvance(int[] arr) {
		if (arr == null || arr.length==0)
			throw new IllegalArgumentException("Invalid argument values");
		int maxPosition = 0;
		int len = arr.length-1;
		for (int i=0;i<=maxPosition && maxPosition<=len;i++) {
			maxPosition=Math.max(maxPosition,i+arr[i]);
		}
		return maxPosition>=len;

	}
	public static void main(String[] argv){

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("ADVANCE:"+canAdvance(arr));
		scanner.close();
	}
}