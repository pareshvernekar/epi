package sample.epi.strings.episolution;

import java.util.*;

public class StringRLE{
	

	public static String encodeRLE(String str) {
		StringBuilder resultBldr = new StringBuilder();
		int len = str.length();
		int startPos = 0;
		int count = 0;
		char ch = '\u0000';

		for (int i=0;i<=len;i++) {
			if (ch=='\u0000') {
				ch = str.charAt(i);
				count+=1;
				continue;
			}
			if (i == len || ch != str.charAt(i)) {
				resultBldr.append(count).append(ch);
				if (i < len) {
					ch = str.charAt(i);
					count=1;
				}
			} else if (ch == str.charAt(i)) {
				count+=1;
			} 

		}
		return resultBldr.toString();
	}


	public static String decodeRLE(String str) {
		StringBuilder resultBldr = new StringBuilder();
		int count = 0;
		int len = str.length();
		char ch = '\u0000';
		for (int i = 0;i<len;i++) {
			if (Character.isDigit(str.charAt(i)))
				count = count*10+str.charAt(i)-'0';
			else {
				append(resultBldr,count, str.charAt(i));
				count = 0;
			}
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