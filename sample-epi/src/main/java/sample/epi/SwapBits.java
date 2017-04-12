package sample.epi;

import java.util.Scanner;

public class SwapBits {

	static long swapBits(long n, int srcIndex, int destIndex ) {
		if (((n >>> srcIndex) & 1L) != ((n >>> destIndex) & 1L)) {
			long bitMask = (1L << srcIndex) | (1L << destIndex);
			n^=bitMask;
		}
		return n;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(swapBits(scanner.nextLong(), 6, 1));
		scanner.close();
	}

}
