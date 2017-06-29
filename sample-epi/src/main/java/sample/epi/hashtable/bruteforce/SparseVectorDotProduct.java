package sample.epi.hashtable.bruteforce;

import java.util.*;
public class SparseVectorDotProduct {
	
	public static double dotProduct(double[] arr1, double[] arr2) {
		Hashtable<Integer,Double> table1 = new Hashtable<>();
		Hashtable<Integer,Double> table2 = new Hashtable<>();
		int len = arr1.length;
		for (int i=0;i<len;i++) {
			if (arr1[i]!=0.0)
				table1.put(i,arr1[i]);
			if (arr2[i]!=0.0)
				table2.put(i,arr2[i]);
		}
		double sum = 0.0;
		if (table1.size() < table2.size()) {
			for (Integer key:table1.keySet()) {
				sum+=table1.get(key)*table2.get(key);
			}
		} else {
			for (Integer key:table2.keySet()) {
				sum+=table1.get(key)*table2.get(key);	
			}
		}
		return sum;

	}
	public static void main(String[] argv) {

			double[] arr1 = new double[]{0.0,1.0,2.0,0.0,3.0,0.0,4.0};
			double[] arr2 = new double[]{0.0,0.0,2.0,0.0,0.0,0.0,4.0};
			System.out.println(dotProduct(arr1,arr2));
	}
}