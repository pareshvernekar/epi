package revision.string;
import java.util.*;

public class SentenceReverse {


	public String reverse(String input) {

		if (input == null || input.length()==0)
			return input;
		char[] ch = input.toCharArray();
		fullReverse(ch);

		int i = -1;

		do {
			i = wordReverse(ch,i+1);
		} while (i < input.length());


		return new String(ch);
	}


	private int wordReverse(char[] ch, int start) {

		int i = start;
		while (true) {

			if (i==ch.length-1 || ch[i+1] == ' ') break;
			i+=1;
		}
		int next = i+1;
		int j = start;
		while (j < i) {
			char c = ch[j];
			ch[j]=ch[i];
			ch[i]=c;
			j++;
			i--;
		} 
		return next;
	}

	private void fullReverse(char[] ch) {
		if (ch == null || ch.length==0)
			throw new IllegalArgumentException();
		int j = ch.length - 1;
		int i = 0;
		while (i < j) {
			char c  = ch[i];
			ch[i]=ch[j];
			ch[j]=c;

			i++;
			j--;
		}
	}


	
	public static void main(String[] argv) {

		String input = "Bob meets Mary";
		SentenceReverse sr = new SentenceReverse();
		System.out.println(sr.reverse(input));


	}
}