package sample.epi.bruteforce;

import java.util.Scanner;

public class ReverseBitsBytes {
	
	
	public static int reverseBits(byte n) {
		int count = 0;
		int currValue = 0;
		int result = 0;
		while (count < 8) {
			currValue = (byte)((n >>> count) & 1);
			result |= currValue << (7 - count);
			count++;
		}
		return result;
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		byte n = scanner.nextByte();
		int i = 0;
	//	System.out.println( i |= 1<<7);
		System.out.println("After reverse:"+reverseBits(n));
		scanner.close();
	}
	
}
