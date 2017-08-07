package revision.string;

import java.util.*;

public class RomanToDecimal {


	static Map<Character,Integer> valueMap = new HashMap<>();
	static {
		valueMap.put('I',1);
		valueMap.put('V',5);
		valueMap.put('X',10);
		valueMap.put('L',50);
		valueMap.put('C',100);
		valueMap.put('D',500);
		valueMap.put('M',1000);
	}
	public boolean isValid(String input) {
		if (input == null || input.length() == 0)
			return Boolean.FALSE;
		int len = input.length();
		char prev = '\u0000',cur='\u0000';
		for (int i = len-1;i>=0;i--) {
			cur = input.charAt(i);
			if (!valueMap.containsKey(cur))
				return Boolean.FALSE;

			if (prev != '\u0000') {

				if (valueMap.get(prev) == valueMap.get(cur) && i < len-2) {
					if (valueMap.get(cur) < valueMap.get(input.charAt(i+2)))
						return Boolean.FALSE;
				}

			}
			prev = cur;
			

		}
		return Boolean.TRUE;

	}
	public int convert(String input) {

		if (input == null || input.length()==0)
			throw new IllegalArgumentException("Invalid parameter value");

		int sum = 0;
		int len = input.length();
		char prev = '\u0000',cur='\u0000';
		for (int i = len-1;i>=0;i--) {
			cur = input.charAt(i);
			if (prev != '\u0000') {
				if (valueMap.get(prev) > valueMap.get(cur)) {
					sum-=valueMap.get(cur);
				} else {
					sum+=valueMap.get(cur);
				}

			} else {
				sum+=valueMap.get(cur);
			}
			prev=cur;
		}

		return sum;
	}
	
	public static void main(String[] argv) {
		RomanToDecimal rtd = new RomanToDecimal();

		System.out.println("I VALID:"+rtd.isValid("I"));
		System.out.println("I:"+rtd.convert("I"));

		System.out.println("IV VALID:"+rtd.isValid("IV"));
		System.out.println("IV:"+rtd.convert("IV"));
		System.out.println("VII VALID:"+rtd.isValid("VII"));
		System.out.println("VII:"+rtd.convert("VII"));
		System.out.println("XIV VALID:"+rtd.isValid("XIV"));
		System.out.println("XIV:"+rtd.convert("XIV"));
		System.out.println("XIIV VALID:"+rtd.isValid("XIIV"));

	}
}