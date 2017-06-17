package sample.epi.arrays.bruteforce;

import java.util.*;

public class ArrayAdvance {

	public static boolean canAdvance(int[] arr) {

		if (arr==null || arr.length==0) {
			throw new IllegalArgumentException("Invalid argument values");
		}
		int len = arr.length;
		if (arr[0] <= 0 )
			return Boolean.FALSE;
		int counter = 0;
		for (int i=len-1;i>=0;i--) {
			if (arr[i]==0) {
				counter+=1;
				continue;
			}
			if (arr[i]>counter) {
				counter=0;
			} else {
				counter+=1;
			}

		}
		return (counter==0);
	}

	public static void main(String[] argv) {
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