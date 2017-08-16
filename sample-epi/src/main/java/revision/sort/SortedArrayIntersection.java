package revision.sort;

import java.util.*;
public class SortedArrayIntersection {
	
	public List<Integer> intersect(List<Integer> input1, List<Integer> input2) {
		if (input1 == null || input1.isEmpty() || input2 == null || input2.isEmpty())
			return null;

		Iterator<Integer> iter1 = input1.iterator();
		Iterator<Integer> iter2 = input2.iterator();
		Integer temp1 =iter1.next(), temp2=iter2.next();
		int i1=0,i2=0;
		List<Integer> result = new ArrayList<>();
		while (iter1.hasNext() && (temp1.compareTo(input2.get(i2)) <0)) {
			temp1=iter1.next();
		}
		
		while (iter2.hasNext() && (temp2.compareTo(temp1) <0)) {
			temp2=iter2.next();
		}
		int count = -1;
		while (iter1.hasNext() && iter2.hasNext()) {
			if (temp1.compareTo(temp2)==0) {
				if (result.isEmpty()) {
					result.add(temp1);
					count+=1;
				} else if (temp1.compareTo(result.get(count)) !=0){
					result.add(temp1);
					count+=1;
				}
			}
			temp1 =iter1.next();temp2=iter2.next();
			while (iter1.hasNext() && (temp1.compareTo(temp2) <0)) {
				temp1=iter1.next();
			}

			while (iter2.hasNext() && (temp2.compareTo(temp1) <0)) {
				temp2=iter2.next();
			}
		}
		if (temp1.compareTo(temp2)==0) {
				if (result.isEmpty()) {
					result.add(temp1);
					count+=1;
				} else if (temp1.compareTo(result.get(count)) !=0){
					result.add(temp1);
					count+=1;
				}
		}
		return result;
	}

	public List<Integer> intersectMod(List<Integer> input1, List<Integer> input2) {
		if (input1 == null || input1.isEmpty() || input2 == null || input2.isEmpty())
			return null;
		int i1=0,i2=0;
		List<Integer> result = new ArrayList<>();

		while (i1 < input1.size() && i2 < input2.size()) {

			if (input1.get(i1).compareTo(input2.get(i2)) == 0 && 
				(i1 ==0 || input1.get(i1).compareTo(input1.get(i1-1)) > 0)) {
				result.add(input1.get(i1));
				i1++;
				i2++;
			} else if (input1.get(i1).compareTo(input2.get(i2)) < 0) {
				i1++;
			} else {
				i2++;
			}
		}
		return result;
	}
	
	public static void main(String[] argv) {
		SortedArrayIntersection sai = new SortedArrayIntersection();
		List<Integer> input1 = Arrays.asList(2,3,3,5,5,6,7,8,12);
		List<Integer> input2 = Arrays.asList(5,5,6,8,8,9,10,10);
		List<Integer> result = sai.intersect(input1,input2);
		for (Integer i:result) {
			System.out.print(i);System.out.print("\t");
		}


		result = sai.intersectMod(input1,input2);
		for (Integer i:result) {
			System.out.print(i);System.out.print("\t");
		}
	}

}