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
	
	static long swapBitsMod(long n, int srcIndex, int destIndex ) {
		byte firstBit = (byte)((n>>>srcIndex) & 1L);
		byte secondBit = (byte)((n>>>destIndex) & 1L);
		if (firstBit != secondBit) {
			n = n ^ ~(secondBit << srcIndex);
			n = n ^ ~(firstBit << srcIndex);
			
		}
		return n;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(swapBits(scanner.nextLong(), 6, 1));
		System.out.println(swapBitsMod(scanner.nextLong(), 6, 1));
		scanner.close();
	}

}
