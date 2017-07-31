package sample.epi.sort.bruteforce;

import java.util.*;

public class SortedArrayIntersection {
	

	public List<Integer> intersect1(Integer[] input1, Integer[] input2) {

		Set<Integer> set1 = new LinkedHashSet<>(Arrays.asList(input1));
		Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(input2));
		if (set1.size() > set2.size()) {
			set1.retainAll(set2);
			return new ArrayList<>(set1);
		} else {
			set2.retainAll(set1);
			return new ArrayList<>(set2);
		}
	}

	public List<Integer> intersect2(Integer[] input1, Integer[] input2) {
			return findIntersection(input1,input2);
	}
	private List<Integer> findIntersection(Integer[] small, Integer[] large) {

		int i=0, j = 0;
		Set<Integer> resultSet = new LinkedHashSet<>();
		while (i < small.length && j < large.length) {

			if (small[i]==large[j] && (i==0 || small[i] != small[i-1])) {
				resultSet.add(small[i]);
				i++;
				j++;
			} else if (small[i] < large[j]) {
				i++;
			} else {
				j++;
			}
		}
		return new ArrayList<>(resultSet);
	}
	public static void main(String[] argv) {

		Integer[] input1 = {2,3,3,5,5,6,7,7,8,12};
		Integer[] input2 = {5,5,6,8,8,9,10,10};
		SortedArrayIntersection sai = new SortedArrayIntersection();
		List<Integer> result = sai.intersect1(input1,input2);
		for (int a:result) {
			System.out.print(a);System.out.print("\t");
		}
		System.out.println();

		result = sai.intersect2(input1,input2);
		for (int a:result) {
			System.out.print(a);System.out.print("\t");
		}
		System.out.println();

		Integer[] input3 = {2,3,3,5};
		Integer[] input4 = {5,5,6,8,8,9,10,10};

		result = sai.intersect2(input3,input4);
		for (int a:result) {
			System.out.print(a);System.out.print("\t");
		}
		System.out.println();
	}
}