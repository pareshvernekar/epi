package sample.epi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberParity {
	
	static Map<Integer,Byte> parityMap = new HashMap(65536);
	
	static {
		System.out.println("Started with initial compute");
		parityMap.put(0, (byte)0);
		for (int i = 1;i<=65536;i++) {
			parityMap.put(i, checkByLowestOneBitNonMod(i));
		}
		System.out.println("Done with initial compute");
	}

	static int computeByMask(long n) {
		int BIT_MASK= 0xFFFF;
		
		int result=(int)Math.pow(2,3)*(int)parityMap.get((int)((n>>>48)&BIT_MASK))
		
				+ (int)Math.pow(2,2)*(int)parityMap.get((int)((n>>>32)&BIT_MASK))
		
				+ (int)Math.pow(2,1)*(int)parityMap.get((int)((n>>>16)&BIT_MASK))
				+ (int)Math.pow(2,0)*(int)parityMap.get((int)(n&BIT_MASK)); 
		return checkByLowestOneBit(result);
	}	
	
	//O(n)
	static int bruteForce(long n) {
		int count =0; long result = 0;
		while (n != 0) {
			result = n & 1;
			if (result == 1)
				count+=1;
			n>>>=1;
			
		}
		
		return count%2;
	}
	
	//O(k) - k = number of 1 bits  
	static int checkByLowestOneBit(long n) {

		byte count = 0;
		while (n != 0) {
			n&= n-1;
			count+=1;
		}
		return (int)(count % 2);
	}
	
	static byte checkByLowestOneBitNonMod(long n) {
		System.out.println("Calculating:"+n);
		byte count = 0;
		while (n != 0) {
			count^=1;
			n&= n-1;
			
		}
		return count;
	}
	
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		if (bruteForce(n) == 0)
			System.out.println(n +" had even parity:bruteForce");
		else
			System.out.println(n +" had odd parity:bruteForce");
		if (checkByLowestOneBit(n) == 0)
			System.out.println(n +" had even parity:checkByLowestOneBit");
		else
			System.out.println(n +" had odd parity:checkByLowestOneBit");
		
		if (checkByLowestOneBitNonMod(n) == 0)
			System.out.println(n +" had even parity:checkByLowestOneBitNonMod");
		else
			System.out.println(n +" had odd parity:checkByLowestOneBitNonMod");
		
		
		if (computeByMask(n) == 0)
			System.out.println(n +" had even parity:computeByMask");
		else
			System.out.println(n +" had odd parity:computeByMask");
		
		scanner.close();
	}
	
}
