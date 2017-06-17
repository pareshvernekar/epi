package  sample.epi.arrays.episolution;

import java.util.*;

public class StockSell {
	
	public static int maxProfit(int[] arr) {
		if (arr == null || arr.length==0)
			throw new IllegalArgumentException("Invalid paramter values");
		int len = arr.length;
		int maxProfit = 0;
		int minPrice  = Integer.MAX_VALUE;
		
		for (int i=0;i<len;i++) {
			minPrice = Math.min(minPrice,arr[i]);
			maxProfit = Math.max(maxProfit,arr[i]-minPrice);
		}
		System.out.println("MINPRICE:"+minPrice);
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