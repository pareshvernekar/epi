package revision.string;

import java.util.*;

public class CharReplaceAndRemove {
	

	public char[] replaceAndRemove(char[] input, char replace, char remove) {

		if (input == null || input.length==0)
			return input;
		int reqLen = 0;
		char ch;
		int i = 0;
		while ((ch=input[i]) != '\u0000') {
			if (ch ==remove) {
			}
			else if (ch == replace)
				reqLen+=2;
			else
				reqLen+=1;
			i++;
		}

		i-=1;
		System.out.println(reqLen+"i:"+i);
		while (reqLen >=0 && i>=0) {
			if (input[i]==remove) {
				i--;
				continue;
			}
			else if (input[i]==replace) {
				input[reqLen]='d';
				reqLen-=1;
				input[reqLen]='d';
			} else {
				input[reqLen]=input[i];
			}
			reqLen-=1;
			i-=1;

		}
		while(reqLen >=0) {

		}

		return input;

	}

	public static void main(String[] argv) {
		char[] ch = {'a','c','d','b','b','c','a','\u0000','\u0000'};
		CharReplaceAndRemove crr = new CharReplaceAndRemove();
		ch = crr.replaceAndRemove(ch,'a','b');
		char ch1;
		int i = 0;
		while ((ch1=ch[i]) != '\u0000') {
			System.out.print(ch1);System.out.print("\t");
			i++;
		}

	}

}