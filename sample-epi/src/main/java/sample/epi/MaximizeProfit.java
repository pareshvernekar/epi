package sample.epi;

public class MaximizeProfit {

	public static void main(String[] argv) {
		double[] L = {2.5,5.6,3.5,8.5,4.5,3.5,9.5,11};
		double[] H = {3.5,7.1,4.0,9,5.5,12.5,13,14};
		double[] S = {3.0,6.1,3.75,8.5,5.0,6,12,12};
		
		double min = S[0];
		double profit = 0.0;
		int size = S.length;
		for (int i = 0;i < size;i++) {
			if (S[i] < min)
				min = S[i];
			if ((S[i]-min) > profit)
				profit = S[i]-min;
		}
		System.out.println("Profit:"+profit);
	}
	
}
