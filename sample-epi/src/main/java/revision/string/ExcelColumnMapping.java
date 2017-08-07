package revision.string;

import java.util.*;

public class ExcelColumnMapping {
	

	public int getInt(String input) {
		if (input == null || "".equals(input))
			return 0;

		int result = 0;
		int len = input.length();
		for (int i=0;i<len;i++) {

			if (!Character.isLetter(input.charAt(i)))
				throw new IllegalArgumentException("Invalid column label");
			result=(result)*26+input.charAt(i)-'A'+1;

		}
		return result;

	}


	public String getColumnId(int input) {
		if (input < 1)
			return "";

		StringBuilder result = new StringBuilder();
		while (input > 0) {
			input--;
			
			char ch = (char) (input % 26 + 'A');
       		input /= 26;

        	result.append(ch);
		}
		
		return result.reverse().toString();

	}


	public static void main(String[] argv) {

		ExcelColumnMapping ecm = new ExcelColumnMapping();
		System.out.println("D:"+ecm.getInt("D"));
		System.out.println("AA:"+ecm.getInt("AA"));
		System.out.println("AB:"+ecm.getInt("AB"));
		System.out.println("AD:"+ecm.getInt("AD"));
		System.out.println("ZZ:"+ecm.getInt("ZZ"));


		System.out.println("4:"+ecm.getColumnId(4));
		System.out.println("27:"+ecm.getColumnId(27));
		System.out.println("28:"+ecm.getColumnId(28));
		 System.out.println("30:"+ecm.getColumnId(30));
		System.out.println("26:"+ecm.getColumnId(26));
		System.out.println("702:"+ecm.getColumnId(702));
		
	}
}