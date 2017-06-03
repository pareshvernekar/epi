package sample.epi.bruteforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseBits {
	
	static Map<Long,Long> reverseMap = new HashMap<>();
	
	static {
		for (long i=0;i<65536;i++) {
			reverseMap.put(i, reverseBitsMod(i));
		}
	}
	
	public static long reverseBitsCache(long n) {
		
		int BIT_MASK=0xFFFF;
		return (reverseMap.get(n&BIT_MASK)<<48)|
		(reverseMap.get((n>>>16) & BIT_MASK)<<32)|
		(reverseMap.get((n>>>32) & BIT_MASK)<< 16)|
		(reverseMap.get((n>>>64) & BIT_MASK));
		
		
	}
	
	public static long reverseBitsMod(long n) {
		int start=0, end = 63;
		long mask = 0L;
		while (start < end) {
			if (((n >>> end)&1L) != ((n>>> start) & 1L)) {
				mask = 1L << end | 1L << start;
				n^=mask;
			}
			start++;
			end--;

		}
		return n;
	}
	
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
		System.out.println("After reverse modified:"+reverseBitsMod(n));
		System.out.println("After reverse cache:"+reverseBitsCache(n));
		scanner.close();
	}
	
}
