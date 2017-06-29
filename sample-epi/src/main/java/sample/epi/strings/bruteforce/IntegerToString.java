package sample.epi.strings.bruteforce;

import java.util.*;

public class IntegerToString {

	public static String convertToString(int number) {
		StringBuilder strBuilder = new StringBuilder();
		boolean isNegative = Boolean.FALSE;
		if (number < 0) {
			isNegative = Boolean.TRUE;
			number*=-1;
		}
		while (number > 0) {

			strBuilder.append(number%10);
			number = number / 10;
		}
		if (isNegative)
			strBuilder.append("-");
		

		return strBuilder.reverse().toString();
	}
	public static void main(String[] argv) {

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println("String:"+convertToString(num));
		scanner.close();
	}
}