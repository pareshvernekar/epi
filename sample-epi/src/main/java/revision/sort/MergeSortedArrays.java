package revision.sort;
import java.util.*;

public class MergeSortedArrays {
	

	public int[] merge(int[] src, int[] dest, int i, int j) {

		if (src == null && dest ==  null)
			throw new IllegalArgumentException("Invalid parameters");
		if (src == null && dest != null)
			return dest;
		else if (src != null && dest == null)
			return src;
		int k = dest.length-1;
		while (i >=0 && j >=0) {
			if (src[i] > dest[j]) {
				dest[k--]=src[i--];
			} else if (src[i] < dest[j]) {
				dest[k--]=dest[j--];
			} else {
				dest[k--]=dest[j--];
				dest[k--]=src[i--];
			}
		}
		while (i>=0) {
			dest[k--]=src[i--];
		}
		while (j>=0) {
			dest[k--]=dest[j--];
		}
		return dest;
	}

	public static void main(String[] argv) {
		int[] a1={5,13,17};
		int[] a2={3,7,11,19};
		int[] dest = new int[a1.length+a2.length];
		System.arraycopy(a1,0,dest,0,a1.length);
		MergeSortedArrays msa = new MergeSortedArrays();
		msa.merge(a2,dest,a2.length-1,a1.length-1);
		for (int i=0;i<dest.length;i++) {
			System.out.print(dest[i]); System.out.print("\t");
		}
		System.out.println();
	}
}