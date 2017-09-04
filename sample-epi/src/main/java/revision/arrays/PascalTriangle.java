package revision.arrays;

import java.util.*;
public class PascalTriangle {
	
	public List<List<Integer>> compute (int n) {

		List<List<Integer>> results = new ArrayList<>();
		results.add(Arrays.asList(1));
		results.add(Arrays.asList(1,1));
		for (int i=2;i<n;i++) {
			List<Integer> prev = results.get(i-1);
			List<Integer> inter = new ArrayList();
			inter.add(1);
			for (int j=0;j<prev.size()-1;j++) {
				inter.add(prev.get(j)+prev.get(j+1));
			}
			inter.add(1);
			results.add(inter);
		}
		return results;
	}

	public static void main(String[] argv) {
		PascalTriangle pt = new PascalTriangle();
		List<List<Integer>> results = pt.compute(5);
		for (List<Integer> inter: results) {
			for(Integer i:inter) {
				System.out.print(i);System.out.print("\t");
			}
			System.out.println();
		}

	}
}