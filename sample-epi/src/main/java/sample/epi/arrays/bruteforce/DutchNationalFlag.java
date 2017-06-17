package sample.epi.arrays.bruteforce;
import java.util.*;


public class DutchNationalFlag {


	public static void rearrange(int[] arr, int index) {
		if (arr == null || index  < 0 || index > arr.length-1)
			throw new IllegalArgumentException("Invalid parameter values");
		int len = arr.length;
		if (len <= 1)
			return;
		int temp = 0;
		int pivot = arr[index];
		for (int i=0;i<len-1;i++) {
			for (int j=i+1;j<len;j++) {
				if (arr[j] < pivot) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					break;
				}

			}
		}
		for (int i=len-1;i>0 && arr[i]>=pivot;i--) {

			for (int j=i-1;j>=0 && arr[j]>=pivot;j--) {

				if (arr[j] > pivot) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					break;
				}
			}
		}
	}

	public static void improvedRearrange(int[] arr, int index) {
		if (arr == null || index  < 0 || index > arr.length-1)
			throw new IllegalArgumentException("Invalid parameter values");
		int len = arr.length;
		if (len <= 1)
			return;
		int temp = 0;
		int pivot = arr[index];
		int i =0, equal = 0, j = len -1;
		while ( equal < j) {

			if (arr[equal] < pivot) {
				temp = arr[equal];
				arr[equal++]=arr[i];
				arr[i++]=temp;
			} else if (arr[equal] == pivot) {
				equal++;
			} else {
				temp=arr[equal];
				arr[equal]=arr[j];
				arr[j--]=temp;
			}
			System.out.println(i+"::"+equal+":"+j);
		System.out.println(toString(arr));
		}
	}
	public static String toString(int[] data) {
		int N = data.length;
		StringBuilder strBuilder = new StringBuilder();
		for (int i=0;i<N;i++) {
			strBuilder.append(data[i]).append(",");
		
		}
		return strBuilder.toString();
	}
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] data = new int[N];
		for (int i=0;i<N;i++) {
			data[i]=scanner.nextInt();
		}
		int index = scanner.nextInt();
		improvedRearrange(data,index);
		
		scanner.close();
	}
}