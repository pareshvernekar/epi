package sample.epi.bruteforce;

import java.util.Scanner;

public class SwapBitsSecondEffort {

	public static long swapBits(long n, int srcIndex, int toIndex) {
		long result = n;
		
		long srcNum = (long)(Math.pow(2, srcIndex));
		long toNum = (long) (Math.pow(2, toIndex));
		srcNum = n & srcNum;
		toNum = n & toNum;
		
		if ((srcNum != 0 && toNum == 0) || 
				(srcNum == 0 && toNum != 0)) {
			//swap
			srcNum = (long)(Math.pow(2, srcIndex));
			 toNum = (long) (Math.pow(2, toIndex));
			result ^=srcNum;
			result	^=toNum;
		}
		
		return result;
	}
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		System.out.println(swapBits(n,6, 1));
		scanner.close();
	}
}
