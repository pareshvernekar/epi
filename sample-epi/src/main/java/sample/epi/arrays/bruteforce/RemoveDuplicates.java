package sample.epi.arrays.bruteforce;

import java.util.*;

//Remove duplicates from a sorted array and shift all elements to left
public class RemoveDuplicates {
	
	/*
	if (arr[i] != currMax) {
				currMax=arr[i];
				if (currZeroPos >= 0) {
					temp = arr[i];
					arr[i]=0;
					arr[currZeroPos]=temp;
					currZeroPos=i;
				}
			} else {
				arr[i]=0;
				currZeroPos = i;
			}
*/
	public static int removeDuplicates(int[] arr) {

		int currMax = arr[0];
		int currZeroPos = -1;
		int temp = 0;
		int validElements = arr.length;
		for (int i=1;i<arr.length;i++) {
			if (arr[i]==0)
				continue;
			if (currMax == arr[i]) {
				arr[i]=0;
				validElements--;
				if (currZeroPos==-1) {
					currZeroPos = i;
				}
			} else {
				currMax=arr[i];
				if (currZeroPos!=-1) {
					arr[currZeroPos]=arr[i];
					arr[i]=0;
					currZeroPos+=1;	
				}
			}
		}
		System.out.println(toString(arr));
		return validElements;
	}

	public static String toString(int[] data) {
		if (data==null || data.length==0)
			return "NULL";
		StringBuilder strBuilder = new StringBuilder();
		int len = data.length;
		for (int i=0;i<len;i++) {
			if (strBuilder.length()==0)
				strBuilder.append(data[i]);
			else
				strBuilder.append(","+data[i]);
		}
		return strBuilder.toString();
	}
	public static void main(String[] argv) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Valid Elements:"+removeDuplicates(arr));
		scanner.close();
	}
}