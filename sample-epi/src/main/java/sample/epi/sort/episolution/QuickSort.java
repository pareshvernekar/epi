package sample.epi.sort.episolution;

import java.util.*;

public class QuickSort {
	

	public void sort(int[] input) {

		quickSort(input,0,input.length-1);
	}

	public void quickSort(int[] input, int low, int high) {

		int len = input.length;

		if (low < high) {
			int pivot = partition(input, low,high);
			for (int i =0;i<len;i++) {
				System.out.print(input[i]);System.out.print("\t");
			}
		System.out.println();
			quickSort(input,low,pivot-1);
			quickSort(input,pivot+1,high);
		}
	}

	public int partition(int[] input, int low , int high) {


		int pivot = input[high];
		int i = low -1 ;
		for (int j = low;j<=high-1;j++) {

			if (input[j] <=  pivot) {

				i+=1;
				int temp=input[i];
				input[i]=input[j];
				input[j]=temp;
			}

		}
		i+=1;
		int temp = input[i];
		input[i]=input[high];
		input[high]=temp;
		return i;

	}

	public static void main(String[] argv) {

		int[] input = {10, 80, 30, 90, 40, 50, 70};
		int len = input.length;
		QuickSort qa = new QuickSort();
		qa.sort(input);
		for (int i =0;i<len;i++) {
			System.out.print(input[i]);System.out.print("\t");
		}
		System.out.println();
	}

}