package  sample.epi.arrays.bruteforce;

import java.util.*;

public class StockSell {
	
	public static int maxProfit(int[] arr) {
		if (arr == null || arr.length==0)
			throw new IllegalArgumentException("Invalid paramter values");
		int len = arr.length;
		int buyPos = 0, sellPos = len-1;
		int maxProfit = arr[sellPos]-arr[buyPos];
		int i = 1, j = len-2;

		while (i < j) {
			if (arr[i] < arr[buyPos]) {
				buyPos  = i;
			}
			i+=1;

			if (arr[j] > arr[sellPos]) {
				sellPos  = j;
			}
			j-=1;
			maxProfit = arr[sellPos]-arr[buyPos];
		}
		System.out.println("Buy:"+arr[buyPos]+"::Buy::"+arr[sellPos]);
		return maxProfit>0?maxProfit:0;
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] stocks = new int[N];
		for (int i=0;i<N;i++) {
			stocks[i]=scanner.nextInt();
		}
		System.out.println("MaximizeProfit:"+maxProfit(stocks));
		scanner.close();
	}
}