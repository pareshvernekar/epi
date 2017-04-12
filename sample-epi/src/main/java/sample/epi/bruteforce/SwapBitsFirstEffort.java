package sample.epi.bruteforce;

import java.util.Scanner;

public class SwapBitsFirstEffort {
	
	public static long swapBits(long i,int srcIndex, int toIndex) {
		int[] arr = new int[64];
		int result = 0;
		int index = 0;
		while (i != 0) {
			arr[index++] = (int)(i & 1L);
			i>>>=1;
		}
	/*	
		for (int j = arr.length-1;j>=0;j--) {
			System.out.print(arr[j]);
		} */
		int temp = arr[srcIndex];
		arr[srcIndex] = arr[toIndex];
		arr[toIndex] = temp;
		for (int j = 0;j < arr.length;j++) {
			result+=arr[j] * Math.pow(2, j);
		}
		return result;
	}
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		System.out.println("After swap:"+swapBits(n,6,1));
		scanner.close();
	}

}
