package revision.primitives;

import java.util.*;

public class ComputeParity {


	int[] parityCache = new int[65536];
	

	/*
	*	Right shift number 1 at a time and keep a count of 1. If odd parity is 1 else parity is 0
	* O(n)
	*/
	public int parityMethod1(long input) {

		int result = 0;

		while (input != 0) {
			result = (input & 1) ==1? result+1:result;
			input>>>=1;
		}
		return (result%2);
	}

	/*
	*	Compute parity by unsetting the last set bit at each operation
	*  O(k) - k is number of 1 bits
	*
	*/

	public int parityMethod2(long input) {

		int result = 0;

		while (input != 0) {
			input = input & (input-1);
			result^=1;
		}
		return (result);
	}


	/*
	* Compute and store parity of all numbers from 0 - 65535
	* Use bit mask to get the parity of each 16 bit section of a 64 bit number
	* XOR the parity to get the parity of the 64 bit number
	* O(1)
	*/
	public int parityMethod3(long input) {

		int result = 0;
		int BIT_MASK=0xFFFF;
		result = parityCache[(int)(input>>>48&(BIT_MASK))] ^
				parityCache[(int)(input>>>32&(BIT_MASK))] ^
				parityCache[(int)(input>>>16&(BIT_MASK))] ^
				parityCache[(int)(input&(BIT_MASK))] ;	
		return (result);
	}

	private void cacheParity() {

		for (int i=0;i<parityCache.length;i++) {
			parityCache[i]=parityMethod2(i);
		}
	}


	public static void main(String[] argv) {

		long l1 = 4;
		long l2 = 3;
		long l3 = 7;
		long l4 = 274859901;
		long l5 = 128;
		long l6 = 6;
		ComputeParity cp = new ComputeParity();
		System.out.println("Method1:4:"+cp.parityMethod1(l1));
		System.out.println("Method1:3:"+cp.parityMethod1(l2));
		System.out.println("Method1:7:"+cp.parityMethod1(l3));
		System.out.println("Method1:274859901:"+cp.parityMethod1(l4));
		System.out.println("Method1:128:"+cp.parityMethod1(l5));
		System.out.println("Method1:6:"+cp.parityMethod1(l6));
		System.out.println("**************************");
		System.out.println("Method2:4:"+cp.parityMethod2(l1));
		System.out.println("Method2:3:"+cp.parityMethod2(l2));
		System.out.println("Method2:7:"+cp.parityMethod2(l3));
		System.out.println("Method2:274859901:"+cp.parityMethod2(l4));
		System.out.println("Method2:128:"+cp.parityMethod2(l5));
		System.out.println("Method2:6:"+cp.parityMethod2(l6));
		cp.cacheParity();

		System.out.println("**************************");
		System.out.println("Method3:4:"+cp.parityMethod3(l1));
		System.out.println("Method3:3:"+cp.parityMethod3(l2));
		System.out.println("Method3:7:"+cp.parityMethod3(l3));
		System.out.println("Method3:274859901:"+cp.parityMethod3(l4));
		System.out.println("Method3:128:"+cp.parityMethod3(l5));
		System.out.println("Method3:6:"+cp.parityMethod3(l6)); 

	}
}