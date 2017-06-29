package sample.epi.arrays.episolution;

import java.util.*;

public class ApplyPermutation {

	public static void permutate(int[] data, int[] perm) {

		if (data==null || perm == null)
			throw new IllegalArgumentException("Invalid parameter values");
		int len = data.length;
		int tempPos = 0;
		for (int i=0;i<len;i++) {
			tempPos = i;
			while (perm[tempPos] > 0) {
				int tempVal = data[perm[tempPos]];
				data[perm[tempPos]]=data[i];
				data[i]=tempVal;
				int next = perm[tempPos];
				perm[tempPos]=perm[tempPos]-len;
				tempPos = next;
			}

		}

	}
	
	public static String toString(int[] data) {
		if (data==null || data.length==0)
			return "NULL";
		StringBuilder strBuilder = new StringBuilder();
		int len = data.length;
		for (int i=0;i<len;i++) {
			if (strBuilder.length()==0)
				strBuilder.append(data[i]);
			else
				strBuilder.append(","+data[i]);
		}
		return strBuilder.toString();
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N1 = scanner.nextInt();
		int[] arr = new int[N1];
		int[] perm = new int[N1];
		for (int i=0;i<N1;i++) {
			arr[i]=scanner.nextInt();
		}

		for (int i=0;i<N1;i++) {
			perm[i]=scanner.nextInt();
		}
		System.out.println("BEFORE PERM:"+toString(arr));
		permutate(arr,perm);
		System.out.println("AFTER PERM:"+toString(arr));
		
		scanner.close();
	}
}
