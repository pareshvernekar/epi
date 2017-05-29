package sample.epi.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegerReverse {

	static int reverseAsString(int n) {

		String s = ""+n;
		int start = s.startsWith("-") | s.startsWith("+")?1:0;
		int end = s.length()-1;
		char[] charArr = s.toCharArray();
		for (int i=start;i<end;i++) {
			char ch = charArr[i];
			charArr[i]=charArr[end];
			charArr[end--] = ch;
		}
		return Integer.parseInt(new String(charArr));
	}
	
	static long reverse(long n) {
		
		boolean isNegative = n < 0?Boolean.TRUE:Boolean.FALSE;
		int count = 0;
		List<Integer> digitList = new ArrayList<>();
		int start = 10;
		int result = 0;
		while (n != 0) {
			digitList.add((int)n%10);
			n/=10;
		}
		int len = digitList.size()-1;
		for (int i:digitList) {
			n+=(i*Math.pow(10, len--));
		}
		return n;
	}
	
	static long reverseModified(long n) {
		long result = 0;
		boolean isNegative = n < 0?Boolean.TRUE:Boolean.FALSE;
		n=Math.abs(n);
		while (n != 0) {
			result = (result*10)+(n%10);
			n/=10;
		}
		if (isNegative) return -result;
		else
			return result;
	}
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("Reverse using string:"+reverseAsString(n));
		System.out.println("Reverse using integer:"+reverse(n));
		System.out.println("Reverse using integer modified:"+reverseModified(n));
		scanner.close();
	}
	
}
