package revision.sort;

import java.util.*;

public class RemoveDuplicates {
	
	public List<String> process(String[] arr) {
		if (arr == null || arr.length==0) 
			return null;
		else if (arr.length==1)
			return Arrays.asList(arr[0]);
		Arrays.sort(arr);
		List<String> results = new ArrayList<>();
		String curr = null;
		for (int i=0;i<arr.length;i++) {

			String temp = arr[i].substring(0,arr[i].indexOf(","));
			if (curr == null) {
				results.add(arr[i]);
				curr = temp;
			} else {
				if (!curr.equals(temp))
					results.add(arr[i]);
				curr = temp;
			}
		}
		return results;
	}

	public List<String> processMod(List<String> input) {
		if (input == null || input.size()<=1) 
			return input;
		Collections.sort(input);
		String curr = null;
		int k = 0;
		for (int i=1;i<input.size();i++) {
			if (!input.get(i).substring(0,input.get(i).indexOf(",")).equals(input.get(k).substring(0,input.get(k).indexOf(","))))
				input.set(++k,input.get(i));
		}
		input.subList(++k,input.size()).clear();
		return input;
	}


	public static void main(String[] arr) {
		String[] input = {"Ian,Botham","David,Gower","Ian,Bell","Ian,Chappell"};
		RemoveDuplicates rd = new RemoveDuplicates();
		List<String> results = rd.process(input);
		for (String str:results) {
			System.out.println(str);
		}
		List<String> newinput = new ArrayList();
		newinput.add("Ian,Botham");
		newinput.add("David,Gower");
		newinput.add("Ian,Bell");
		newinput.add("Ian,Chappell");
		results = rd.processMod(newinput);
		System.out.println("***************************");
		for (String str:results) {
			System.out.println(str);
		}
	}
}