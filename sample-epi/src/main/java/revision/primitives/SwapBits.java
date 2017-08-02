package revision.primitives;

import java.util.*;


//swap bits in the ith and jth position
public class SwapBits {
	

	public int swap(int n, int i, int j) {
		if (((n>>>i-1) & 1) != ((n>>>j-1) & 1) ) {
			
			int BIT_MASK = 1 << i-1 | 1 << j-1;
			n = n ^ BIT_MASK;
		}
		return n;
	}

	public static void main(String[] argv) {

		int i1 = 7;	//111 -- no change
		int i2 = 4;	//100 - change to 1

		SwapBits sb = new SwapBits();
		System.out.println(" SWAP 7:"+sb.swap(i1,1,3));
		System.out.println(" SWAP 4:"+sb.swap(i2,1,3));
	}
}