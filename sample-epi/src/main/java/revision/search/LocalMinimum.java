package revision.search;

import java.util.*;

public class LocalMinimum {
	

	public static int localMinima(int[] arr, int left, int right) {
		int mid = left +(right-left)/2;

		if ((mid ==0 || arr[mid-1] >= arr[mid]) && 
			(mid==arr.length-1 || arr[mid] <=arr[mid+1])) 
			return mid;
		else if (mid > 0 && arr[mid] < arr[mid-1])
			return localMinima(arr,left, mid-1);
		else
			return localMinima(arr,mid+1,right);
	} 

	public static void main(String[] argv) {

		int[] arr = {20,10,4,2,3,5,16,17};

		System.out.println("localMinima:"+(localMinima(arr,0,arr.length-1)));

		int[] arr1 = {4, 3, 1, 14, 16, 40};
		System.out.println("localMinima:"+(localMinima(arr1,0,arr1.length-1)));
	}
}