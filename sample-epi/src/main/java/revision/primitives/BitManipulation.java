package revision.primitives;

import java.util.*;

public class BitManipulation {

	int BIT_MASK=0XFFFF;

	int[] reverseArr = new int[140];
	public long reverseBits(long input) {
		return 
			reverseArr[(int)(input & BIT_MASK)] << 48 |
			reverseArr[(int)(input >>> 16 & BIT_MASK)] << 32 |
			reverseArr[(int)(input >>> 32 & BIT_MASK)] << 16|
			reverseArr[(int)(input >>> 48 & BIT_MASK)] ;

	}	

	private void buildReverseArray() {

		int i = 0, j = 15;
		int BIT_MASK=0;
		int count=0;
		for (int k=0;k<140;k++) {
			count=k;
			while (i < j) {

				if (((count>>>j) & 1) != ((count>>>i) & 1)) {
					BIT_MASK=1<<j | 1<<i;
					count^=BIT_MASK;
				}
				i++;
				j--;
			}
			System.out.println("k:"+k+"::"+count);
			reverseArr[k]=count;
			i = 0; j = 63;
		}

	}

	public static void main(String[] argv) {

		long ip1 = 128;	
		BitManipulation bm = new BitManipulation();
		bm.buildReverseArray();
		System.out.println("Reverse 128:"+bm.reverseBits(ip1));

	}
}