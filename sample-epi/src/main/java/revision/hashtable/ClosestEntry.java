package revision.hashtable;

import java.util.*;

public class ClosestEntry {

	public static void main(String[] argv) {
		List<String> input = Arrays.asList("All","work","and","no","play","makes","for","no","work","no","fun","and","no","results");
		ClosestEntry ce = new ClosestEntry();	
		Integer result = ce.process(input);
		System.out.println(result);
	}
	
	public Integer process(List<String> input) {
		if (input == null || input.isEmpty())
			return null;
		Map<String,Integer> keyDistanceMap = new HashMap<>();
		String currString = "";
		int curMin = Integer.MAX_VALUE;
		int len = input.size();
		for (int i=0;i<len;i++) {
			if (keyDistanceMap.containsKey(input.get(i))) {
				int temp = i-keyDistanceMap.get(input.get(i));
				if (Integer.compare(temp,curMin) < 0) {
					curMin=temp;
					currString=input.get(i);
				}
			} 
				keyDistanceMap.put(input.get(i),i);
			
		}
		return curMin;
	}
}