package sample.epi.bruteforce;

import java.util.Scanner;

public class ReverseBits {
	
	
	public static long reverseBits(long n) {
		int count = 0;
		long currValue = 0;
		long result = 0;
		while (count < 64) {
			currValue = ((n >>> count) & 1);
			result |= currValue << (63 - count);
			count++;
		}
		return result;
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		System.out.println("After reverse:"+reverseBits(n));
		scanner.close();
	}
	
}
