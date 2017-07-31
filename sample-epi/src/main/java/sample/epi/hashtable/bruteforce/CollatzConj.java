package sample.epi.hashtable.bruteforce;

import java.util.*;
//13.13
public class CollatzConj {
	
	public void testCollatz(List<Integer> input) {

		Set<Integer> validCollatz = new HashSet<>();
		int num = 0;
		for (Integer i:input) {
			num = i;
			while (true) {
				if (num%2==0)
					num=num/2;
				else
					num=(num*3)+1;
				if (validCollatz.contains(num) || num==1) {
					break;
				} 
				System.out.println("NUM:"+num);
			}
			validCollatz.add(i);
			System.out.println("Valid collatz:"+i);
		}
	}


	public static void main(String[] argv) {

		List<Integer> input = Arrays.asList(11,16,52);
		CollatzConj cc = new CollatzConj();
		cc.testCollatz(input);

	}
}