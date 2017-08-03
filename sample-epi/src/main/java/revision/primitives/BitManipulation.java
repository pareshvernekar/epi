package revision.primitives;

import java.util.*;

public class BitManipulation {

	int BIT_MASK=0XFFFF;

	int[] reverseArr = new int[65536];
	public long reverseBits(long input) {

		return 
			reverseArr[(int)(input & BIT_MASK)] << 48 |
			reverseArr[(int)(input >>> 16 & BIT_MASK)] << 32 |
			reverseArr[(int)(input >>> 32 & BIT_MASK)] << 16|
			reverseArr[(int)(input >>> 48 & BIT_MASK)] ;

	}	


	public long multiply (long x, long y) {

		long result = 0;

		while (x != 0) {
			if ( (x & 1) != 0) {
				result=add(result,y);
				System.out.println("result:"+result);
			}
			x >>>=1;
			y <<= 1;
			
		}

		return result;
	}


	public long add(long a, long b) {

		long sum = 0, k = 1, tempa=a, tempb=b, carryin = 0;
		while (tempa != 0 || tempb != 0) {

				long ak = (a & k); 
				long bk = (b & k);
				long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
				sum |= ak ^ bk ^ carryin;
				carryin = carryout << 1;
				k <<= 1;
				tempa>>>=1;
				tempb>>>=1;

		}

		return sum | carryin;
	}

	private void buildReverseArray() {

		int i = 0, j = 15;
		int BIT_MASK=0;

		for (int k=0;k<140;k++) {
			int b = 0;
			int count = k;
			while (count != 0) {
				b <<=1;
				b|=(count&1);
				count>>>=1;
			}
			reverseArr[k]=b;
						
		}

	}

	public long reverseNumber(long n) {


		long result = 0;

		boolean isNegative = n < 0? Boolean.TRUE:Boolean.FALSE;
		if (isNegative)
			n=Math.abs(n);

		while (n != 0) {

			result = (result*10)+(n%10);
			n=n/10;
		}
		return (isNegative?(-1)*result:result);

	}

	public Boolean isPalindrome(long n) {

		if (n <= 0)
			return Boolean.FALSE;

		
		while (n > 10) {
			int pow = (int)Math.log10((double)n);
			int n1 = (int)(n/(int)Math.pow(10,pow));
			int n2 = (int)n%10;
			if (n1 != n2)
				return Boolean.FALSE;
			n=n%(int)Math.pow(10,pow);
			n=n/10;
		}
		
		return Boolean.TRUE;
	}


	public static void main(String[] argv) {

		long ip1 = 13;	
		long ip2 = 543;
		long ip3 = -119;
		long ip4 = 343;
		long ip5 = 1221;
		BitManipulation bm = new BitManipulation();
		bm.buildReverseArray();
		System.out.println("Reverse bitwise 11:"+bm.reverseBits(ip1));

		System.out.println("Reverse Number 13:"+bm.reverseNumber(ip1));

		System.out.println("Reverse Number 543:"+bm.reverseNumber(ip2));
		System.out.println("Reverse Number -119:"+bm.reverseNumber(ip3));

		System.out.println("Palindrome:0:"+bm.isPalindrome(0));
		System.out.println("Palindrome:543"+bm.isPalindrome(ip2));
		System.out.println("Palindrome:--119"+bm.isPalindrome(ip3));
		System.out.println("Palindrome:343"+bm.isPalindrome(ip4));
		System.out.println("Palindrome:1221"+bm.isPalindrome(ip5));

		System.out.println("Multiply:3*11:::"+bm.multiply(3,11));
		

	}
}