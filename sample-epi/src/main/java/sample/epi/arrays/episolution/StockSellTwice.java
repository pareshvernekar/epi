package sample.epi.arrays.episolution;
import java.util.*;

public class StockSellTwice {
	
	public static Double maxProfit(List<Double> prices) {
		double minPrice = Double.MAX_VALUE;
		double maxProfit = 0.0d;
		int len = prices.size();
		List<Double> maxProfitSoFar = new ArrayList<>();
		for (int i=0;i<len;i++) {
			minPrice = Math.min(minPrice,prices.get(i));
			maxProfit = Math.max(maxProfit, prices.get(i)-minPrice);
			maxProfitSoFar.add(maxProfit);
		}
		double maxPrice = Double.MIN_VALUE;
		for (int i=len-1;i>0;i--) {
			maxPrice = Math.max(maxPrice,prices.get(i));
			maxProfit = Math.max(maxProfit, maxPrice-prices.get(i)+maxProfitSoFar.get(i-1));
		}
		return maxProfit;

	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		List<Double> prices = new ArrayList<>();
		for (int i=0;i<N;i++) {
			prices.add(scanner.nextDouble());
		}
		System.out.println("MAXPROFIT:"+maxProfit(prices));
		scanner.close();
	}
}