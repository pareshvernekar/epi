package sample.epi.arrays.bruteforce;
import java.util.*;
/*
* Given an array of integers, arrange such that even numbers are first
*/
public class EvenOddArrayArrange {

	public static void rearrange(int[] arr) {
		int i=0;
		int len = arr.length-1;
		int k = len;
		int temp = 0;
		while (i < k) {
			while (i <= len && arr[i]%2==0 ) {
				i+=1;		//scan even elements, till u find odd element
			}
			while ( k >=0 && arr[k]%2 != 0 ) {
				k-=1;		//scan odd elements, till u find even element
			}
			if (i < k) {
			temp=arr[i];
			arr[i]=arr[k];
			arr[k]=temp;
			temp=0;
		}+

		}
	}
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i]=scanner.nextInt();
		}
		rearrange(arr);
		for (int i=0;i<N;i++) {
			System.out.print(arr[i]+",");
		}
		scanner.close();
	}

}