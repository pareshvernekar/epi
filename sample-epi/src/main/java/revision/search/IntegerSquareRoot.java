package revision.search;

import java.util.*;

public class IntegerSquareRoot {
	
	public static void main(String[] argv) {
		IntegerSquareRoot isr = new IntegerSquareRoot();
		System.out.println(isr.sqrt(64));
		System.out.println(isr.sqrt(25));	
	}

	public int sqrt(int n) {
		if (n <=0 )
			return n;
		int left = 1;
		int right=n;
		while (left <=right) {
			int mid = left + (right-left)/2;
			if (mid==n/mid)
				return mid;
			else if (mid > n/mid)
				right=mid-1;
			else 
				left=mid+1;
		}
		return left;
	}
}