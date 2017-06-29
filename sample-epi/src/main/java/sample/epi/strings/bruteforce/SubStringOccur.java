package sample.epi.strings.bruteforce;

import java.util.*;

public class SubStringOccur {

	public static int substring(String t, String s) {
		int index = -1;
		if (s.length() > t.length())
			return index;
		int tlen = t.length();
		int slen = s.length();
		boolean found = true;
		
		for (int i =0;i<tlen;i++) {
			found = true;
			index = i;
			if (t.charAt(i)!=s.charAt(0))
				continue;
			for (int j=1;j<slen;j++) {
				if (t.charAt(i+j)!=s.charAt(j)) {
					found = false;
					break;
				}
			}
			if (index <= (tlen-slen) && found)
				break;
		}
		if (index <= (tlen-slen) && found)
			return index;
		else
			return -1;
	}
	public static void main(String[] argv) {
		String t = "aabcdeffgh";
		String s1 =  "cde";
		String s2 = "ccd";
		System.out.println(substring(t,s1));
		System.out.println(substring(t,s2));
	}
	
}