package sample.epi.strings.bruteforce;

import java.util.*;

public class LookAndSay {
	
	public static char getNInSequence(int n) {
		char result = '\u0000';
		int count = 0;
		char ch = '\u0000';
		char[] charArr = new char[1];

		StringBuilder strBuilder = new StringBuilder();
		int curLen = 0;

		if (n <= 0)
			return 1;

		charArr[0]='1';
		
		while (curLen < n+1) {
			count = 0;
			System.out.println(new String(charArr));
			boolean append = false;
			for (int i=0;i<charArr.length;i++) {
				if (count == 0) {
					count=1;
					ch = charArr[0];
					append = false;
					continue;

				}

				if (charArr[i]==ch) {
					count+=1;
					append = false;
				} else {
					strBuilder.append(""+count).append(ch);
					ch = charArr[i];
					count=1;
				}
			}


				if (!append) {
					strBuilder.append(""+count).append(ch);
					ch = '\u0000';
					count=0;
					append = true;
				}
			System.out.println("strBuilder:"+strBuilder.length());
			charArr = strBuilder.toString().toCharArray();
			strBuilder = new StringBuilder();
			curLen = charArr.length;
			System.out.println(new String(charArr)+"::CurLen::"+curLen+":n+1:"+(n+1));
		}
		result = charArr[n];

		return result;


	}

	public static void main(String[] argv) {
		int n = 0;

		try {
			n = Integer.parseInt(argv[0]);
		} catch(Exception ex) {
			n=1;
		}

		System.out.println(getNInSequence(n));
	}
}