package revision.string;

import java.util.*;

public class StringManipulation {
	

	public int toInt(String s) {

		if (s == null || "".equals(s))
			throw new IllegalArgumentException();

		int len = s.length();
		int result = 0;
		boolean isNegative = (s.charAt(0)=='-')?Boolean.TRUE:Boolean.FALSE;
		int i=isNegative?1:0;
		while (i < len) {
			if (!Character.isDigit(s.charAt(i)))
				throw new IllegalArgumentException();
			result=result*10+s.charAt(i)-'0';
			i++;
		}
		return (isNegative?-result:result);
	}


	public String toString(int i) {

		boolean isNegative = (i < 0 )?Boolean.TRUE:Boolean.FALSE;
		i = Math.abs(i);
		StringBuilder strBuilder = new StringBuilder();
		if (isNegative)
			strBuilder.append('-');
		if (i==0)
			return "0";
		int pow = (int)(Math.floor(Math.log10(i)));

		while (i != 0) {
			strBuilder.append((i/(int)(Math.pow(10,pow))));
			i=i%(int)(Math.pow(10,pow));
			pow/=10;
		}
		return strBuilder.toString();
	}


	public static void main(String[] argv) {

		StringManipulation sm = new StringManipulation();
		int result = sm.toInt("321");
		assert result==321;
		result = sm.toInt("-111");
		assert result==-111;

		result = sm.toInt("0");
		assert result == 0;

		String strResult = sm.toString(123);
		assert strResult.equals("123");

		strResult = sm.toString(-422);
		assert strResult.equals("-422");
	}
}