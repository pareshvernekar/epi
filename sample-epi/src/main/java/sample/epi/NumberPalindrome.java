package sample.epi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberPalindrome {

	static List<Integer> digitList = new ArrayList<>();
	
	static boolean isPalindrome(long n) {
		if (n <= 0)
			return Boolean.FALSE;
		long reverse = reverse(n);
		return (n==reverse);
	}
	
	static boolean isPalindromeMod(long n) {
		if (n <= 0)
			return Boolean.FALSE;
		int lsb = 0, msb=0;
		while (n > 9) {
			msb=getMostSignificantBit(n);
			n=n - (msb * (long)Math.pow(10,getBase10Log(n)));
			System.out.println(n);
			lsb=getLeastSignificantBit(n);
			n=(n-lsb)/10;
			if (msb != lsb) 
				return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	
	static int getMostSignificantBit(long n) {
		return (int)(n/ Math.pow(10,getBase10Log(n)));
	}
	
	static int getLeastSignificantBit(long n) {
		return (int)n%10;
	}
	
	private static int getBase10Log(long n) {
		return (int)Math.log10(n);
	}
	
	static long reverse(long n) {
		long result = 0;
		while (n != 0) {
			result = (result*10)+(n%10);
			n/=10;
		}
		return result;
	}
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();		
		System.out.println("isPalindrome:"+isPalindrome(n));
		System.out.println("isPalindrome:"+isPalindromeMod(n));
		

	}
}
