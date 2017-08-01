package revision.sort;

import java.util.*;

public class SortPractise<T extends Comparable<T>> {


	public T[] selectionSort(T[] input) {

		if (input == null || input.length==0)
			return input;

		int len = input.length;

		T currMin = null;
		int minPos = -1;

		for (int i=0;i<len-1;i++) {

			int j = i+1;
			minPos = i;
			currMin = input[i];
			while (j < len) {
				if (currMin.compareTo(input[j]) > 0) {
					minPos = j;
					currMin=input[j];
				}
				j++;
			}
			if (i != minPos) {
				T temp = input[i];
				input[i]=input[minPos];
				input[minPos]=temp;
			}

		}
		return input;
	}

	public T[] insertionSort(T[] input) {


		if (input == null || input.length==0)
			return input;

		int len = input.length;

		for (int i =1;i<len;i++) {

			int j = i-1;
			T temp = input[i];
			while (j>=0 && input[j].compareTo(temp) > 0 ) {
				input[j+1]=input[j];
				j--;
			}
			input[j+1]=temp;
		}

		return input;
	}
	
	public static void main(String[] argv) {

		Integer[] input = {10,8,8,9,6,7,3,4,2,1,0};
		SortPractise<Integer> sp = new SortPractise<>();
		sp.selectionSort(input);
		String result = sp.getPrintableString(input);
		System.out.println("Selection Sort:"+result);

		Integer[]  input1 = {10,8,7,9,6,7,3,4,2,1,0};

		sp.insertionSort(input1);
		String result1 = sp.getPrintableString(input1);
		System.out.println("Insertion Sort:"+result1);

	}

	private String getPrintableString(T[] input) {

		if (input == null || input.length==0)
			return "";

		int len = input.length;

		StringBuilder strBuilder = new StringBuilder();
		for (int i =0;i<len;i++) {
			if (strBuilder.length() == 0) {
				strBuilder.append(input[i].toString());
			} else {
				strBuilder.append(","+input[i].toString());
			}
		}
		return strBuilder.toString();

	}
}