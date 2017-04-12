package sample.epi.bruteforce;

public class MaximizeProfit {

	public static void main(String[] argv) {
		double[] L = {2.5,5.6,3.5,8.5,4.5,3.5,9.5,11};
		double[] H = {3.5,7.1,4.0,9,5.5,12.5,13,14};
		double[] S = {3.0,6.1,3.75,8.5,5.0,6,12,12};
		
		int n = S.length;
		double maxProfit = 0.0;
		for (int i=0;i<n-1;i++) {
			double buy = S[i];
			for (int j = i+1;j<n;j++) {
				double sell = S[j];
				if ((sell - buy) > maxProfit)
					maxProfit = (sell - buy);
			}
		}
		System.out.println("Max profit:"+maxProfit);
	}
	
}
