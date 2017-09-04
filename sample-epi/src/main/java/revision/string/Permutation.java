package revision.string;

import java.util.*;
public class Permutation {

	public static void main(String[] argv) {
		String input="abcd";
		Permutation p = new Permutation();
		List<String> results = p.compute(input);
		for (String str:results) {
			System.out.println(str);
		}
	}
	public List<String> compute(String input) {

		if (input == null || input.isEmpty())
			return null;
		List<String> results = new ArrayList<>();
		process("",input,results);
		return results;
	}

	public void process(String prefix, String input, List<String> results) {
		if (input.isEmpty())
			results.add(prefix);
		else {
			int len = input.length();
			for (int i=0;i<len;i++) {

				process(prefix+input.charAt(i),input.substring(0,i)+input.substring(i+1,len),results);
			}
		}
	}
}