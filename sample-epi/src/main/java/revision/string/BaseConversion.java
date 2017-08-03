package revision.string;

import java.util.*;

public class BaseConversion {
	

	public String convertBase(String source, int fromBase, int toBase) {

		long decResult;
		if (fromBase != 10) {
			decResult = convertToDecimal(source,fromBase);
		} else {
			decResult = Integer.valueOf(source);
		}
		if (toBase == 10)
			return String.valueOf(decResult);
		else
			return convertBase(decResult,toBase);
	}


	public String convertBase(long source, int toBase) {
		StringBuilder resultBldr = new StringBuilder();
		int result = 0;
		while (source > 0) {
			result = (int)(source%toBase);
			if (toBase > 10) {
				resultBldr.append((char)('A'+result-10));
			} else
				resultBldr.append(source%toBase);
			source/=toBase;
		}


		return resultBldr.reverse().toString();
	}

	private long convertToDecimal(String source, int fromBase) {
		long result = 0;
		int len = source.length();
		int count = 0;
		int temp;
		for (int i = len-1;i>=0;i--) {
			if (fromBase > 10) {
				temp=(10+source.charAt(i)-'A');
			} else 
				temp = source.charAt(i)-'0';
			result+=(int)Math.pow(fromBase,count++)*(temp);
		}
		return result;
	}
	// A - 10, B - 11, C - 12, D - 13, E - 14, F - 15
	public static void main(String[] argv) {

		String ip1 = "1101";
		String ip2 ="B";
		String ip3 ="F";
		String ip4 ="FFFF";
		BaseConversion bc = new BaseConversion();
		System.out.println(bc.convertBase(ip1,2,10));
		System.out.println(bc.convertBase(ip2,16,10));
		System.out.println(bc.convertBase(ip3,16,10));
		System.out.println(bc.convertBase(ip4,16,10));
		System.out.println(bc.convertBase("13",10,2));
		System.out.println(bc.convertBase("65534",10,16));
		System.out.println(bc.convertBase("1101",2,16));
	}
}