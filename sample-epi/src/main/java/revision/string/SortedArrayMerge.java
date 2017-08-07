package revision.string;

import java.util.*;

//Variant
//Array has sufficient space
public class SortedArrayMerge {
	
	public int[] merge(int[] a, int[] b) {

		int j = a.length-1;
		int i = 0;
		while (b[i] != 0) {
			i++;
		}
		i--;
		int k = b.length-1;

		while (k >= 0 && i >=0 && j >= 0) {
			if (i >=0 && j >= 0 && a[j] >= b[i]) {
				b[k--] = a[j--];
			} else if (j >=0){
				b[k--]=b[i--];
			}
		}
		while (j>=0) {
			b[k--]=a[j--];
		}
		while (i>=0) {
			b[k--]=b[i--];
		}
	return b;
 	}	

	public static void main(String[] argv) {


		int[] ip1 = {2,5,9,15};
		int[] ip2 = new int[9];
		ip2[0]=1;
		ip2[1]=6;
		ip2[2]=7;
		ip2[3]=12;
		ip2[4]=16;

		SortedArrayMerge sam = new SortedArrayMerge();
		ip2 = sam.merge(ip1,ip2);

		for (int i = 0 ;i < ip2.length;i++) {
			System.out.print(ip2[i]);System.out.print("\t");
		}

	}

}