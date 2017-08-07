package revision.string;

import java.util.*;

public class StringPalindrome {
	

	public boolean isPalindrome(String input) {

		if (input == null || input.length()==0)
			return Boolean.FALSE;

		int i = 0; 
		int j = input.length() - 1;
		while (i < j) {
			while (i < j) {
				if (!Character.isLetter(input.charAt(i)))
					i++;
				else
					break;
			}
			
			while (j  > i) {
				if (!Character.isLetter(input.charAt(j)))
					j--;
				else
					break;
			}
			if (input.charAt(i) != input.charAt(j))
				return Boolean.FALSE;


			i++;
			j--;
		}

		return Boolean.TRUE;

	}


	public static void main(String[] argv) {

		String ip1="A man, a plan, a canal, Panama";
		String ip2="Able was I, ere I saw Elba!";
		String ip3="Ray a Ray";
		StringPalindrome sp = new StringPalindrome();

		System.out.println(" IP1 :"+sp.isPalindrome(ip1.toLowerCase()));
		System.out.println(" IP2 :"+sp.isPalindrome(ip2.toLowerCase()));
		System.out.println(" IP3 :"+sp.isPalindrome(ip3.toLowerCase()));


	}

}