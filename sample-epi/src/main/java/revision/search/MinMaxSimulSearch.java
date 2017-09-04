package revision.search;
import java.util.*;

public class MinMaxSimulSearch {

	public static void main(String[] argv) {
		MinMaxSimulSearch mmss = new MinMaxSimulSearch();
		int[] input = {3,2,5,1,2,4};
		List<Integer> result = mmss.search(input);
		System.out.println(result.get(0)+"::"+result.get(1));

		result = mmss.searchMod(input);
		System.out.println(result.get(0)+"::"+result.get(1));		
	}

	public List<Integer> search(int[] input) {
		int currMin = Integer.MAX_VALUE;
		int currMax=Integer.MIN_VALUE;
		if (input == null || input.length==0)
			return null;
		for (int i=0;i<input.length;i++) {
			currMin=Integer.min(currMin,input[i]);
			currMax=Integer.max(currMax,input[i]);
		}
		return Arrays.asList(currMin,currMax);
	}

	public List<Integer> searchMod(int[] input) {
		if (input == null || input.length==0)
			return null;
		if (input.length==1)
			return Arrays.asList(input[0],input[0]);

		MinMax globalMinMax = MinMax.get(input[0],input[1]);
		for (int i=2;i+1<input.length;i+=2) {
			MinMax localMinMax = MinMax.get(input[i],input[i+1]);
			globalMinMax=new MinMax(Integer.min(localMinMax.min,globalMinMax.min), 
				Integer.max(localMinMax.max, globalMinMax.max));
		}
		if (input.length %2 != 0) {
			globalMinMax=new MinMax(Integer.min(input[input.length-1],globalMinMax.min), 
				Integer.max(input[input.length-1], globalMinMax.max));
		}

		return Arrays.asList(globalMinMax.min, globalMinMax.max);
	}
}

class MinMax {

	int min;
	int max;

	public MinMax(int min, int max) {
		this.min=min;
		this.max=max;
	} 

	public static MinMax get(int a, int b) {
		return Integer.compare(b,a) < 0? new MinMax(b,a):new MinMax(a,b);
	}

}