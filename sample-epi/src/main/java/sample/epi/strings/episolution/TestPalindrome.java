package sample.epi.strings.episolution;

import java.util.*;
//7.5
public class TestPalindrome {
	
	public static boolean testPalindrome(String text) {
		if (text == null || text.isEmpty())
			throw new IllegalArgumentException("Invalid paramter values");

		int i = 0, j = text.length() - 1;
		System.out.println("INPUT TEXT:"+text);
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(text.charAt(i))) {
				++i;
			}

			while (i < j && !Character.isLetterOrDigit(text.charAt(j))) {
				--j;
			}
			System.out.println(i+"::"+j);
			if (i > j || text.charAt(i++) != text.charAt(j--)) {
				System.out.println(i+"::"+j);
				System.out.println(text.charAt(i)+"::"+text.charAt(j));
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;

	}
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		String palindromeStr = scanner.next();
		System.out.println("Is palindrome:"+testPalindrome("EED, 1,1,9DEE"));
		scanner.close();

	}
}