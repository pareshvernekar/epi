package revision.search;

import java.util.*;

public class PrefixSearch {

	public static void main(String[] argv) {

		List<String> input = Arrays.asList("aaa","aab","aba","abb","abc","aca","acb");

		PrefixSearch ps = new PrefixSearch();
		System.out.println(ps.test(input,"ab"));
		System.out.println(ps.test(input,"ac"));
		System.out.println(ps.test(input,"ad"));
	}
	
	public boolean test(List<String> input, String p) {

		if (input == null || input.size()==0|| p==null||p.length()==0)
			return Boolean.FALSE;

		int left = 0;
		int right=input.size()-1;
		while (left <= right) {
			int middle = left + (right-left)/2;
			if (input.get(middle).startsWith(p))
				return Boolean.TRUE;
			else if (input.get(middle).compareTo(p) > 0) {
				right=middle-1;
			} else if (input.get(middle).compareTo(p) < 0) {
				left=middle+1;
			}
		}
		return Boolean.FALSE;
	}


}