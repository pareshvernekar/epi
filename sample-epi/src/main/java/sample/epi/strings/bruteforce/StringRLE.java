package sample.epi.strings.bruteforce;

import java.util.*;

public class StringRLE{
	

	public static String encodeRLE(String str) {
		StringBuilder resultBldr = new StringBuilder();
		int len = str.length();
		int startPos = 0;
		int count = 0;
		char ch = '\u0000';

		for (int i=0;i<len;i++) {
			if (ch=='\u0000') {
				ch = str.charAt(i);
				count+=1;
				continue;
			}
			if (ch == str.charAt(i)) {
				count+=1;
			} else {
				resultBldr.append(count).append(ch);
				ch = str.charAt(i);
				count=1;
			}

		}
		resultBldr.append(count).append(ch);
		return resultBldr.toString();
	}


	public static String decodeRLE(String str) {
		StringBuilder resultBldr = new StringBuilder();

		int len = str.length();
		for (int i = 0;i<len;i+=2) {
			append(resultBldr,Integer.parseInt(str.charAt(i)+""), str.charAt(i+1));
		}

		return resultBldr.toString();
	}

	private static void append(StringBuilder strBuilder, int count, char ch) {

		while (count-- >0) {
			strBuilder.append(ch);
		}
	} 
	public static void main(String[] argv) {

		String encoded = encodeRLE(argv[0]);
		System.out.println("Encoded:"+encoded);
		String decoded = decodeRLE(encoded);
		System.out.println("Decoded:"+decoded);

	}
}